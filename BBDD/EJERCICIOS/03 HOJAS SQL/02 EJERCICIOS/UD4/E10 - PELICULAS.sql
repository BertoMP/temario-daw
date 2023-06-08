SELECT * FROM PELICULAS;

/* a) Visualiza la película con mayor presupuesto. */

SELECT * 
FROM PELICULAS
WHERE PRESUPUESTO = (SELECT MAX(PRESUPUESTO) 
                     FROM PELICULAS);

/* b) Visualiza la película más larga. */

SELECT * 
FROM PELICULAS
WHERE DURACION = (SELECT MAX(DURACION) 
                  FROM PELICULAS);

/* c) El nombre, año y recaudación de la película con menor recaudación.
      La recaudación se mostrará sin decimales (redondear). */

SELECT TITULO, AÑO, ROUND(RECAUDACION,0) RECAUDACION 
FROM PELICULAS
WHERE RECAUDACION = (SELECT MIN(RECAUDACION) 
                     FROM PELICULAS);

/* d) El nombre, año y beneficio de la película más antigua. El beneficio
      se calculara a partir del presupuesto y la recaudación. */

SELECT TITULO, AÑO, (RECAUDACION - PRESUPUESTO) BENEFICIO 
FROM PELICULAS
WHERE AÑO = (SELECT MIN(AÑO) 
             FROM PELICULAS);

/* e) Para cada película se verá el título, año y la diferencia de duración
      que tiene con la duración media de las peliculas de la tabla. Este
      último campo aparecerá redondeado sin decimales y con nombre
      "difiere de la media". */

SELECT TITULO, AÑO, ROUND((DURACION - (SELECT AVG(DURACION) 
                                       FROM PELICULAS)),0) "DIFIERE DE LA MEDIA" 
FROM PELICULAS;

/* f) Para cada película se verá el título, año y la diferencia de recaudación
      con respecto a la mayor recaudación (redondeado a las unidades de
      millar). */

SELECT TITULO, AÑO, ROUND(RECAUDACION - (SELECT MAX(RECAUDACION) 
                                         FROM PELICULAS),-3) DIFIERE 
FROM PELICULAS;
