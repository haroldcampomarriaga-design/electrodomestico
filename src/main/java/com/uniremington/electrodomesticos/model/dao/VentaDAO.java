package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.VentaVO;
import java.util.Optional;

public interface VentaDAO extends BaseDAO<VentaVO, Integer> {

    Optional<VentaVO> findByNumeroFactura(String numeroFactura);
}
