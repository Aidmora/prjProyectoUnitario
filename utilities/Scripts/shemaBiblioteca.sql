


CREATE TABLE AUTOR
(
    IdAutor         INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
    NombreAutor          VARCHAR(20) NOT NULL,
    Estado          VARCHAR(1)  NOT NULL DEFAULT('A'),
    Nacionalidad    VARCHAR(20) NOT NULL,
    FechaNacimiento VARCHAR(40) NOT NULL

);
-- Insertar autor 1
INSERT INTO AUTOR (NombreAutor, Nacionalidad, FechaNacimiento)
VALUES ('John Smith', 'Estados Unidos', '1970-05-15');

-- Insertar autor 2
INSERT INTO AUTOR (NombreAutor, Nacionalidad, FechaNacimiento)
VALUES ('Maria Rodriguez', 'España', '1985-09-28');

-- Insertar autor 3
INSERT INTO AUTOR (NombreAutor, Nacionalidad, FechaNacimiento)
VALUES ('David Lee', 'Canadá', '1980-02-10');

-- Insertar autor 4
INSERT INTO AUTOR (NombreAutor, Nacionalidad, FechaNacimiento)
VALUES ('Luisa Martinez', 'México', '1992-07-03');

-- Insertar autor 5
INSERT INTO AUTOR (NombreAutor, Nacionalidad, FechaNacimiento)
VALUES ('Anna Johnson', 'Reino Unido', '1975-12-20');

-- Insertar autor 6
INSERT INTO AUTOR (NombreAutor, Nacionalidad, FechaNacimiento)
VALUES ('Hans Müller', 'Alemania', '1988-04-05');

-- Insertar autor 7
INSERT INTO AUTOR (NombreAutor, Nacionalidad, FechaNacimiento)
VALUES ('Sophie Dupont', 'Francia', '1990-11-15');

-- Insertar autor 8
INSERT INTO AUTOR (NombreAutor, Nacionalidad, FechaNacimiento)
VALUES ('Luca Rossi', 'Italia', '1978-06-25');

-- Insertar autor 9
INSERT INTO AUTOR (NombreAutor, Nacionalidad, FechaNacimiento)
VALUES ('Javier Fernandez', 'España', '1982-03-12');

-- Insertar autor 10
INSERT INTO AUTOR (NombreAutor, Nacionalidad, FechaNacimiento)
VALUES ('Emily Wang', 'China', '1995-08-08');

SELECT * FROM AUTOR;

CREATE TABLE LIBRO
(
    IdLibro             INTEGER         NOT NULL PRIMARY KEY AUTOINCREMENT,
    IdAutor             INTEGER         NOT NULL ,
    NombreLibro              VARCHAR(10)     NOT NULL,
    FechaPublicacion    VARCHAR(200)    NOT NULL,
    Genero              VARCHAR(60)    NOT NULL,
    Editorial           VARCHAR(60)    NOT NULL,
    Estado              VARCHAR(1)      NOT NULL DEFAULT('A'),
    
    CONSTRAINT FK_IdAutor,
    FOREIGN KEY (IdAutor) REFERENCES AUTOR (IdAutor)

);
-- Insertar libro 1
INSERT INTO LIBRO (IdAutor, NombreLibro, FechaPublicacion, Genero, Editorial)
VALUES (1, 'El Secreto', '2020-03-15', 'Autoayuda', 'Editorial X');

-- Insertar libro 2
INSERT INTO LIBRO (IdAutor, NombreLibro, FechaPublicacion, Genero, Editorial)
VALUES (2, 'La Aventura', '2019-07-20', 'Aventura', 'Editorial Y');

-- Insertar libro 3
INSERT INTO LIBRO (IdAutor, NombreLibro, FechaPublicacion, Genero, Editorial)
VALUES (3, 'Ciencia Ficción 101', '2021-01-10', 'Ciencia Ficción', 'Editorial Z');

-- Insertar libro 4
INSERT INTO LIBRO (IdAutor, NombreLibro, FechaPublicacion, Genero, Editorial)
VALUES (4, 'Historia Antigua', '2018-05-02', 'Historia', 'Editorial A');

-- Insertar libro 5
INSERT INTO LIBRO (IdAutor, NombreLibro, FechaPublicacion, Genero, Editorial)
VALUES (5, 'El Misterio', '2022-08-30', 'Misterio', 'Editorial B');

-- Insertar libro 6
INSERT INTO LIBRO (IdAutor, NombreLibro, FechaPublicacion, Genero, Editorial)
VALUES (6, 'Aprende a Programar', '2017-11-12', 'Informática', 'Editorial C');

-- Insertar libro 7
INSERT INTO LIBRO (IdAutor, NombreLibro, FechaPublicacion, Genero, Editorial)
VALUES (7, 'Amor y Romance', '2019-04-25', 'Romance', 'Editorial D');

-- Insertar libro 8
INSERT INTO LIBRO (IdAutor, NombreLibro, FechaPublicacion, Genero, Editorial)
VALUES (8, 'Viaje al Futuro', '2020-06-08', 'Ciencia Ficción', 'Editorial E');

-- Insertar libro 9
INSERT INTO LIBRO (IdAutor, NombreLibro, FechaPublicacion, Genero, Editorial)
VALUES (9, 'Misterios por Resolver', '2021-02-18', 'Misterio', 'Editorial F');

-- Insertar libro 10
INSERT INTO LIBRO (IdAutor, NombreLibro, FechaPublicacion, Genero, Editorial)
VALUES (10, 'Aventuras en la Selva', '2018-09-14', 'Aventura', 'Editorial G');

SELECT * FROM LIBRO;
CREATE TABLE RESENA
(
    IdResena    INTEGER         NOT NULL PRIMARY KEY AUTOINCREMENT,
    IdLibro     INTEGER         NOT NULL,
    IdAutor     INTEGER         NOT NULL ,
    Resena      VARCHAR(100)     NOT NULL,
    Puntuacion  INTEGER         NOT NULL,
    FechaResena VARCHAR(200)    NOT NULL,
    Estado      VARCHAR(1)      NOT NULL DEFAULT('A'),

    CONSTRAINT FK_IdLibro,
    FOREIGN KEY(IdLibro) REFERENCES LIBRO(IdLibro),

    CONSTRAINT FK_IdAutor,
    FOREIGN KEY(IdAutor) REFERENCES AUTOR(IdAutor) 

);
-- Insertar reseña 1
INSERT INTO RESENA (IdLibro, IdAutor, Resena, Puntuacion, FechaResena)
VALUES (1, 1, 'Muy interesante', 4, '2020-04-10');

-- Insertar RESENA 2
INSERT INTO RESENA (IdLibro, IdAutor, Resena, Puntuacion, FechaResena)
VALUES (2, 2, 'Una aventura emocionante', 5, '2019-08-25');

-- Insertar RESENA 3
INSERT INTO RESENA (IdLibro, IdAutor, Resena, Puntuacion, FechaResena)
VALUES (3, 3, 'Una obra maestra de la ciencia ficción', 5, '2021-02-05');

-- Insertar RESENA 4
INSERT INTO RESENA (IdLibro, IdAutor, Resena, Puntuacion, FechaResena)
VALUES (4, 4, 'Interesante libro histórico', 4, '2018-06-20');

-- Insertar RESENA 5
INSERT INTO RESENA (IdLibro, IdAutor, Resena, Puntuacion, FechaResena)
VALUES (5, 5, 'Misterio bien desarrollado', 4, '2022-09-15');

-- Insertar RESENA 6
INSERT INTO RESENA (IdLibro, IdAutor, Resena, Puntuacion, FechaResena)
VALUES (6, 6, 'Excelente libro de programación', 5, '2017-12-01');

-- Insertar RESENA 7
INSERT INTO RESENA (IdLibro, IdAutor, Resena, Puntuacion, FechaResena)
VALUES (7, 7, 'Una historia de amor cautivadora', 4, '2019-05-12');

-- Insertar RESENA 8
INSERT INTO RESENA (IdLibro, IdAutor, Resena, Puntuacion, FechaResena)
VALUES (8, 8, 'Fascinante viaje en el tiempo', 5, '2020-07-30');

-- Insertar RESENA 9
INSERT INTO RESENA (IdLibro, IdAutor, Resena, Puntuacion, FechaResena)
VALUES (9, 9, 'Resuelve misterios emocionantes', 4, '2021-03-20');

-- Insertar RESENA 10
INSERT INTO RESENA (IdLibro, IdAutor, Resena, Puntuacion, FechaResena)
VALUES (10, 10, 'Aventuras en la selva salvaje', 5, '2018-10-05');
SELECT * FROM RESENA;

