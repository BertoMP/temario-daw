/* a) Obtén la suma de salarios, el salario máximo y el salario mínimo por 
      cada departamento. */
SELECT SUM(SALARIO), MAX(SALARIO), MIN(SALARIO)
FROM EMPLE
GROUP BY DEPT_NO;

/* b) Visualiza el número mínimo de empleados que tiene algún departamento. */
SELECT MIN(COUNT(*))
FROM EMPLE
GROUP BY DEPT_NO;