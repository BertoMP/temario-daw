--CREAR TABLAS
/* TABLA TELESCOPIO */
CREATE TABLE TELESCOPIO (
    modelo VARCHAR2(15) PRIMARY KEY,
    tipo VARCHAR2(15) CHECK (tipo IN ('reflector','refractor','catadióptrico')),
    magnitud NUMBER(4,2),
    aumentos VARCHAR2(4) CHECK (aumentos LIKE '%x'),
    distancia_focal number(4),
    apertura NUMBER(4),
    ocular NUMBER(3)
);
/* TABLA MONTURA */
create table MONTURA(
    referencia VARCHAR2(15) PRIMARY KEY,
    tipo VARCHAR2(15) 
        CHECK (tipo IN ('altacimutal','ecuatorial','motorizadaGoTo'))
);
/* TABLA PACK */
create table PACK(
    modelo VARCHAR2(15) REFERENCES TELESCOPIO,
    montura VARCHAR2(15) REFERENCES MONTURA,
    precio NUMBER (7,2),
    /*CONSTRAINTS DE TABLA*/
        PRIMARY KEY(modelo,montura)
);