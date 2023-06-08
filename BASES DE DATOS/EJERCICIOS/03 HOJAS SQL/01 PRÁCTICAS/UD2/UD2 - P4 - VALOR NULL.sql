--CREACION DE LA TABLA
CREATE TABLE material
(
    codigo NUMBER(2) PRIMARY KEY,
    precio NUMBER(5,2),
    nombre VARCHAR2(30)
);

--INSERCIÓN DE REGISTROS
INSERT INTO material VALUES (33, 0, 'Aluminio');
INSERT INTO material (codigo, nombre) VALUES (34, 'Hierro');

--MOSTRAR FILAS
SELECT * FROM material;

--INSERCIÓN DE REGISTROS 2
INSERT INTO material VALUES (35, 25.99, ' ');
INSERT INTO material (codigo, precio) VALUES (36, 25.10);