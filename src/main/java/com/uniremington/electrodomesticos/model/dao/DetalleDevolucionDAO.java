package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.DetalleDevolucionVO;
import java.util.List;

public interface DetalleDevolucionDAO extends BaseDAO<DetalleDevolucionVO, Integer> {

    List<DetalleDevolucionVO> findByIdDevolucion(Integer idDevolucion);
}
