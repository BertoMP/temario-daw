--CREAR TABLAS
/*TABLA VENDEDOR
  Se crea primero porque la tabla VENDEDOR va a referenciar
  a esta tabla en su FK.
  Restricciones de columna para los CHECK de calle y comunidad,
  así como para la restricción UNIQUE del campo comunidad.
  La PK debe ser una restricción de tabla al estar compuesta por dos
  campos (calle y ciudad).*/
CREATE TABLE TIENDA
(
    calle VARCHAR2(50) 
        CONSTRAINT C_CALLE_NOMBRE_C_P CHECK(calle LIKE 'C%' OR calle LIKE 'P%'),
    ciudad VARCHAR2(50),
    comunidad VARCHAR2(50)
        CONSTRAINT C_COMUNIDAD_NOT_NULL CHECK(comunidad IS NOT NULL)
        CONSTRAINT U_COMUNIDAD_UNICA UNIQUE,
        CONSTRAINT PK_TIENDA PRIMARY KEY(calle,ciudad)
);
/*TABLA TORNILLO
  Se crea primero porque la tabla VENTA va a referenciar
  a esta tabla en su FK.
  Restricciones de columna para los CHECK de codigo y diametro.
  La PK debe ser una restricción de tabla al estar compuesta por dos
  campos (codigo y diametro).*/
CREATE TABLE TORNILLO
(
    codigo CHAR(3)
        CONSTRAINT C_CODIGO_OPCION 
            CHECK(codigo IN('AA1','AA2','AA3','AA4','AA5')),
    diametro NUMBER(2) CONSTRAINT C_DIAMENTRO_MAX90 CHECK(diametro < 90),
        CONSTRAINT PK_TORNILLO PRIMARY KEY(codigo,diametro)
);
/*TABLA VENDEDOR
  Restricción de columna para la PK ya que está compuesta por un 
  único campo.
  Restricción de tabla para la FK ya que está compuesta por varios
  campos (calle y ciudad) que referencian a los campos del mismo nombre
  de la tabla TIENDA. */
CREATE TABLE VENDEDOR
(
    dni VARCHAR2(9) CONSTRAINT PK_VENDEDOR PRIMARY KEY,
    calle VARCHAR2(50),
    ciudad VARCHAR2(50),
        CONSTRAINT FK_VENDEDOR_TIENDA 
            FOREIGN KEY(calle,ciudad) REFERENCES TIENDA(calle,ciudad)
);
/*TABLA VENTA
  Restricción de columna para la FK que referencia a la tabla VENDEDOR
  ya que está compuesta por un único campo (vendedor) que referencia
  al campo dni de la otra tabla.
  Restricción de columna para la restricción CHECK del campo cantidad.
  DEFAULT en campos fecha (DEFAULT SYSDATE) y cantidad (DEFAULT 25) que
  se insertarán como valores por defecto en caso de que no se indique nada
  en el momento de la inserción de registros.
  La PK debe ser una restricción de tabla ya que está formada por cuatro
  campos (vendedor, cod_tornillo, diametro, fecha).
  La segunda FK de la tabla debe ser una restricción de tabla ya que está
  formada por dos campos (cod_tornillo, diametro) que referencian a los
  campos codigo y tornillo de la tabla TORNILLO. */
CREATE TABLE VENTA
(
    vendedor VARCHAR2(9) CONSTRAINT FK_VENTA_VENDEDOR REFERENCES VENDEDOR(dni),
    cod_tornillo CHAR(3),
    diametro NUMBER(2),
    fecha DATE DEFAULT SYSDATE,
    cantidad NUMBER(2) DEFAULT 25
        CONSTRAINT C_CANTIDAD_MIN5_MAX50 CHECK(cantidad BETWEEN 5 AND 50),
        CONSTRAINT PK_VENTA PRIMARY KEY(vendedor,cod_tornillo,diametro,fecha),
        CONSTRAINT FK_VENTA_TORNILLO FOREIGN KEY(cod_tornillo,diametro) 
            REFERENCES TORNILLO(codigo,diametro)
);
--VER RESTRICCIONES
SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME='TIENDA' 
    OR TABLE_NAME='TORNILLO'
    OR TABLE_NAME='VENDEDOR'
    OR TABLE_NAME='VENTA'
ORDER BY TABLE_NAME ASC;

SELECT * FROM USER_CONS_COLUMNS
WHERE TABLE_NAME='TIENDA' 
    OR TABLE_NAME='TORNILLO'
    OR TABLE_NAME='VENDEDOR'
    OR TABLE_NAME='VENTA'
ORDER BY TABLE_NAME ASC;

--INSERTAR REGISTROS
INSERT INTO TIENDA VALUES ('C. JORGE JUAN', 'MADRID', 'MADRID');
INSERT INTO TIENDA VALUES ('C. PRADILLO', 'OVIEDO', 'ASTURIAS');
INSERT INTO TIENDA VALUES ('C. JORGE JUAN', 'GRANADA', 'ANDALUCÍA');
INSERT INTO TIENDA VALUES ('PLAZA MAYOR', 'SALAMANCA', 'CASILLA LEÓN');

INSERT INTO TORNILLO VALUES ('AA1', 20);
INSERT INTO TORNILLO VALUES ('AA5', 15);
INSERT INTO TORNILLO VALUES ('AA2', 20);
INSERT INTO TORNILLO VALUES ('AA3', 10);
INSERT INTO TORNILLO VALUES ('AA2', 10);

INSERT INTO VENDEDOR VALUES ('10000000F', 'C. JORGE JUAN', 'MADRID');
INSERT INTO VENDEDOR VALUES ('50000000U', 'C. PRADILLO', 'OVIEDO');
INSERT INTO VENDEDOR VALUES ('90000000T', 'C. JORGE JUAN', 'GRANADA');
INSERT INTO VENDEDOR VALUES ('70000000Y', 'PLAZA MAYOR', 'SALAMANCA');

INSERT INTO VENTA VALUES ('10000000F', 'AA1', 20, '12-02-2021', 30);
INSERT INTO VENTA VALUES ('50000000U', 'AA5', 15, '12-02-2021', 10);
INSERT INTO VENTA VALUES ('90000000T', 'AA2', 20, '13-05-2021', 12);
INSERT INTO VENTA VALUES ('70000000Y', 'AA3', 10, '20-05-2021', 8);
INSERT INTO VENTA VALUES ('10000000F', 'AA2', 10, '18-04-2021', 5);
INSERT INTO VENTA VALUES ('10000000F', 'AA2', 20, '20-04-2021', 7);

--VER DATOS
SELECT * FROM TIENDA;
SELECT * FROM TORNILLO;
SELECT * FROM VENDEDOR;
SELECT * FROM VENTA;

--INSERTAR REGISTRO CON CAMPOS VACÍOS
INSERT INTO VENTA(vendedor,cod_tornillo,diametro)
    VALUES ('10000000F', 'AA1', 20);

--INSERTAR REGISTROS NO VALIDOS
INSERT INTO VENTA VALUES ('10000000F', 'AA1', 20, '12-02-2021', 7);
/* PK_VENTA 
   Se repiten todos los campos de la PK de la tabla VENTA, registro 6
   de esa tabla. */
INSERT INTO VENTA VALUES ('50000000U', 'AA3', 20, '12-12-2021', 10);
/* FK_VENTA_TORNILLO
   No existe el tornillo con los datos AA3 de código y 20 de diametro
   en la tabla TORNILLO */
INSERT INTO VENTA VALUES ('50000000U', 'AA7', 20, '12-11-2021', 2);
/* C_CANTIDAD_MIN5_MAX50
   Sólo se venden 2 tornillos cuando la venta mínima establecida en
   la tabla VENTA es de 5.
   Además también saltaría la restricción FK_VENTA_TORNILLO ya que
   el tornillo con código AA7 y diámetro 20 no existe en esa tabla.*/
INSERT INTO VENTA VALUES ('90000000T', 'AA1', 20, '01-05-2021', 54);
/* C_CANTIDAD_MIN5_MAX50
   Sólo se venden 54 tornillos cuando la venta máxima establecida en
   la tabla VENTA es de 50.
   Además también saltaría la restricción FK_VENTA_TORNILLO ya que
   el tornillo con código AA7 y diámetro 20 no existe en esa tabla.*/
INSERT INTO TIENDA VALUES ('PLAZA MAYOR', 'MADRID', 'MADRID');
/* U_COMUNIDAD_UNICA
   Sólo puede existir una tienda por comunidad, en este caso ya existe  
   una tienda en la CAM (registro 1 de la tabla TIENDA). */
INSERT INTO TIENDA(calle,ciudad) VALUES ('PLAZA MAYOR','RIOFRIO');
/* C_COMUNIDAD_NOT_NULL 
   En la tabla TIENDA el campo comunidad está restringido por un CHECK 
   IS NOT NULL por lo que el campo nunca puede ser nulo. */
INSERT INTO TORNILLO VALUES ('AA6', 95);
/* C_DIAMETRO_MAX90 
   En la tabla TORNILLO el campo diámetro está restringido por un CHECK
   para los diámetros (deben ser menores de 90) por lo que al intentar
   insertar un diámetro mayor (95) la restricción salta. */