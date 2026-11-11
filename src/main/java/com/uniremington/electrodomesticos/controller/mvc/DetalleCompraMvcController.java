package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.DetalleCompraDAO;
import com.uniremington.electrodomesticos.model.vo.DetalleCompraVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detalles-compra")
public class DetalleCompraMvcController extends CrudMvcController<DetalleCompraVO> {

    public DetalleCompraMvcController(DetalleCompraDAO dao) {
        super(dao, DetalleCompraVO.class, DetalleCompraVO::new, DetalleCompraVO::getIdDetalleCompra,
                "idDetalleCompra", "/detalles-compra", "Detalles de compra");
    }
}
