package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.GarantiaDAO;
import com.uniremington.electrodomesticos.model.vo.GarantiaVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/garantias")
public class GarantiaMvcController extends CrudMvcController<GarantiaVO> {

    public GarantiaMvcController(GarantiaDAO dao) {
        super(dao, GarantiaVO.class, GarantiaVO::new, GarantiaVO::getIdGarantia, "idGarantia", "/garantias", "Garantías");
    }
}
