package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.DevolucionDAO;
import com.uniremington.electrodomesticos.model.vo.DevolucionVO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/devoluciones")
public class DevolucionRestController extends CrudRestController<DevolucionVO> {

    private final DevolucionDAO devolucionDAO;

    public DevolucionRestController(DevolucionDAO devolucionDAO) {
        super(devolucionDAO, DevolucionVO::getIdDevolucion);
        this.devolucionDAO = devolucionDAO;
    }

    @GetMapping("/venta/{idVenta}")
    public List<DevolucionVO> findByIdVenta(@PathVariable Integer idVenta) {
        return devolucionDAO.findByIdVenta(idVenta);
    }

    @GetMapping("/compra/{idCompra}")
    public List<DevolucionVO> findByIdCompra(@PathVariable Integer idCompra) {
        return devolucionDAO.findByIdCompra(idCompra);
    }
}
