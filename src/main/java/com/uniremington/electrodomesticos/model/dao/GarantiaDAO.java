package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.GarantiaVO;
import java.util.List;
import java.util.Optional;

public interface GarantiaDAO extends BaseDAO<GarantiaVO, Integer> {

    Optional<GarantiaVO> findByIdSerie(Integer idSerie);

    List<GarantiaVO> findByIdDetalleVenta(Integer idDetalleVenta);
}
