package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.DetalleVentaVO;
import java.util.List;

public interface DetalleVentaDAO extends BaseDAO<DetalleVentaVO, Integer> {

    List<DetalleVentaVO> findByIdVenta(Integer idVenta);
}
