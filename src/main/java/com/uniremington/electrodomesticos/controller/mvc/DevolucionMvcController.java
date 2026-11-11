package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.DevolucionDAO;
import com.uniremington.electrodomesticos.model.vo.DevolucionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/devoluciones")
public class DevolucionMvcController extends CrudMvcController<DevolucionVO> {

    public DevolucionMvcController(DevolucionDAO dao) {
        super(dao, DevolucionVO.class, DevolucionVO::new, DevolucionVO::getIdDevolucion,
                "idDevolucion", "/devoluciones", "Devoluciones");
    }
}
