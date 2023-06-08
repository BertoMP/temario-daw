--a) Obtén los departamentos en los que el salario medio es mayor de 2500.
SELECT DEPT_NO
FROM EMPLE
GROUP BY DEPT_NO
HAVING AVG(SALARIO) > 2500;

/*b) Obtén los departamentos en los que el salario medios es mayor o igual que
     la media de todos los salarios. */
SELECT DEPT_NO
FROM EMPLE
GROUP BY DEPT_NO
HAVING AVG(SALARIO) >= (
    SELECT AVG(SALARIO)
    FROM EMPLE);


