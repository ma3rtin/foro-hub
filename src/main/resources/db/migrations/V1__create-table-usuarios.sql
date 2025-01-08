
CREATE TABLE usuarios (
                          id bigint PRIMARY KEY auto_increment,
                          nombre VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          clave VARCHAR(255) NOT NULL
);