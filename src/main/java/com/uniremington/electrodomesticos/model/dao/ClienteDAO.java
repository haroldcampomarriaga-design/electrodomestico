package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.ClienteVO;
import java.util.Optional;

public interface ClienteDAO extends BaseDAO<ClienteVO, Integer> {

    Optional<ClienteVO> findByNumeroDocumento(String numeroDocumento);
}
