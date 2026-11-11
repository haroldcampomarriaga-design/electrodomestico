package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.MovimientoInventarioDAO;
import com.uniremington.electrodomesticos.model.vo.MovimientoInventarioVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movimientos-inventario")
public class MovimientoInventarioMvcController extends CrudMvcController<MovimientoInventarioVO> {

    public MovimientoInventarioMvcController(MovimientoInventarioDAO dao) {
        super(dao, MovimientoInventarioVO.class, MovimientoInventarioVO::new, MovimientoInventarioVO::getIdMovimiento,
                "idMovimiento", "/movimientos-inventario", "Movimientos de inventario");
    }
}
