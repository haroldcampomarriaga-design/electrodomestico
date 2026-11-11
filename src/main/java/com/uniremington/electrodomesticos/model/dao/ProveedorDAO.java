package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.ProveedorVO;
import java.util.Optional;

public interface ProveedorDAO extends BaseDAO<ProveedorVO, Integer> {

    Optional<ProveedorVO> findByNit(String nit);
}
