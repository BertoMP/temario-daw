--CREAR TABLA
CREATE TABLE personas2
(
    nif VARCHAR2(9),
    nombre VARCHAR2(30),
    calle VARCHAR2(30),
    numero NUMBER(3),
    piso NUMBER(2),
    puerta CHAR(1),
    PRIMARY KEY (nif),
    FOREIGN KEY (calle, numero, piso, puerta)
    REFERENCES bloques_pisos (calle, numero, piso, puerta)
);

--INSERTAR REGISTROS
INSERT INTO personas2 VALUES ('49635201G', 'Pedro Martínez', 'Mayor', 25, 3, 'A');
INSERT INTO personas2 VALUES ('56008932L', 'Sonia Gil', 'Mayor', 15, 6, 'B');

/* El segundo registro no se puede introducir porque en la tabla
   bloques_pisos no hay ningún registro con el numero 15, todos 
   son registros con número 25. Para crear este registro habría
   que crear primero un registro en la tabla bloque_pisos con
   el número 15. */

--BUSCAR REGISTROS TABLA BLOQUES_PISOS
SELECT * FROM bloques_pisos;