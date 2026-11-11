package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.ProductoVO;
import java.util.Optional;

public interface ProductoDAO extends BaseDAO<ProductoVO, Integer> {

    Optional<ProductoVO> findByCodigo(String codigo);
}
