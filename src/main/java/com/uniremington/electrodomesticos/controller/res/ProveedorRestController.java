package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.ProveedorDAO;
import com.uniremington.electrodomesticos.model.vo.ProveedorVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorRestController extends CrudRestController<ProveedorVO> {

    private final ProveedorDAO proveedorDAO;

    public ProveedorRestController(ProveedorDAO proveedorDAO) {
        super(proveedorDAO, ProveedorVO::getIdProveedor);
        this.proveedorDAO = proveedorDAO;
    }

    @GetMapping("/nit/{nit}")
    public ResponseEntity<ProveedorVO> findByNit(@PathVariable String nit) {
        return ResponseEntity.of(proveedorDAO.findByNit(nit));
    }
}
