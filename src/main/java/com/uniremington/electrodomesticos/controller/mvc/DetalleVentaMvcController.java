package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.DetalleVentaDAO;
import com.uniremington.electrodomesticos.model.vo.DetalleVentaVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detalles-venta")
public class DetalleVentaMvcController extends CrudMvcController<DetalleVentaVO> {

    public DetalleVentaMvcController(DetalleVentaDAO dao) {
        super(dao, DetalleVentaVO.class, DetalleVentaVO::new, DetalleVentaVO::getIdDetalleVenta,
                "idDetalleVenta", "/detalles-venta", "Detalles de venta");
    }
}
