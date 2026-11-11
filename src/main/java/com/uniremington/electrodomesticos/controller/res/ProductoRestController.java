package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.ProductoDAO;
import com.uniremington.electrodomesticos.model.vo.ProductoVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController extends CrudRestController<ProductoVO> {

    private final ProductoDAO productoDAO;

    public ProductoRestController(ProductoDAO productoDAO) {
        super(productoDAO, ProductoVO::getIdProducto);
        this.productoDAO = productoDAO;
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ProductoVO> findByCodigo(@PathVariable String codigo) {
        return ResponseEntity.of(productoDAO.findByCodigo(codigo));
    }
}
