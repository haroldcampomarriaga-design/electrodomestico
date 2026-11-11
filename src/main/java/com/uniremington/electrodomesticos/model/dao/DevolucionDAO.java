package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.DevolucionVO;
import java.util.List;

public interface DevolucionDAO extends BaseDAO<DevolucionVO, Integer> {

    List<DevolucionVO> findByIdVenta(Integer idVenta);

    List<DevolucionVO> findByIdCompra(Integer idCompra);
}
