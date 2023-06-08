--CREACIÓN DE LA TABLA
CREATE TABLE bloques_pisos
(
    calle VARCHAR2(30),
    numero NUMBER(3),
    piso NUMBER(2),
    puerta CHAR(1),
    codigo_postal NUMBER(5),
    metros NUMBER(5),
    comentarios VARCHAR2(60),
        PRIMARY KEY(calle, numero, piso, puerta)
);

--INSERTAR REGISTROS
INSERT INTO bloques_pisos VALUES ('Mayor', 25, 3, 'A', 28005, 89, 'Con balcón');
INSERT INTO bloques_pisos VALUES ('Mayor', 25, 3, 'B', 28005, 80, 'Interior');
INSERT INTO bloques_pisos VALUES ('Mayor', 25, 3, 'B', 28005, 89, 'Reformado');

/* El último registro repite todos los valores de la clave primaria
   (calle, numero, piso y puerta) del registro anterior así que es imposible 
   introducir el registro. */
