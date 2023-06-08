--CREAR TABLA
CREATE TABLE ejemplo_unique
(
    dni VARCHAR2(9) PRIMARY KEY,
    nombre VARCHAR2(30) UNIQUE,
    edad NUMBER(3)
);

--INSERTAR REGISTROS
INSERT INTO ejemplo_unique VALUES ('11111A', 'John', 53);
INSERT INTO ejemplo_unique VALUES ('11111B', 'John', 22);

--INSERTAR REGISTROS CON NOMBRE NULL
INSERT INTO ejemplo_unique (dni, edad) VALUES ('11111B', 53);
INSERT INTO ejemplo_unique (dni, edad) VALUES ('11111C', 22);

SELECT * FROM ejemplo_unique;
