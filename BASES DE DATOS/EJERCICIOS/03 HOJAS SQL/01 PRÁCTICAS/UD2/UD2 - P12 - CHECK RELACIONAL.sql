--CREAR TABLAS
CREATE TABLE fabricantes
(
    cod_fabricante NUMBER(3),
    nombre VARCHAR2(15),
    pais VARCHAR2(15) NOT NULL,
        PRIMARY KEY (cod_fabricante)
);

CREATE TABLE articulos
(
    articulo VARCHAR2(20),
    cod_fabricante NUMBER(3),
    peso NUMBER(3),
    categoria VARCHAR2(10),
    precio_venta NUMBER(6, 2),
    existencia NUMBER(5),
        PRIMARY KEY (articulo, cod_fabricante, peso, categoria),
        FOREIGN KEY (cod_fabricante) REFERENCES fabricantes(cod_fabricante),
        CHECK (precio_venta > 0),
        CHECK (peso > 0),
        CHECK (categoria IN('Primera', 'Segunda', 'Tercera'))
);

--INSERTAR REGISTROS
INSERT INTO fabricantes VALUES (001, 'Asus', 'Taiwán');
INSERT INTO articulos VALUES ('Placa Base 12231X', 001, 12, 'Primera', 
                              123.54, 245);
                              
