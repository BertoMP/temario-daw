--******** TABLA DEPART: ***********

DROP TABLE DEPART cascade constraints; --es normal que falle si la tabla no existe previamente

CREATE TABLE DEPART (
 DEPT_NO  NUMBER(2) PRIMARY KEY,
 DNOMBRE  VARCHAR2(14) UNIQUE, 
 LOC      VARCHAR2(14) ) ;

INSERT INTO DEPART VALUES (10,'CONTABILIDAD','SEVILLA');
INSERT INTO DEPART VALUES (20,'INVESTIGACION','MADRID');
INSERT INTO DEPART VALUES (30,'VENTAS','BARCELONA');
INSERT INTO DEPART VALUES (40,'PRODUCCION','BILBAO');

--******** TABLA EMPLE: *************

DROP TABLE EMPLE cascade constraints; --es normal que falle si la tabla no existe previamente

CREATE TABLE EMPLE (
 EMP_NO    NUMBER(4) PRIMARY KEY,
 APELLIDO  VARCHAR2(10) UNIQUE , --esto es una simplificaci n de un caso real
 OFICIO    VARCHAR2(15)  ,
 DIR       NUMBER(4) REFERENCES EMPLE ON DELETE SET NULL,
 FECHA_ALT DATE      ,
 SALARIO   NUMBER(7),
 COMISION  NUMBER(7),
 DEPT_NO   NUMBER(2) REFERENCES DEPART ON DELETE SET NULL) ;

INSERT INTO EMPLE VALUES (7839,'REY','PRESIDENTE',NULL,'17/11/2019',4100,NULL,10);
INSERT INTO EMPLE VALUES (7566,'JIMENEZ','DIRECTOR',7839,'02/04/2020',2900,NULL,20);
INSERT INTO EMPLE VALUES (7902,'FERNANDEZ','ANALISTA',7566,'03/12/2020',3000,NULL,20);
INSERT INTO EMPLE VALUES (7369,'SANCHEZ','DESARROLLADOR',7902,'17/12/2019',1040,NULL,20);
INSERT INTO EMPLE VALUES (7698,'NEGRO','DIRECTOR',7839,'01/05/2020',3005,NULL,30);
INSERT INTO EMPLE VALUES (7499,'ARROYO','VENDEDOR',7698,'20/02/2021',1500,390,30);
INSERT INTO EMPLE VALUES (7521,'SALA','VENDEDOR',7698,'22/02/2021',1625,650,30);
INSERT INTO EMPLE VALUES (7654,'MARTIN','VENDEDOR',7698,'29/09/2021',1600,1020,30);
INSERT INTO EMPLE VALUES (7782,'CEREZO','DIRECTOR',7839,'09/06/2021',2885,NULL,10);
INSERT INTO EMPLE VALUES (7788,'GIL','ANALISTA',7566,'09/11/2020',3000,NULL,20);
INSERT INTO EMPLE VALUES (7844,'TOVAR','DESARROLLADOR',7698,'08/09/2021',1350,0,30);
INSERT INTO EMPLE VALUES (7876,'ALONSO','DESARROLLADOR',7788,'23/09/2020',1430,NULL,20);
INSERT INTO EMPLE VALUES (7900,'JIMENO','DESARROLLADOR',7698,'03/12/2021',1335,NULL,30);
INSERT INTO EMPLE VALUES (7934,'MU�OZ','DESARROLLADOR',7782,'23/01/2020',1690,NULL,10);
COMMIT;

--A) 
SELECT * FROM EMPLE;
--B)
SELECT EMP_NO, APELLIDO, SALARIO FROM EMPLE;
--C)
SELECT DISTINCT APELLIDO FROM EMPLE;