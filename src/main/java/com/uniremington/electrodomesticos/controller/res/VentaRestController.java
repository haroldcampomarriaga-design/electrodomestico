package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.VentaDAO;
import com.uniremington.electrodomesticos.model.vo.VentaVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ventas")
public class VentaRestController extends CrudRestController<VentaVO> {

    private final VentaDAO ventaDAO;

    public VentaRestController(VentaDAO ventaDAO) {
        super(ventaDAO, VentaVO::getIdVenta);
        this.ventaDAO = ventaDAO;
    }

    @GetMapping("/factura/{numeroFactura}")
    public ResponseEntity<VentaVO> findByNumeroFactura(@PathVariable String numeroFactura) {
        return ResponseEntity.of(ventaDAO.findByNumeroFactura(numeroFactura));
    }
}
