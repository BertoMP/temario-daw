CREATE DATABASE BIBLIOTECA;

USE BIBLIOTECA;

CREATE TABLE AUTOR (
    ID_PERSONA INTEGER(2),
    NOMBRE     VARCHAR(20),
    APELLIDO   VARCHAR(14),
    CONSTRAINT PK_AUTOR PRIMARY KEY (ID_PERSONA)
);

INSERT INTO AUTOR (ID_PERSONA, NOMBRE, APELLIDO)
VALUES (10,'Joanne','Rowling'),
       (20,'John Ronald Reuel','Tolkien'),
       (30,'Clive Staples','Lewis'),
       (40,'Roald','Dahl'),
       (50,'Marget','Weis'),
       (60,'Tracy','Hickman'),
       (70,'Elvira','Lindo');

CREATE TABLE LIBRO (
    ID_LIBRO   INTEGER(3),
    TITULO     VARCHAR(40),
    GENERO     VARCHAR(15),
    PAIS       VARCHAR(10),
    ANO        INTEGER(4),
    NUMPAGINAS INTEGER(4),
        CONSTRAINT PK_LIBRO PRIMARY KEY (ID_LIBRO)
);

INSERT INTO LIBRO
    VALUES (10,'Manolito Gafotas','infantil','España',1994,192),
           (20,'Crónicas de la Dragonlance','fantasía épica','USA',1987,1472),
           (30,'Matilda','falntasía','UK',1988, 248),
           (40,'El león, la bruja y el armario','fantasía','UK',1950,240),
           (50,'el hobbit','Fantasía heroica','UK',1937,288),
           (60,'Harry Potter y la piedra filosofal','fantasía','UK',1997,264);

CREATE TABLE ESCRIBEN(
    ID_LIBRO    INTEGER(3),
    ID_PERSONA  INTEGER(2),
        CONSTRAINT PK_ESCRIBEN PRIMARY KEY (ID_LIBRO, ID_PERSONA),
        CONSTRAINT FK_ESCRIBEN_LIBRO FOREIGN KEY (ID_LIBRO) REFERENCES LIBRO(ID_LIBRO),
        CONSTRAINT FK_ESCRIBEN_AUTOR FOREIGN KEY (ID_PERSONA) REFERENCES AUTOR(ID_PERSONA)
);

INSERT INTO ESCRIBEN
    VALUES (10,70),
           (20,60),
           (20,50),
           (30,40),
           (40,30),
           (50,20),
           (60,10);

CREATE TABLE USUARIO (
    ID          INTEGER(2),
    EMAIL       VARCHAR(20),
    PASSWORD    VARCHAR(10),
        CONSTRAINT PK_USUARIO PRIMARY KEY (ID)
);

INSERT INTO USUARIO
    VALUES (10,'pepe@gmail.com','1234'),
           (20,'maria@gmail.com','5678'),
           (30,'raul@gmail.com','1298'),
           (40,'ana@gmail.com','4321');