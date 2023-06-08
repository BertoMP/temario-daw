Drop table notas_alumnos cascade constraints;

create table notas_alumnos
 (
   NOMBRE_ALUMNO VARCHAR2(25) primary key ,
   nota1 number(2),
   nota2 number(2),
   nota3 number(2)
 ) ;
 
insert into NOTAS_ALUMNOS VALUES ('Alcalde García, M. Luisa',5,5,5);
insert into NOTAS_ALUMNOS VALUES ('Benito Martín, Luis',7,6,8);
insert into NOTAS_ALUMNOS VALUES ('Casas Martínez, Manuel',7,5,NULL);
insert into NOTAS_ALUMNOS VALUES ('Corregidor Sánchez, Ana',6,9,8);
insert into NOTAS_ALUMNOS VALUES ('Díaz Sánchez, Maria',NULL,NULL,7);

commit;

--A)
SELECT * FROM NOTAS_ALUMNOS;

--B)
SELECT NOMBRE_ALUMNO, (NOTA1 + NOTA2 + NOTA3) / 3 "NOTA MEDIA" 
    FROM NOTAS_ALUMNOS;

--C)
SELECT NOMBRE_ALUMNO, ROUND((NOTA1 + NOTA2 + NOTA3) / 3,2) "NOTA MEDIA" 
    FROM NOTAS_ALUMNOS;