package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.DetalleCompraDAO;
import com.uniremington.electrodomesticos.model.vo.DetalleCompraVO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalles-compra")
public class DetalleCompraRestController extends CrudRestController<DetalleCompraVO> {

    private final DetalleCompraDAO detalleCompraDAO;

    public DetalleCompraRestController(DetalleCompraDAO detalleCompraDAO) {
        super(detalleCompraDAO, DetalleCompraVO::getIdDetalleCompra);
        this.detalleCompraDAO = detalleCompraDAO;
    }

    @GetMapping("/compra/{idCompra}")
    public List<DetalleCompraVO> findByIdCompra(@PathVariable Integer idCompra) {
        return detalleCompraDAO.findByIdCompra(idCompra);
    }
}
