package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.DetalleDevolucionDAO;
import com.uniremington.electrodomesticos.model.vo.DetalleDevolucionVO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalles-devolucion")
public class DetalleDevolucionRestController extends CrudRestController<DetalleDevolucionVO> {

    private final DetalleDevolucionDAO detalleDevolucionDAO;

    public DetalleDevolucionRestController(DetalleDevolucionDAO detalleDevolucionDAO) {
        super(detalleDevolucionDAO, DetalleDevolucionVO::getIdDetalleDevolucion);
        this.detalleDevolucionDAO = detalleDevolucionDAO;
    }

    @GetMapping("/devolucion/{idDevolucion}")
    public List<DetalleDevolucionVO> findByIdDevolucion(@PathVariable Integer idDevolucion) {
        return detalleDevolucionDAO.findByIdDevolucion(idDevolucion);
    }
}
