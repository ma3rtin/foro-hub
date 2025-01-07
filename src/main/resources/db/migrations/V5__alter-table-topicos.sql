ALTER TABLE topicos
    ADD COLUMN curso_id bigint;
ALTER TABLE topicos
    ADD CONSTRAINT fk_topicos_curso_id
        FOREIGN KEY (curso_id) REFERENCES cursos(id);