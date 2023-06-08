--CREAR TABLA
CREATE TABLE personas1
(
    nif VARCHAR2(9),
    nombre VARCHAR2(30),
    poblacion VARCHAR2(20),
    provincia NUMBER(2) REFERENCES provin(codigo),
        PRIMARY KEY(nif)
);

--INSERTAR REGISTROS
INSERT INTO personas1 VALUES ('49635201G', 'Pedro Martínez', 'Coslada', 91);
INSERT INTO personas1 VALUES ('56008932L', 'Sonia Gil', 'Guadalajara', 19);

/* El segundo registro no puede insertarse debido a que no hay 
   un registro con PK 19 en la tabla provin, habría que crear
   primero ese registro */

--BUSCAR REGISTROS TABLA PROVIN
SELECT * FROM provin;