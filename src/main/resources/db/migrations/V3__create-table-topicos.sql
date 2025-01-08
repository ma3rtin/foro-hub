CREATE TABLE topicos (
                         id bigint PRIMARY KEY auto_increment,
                         titulo VARCHAR(255) NOT NULL,
                         mensaje TEXT NOT NULL,
                         fecha_de_creacion TIMESTAMP NOT NULL,
                         status BOOLEAN NOT NULL,
                         usuario_id bigint NOT NULL,
                         curso_id bigint NOT NULL,

                         CONSTRAINT fk_topicos_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
                         CONSTRAINT fk_topicos_curso_id FOREIGN KEY (curso_id) REFERENCES cursos(id)

);