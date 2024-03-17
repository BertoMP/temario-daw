-- ELIMINA LA BASE DE DATOS.
DROP
DATABASE BIBLIOTECA;

-- CREACIÓN DE LA BASE DE DATOS.
CREATE
DATABASE BIBLIOTECA;

-- USO DE LA BASE DE DATOS.
USE
BIBLIOTECA;

CREATE TABLE AUTORES
(
    ID_PERSONA        INTEGER(2) AUTO_INCREMENT,
    NOMBRE            VARCHAR(20),
    APELLIDO          VARCHAR(14),
    FECHA_NACIMIENTO  DATE,
    PAIS_ORIGEN       VARCHAR(20),
    LIBROS_PUBLICADOS INTEGER,
    CONSTRAINT PK_AUTORES PRIMARY KEY (ID_PERSONA)
);

-- CREACIÓN DE LA TABLA LIBROS.
CREATE TABLE LIBROS
(
    ID_LIBRO    INTEGER(3) AUTO_INCREMENT,
    TITULO      VARCHAR(100),
    GENERO      VARCHAR(50),
    PAIS        VARCHAR(50),
    ANO         INTEGER(4),
    NUM_PAGINAS INTEGER(5),
    CONSTRAINT PK_LIBROS PRIMARY KEY (ID_LIBRO)
);

-- CREACIÓN DE LA TABLA ESCRIBEN.
CREATE TABLE ESCRIBEN
(
    ID_LIBRO   INTEGER(3),
    ID_PERSONA INTEGER(2),
    CONSTRAINT PK_ESCRIBEN PRIMARY KEY (ID_LIBRO, ID_PERSONA),
    CONSTRAINT FK_ESCRIBEN_LIBROS FOREIGN KEY (ID_LIBRO) REFERENCES LIBROS (ID_LIBRO),
    CONSTRAINT FK_ESCRIBEN_AUTORES FOREIGN KEY (ID_PERSONA) REFERENCES AUTORES (ID_PERSONA)
);

-- CREACIÓN DE LA TABLA USUARIOS.
CREATE TABLE USUARIOS
(
    ID       INTEGER(2) AUTO_INCREMENT,
    EMAIL    VARCHAR(100),
    PASSWORD VARCHAR(100),
    CONSTRAINT PK_USUARIOS PRIMARY KEY (ID)
);

-- INSERCIÓN EN LA TABLA AUTORES.
INSERT INTO AUTORES (ID_PERSONA, NOMBRE, APELLIDO, FECHA_NACIMIENTO, PAIS_ORIGEN, LIBROS_PUBLICADOS)
VALUES (10, 'j.k.', 'rowling', '1965-07-31', 'uk', 14),
       (20, 'j.r.r.', 'tolkien', '1892-01-03', 'uk', 26),
       (30, 'c.s', 'lewis', '1898-11-29', 'irlanda del norte', 73),
       (40, 'roald', 'dahl', '1916-09-13', 'uk', 48),
       (50, 'marget', 'weis', '1948-03-16', 'usa', 150),
       (60, 'tracy', 'hickman', '1955-11-26', 'usa', 60),
       (70, 'elvira', 'lindo', '1962-01-23', 'españa', 25),
       (80, 'isaac', 'asimov', '1920-01-02', 'usa', 506),
       (90, 'agatha', 'christie', '1890-09-15', 'uk', 66),
       (100, 'george r.r.', 'martin', '1948-09-20', 'usa', 27),
       (110, 'jules', 'verne', '1828-02-08', 'francia', 65),
       (120, 'stephen', 'king', '1947-09-21', 'usa', 61),
       (130, 'jorge', 'luis borges', '1899-08-24', 'argentina', 27),
       (140, 'jane', 'austen', '1775-12-16', 'uk', 6),
       (150, 'gabriel', 'garcía márquez', '1927-03-06', 'colombia', 25),
       (160, 'philip', 'k. dick', '1928-12-16', 'usa', 44),
       (170, 'haruki', 'murakami', '1949-01-12', 'japón', 14),
       (180, 'margaret', 'atwood', '1939-11-18', 'canadá', 54),
       (190, 'terry', 'pratchett', '1948-04-28', 'uk', 70),
       (200, 'neil', 'gaiman', '1960-11-10', 'uk', 61),
       (210, 'h.p.', 'lovecraft', '1890-08-20', 'usa', 63);

-- INSERCIÓN EN LA TABLA LIBROS.
INSERT INTO LIBROS (ID_LIBRO, TITULO, GENERO, PAIS, ANO, NUM_PAGINAS)
VALUES (10, 'manolito gafotas', 'infantil', 'españa', 1994, 192),
       (20, 'crónicas de la dragonlance', 'fantasía épica', 'usa', 1987, 1472),
       (30, 'matilda', 'fantasía', 'uk', 1988, 248),
       (40, 'el león, la bruja y el armario', 'fantasía', 'uk', 1950, 240),
       (50, 'el hobbit', 'fantasía heroica', 'uk', 1937, 288),
       (60, 'harry potter y la piedra filosofal', 'fantasía', 'uk', 1997, 264),
       (70, 'yo, robot', 'ciencia ficción', 'usa', 1950, 224),
       (80, 'asesinato en el orient express', 'misterio', 'uk', 1934, 256),
       (90, 'juego de tronos', 'fantasía épica', 'usa', 1996, 694),
       (100, 'veinte mil leguas de viaje submarino', 'aventura', 'francia', 1870, 288),
       (110, 'it', 'terror', 'usa', 1986, 1138),
       (120, 'ficciones', 'ficción', 'argentina', 1944, 224),
       (130, 'orgullo y prejuicio', 'novela romántica', 'uk', 1813, 432),
       (140, 'cien años de soledad', 'realismo mágico', 'colombia', 1967, 432),
       (150, 'blade runner', 'ciencia ficción', 'usa', 1968, 210),
       (160, 'norwegian wood', 'ficción contemporánea', 'japón', 1987, 296),
       (170, 'the handmaid''s tale', 'distopía', 'canadá', 1985, 311),
       (180, 'mort', 'fantasía humorística', 'uk', 1987, 272),
       (190, 'good omens', 'fantasía cómica', 'uk', 1990, 432),
       (200, 'the call of cthulhu', 'horror', 'usa', 1928, 26),
       (210, 'el señor de los anillos', 'fantasía épica', 'uk', 1954, 1178),
       (220, 'dune', 'ciencia ficción', 'usa', 1965, 412),
       (230, 'la naranja mecánica', 'distopía', 'uk', 1962, 213);

-- INSERCIÓN DE LA TABLA ESCRIBEN.
INSERT INTO ESCRIBEN (ID_LIBRO, ID_PERSONA)
VALUES (10, 70),
       (20, 60),
       (20, 50),
       (30, 40),
       (40, 30),
       (50, 20),
       (60, 10),
       (70, 80),
       (80, 90),
       (90, 100),
       (100, 110),
       (110, 120),
       (120, 130),
       (130, 140),
       (140, 150),
       (150, 160),
       (160, 170),
       (170, 180),
       (180, 190),
       (190, 200),
       (200, 210),
       (210, 20),
       (220, 100),
       (230, 120);

/* INSERCIÓN EN TABLA USUARIOS (OBSOLETO, AHORA LA
   INSERCIÓN DE DATOS DEBE SER POR CUENTA PARA GENERAR
   UN HASH DE LA CONTRASEÑA) */
INSERT INTO USUARIOS
VALUES (10,'pepe@gmail.com','1234'),
       (20,'maria@gmail.com','5678'),
       (30,'raul@gmail.com','1298'),
       (40,'ana@gmail.com','4321');