DROP TABLE TUBOS_PINTURA;
DROP TABLE MALETINES;

CREATE TABLE MALETINES(
COD_MALETIN VARCHAR2(3) PRIMARY KEY,
MATERIAL VARCHAR2(30),
CAPACIDAD NUMBER(3)
);

CREATE TABLE TUBOS_PINTURA(
REF NUMBER(3) PRIMARY KEY,
MARCA VARCHAR2(30),
COLOR VARCHAR2(30),
TIPO VARCHAR2(30) CHECK (TIPO IN ('√≥leo','acr√≠lico','acuarela')),
COD_MALETIN VARCHAR2(3) REFERENCES MALETINES ON DELETE SET NULL
);

INSERT INTO MALETINES VALUES ('M-1','madera de pino',15);
INSERT INTO MALETINES VALUES ('M-2','resina',35);
INSERT INTO MALETINES VALUES ('M-3','madera de pino',50);
INSERT INTO MALETINES VALUES ('M-4','resina',12);
INSERT INTO MALETINES VALUES ('M-5','madera de roble',45);
INSERT INTO MALETINES VALUES ('M-6','pl√°stico',45);
INSERT INTO TUBOS_PINTURA(REF,MARCA,COLOR,TIPO) VALUES('010','Tit√°n','azul ultramar','√≥leo');
INSERT INTO TUBOS_PINTURA(REF,MARCA,COLOR,TIPO) VALUES('011','Tit√°n','azul cobalto','√≥leo');
INSERT INTO TUBOS_PINTURA(REF,MARCA,COLOR,TIPO) VALUES('012','Tit√°n','azul cobalto','acuarela');
INSERT INTO TUBOS_PINTURA(REF,MARCA,COLOR,TIPO) VALUES('013','Winsor and Newton','azul ultramar','acuarela');
INSERT INTO TUBOS_PINTURA VALUES('034','Van Gogh','laca carm√≠n','acuarela','M-2');
INSERT INTO TUBOS_PINTURA VALUES('036','Van Gogh','verde esmeralda','acuarela','M-2');
INSERT INTO TUBOS_PINTURA VALUES('037','Rembrandt','ocre amarillo','acr√≠lico','M-3');
INSERT INTO TUBOS_PINTURA VALUES('045','Rembrandt','siena tostada','acr√≠lico','M-3');
INSERT INTO TUBOS_PINTURA VALUES('046','Rembrandt','siena natural','acr√≠lico','M-3');
INSERT INTO TUBOS_PINTURA VALUES('047','Rembrandt','sombra tostada','acr√≠lico','M-3');
INSERT INTO TUBOS_PINTURA VALUES('048','Rembrandt','sombra natural','acr√≠lico','M-3');
INSERT INTO TUBOS_PINTURA VALUES('050','Amsterdam','azul cyan','√≥leo','M-5');
INSERT INTO TUBOS_PINTURA VALUES('060','Amsterdam','negro','√≥leo','M-5');
INSERT INTO TUBOS_PINTURA VALUES('014','Tit√°n','blanco','√≥leo','M-5');

COMMIT;

SELECT * FROM MALETINES;
SELECT * FROM TUBOS_PINTURA;

/* a) Muestra, para cada tubo de pintura, su referencia y el material del 
      maletÌn en el que est· guardado. Solo deben visualizarse los tubos que 
      se guardan dentro de un malet√≠n. */

SELECT REF, MATERIAL
FROM MALETINES M, TUBOS_PINTURA TP
WHERE M.COD_MALETIN = TP.COD_MALETIN;

SELECT REF, MATERIAL
FROM MALETINES M
INNER JOIN TUBOS_PINTURA TP ON M.COD_MALETIN = TP.COD_MALETIN;

/* b) Muestra la cantidad de tubos de pintura que hay en el maletÌn M-3. */

SELECT COUNT(*) "CANTIDAD"
FROM TUBOS_PINTURA
WHERE COD_MALETIN = 'M-3';

/* c) Muestra la referencia y el color de todos los tubos de pintura, asÌ como 
      el cÛdigo y el material del maletÌn donde se guardan. TambiÈn deben 
      aparecer los tubos que se venden sueltos (no est·n dentro de ning˙n 
      maletÌn) */

SELECT REF, COLOR, M.COD_MALETIN, MATERIAL
FROM MALETINES M, TUBOS_PINTURA TP
WHERE M.COD_MALETIN(+) = TP.COD_MALETIN;

SELECT REF, COLOR, M.COD_MALETIN, MATERIAL
FROM MALETINES M
RIGHT JOIN TUBOS_PINTURA TP ON M.COD_MALETIN = TP.COD_MALETIN;
