/* a) Visualiza el mayor salario medio por departamento que haya en la 
      empresa. */
SELECT MAX(AVG(SALARIO))
FROM EMPLE
GROUP BY DEPT_NO;

/* b) Visualiza el número de departamento con el mayor salario medio de toda 
      la empresa. */
SELECT DEPT_NO
FROM EMPLE
GROUP BY DEPT_NO
HAVING AVG(SALARIO) = (
    SELECT MAX(AVG(SALARIO))
    FROM EMPLE
    GROUP BY DEPT_NO);
    
/* c) Visualiza el número de departamento y el número de empleados que tiene 
      el departamento con más emplados. */
SELECT DEPT_NO, COUNT(*)
FROM EMPLE
GROUP BY DEPT_NO
HAVING COUNT(*) = (
    SELECT MAX(COUNT(*))
    FROM EMPLE
    GROUP BY DEPT_NO);

/* d) Visualiza el número de departamento, el nombre del departamento y el
      nÃºmero de empleados del departamento con más empleados. */
SELECT E.DEPT_NO, DNOMBRE, COUNT(*)
FROM EMPLE E
INNER JOIN DEPART D ON E.DEPT_NO = D.DEPT_NO
GROUP BY E.DEPT_NO, DNOMBRE
HAVING COUNT(*) = (
    SELECT MAX(COUNT(*))
    FROM EMPLE
    GROUP BY DEPT_NO);

/* e) Obtén los nombres de departamentos con más de 4 personas trabajando en
      ellos. */
SELECT DNOMBRE
FROM DEPART D
INNER JOIN EMPLE E ON D.DEPT_NO = E.DEPT_NO
GROUP BY E.DEPT_NO, DNOMBRE
HAVING COUNT(*) > 4;
