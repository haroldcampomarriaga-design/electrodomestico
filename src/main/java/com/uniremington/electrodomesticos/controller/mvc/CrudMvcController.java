package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.BaseDAO;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

public abstract class CrudMvcController<T> {

    private final BaseDAO<T, Integer> dao;
    private final Class<T> entityType;
    private final Supplier<T> entityFactory;
    private final Function<T, Integer> idExtractor;
    private final String idProperty;
    private final String basePath;
    private final String title;

    protected CrudMvcController(
            BaseDAO<T, Integer> dao,
            Class<T> entityType,
            Supplier<T> entityFactory,
            Function<T, Integer> idExtractor,
            String idProperty,
            String basePath,
            String title) {
        this.dao = dao;
        this.entityType = entityType;
        this.entityFactory = entityFactory;
        this.idExtractor = idExtractor;
        this.idProperty = idProperty;
        this.basePath = basePath;
        this.title = title;
    }

    @GetMapping
    public ModelAndView list() throws IntrospectionException {
        List<Map<String, Object>> rows = new ArrayList<>();
        for (T entity : dao.findAll()) {
            BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(entity);
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("_id", idExtractor.apply(entity));
            for (PropertyDescriptor property : properties()) {
                if (!"password".equalsIgnoreCase(property.getName())) {
                    row.put(property.getName(), wrapper.getPropertyValue(property.getName()));
                }
            }
            rows.add(row);
        }

        ModelAndView modelAndView = new ModelAndView("crud/list");
        modelAndView.addObject("title", title);
        modelAndView.addObject("activePath", basePath);
        modelAndView.addObject("basePath", basePath);
        modelAndView.addObject("columns", columns());
        modelAndView.addObject("rows", rows);
        return modelAndView;
    }

    @GetMapping("/nuevo")
    public ModelAndView createForm() throws IntrospectionException {
        return form(entityFactory.get(), basePath);
    }

    @PostMapping
    public String create(@RequestParam MultiValueMap<String, String> form) {
        dao.save(bind(entityFactory.get(), form, true));
        return "redirect:" + basePath;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView updateForm(@PathVariable Integer id) throws IntrospectionException {
        T entity = findOrThrow(id);
        return form(entity, basePath + "/" + id);
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Integer id, @RequestParam MultiValueMap<String, String> form) {
        T entity = bind(findOrThrow(id), form, false);
        dao.update(entity);
        return "redirect:" + basePath;
    }

    @PostMapping("/{id}/eliminar")
    public String delete(@PathVariable Integer id) {
        if (!dao.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:" + basePath;
    }

    private ModelAndView form(T entity, String action) throws IntrospectionException {
        BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(entity);
        ModelAndView modelAndView = new ModelAndView("crud/form");
        modelAndView.addObject("title", title);
        modelAndView.addObject("activePath", basePath);
        modelAndView.addObject("action", action);
        modelAndView.addObject("basePath", basePath);
        modelAndView.addObject("fields", editableFields(wrapper));
        return modelAndView;
    }

    private T bind(T entity, MultiValueMap<String, String> form, boolean creating) {
        BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(entity);
        wrapper.setConversionService(new DefaultConversionService());
        String password = form.getFirst("password");
        if (creating && wrapper.isWritableProperty("password")
                && (password == null || password.isBlank())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La contraseña es obligatoria.");
        }
        form.forEach((name, values) -> {
            if (!idProperty.equals(name)
                    && wrapper.isWritableProperty(name)
                    && !values.isEmpty()
                    && !("password".equalsIgnoreCase(name) && values.get(0).isBlank())) {
                wrapper.setPropertyValue(name, values.get(0));
            }
        });
        return entity;
    }

    private T findOrThrow(Integer id) {
        return dao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private List<PropertyDescriptor> properties() throws IntrospectionException {
        return List.of(Introspector.getBeanInfo(entityType, Object.class).getPropertyDescriptors());
    }

    private List<Map<String, Object>> columns() throws IntrospectionException {
        List<Map<String, Object>> columns = new ArrayList<>();
        for (PropertyDescriptor property : properties()) {
            if (!"password".equalsIgnoreCase(property.getName())) {
                Map<String, Object> column = new LinkedHashMap<>();
                column.put("name", property.getName());
                column.put("label", label(property.getName()));
                columns.add(column);
            }
        }
        return columns;
    }

    private List<Map<String, Object>> editableFields(BeanWrapper wrapper) throws IntrospectionException {
        List<Map<String, Object>> fields = new ArrayList<>();
        for (PropertyDescriptor property : properties()) {
            String name = property.getName();
            if (idProperty.equals(name) || property.getWriteMethod() == null) {
                continue;
            }

            Map<String, Object> field = new LinkedHashMap<>();
            field.put("name", name);
            field.put("label", label(name));
            List<String> options = options(name);
            field.put("type", options.isEmpty() ? inputType(property.getPropertyType(), name) : "select");
            field.put("step", Number.class.isAssignableFrom(property.getPropertyType()) ? "any" : null);
            Object value = "password".equalsIgnoreCase(name) ? "" : wrapper.getPropertyValue(name);
            field.put("value", formatValue(value));
            field.put("options", options);
            fields.add(field);
        }
        return fields;
    }

    private List<String> options(String propertyName) {
        return switch (propertyName.toLowerCase()) {
            case "estado" -> switch (entityType.getSimpleName()) {
                case "CompraVO" -> List.of("PENDIENTE", "RECIBIDA", "ANULADA");
                case "VentaVO" -> List.of("PENDIENTE", "COMPLETADA", "ANULADA");
                case "DevolucionVO" -> List.of("PENDIENTE", "APROBADA", "RECHAZADA", "COMPLETADA");
                case "GarantiaVO" -> List.of("VIGENTE", "VENCIDA", "ANULADA");
                case "ProductoSerieVO" -> List.of("DISPONIBLE", "VENDIDO", "DEVUELTO", "DANADO", "EN_REPARACION");
                case "ProveedorVO" -> List.of("ACTIVO", "INACTIVO");
                case "UsuarioVO" -> List.of("ACTIVO", "INACTIVO");
                default -> List.of("ACTIVO", "INACTIVO");
            };
            case "rol" -> List.of("ADMINISTRADOR", "VENDEDOR", "ALMACENISTA");
            case "metodopago" -> List.of("EFECTIVO", "TRANSFERENCIA", "TARJETA", "CREDITO");
            case "tipodevolucion" -> List.of("CLIENTE", "PROVEEDOR");
            case "accion" -> List.of("REINGRESO_INVENTARIO", "DEVOLVER_PROVEEDOR", "REPARACION", "REEMBOLSO");
            case "estadoproducto" -> List.of("BUENO", "DEFECTUOSO", "DANADO");
            case "tipomovimiento" -> List.of("ENTRADA_COMPRA", "SALIDA_VENTA", "ENTRADA_DEVOLUCION",
                    "SALIDA_DEVOLUCION", "AJUSTE_ENTRADA", "AJUSTE_SALIDA");
            default -> List.of();
        };
    }

    private String inputType(Class<?> propertyType, String propertyName) {
        if ("password".equalsIgnoreCase(propertyName)) {
            return "password";
        }
        if ("correo".equalsIgnoreCase(propertyName)) {
            return "email";
        }
        if (LocalDateTime.class.equals(propertyType)) {
            return "datetime-local";
        }
        if (LocalDate.class.equals(propertyType)) {
            return "date";
        }
        if (Number.class.isAssignableFrom(propertyType)) {
            return "number";
        }
        return "text";
    }

    private String formatValue(Object value) {
        if (value instanceof LocalDateTime dateTime) {
            return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(dateTime);
        }
        if (value instanceof LocalDate date) {
            return DateTimeFormatter.ISO_LOCAL_DATE.format(date);
        }
        return value == null ? "" : value.toString();
    }

    private String label(String propertyName) {
        return propertyName.replaceAll("([a-z])([A-Z])", "$1 $2");
    }
}
