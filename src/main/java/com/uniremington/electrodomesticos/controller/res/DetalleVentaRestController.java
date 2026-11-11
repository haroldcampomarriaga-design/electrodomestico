package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.DetalleVentaDAO;
import com.uniremington.electrodomesticos.model.vo.DetalleVentaVO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalles-venta")
public class DetalleVentaRestController extends CrudRestController<DetalleVentaVO> {

    private final DetalleVentaDAO detalleVentaDAO;

    public DetalleVentaRestController(DetalleVentaDAO detalleVentaDAO) {
        super(detalleVentaDAO, DetalleVentaVO::getIdDetalleVenta);
        this.detalleVentaDAO = detalleVentaDAO;
    }

    @GetMapping("/venta/{idVenta}")
    public List<DetalleVentaVO> findByIdVenta(@PathVariable Integer idVenta) {
        return detalleVentaDAO.findByIdVenta(idVenta);
    }
}
