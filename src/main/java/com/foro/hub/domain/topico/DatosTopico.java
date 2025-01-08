package com.foro.hub.domain.topico;

import java.time.LocalDateTime;

public record DatosTopico(String titulo,
                          String mensaje,
                          LocalDateTime fecha,
                          Boolean estado,
                          Long autor,
                          Long curso) {
    public DatosTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFecha_de_Creacion(), topico.getStatus(), topico.getUsuario().getId(), topico.getCurso().getId());
    }
}
