package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.BaseDAO;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class CrudRestController<T> {

    private final BaseDAO<T, Integer> dao;
    private final Function<T, Integer> idExtractor;

    protected CrudRestController(BaseDAO<T, Integer> dao, Function<T, Integer> idExtractor) {
        this.dao = dao;
        this.idExtractor = idExtractor;
    }

    @GetMapping
    public List<T> findAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable Integer id) {
        return ResponseEntity.of(dao.findById(id));
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dao.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable Integer id, @RequestBody T entity) {
        if (!Objects.equals(id, idExtractor.apply(entity))) {
            return ResponseEntity.badRequest().build();
        }

        if (!dao.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dao.update(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!dao.deleteById(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
