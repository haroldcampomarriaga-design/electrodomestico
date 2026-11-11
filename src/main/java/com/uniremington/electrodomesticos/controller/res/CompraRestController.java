package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.CompraDAO;
import com.uniremington.electrodomesticos.model.vo.CompraVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compras")
public class CompraRestController extends CrudRestController<CompraVO> {

    private final CompraDAO compraDAO;

    public CompraRestController(CompraDAO compraDAO) {
        super(compraDAO, CompraVO::getIdCompra);
        this.compraDAO = compraDAO;
    }

    @GetMapping("/factura/{numeroFactura}")
    public ResponseEntity<CompraVO> findByNumeroFactura(@PathVariable String numeroFactura) {
        return ResponseEntity.of(compraDAO.findByNumeroFactura(numeroFactura));
    }
}
