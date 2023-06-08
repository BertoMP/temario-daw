/* a. Partiendo de la tabla EMPLE, visualiza por cada oficio de los empleados
      del departamento 'VENTAS' la suma de salarios. */
SELECT OFICIO, COUNT(*), SUM(SALARIO)
FROM EMPLE E
INNER JOIN DEPART D ON E.DEPT_NO = D.DEPT_NO
WHERE DNOMBRE = 'VENTAS'
GROUP BY OFICIO;

/* b. Selecciona aquellos apellidos de la tabla EMPLE cuyo salario sea el mayor
      salario en su departamento. */
SELECT APELLIDO
FROM EMPLE
WHERE (DEPT_NO, SALARIO) IN (SELECT DEPT_NO, MAX(SALARIO) 
                             FROM EMPLE 
                             GROUP BY DEPT_NO);

/* c. A partir de la tabla EMPLE, visualiza el número de empleados de cada
      departamento cuyo oficio sea 'DESARROLLADOR'. */
SELECT E.DEPT_NO, D.DNOMBRE, COUNT(*)
FROM EMPLE E
INNER JOIN DEPART D ON E.DEPT_NO = D.DEPT_NO
WHERE OFICIO = 'DESARROLLADOR'
GROUP BY E.DEPT_NO, D.DNOMBRE;

/* d. Desde la tabla EMPLE, visualiza el departamento que tenga más
      empleados cuyo oficio sea 'DESARROLLADOR'. */

SELECT DEPT_NO
FROM EMPLE
WHERE OFICIO = 'DESARROLLADOR'
GROUP BY DEPT_NO
HAVING COUNT(*) = (SELECT MAX(COUNT(*))
                   FROM EMPLE
                   WHERE OFICIO = 'DESARROLLADOR'
                   GROUP BY DEPT_NO);

/* e. A partir de las tablas EMPLE y DEPART, visualiza el número de departamento
      y el nombre de departamento que tenga más empleados cuyo oficio sea 
      'DESARROLLADOR' */
SELECT E.DEPT_NO, D.DNOMBRE
FROM EMPLE E
INNER JOIN DEPART D ON E.DEPT_NO = D.DEPT_NO
WHERE OFICIO = 'DESARROLLADOR'
GROUP BY E.DEPT_NO, D.DNOMBRE
HAVING COUNT(*) = (SELECT MAX(COUNT(*))
                   FROM EMPLE
                   WHERE OFICIO = 'DESARROLLADOR'
                   GROUP BY DEPT_NO);

/* f. Busca los departamentos que tienen más de dos personas trabajando en la 
      misma profesión. */
SELECT DEPT_NO
FROM EMPLE
GROUP BY DEPT_NO, OFICIO
HAVING COUNT(EMP_NO) > 2;