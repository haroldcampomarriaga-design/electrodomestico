package com.uniremington.electrodomesticos.controller.res;

import com.uniremington.electrodomesticos.model.vo.UsuarioVO;
import java.time.LocalDateTime;

public record UsuarioResponse(
        Integer idUsuario,
        String nombre,
        String apellido,
        String correo,
        String telefono,
        String rol,
        String estado,
        LocalDateTime fechaCreacion) {

    public static UsuarioResponse from(UsuarioVO usuario) {
        return new UsuarioResponse(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreo(),
                usuario.getTelefono(),
                usuario.getRol(),
                usuario.getEstado(),
                usuario.getFechaCreacion());
    }
}
