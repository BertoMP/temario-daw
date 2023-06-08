drop table peliculas;

create table peliculas(
titulo varchar(40),
año number(4),
duracion number(3),
presupuesto number(12,2),
recaudacion number(12,2) default 0,
oscar number(2),
primary key (titulo,año)
);

insert into peliculas values ('Ben Hur',1959,212,15175000,146900000,11);
insert into peliculas (titulo,año,duracion,presupuesto,recaudacion) 
    values ('Ben Hur',2016,124,100000000,94061311.65);
insert into peliculas values ('Forrest Gump',1994,142,55000000,677387716.78,6);
insert into peliculas values ('El Padrino',1972,175,6000000,245066411.24,3);
insert into peliculas values ('La La Land',2016,128,30000000,445636919.02,6);
insert into peliculas values ('Million Dollar Baby',2004,132,30000000,216763646,4);

commit;

/* 4.1 El número de películas que hay en la tabla. */
SELECT COUNT(*) FROM PELICULAS;

/* 4.2 El número de películas que hay en la tabla que han ganado algún Óscar. */
SELECT COUNT(OSCAR) FROM PELICULAS;

/* 4.3 La duración media de todas las películas de la tabla, redondeada sin 
       decimales.*/
SELECT ROUND(AVG(DURACION), 0) FROM PELICULAS;

/* 4.4 La recaudación más grande que se ha obtenido en una película, redondeada 
       al millar. (por ejemplo 5212015 se redondearía a 5212000) */
SELECT MAX(ROUND(RECAUDACION, -3)) FROM PELICULAS;

/* 4.5 El mayor presupuesto invertido */
SELECT MAX(PRESUPUESTO) FROM PELICULAS;
SELECT TO_CHAR(MAX(PRESUPUESTO),'$999G999G999G999') FROM PELICULAS;

/* 4.6 Cuántas películas tienen un presupuesto mayor que 30 000 000 */
SELECT COUNT(*) FROM PELICULAS
WHERE PRESUPUESTO > 30000000;

/* 4.7 La recaudación obtenida con todas las películas, redondeada sin 
       decimales. */
SELECT ROUND(SUM(RECAUDACION), 0) FROM PELICULAS;
SELECT TO_CHAR(ROUND(SUM(RECAUDACION), 0),'$999G999G999G999') FROM PELICULAS;

/* 4.8 La duración de la película más larga. */
SELECT MAX(DURACION) FROM PELICULAS;

/* 4.9 La recaudación obtenida entre todas las películas que se estrenaron 
       después del año 2000.*/
SELECT SUM(RECAUDACION) FROM PELICULAS
WHERE AÑO > 2000;

SELECT TO_CHAR(SUM(RECAUDACION),'$999G999G999D99') FROM PELICULAS
WHERE AÑO > 2000;

/* 4.10 La menor recaudación obtenida. Se mostrará la recaudación sin 
        decimales.*/
SELECT ROUND(MIN(RECAUDACION), 0) FROM PELICULAS;
SELECT TO_CHAR(ROUND(MIN(RECAUDACION),0),'$999G999G999G999') FROM PELICULAS;

/* 4.11 El año de la película más antigua, el año de la película más moderna y 
        la diferencia de años entre ambas con el texto “DIFERENCIA”. Estos tres 
        datos se deben obtener con una sola consulta (un solo select). */
SELECT MAX(AÑO), MIN(AÑO), (MAX(AÑO) - MIN(AÑO)) "DIFERENCIA" FROM PELICULAS;

/* 4.12 El beneficio de cada película, con el título “beneficio”. Para 
        obtener el beneficio hay que tener en cuenta la cantidad invertida 
        (presupuesto) y la recaudada. También aparecerá el título y año de cada 
        película. Se ordenará la tabla por orden decreciente del beneficio. */
SELECT (RECAUDACION - PRESUPUESTO) "BENEFICIO", TITULO, AÑO FROM PELICULAS
ORDER BY (RECAUDACION - PRESUPUESTO) DESC;

SELECT TO_CHAR((RECAUDACION - PRESUPUESTO),'$999G999G999D99') "BENEFICIO", 
    TITULO, AÑO FROM PELICULAS
ORDER BY (RECAUDACION - PRESUPUESTO) DESC;

/* 4.13 La media de la duración de todas las películas de la tabla, redondeada 
        a un decimal. */
SELECT ROUND(AVG(DURACION), 1) FROM PELICULAS;

/* 4.14 Cuántas películas duran entre 2 horas y dos horas y media. */
SELECT COUNT(*) FROM PELICULAS
WHERE DURACION BETWEEN 120 AND 150;

/* 4.15 La duración de todas las películas juntas, expresada en horas. */
SELECT ROUND((SUM(DURACION) / 60),0) FROM PELICULAS;
SELECT ROUND((SUM(DURACION) / 60),2) FROM PELICULAS;

/* 4.16 Cuántos títulos distintos de películas hay. */
SELECT COUNT(DISTINCT TITULO) FROM PELICULAS;