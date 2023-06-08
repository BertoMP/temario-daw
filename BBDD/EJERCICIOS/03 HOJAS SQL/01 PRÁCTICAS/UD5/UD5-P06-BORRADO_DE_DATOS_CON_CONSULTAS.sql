--A
SELECT * 
FROM ANTIGUOS;

--BORRADO DE DATOS
DELETE
FROM ANTIGUOS
WHERE (NOMBRE, EDAD, LOCALIDAD) IN (SELECT *
                                    FROM ALUM);

/*Otra forma de hacerlo*/
DELETE
FROM ANTIGUOS
WHERE (NOMBRE, EDAD, LOCALIDAD) IN (SELECT * FROM ALUM
                                    INTERSECT
                                    SELECT * FROM ANTIGUOS);

--B
SELECT *
FROM DEPART;

DELETE
FROM DEPART
WHERE DEPT_NO NOT IN (SELECT DEPT_NO
                      FROM EMPLE
                      WHERE DEPT_NO IS NOT NULL);