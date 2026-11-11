package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.dao.UsuarioDAO;
import com.uniremington.electrodomesticos.model.vo.UsuarioVO;
import java.util.List;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

    private final UsuarioDAO usuarioDAO;

    public UsuarioRestController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @GetMapping
    public List<UsuarioResponse> findAll() {
        return usuarioDAO.findAll().stream()
                .map(UsuarioResponse::from)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.of(usuarioDAO.findById(id).map(UsuarioResponse::from));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> create(@RequestBody UsuarioVO usuario) {
        UsuarioVO saved = usuarioDAO.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponse.from(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> update(
            @PathVariable Integer id,
            @RequestBody UsuarioVO usuario) {
        if (!Objects.equals(id, usuario.getIdUsuario())) {
            return ResponseEntity.badRequest().build();
        }

        if (!usuarioDAO.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(UsuarioResponse.from(usuarioDAO.update(usuario)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!usuarioDAO.deleteById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<UsuarioResponse> findByCorreo(@PathVariable String correo) {
        return ResponseEntity.of(usuarioDAO.findByCorreo(correo).map(UsuarioResponse::from));
    }
}
