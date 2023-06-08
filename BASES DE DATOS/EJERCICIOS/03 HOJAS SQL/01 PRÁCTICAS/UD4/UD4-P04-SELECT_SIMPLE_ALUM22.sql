--***TABLA ALUM22***************

Drop table ALUM22; --ES NORMAL QUE FALLE SI LA TABLA NO EXISTE PREVIAMENTE

create table ALUM22(
DNI	VARCHAR2(10) PRIMARY KEY,
NOMBRE	CHAR(15) NOT NULL,
APELLIDOS	VARCHAR2(20) NOT NULL,
FECHA_NAC	DATE,
DIRECCION	VARCHAR2(20),
POBLACION	VARCHAR2(20),
PROVINCIA	VARCHAR2(20),
CURSO	NUMBER(2)  NOT NULL,
NIVEL	VARCHAR2(3)  NOT NULL,
CLASE	CHAR(1)  NOT NULL,
FALTAS1	NUMBER(2),
FALTAS2	NUMBER(2),
FALTAS3	NUMBER(2)
);

INSERT INTO ALUM22 VALUES ('34448974N', 'CONCHA', 'ESTRUCH VIDAL','10/11/2004',
'C/ MEDICO FELIX, 12','BERROCALEJO', 'CACERES',2,'DAI','A',0,0,0);

INSERT INTO ALUM22 VALUES ('34448999N', 'DORA', 'MARTIN BRE A','10/11/2004',
'C/ MEDICO FELIX, 10','BERROCALEJO', 'CACERES',1,'ESO','C',0,0,0);

INSERT INTO ALUM22 VALUES ('45021354R', 'JULIO', 'CISNEROS','09/11/2002',
'C/ VIA GRANDE, 34','VILLARRIBA', 'GUADALAJARA',2,'ASI','B',25,3,0);

INSERT INTO ALUM22 VALUES ('12345678E', 'ANDR S', 'PALOMERA','19/03/2002',
'C/ CURTIDORES, 13','RIOFRIO', 'GUADALAJARA',2,'ASI','B',3,3,1);

INSERT INTO ALUM22 VALUES ('3456754B', 'EVA', 'MARTINEZ','05/03/2001',
'C/ JULIETA, 67','COLINDRES', 'CANTABRIA',1,'ESO','D',0,33,2);

INSERT INTO ALUM22 VALUES ('7654567Y', 'JASMIN', 'YAWHAJER','12/05/2005',
'C/ VIA GRANDE, 38','VILLARRIBA', 'GUADALAJARA',4,'ESO','B',11,0,1);

INSERT INTO ALUM22 VALUES ('45652356P', 'ANDREA', 'MATEOS','28/03/2005',
'C/ JAMONES, 2','SANTANDER', 'CANTABRIA',3,'ESO','A',0,1,4);

INSERT INTO ALUM22 VALUES ('45673654S', 'JULIA', 'PEREZ','15/08/2001',
'C/ CULEBRA, 6','LOECHES', 'MADRID',1,'ASI','A',0,0,1);

INSERT INTO ALUM22 VALUES ('31448974T', 'CONCHA', 'VINOTERO','10/11/2001',
'C/ MEDICO FELIX, 13','BERROCALEJO', 'CACERES',2,'DAI','A',1,2,0);

INSERT INTO ALUM22 VALUES ('34448339N', 'DENIS', 'MARTINEZ','10/12/2001',
'C/ MEDICO FELIX, 24','BERROCALEJO', 'CACERES',1,'ESO','C',0,0,0);

INSERT INTO ALUM22 VALUES ('35021354R', 'JULI N', 'CANTOBLANCO','12/11/2004',
'C/ VIA GRANDE, 30','VILLARRIBA', 'GUADALAJARA',2,'ASI','B',12,0,1);

INSERT INTO ALUM22 VALUES ('33345678R', 'AGUST N', 'PARRONDO','30/03/2001',
'C/ CURTIDORES, 11','RIOFRIO', 'GUADALAJARA',2,'ASI','B',0,0,1);

INSERT INTO ALUM22 VALUES ('1446754B', 'CLAUDIA', 'MANTOBLANCO','15/08/2003',
'C/ JULIETA, 61','COLINDRES', 'CANTABRIA',1,'ESO','D',0,0,2);

INSERT INTO ALUM22 VALUES ('3654567R', 'HICHAM', 'ALAHAT','10/02/2002',
'C/ VIA GRANDE, 31','VILLARRIBA', 'GUADALAJARA',4,'ESO','B',11,0,1);

INSERT INTO ALUM22 VALUES ('44652356E', 'ANDREA', 'PEREZ','19/01/2001',
'C/ JAMONES, 2','SANTANDER', 'CANTABRIA',3,'ESO','A',0,1,4);


COMMIT;

--A)
SELECT * FROM ALUM22;
--B)
SELECT DNI, NOMBRE, APELLIDOS, CURSO, NIVEL, CLASE FROM ALUM22
ORDER BY NOMBRE ASC, APELLIDOS ASC;
--C)
SELECT * FROM ALUM22
WHERE PROVINCIA='GUADALAJARA';
--D)
SELECT NOMBRE, APELLIDOS, FECHA_NAC FROM ALUM22
WHERE PROVINCIA='GUADALAJARA'
ORDER BY FECHA_NAC DESC;