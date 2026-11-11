package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.ProductoSerieVO;
import java.util.List;
import java.util.Optional;

public interface ProductoSerieDAO extends BaseDAO<ProductoSerieVO, Integer> {

    Optional<ProductoSerieVO> findByNumeroSerie(String numeroSerie);

    List<ProductoSerieVO> findByIdProducto(Integer idProducto);
}
