--2.1
SELECT * FROM EMPLE;

INSERT INTO EMPLE
SELECT 1111, 'GARCÍA', 'ANALISTA', 7566, (SYSDATE + 1), 2000, 120, DEPT_NO
FROM EMPLE
GROUP BY DEPT_NO
HAVING COUNT(EMP_NO) = (SELECT MAX(COUNT(EMP_NO))
                        FROM EMPLE
                        GROUP BY DEPT_NO);

--2.2
UPDATE EMPLE
SET SALARIO = (SALARIO / 2),
    COMISION = 0
WHERE DEPT_NO = (SELECT DEPT_NO
                 FROM EMPLE
                 GROUP BY DEPT_NO
                 HAVING COUNT(EMP_NO) = (SELECT MAX(COUNT(EMP_NO))
                                         FROM EMPLE
                                         GROUP BY DEPT_NO));

--2.3
UPDATE EMPLE
SET DEPT_NO = (SELECT DEPT_NO
               FROM EMPLE
               WHERE OFICIO = 'ANALISTA'
               GROUP BY DEPT_NO
               HAVING COUNT(EMP_NO) = (SELECT MAX(COUNT(EMP_NO))
                                       FROM EMPLE
                                       WHERE OFICIO = 'ANALISTA'
                                       GROUP BY DEPT_NO))
WHERE APELLIDO = 'NEGRO';