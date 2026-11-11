package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.ClienteDAO;
import com.uniremington.electrodomesticos.model.vo.ClienteVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController extends CrudRestController<ClienteVO> {

    private final ClienteDAO clienteDAO;

    public ClienteRestController(ClienteDAO clienteDAO) {
        super(clienteDAO, ClienteVO::getIdCliente);
        this.clienteDAO = clienteDAO;
    }

    @GetMapping("/documento/{numeroDocumento}")
    public ResponseEntity<ClienteVO> findByNumeroDocumento(@PathVariable String numeroDocumento) {
        return ResponseEntity.of(clienteDAO.findByNumeroDocumento(numeroDocumento));
    }
}
