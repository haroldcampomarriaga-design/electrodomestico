package com.uniremington.electrodomesticos.controller.mvc;

import com.uniremington.electrodomesticos.model.dao.ClienteDAO;
import com.uniremington.electrodomesticos.model.vo.ClienteVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteMvcController extends CrudMvcController<ClienteVO> {

    public ClienteMvcController(ClienteDAO dao) {
        super(dao, ClienteVO.class, ClienteVO::new, ClienteVO::getIdCliente, "idCliente", "/clientes", "Clientes");
    }
}
