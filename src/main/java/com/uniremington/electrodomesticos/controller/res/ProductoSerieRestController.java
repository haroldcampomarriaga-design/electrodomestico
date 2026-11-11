package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.ProductoSerieDAO;
import com.uniremington.electrodomesticos.model.vo.ProductoSerieVO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/series")
public class ProductoSerieRestController extends CrudRestController<ProductoSerieVO> {

    private final ProductoSerieDAO productoSerieDAO;

    public ProductoSerieRestController(ProductoSerieDAO productoSerieDAO) {
        super(productoSerieDAO, ProductoSerieVO::getIdSerie);
        this.productoSerieDAO = productoSerieDAO;
    }

    @GetMapping("/numero/{numeroSerie}")
    public ResponseEntity<ProductoSerieVO> findByNumeroSerie(@PathVariable String numeroSerie) {
        return ResponseEntity.of(productoSerieDAO.findByNumeroSerie(numeroSerie));
    }

    @GetMapping("/producto/{idProducto}")
    public List<ProductoSerieVO> findByIdProducto(@PathVariable Integer idProducto) {
        return productoSerieDAO.findByIdProducto(idProducto);
    }
}
