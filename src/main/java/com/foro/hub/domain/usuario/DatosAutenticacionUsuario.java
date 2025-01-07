package com.foro.hub.domain.usuario;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(@NotBlank
                                        @Email
                                        String email,
                                        @NotBlank
                                        String clave) {
}
