DROP TABLE CENTROS cascade constraints; 

CREATE TABLE CENTROS (
 COD_CENTRO   NUMBER(4) PRIMARY KEY,
 TIPO_CENTRO  CHAR(1),
 NOMBRE VARCHAR2(30),
 DIRECCION VARCHAR2(26),
 TELEFONO NUMBER(9),
 NUM_PLAZAS NUMBER(4)
 ) ;


INSERT INTO CENTROS VALUES (10,'C','IES El Quijote', 'Avda. Los Molinos 25', 915887654,538);
INSERT INTO CENTROS VALUES (15,'P','CP Los Danzantes', 'C/Las Musas s/n',985112322,250);
INSERT INTO CENTROS VALUES (22,'C', 'IES Planeta Tierra', 'C/Mina 45',925443400,300);
INSERT INTO CENTROS VALUES (45,'P', 'CP Manuel Hidalgo', 'C/Granada 5',926202310,220);
INSERT INTO CENTROS VALUES (50,'C', 'IES Gaud�', 'C/Los Torneros 21',919406090,310);
COMMIT;

SELECT *
FROM CENTROS;

DELETE CENTROS
WHERE COD_CENTRO = 50;