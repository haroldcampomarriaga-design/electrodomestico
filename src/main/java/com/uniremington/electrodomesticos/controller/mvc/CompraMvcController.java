package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.CompraDAO;
import com.uniremington.electrodomesticos.model.vo.CompraVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/compras")
public class CompraMvcController extends CrudMvcController<CompraVO> {

    public CompraMvcController(CompraDAO dao) {
        super(dao, CompraVO.class, CompraVO::new, CompraVO::getIdCompra, "idCompra", "/compras", "Compras");
    }
}
