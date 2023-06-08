--CREAR TABLAS
CREATE TABLE LIBRO
(
    isbn VARCHAR2(10),
    titulo VARCHAR2(30),
    tematica VARCHAR2(20),
    posicion VARCHAR2(5),
        PRIMARY KEY(isbn),
        CHECK(titulo IS NOT NULL),
        CHECK(tematica IN('terror', 'aventuras', 'infantil')),
        CHECK(posicion LIKE 'EST-_')
);

CREATE TABLE autor
(
    isbn VARCHAR2(10),
    nombre VARCHAR2(30),
        PRIMARY KEY(isbn, nombre),
        FOREIGN KEY(isbn) REFERENCES libro(isbn)
);

INSERT INTO LIBRO VALUES ('123-ABC', 'Titulo1', 'terror', 'EST-A');
INSERT INTO AUTOR VALUES ('123-ABC', 'Ana');

--INSERTAR REGISTROS NO VALIDOS
/* PARA LA TABLA LIBRO */
/* Registro que no cumple la restriccion NOT NULL en el título. */
INSERT INTO LIBRO (isbn, tematica, posicion) VALUES ('124-ABC', 'aventuras',
                                                     'EST-1');
/* Registro que no cumple temática */
INSERT INTO LIBRO VALUES ('124-ABC', 'Titulo2', 'fantasía', 'EST-F');

/* Registro que no cumple estantería */
INSERT INTO LIBRO VALUES ('124-ABC', 'Titulo3', 'infantil', 'Est-F');

/* Registro que no cumple la clave primaria. */
INSERT INTO LIBRO VALUES ('123-ABC', 'Titulo4', 'terror', 'EST-B');

/* PARA LA TABLA AUTOR */
/* Registro que no cumple la clave primaria */
INSERT INTO AUTOR VALUES('123-ABC', 'Ana');
 
/* Regristro que no cumple la clave externa */
INSERT INTO AUTOR VALUES('123-ACB', 'Luis');