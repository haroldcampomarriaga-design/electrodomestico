package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.ProductoSerieDAO;
import com.uniremington.electrodomesticos.model.vo.ProductoSerieVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/series")
public class ProductoSerieMvcController extends CrudMvcController<ProductoSerieVO> {

    public ProductoSerieMvcController(ProductoSerieDAO dao) {
        super(dao, ProductoSerieVO.class, ProductoSerieVO::new, ProductoSerieVO::getIdSerie, "idSerie", "/series", "Series de producto");
    }
}
