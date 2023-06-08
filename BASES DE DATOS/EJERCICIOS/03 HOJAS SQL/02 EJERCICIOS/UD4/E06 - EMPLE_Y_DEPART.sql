SELECT * FROM EMPLE;
SELECT * FROM DEPART;

/* a) Selecciona la localidad de los departamentos de aquellos empleados cuyo
      oficio sea "ANALISTA". */

SELECT DISTINCT LOC FROM DEPART D
WHERE D.DEPT_NO IN (SELECT DEPT_NO FROM EMPLE
                    WHERE OFICIO = 'ANALISTA');

SELECT DISTINCT LOC FROM DEPART D, EMPLE E
WHERE E.DEPT_NO = D.DEPT_NO
    AND E.OFICIO = 'ANALISTA';

/* b) Obtén los datos de los empleados cuyo director (columna DIR de la tabla
      EMPLE) sea "CEREZO". */

SELECT * FROM EMPLE
WHERE DIR = (SELECT EMP_NO FROM EMPLE
             WHERE APELLIDO = 'CEREZO');

SELECT E.* FROM EMPLE E, EMPLE EM
WHERE E.DIR = EM.EMP_NO
    AND EM.APELLIDO = 'CEREZO';
    
/* c) Obtén los datos de los empleados del departamento de "VENTAS". */

SELECT * FROM EMPLE E
WHERE E.DEPT_NO = (SELECT DEPT_NO FROM DEPART
                   WHERE DNOMBRE = 'VENTAS');

SELECT E.* FROM EMPLE E, DEPART D
WHERE E.DEPT_NO = D.DEPT_NO
    AND D.DNOMBRE = 'VENTAS';
    

/* d) Obtén los datos de los departamentos que NO tienen empleados. */

SELECT * FROM DEPART D
WHERE D.DEPT_NO NOT IN(SELECT DEPT_NO FROM EMPLE);

/* e) Obtén los datos de los departamentos que tengan empleados. */

SELECT * FROM DEPART D
WHERE D.DEPT_NO IN(SELECT DEPT_NO FROM EMPLE);

/* f) Obtén el apellido y el salario de los empleados que superen todos los
      salarios de los empleados del departamento 20. */

SELECT APELLIDO, SALARIO FROM EMPLE E
WHERE E.SALARIO > (SELECT MAX(SALARIO) FROM EMPLE
                   WHERE DEPT_NO = 20);

SELECT APELLIDO, SALARIO FROM EMPLE E, DEPART D
WHERE E.DEPT_NO = D.DEPT_NO 
    AND E.SALARIO > (SELECT MAX(SALARIO) FROM EMPLE
                     WHERE DEPT_NO = 20);

/* g) Para cada empleado obtén: número empleado, apellido y apellido de su
      director (aparecerá como "DIRECTOR") */

SELECT E.EMP_NO, E.APELLIDO, EM.APELLIDO "DIRECTOR" FROM EMPLE E, EMPLE EM
WHERE E.DIR = EM.EMP_NO;


SELECT E.EMP_NO, E.APELLIDO, (SELECT APELLIDO FROM EMPLE WHERE EMP_NO = E.DIR)
    "DIRECTOR" FROM EMPLE E;
