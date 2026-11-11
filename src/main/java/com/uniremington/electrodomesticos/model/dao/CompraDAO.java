package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.CompraVO;
import java.util.Optional;

public interface CompraDAO extends BaseDAO<CompraVO, Integer> {

    Optional<CompraVO> findByNumeroFactura(String numeroFactura);
}
