package com.uniremington.electrodomesticos.model.dao;

import com.uniremington.electrodomesticos.model.vo.UsuarioVO;
import java.util.Optional;

public interface UsuarioDAO extends BaseDAO<UsuarioVO, Integer> {

    Optional<UsuarioVO> findByCorreo(String correo);
}
