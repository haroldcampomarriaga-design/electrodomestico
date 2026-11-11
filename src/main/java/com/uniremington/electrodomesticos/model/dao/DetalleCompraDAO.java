package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.DetalleCompraVO;
import java.util.List;

public interface DetalleCompraDAO extends BaseDAO<DetalleCompraVO, Integer> {

    List<DetalleCompraVO> findByIdCompra(Integer idCompra);
}
