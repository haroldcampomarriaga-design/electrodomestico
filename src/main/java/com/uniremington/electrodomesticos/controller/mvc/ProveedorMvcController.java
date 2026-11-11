package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.ProveedorDAO;
import com.uniremington.electrodomesticos.model.vo.ProveedorVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proveedores")
public class ProveedorMvcController extends CrudMvcController<ProveedorVO> {

    public ProveedorMvcController(ProveedorDAO dao) {
        super(dao, ProveedorVO.class, ProveedorVO::new, ProveedorVO::getIdProveedor, "idProveedor", "/proveedores", "Proveedores");
    }
}
