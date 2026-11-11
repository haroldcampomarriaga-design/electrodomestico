package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.VentaDAO;
import com.uniremington.electrodomesticos.model.vo.VentaVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ventas")
public class VentaMvcController extends CrudMvcController<VentaVO> {

    public VentaMvcController(VentaDAO dao) {
        super(dao, VentaVO.class, VentaVO::new, VentaVO::getIdVenta, "idVenta", "/ventas", "Ventas");
    }
}
