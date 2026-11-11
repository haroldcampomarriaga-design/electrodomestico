package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.MovimientoInventarioDAO;
import com.uniremington.electrodomesticos.model.vo.MovimientoInventarioVO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movimientos-inventario")
public class MovimientoInventarioRestController extends CrudRestController<MovimientoInventarioVO> {

    private final MovimientoInventarioDAO movimientoInventarioDAO;

    public MovimientoInventarioRestController(MovimientoInventarioDAO movimientoInventarioDAO) {
        super(movimientoInventarioDAO, MovimientoInventarioVO::getIdMovimiento);
        this.movimientoInventarioDAO = movimientoInventarioDAO;
    }

    @GetMapping("/producto/{idProducto}")
    public List<MovimientoInventarioVO> findByIdProducto(@PathVariable Integer idProducto) {
        return movimientoInventarioDAO.findByIdProducto(idProducto);
    }
}
