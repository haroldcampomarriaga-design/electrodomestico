package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.UsuarioDAO;
import com.uniremington.electrodomesticos.model.vo.UsuarioVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioMvcController extends CrudMvcController<UsuarioVO> {

    public UsuarioMvcController(UsuarioDAO dao) {
        super(dao, UsuarioVO.class, UsuarioVO::new, UsuarioVO::getIdUsuario, "idUsuario", "/usuarios", "Usuarios");
    }
}
