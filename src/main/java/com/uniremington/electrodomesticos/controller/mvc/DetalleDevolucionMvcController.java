package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.DetalleDevolucionDAO;
import com.uniremington.electrodomesticos.model.vo.DetalleDevolucionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detalles-devolucion")
public class DetalleDevolucionMvcController extends CrudMvcController<DetalleDevolucionVO> {

    public DetalleDevolucionMvcController(DetalleDevolucionDAO dao) {
        super(dao, DetalleDevolucionVO.class, DetalleDevolucionVO::new, DetalleDevolucionVO::getIdDetalleDevolucion,
                "idDetalleDevolucion", "/detalles-devolucion", "Detalles de devolución");
    }
}
