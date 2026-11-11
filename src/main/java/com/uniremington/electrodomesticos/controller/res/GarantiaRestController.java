package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.GarantiaDAO;
import com.uniremington.electrodomesticos.model.vo.GarantiaVO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/garantias")
public class GarantiaRestController extends CrudRestController<GarantiaVO> {

    private final GarantiaDAO garantiaDAO;

    public GarantiaRestController(GarantiaDAO garantiaDAO) {
        super(garantiaDAO, GarantiaVO::getIdGarantia);
        this.garantiaDAO = garantiaDAO;
    }

    @GetMapping("/serie/{idSerie}")
    public ResponseEntity<GarantiaVO> findByIdSerie(@PathVariable Integer idSerie) {
        return ResponseEntity.of(garantiaDAO.findByIdSerie(idSerie));
    }

    @GetMapping("/detalle-venta/{idDetalleVenta}")
    public List<GarantiaVO> findByIdDetalleVenta(@PathVariable Integer idDetalleVenta) {
        return garantiaDAO.findByIdDetalleVenta(idDetalleVenta);
    }
}
