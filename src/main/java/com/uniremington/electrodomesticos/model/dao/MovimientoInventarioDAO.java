package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.MovimientoInventarioVO;
import java.util.List;

public interface MovimientoInventarioDAO extends BaseDAO<MovimientoInventarioVO, Integer> {

    List<MovimientoInventarioVO> findByIdProducto(Integer idProducto);
}
