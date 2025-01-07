package com.foro.hub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull
                                    Long id,
                                    String titulo,
                                    String mensaje,
                                    Boolean estado
                                    ) {
}
