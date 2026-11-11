package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.ProductoDAO;
import com.uniremington.electrodomesticos.model.vo.ProductoVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoMvcController extends CrudMvcController<ProductoVO> {

    public ProductoMvcController(ProductoDAO dao) {
        super(dao, ProductoVO.class, ProductoVO::new, ProductoVO::getIdProducto, "idProducto", "/productos", "Productos");
    }
}
