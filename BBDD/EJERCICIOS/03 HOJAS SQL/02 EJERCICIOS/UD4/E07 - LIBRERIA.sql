SELECT * FROM LIBRERIA;

/* a) Visualiza el tema, estante y ejemplares de las filas de LIBRERIA con
      ejemplares comprendidos entre 8 y 15. */

SELECT * FROM LIBRERIA
WHERE EJEMPLARES BETWEEN 8 AND 15;

/* b) Visualiza las columnas TEMA, ESTANTE y EJEMPLARES de las filas cuyo
      ESTANTE no está comprendido entre la "B" y la "D" */

SELECT * FROM LIBRERIA
WHERE ESTANTE NOT BETWEEN 'B' AND 'D';

/* c) Visualiza con una sola orden SELECT todos los temas de librería cuyo
      número de ejemplares sea inferior a los que hay en "MEDICINA". */

SELECT TEMA FROM LIBRERIA L
WHERE L.EJEMPLARES < (SELECT EJEMPLARES FROM LIBRERIA
                      WHERE TEMA = 'MEDICINA');

/* d) Visualiza los temas de LIBRERIA cuyo número de ejemplares no está entre
      15 y 20, ambos incluidos. */

SELECT TEMA FROM LIBRERIA
WHERE EJEMPLARES NOT BETWEEN 15 AND 20;

/* e) Visualiza los temas con mayor número de ejemplares y que tengan al menos
      una "E". */

SELECT TEMA, EJEMPLARES FROM LIBRERIA L
WHERE L.EJEMPLARES > (SELECT AVG(EJEMPLARES) FROM LIBRERIA)
    AND TEMA LIKE '%E%';
