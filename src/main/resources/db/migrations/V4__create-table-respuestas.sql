CREATE TABLE respuestas (
                            id bigint PRIMARY KEY auto_increment,
                            nombre VARCHAR(255) NOT NULL,
                            mensaje TEXT NOT NULL,
                            fecha_de_creacion TIMESTAMP NOT NULL,
                            topico_id bigint NOT NULL,
                            usuario_id bigint NOT NULL,

                            CONSTRAINT fk_respuestas_topico_id FOREIGN KEY (topico_id) REFERENCES topicos(id),
                            CONSTRAINT fk_respuestas_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);