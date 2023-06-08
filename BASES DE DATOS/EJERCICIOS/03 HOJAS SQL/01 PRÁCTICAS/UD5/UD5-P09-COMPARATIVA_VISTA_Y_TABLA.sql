--A)
CREATE TABLE TABLA_PEOR_PAGADOS
AS
SELECT *
FROM EMPLE
WHERE SALARIO = (SELECT MIN(SALARIO)
                 FROM EMPLE);

SELECT *
FROM TABLA_PEOR_PAGADOS;

--B)
CREATE VIEW VISTA_PEOR_PAGADOS
AS
SELECT *
FROM EMPLE
WHERE SALARIO = (SELECT MIN(SALARIO)
                 FROM EMPLE);

SELECT *
FROM VISTA_PEOR_PAGADOS;

--C)
INSERT INTO EMPLE
VALUES (9999,'CATAL�N','ANALISTA',7902,SYSDATE,1040,NULL,10);

--D)
SELECT *
FROM TABLA_PEOR_PAGADOS;

SELECT *
FROM VISTA_PEOR_PAGADOS;