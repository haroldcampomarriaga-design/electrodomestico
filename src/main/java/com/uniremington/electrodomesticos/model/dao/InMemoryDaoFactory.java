package com.uniremington.electrodomesticos.model.dao;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

final class InMemoryDaoFactory {

    private InMemoryDaoFactory() {
    }

    static <D> D create(Class<D> daoType, Class<?> entityType, String idProperty) {
        return daoType.cast(Proxy.newProxyInstance(
                daoType.getClassLoader(),
                new Class<?>[] { daoType },
                new InMemoryDaoHandler(entityType, idProperty)));
    }

    private static final class InMemoryDaoHandler implements InvocationHandler {

        private final Class<?> entityType;
        private final Method idGetter;
        private final Method idSetter;
        private final Map<String, Method> getters = new LinkedHashMap<>();
        private final Map<Integer, Object> entities = new LinkedHashMap<>();
        private int nextId = 1;

        private InMemoryDaoHandler(Class<?> entityType, String idProperty) {
            this.entityType = entityType;
            Method foundIdGetter = null;
            Method foundIdSetter = null;
            try {
                for (PropertyDescriptor property : Introspector.getBeanInfo(entityType).getPropertyDescriptors()) {
                    if (property.getReadMethod() != null) {
                        getters.put(property.getName(), property.getReadMethod());
                    }
                    if (property.getName().equals(idProperty)) {
                        foundIdGetter = property.getReadMethod();
                        foundIdSetter = property.getWriteMethod();
                    }
                }
            } catch (java.beans.IntrospectionException exception) {
                throw new IllegalArgumentException("Cannot inspect " + entityType.getName(), exception);
            }
            if (foundIdGetter == null || foundIdSetter == null) {
                throw new IllegalArgumentException("Missing readable/writable ID property " + idProperty
                        + " on " + entityType.getName());
            }
            idGetter = foundIdGetter;
            idSetter = foundIdSetter;
        }

        @Override
        public synchronized Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String name = method.getName();
            if (method.getDeclaringClass() == Object.class) {
                return switch (name) {
                    case "toString" -> "InMemory" + entityType.getSimpleName() + "DAO";
                    case "hashCode" -> System.identityHashCode(proxy);
                    case "equals" -> proxy == args[0];
                    default -> throw new UnsupportedOperationException(name);
                };
            }

            return switch (name) {
                case "findById" -> Optional.ofNullable(entities.get((Integer) args[0]));
                case "findAll" -> new ArrayList<>(entities.values());
                case "save" -> save(args[0]);
                case "update" -> update(args[0]);
                case "deleteById" -> entities.remove((Integer) args[0]) != null;
                case "existsById" -> entities.containsKey((Integer) args[0]);
                default -> findByProperty(method, args[0]);
            };
        }

        private Object save(Object entity) throws ReflectiveOperationException {
            checkEntity(entity);
            Integer id = (Integer) idGetter.invoke(entity);
            if (id == null) {
                id = nextId++;
                idSetter.invoke(entity, id);
            } else {
                nextId = Math.max(nextId, id + 1);
            }
            entities.put(id, entity);
            return entity;
        }

        private Object update(Object entity) throws ReflectiveOperationException {
            checkEntity(entity);
            Integer id = (Integer) idGetter.invoke(entity);
            if (id == null) {
                throw new IllegalArgumentException("Cannot update an entity without an ID");
            }
            entities.put(id, entity);
            nextId = Math.max(nextId, id + 1);
            return entity;
        }

        private Object findByProperty(Method method, Object value) throws Throwable {
            if (!method.getName().startsWith("findBy") || method.getParameterCount() != 1) {
                throw new UnsupportedOperationException("Unsupported DAO operation: " + method.getName());
            }
            String propertyName = Introspector.decapitalize(method.getName().substring("findBy".length()));
            Method getter = getters.get(propertyName);
            if (getter == null) {
                throw new IllegalArgumentException("No property " + propertyName + " on " + entityType.getName());
            }
            List<Object> matches = new ArrayList<>();
            for (Object entity : entities.values()) {
                if (Objects.equals(getter.invoke(entity), value)) {
                    matches.add(entity);
                }
            }
            if (method.getReturnType() == Optional.class) {
                return matches.stream().findFirst();
            }
            if (List.class.isAssignableFrom(method.getReturnType())) {
                return matches;
            }
            throw new UnsupportedOperationException("Unsupported return type for " + method.getName());
        }

        private void checkEntity(Object entity) {
            if (!entityType.isInstance(entity)) {
                throw new IllegalArgumentException("Expected " + entityType.getName());
            }
        }
    }
}
