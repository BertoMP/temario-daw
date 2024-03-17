-- ELIMINA LA BASE DE DATOS.
DROP
DATABASE BIBLIOTECA;

-- CREACIÓN DE LA BASE DE DATOS.
CREATE
DATABASE BIBLIOTECA;

-- USO DE LA BASE DE DATOS.
USE
BIBLIOTECA;

-- CREACIÓN DE LA TABLA AUTORES.
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
    ROL      VARCHAR(100),
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
       (210, 'h.p.', 'lovecraft', '1890-08-20', 'usa', 63),
       (220, 'ernest', 'hemingway', '1899-07-21', 'usa', 27),
       (230, 'arthur', 'conan doyle', '1859-05-22', 'uk', 60),
       (240, 'robin', 'hobb', '1952-03-05', 'usa', 32),
       (250, 'isaac', 'bashevis singer', '1902-07-14', 'polonia', 20),
       (260, 'alice', 'sebold', '1963-09-06', 'usa', 4),
       (270, 'gillian', 'flynn', '1971-02-24', 'usa', 5),
       (280, 'mario', 'vargas llosa', '1936-03-28', 'perú', 33),
       (290, 'robert', 'jordan', '1948-10-17', 'usa', 11),
       (300, 'toni', 'morrison', '1931-02-18', 'usa', 11),
       (310, 'rudyard', 'kipling', '1865-12-30', 'india', 36),
       (320, 'ernest', 'cline', '1972-03-29', 'usa', 2),
       (330, 'arundhati', 'roy', '1961-11-24', 'india', 2),
       (340, 'gillian', 'white', '1955-09-02', 'uk', 8),
       (350, 'kazuo', 'ishiguro', '1954-11-08', 'japón', 8),
       (360, 'gao', 'xinjiang', '1940-02-04', 'china', 5),
       (370, 'zadie', 'smith', '1975-10-25', 'uk', 7),
       (380, 'orhan', 'pamuk', '1952-06-07', 'turquía', 15);

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
       (230, 'la naranja mecánica', 'distopía', 'uk', 1962, 213),
       (240, 'assassin''s apprentice', 'fantasía épica', 'usa', 1995, 448),
       (250, 'the old man and the sea', 'novela', 'usa', 1952, 127),
       (260, 'the lovely bones', 'ficción contemporánea', 'usa', 2002, 328),
       (270, 'gone girl', 'misterio', 'usa', 2012, 419),
       (280, 'la ciudad y los perros', 'novela', 'perú', 1962, 456),
       (290, 'the eye of the world', 'fantasía épica', 'usa', 1990, 688),
       (300, 'beloved', 'novela', 'usa', 1987, 324),
       (310, 'the jungle book', 'aventura', 'india', 1894, 228),
       (320, 'the posthumous memoirs of bras cubas', 'realismo mágico', 'brasil', 1881, 160),
       (330, 'to kill a mockingbird', 'novela', 'usa', 1960, 281),
       (340, 'hacia rutas salvajes', 'aventura', 'usa', 1996, 224),
       (350, 'la chica del tren', 'misterio', 'uk', 2015, 336),
       (360, 'neverwhere', 'fantasía urbana', 'uk', 1996, 370),
       (370, '1984', 'distopía', 'uk', 1949, 328),
       (380, 'el retrato de dorian gray', 'terror', 'uk', 1890, 194),
       (390, 'la carretera', 'postapocalíptico', 'usa', 2006, 287),
       (400, 'la torre oscura', 'fantasía oscura', 'usa', 1982, 512),
       (410, 'la sombra del viento', 'misterio', 'españa', 2001, 487),
       (420, 'los hombres que no amaban a las mujeres', 'thriller', 'suecia', 2005, 672),
       (430, 'el código da vinci', 'misterio', 'usa', 2003, 593),
       (440, 'ready player one', 'ciencia ficción', 'usa', 2011, 372),
       (450, 'el dios de las pequeñas cosas', 'drama', 'india', 1997, 339),
       (460, 'no confíes en nadie', 'thriller', 'uk', 2003, 412),
       (470, 'nunca me abandones', 'ciencia ficción', 'uk', 2005, 368),
       (480, 'soy el número cuatro', 'ciencia ficción', 'usa', 2010, 440),
       (490, 'cambio de piel', 'realismo mágico', 'china', 1993, 285),
       (500, 'dientes blancos', 'comedia', 'uk', 2000, 550);

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
       (230, 120),
       (240, 240),
       (250, 220),
       (260, 260),
       (270, 270),
       (280, 280),
       (290, 290),
       (300, 300),
       (310, 310),
       (320, 280),
       (330, 300),
       (340, 220),
       (350, 270),
       (360, 200),
       (370, 230),
       (380, 140),
       (390, 280),
       (400, 100),
       (410, 70),
       (420, 310),
       (430, 270),
       (440, 320),
       (450, 330),
       (460, 340),
       (470, 350),
       (480, 320),
       (490, 360),
       (500, 370);

/* INSERCIÓN EN TABLA USUARIOS */
INSERT INTO USUARIOS
VALUES (10,'pepe@gmail.com','1234'),
       (20,'maria@gmail.com','5678'),
       (30,'raul@gmail.com','1298'),
       (40,'ana@gmail.com','4321');