SELECT * FROM ALUMNOS;
SELECT * FROM ASIGNATURAS;
SELECT * FROM NOTAS;

/* a) Visualiza todas las asignaturas que contentan tres letras 'o' en su
      interior y tengan alumnos matriculados de 'Madrid'. */

SELECT NOMBRE FROM ASIGNATURAS A, NOTAS N, ALUMNOS AL
WHERE A.COD = N.COD AND N.DNI = AL.DNI
    AND NOMBRE LIKE '%o%o%o%'
    AND AL.POBLA = 'Madrid'; 

/* b) Visualiza los nombres de alumnos de "Madrid" que tengan alguna asignatura
      suspendida. */

SELECT APENOM FROM ALUMNOS AL, NOTAS N
WHERE N.DNI = AL.DNI
    AND POBLA = 'Madrid'
    AND NOTA < 5;

/* c) Muestra los nombre de alumnos que tengan la misma nota que tiene 'Díaz 
      Fernández, María' en 'FOL' en alguna asignatura. */

SELECT DISTINCT APENOM FROM ALUMNOS A, NOTAS N
WHERE A.DNI = N.DNI
    AND N.NOTA = (SELECT NOTA FROM NOTAS N, ALUMNOS A, ASIGNATURAS ASI
                  WHERE A.DNI = N.DNI AND ASI.COD = N.COD
                  AND A.APENOM = 'Díaz Fernández, María'
                  AND ASI.NOMBRE = 'FOL')
    AND A.APENOM != 'Díaz Fernández, María';
                                
/* d) Obtén los datos de las asignaturas que no tengan alumnos. */

SELECT * FROM ASIGNATURAS A
WHERE A.COD NOT IN (SELECT COD FROM NOTAS);

/* e) Obtén el nombre y apellido de los alumnos que tengan nota en la asignatura
      con código 1. */

SELECT APENOM FROM ALUMNOS A, NOTAS N
WHERE A.DNI = N.DNI
    AND N.COD = 1;

/* f) Obtén el nombre y apellido de los alumnos que no tengan nota en la
      asignatura con código 1. */

SELECT DISTINCT APENOM FROM ALUMNOS A, NOTAS N
WHERE A.DNI = N.DNI
    AND A.DNI NOT IN(SELECT DNI FROM NOTAS
                     WHERE COD = 1);
                     
/* g) Obtén el listado completo de calificaciones: nombre y apellido de alumno,
      nombre de asignatura y nota del alumno. Aparecerá ordenado por alumno
      y asignatura.*/

SELECT APENOM, NOMBRE, NOTA FROM ALUMNOS A, ASIGNATURAS ASI, NOTAS N
WHERE N.COD = ASI.COD AND A.DNI = N.DNI
ORDER BY APENOM ASC, NOMBRE ASC;
