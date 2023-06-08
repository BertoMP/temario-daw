--2.1 Los árboles plantados entre 2010 y 2012.
SELECT * FROM EJEMPLAR_ARBOL
WHERE AÑO_PLANT BETWEEN 2010 AND 2012;

/*2.2 Los árboles de Madrid que no tienen poda registrada (campo “ultima_poda”) 
      y miden más de 300 centímetros.*/
SELECT * FROM EJEMPLAR_ARBOL
WHERE PROVINCIA = 'MADRID' AND ULTIMA_PODA = 'NO REGISTRADA' 
    AND ALTURA_CM > 300;

/*2.3 Los alcornoques plantados en Oviedo antes del 2007 que miden 
      más de 500 centímetros.
      Mostrar todos los datos del árbol, ordenados por altura.*/
SELECT * FROM EJEMPLAR_ARBOL 
WHERE ESPECIE = 'ALCORNOQUE' AND POBLACION = 'OVIEDO'
AND AÑO_PLANT < 2007 AND ALTURA_CM > 500
ORDER BY ALTURA_CM ASC;

/*2.4 Las poblaciones y provincias que han podado árboles (campo “ultima_poda”) 
      y sin embargo no tenían recomendada ninguna poda 
      (campo “rec_periodicidad_poda”).
      Ordenar por provincia, y dentro de provincia por población, en orden 
      alfabético (debe aparecer a la izquierda la provincia y a la derecha 
      la población).*/
SELECT DISTINCT PROVINCIA, POBLACION FROM EJEMPLAR_ARBOL
WHERE ULTIMA_PODA != 'NO REGISTRADA' AND REC_PERIODICIDAD_PODA = 'NO PODA'
ORDER BY PROVINCIA ASC, POBLACION ASC;

/*2.5 Las alturas de los árboles que tienen riego de algún tipo y se plantaron 
      antes del año 2000.
      Deben aparecer ordenadas de mayor a menor.*/
SELECT ALTURA_CM FROM EJEMPLAR_ARBOL
WHERE RIEGO IS NOT NULL AND AÑO_PLANT < 2000
ORDER BY ALTURA_CM DESC;

/*2.6 La especie, orden de registro, recomendación de poda y última poda de 
      árboles de la provincia de Madrid. Ordenar por la última poda realizada.
      No deben aparecer árboles que no tienen poda registrada 
      (campo “ultima_poda”).
      El resultado debe expresar el nombre de las columnas 
      “rec_periodicidad_poda” y “orden_reg” como “recomendación de poda” y 
      “orden de alta en BD”, respectivamente.*/
SELECT ESPECIE, ORDEN_REG "ORDEN DE ALTA EN BD", REC_PERIODICIDAD_PODA
    "RECOMENDACIÓN DE PODA", ULTIMA_PODA FROM EJEMPLAR_ARBOL
WHERE ULTIMA_PODA != 'NO REGISTRADA' AND PROVINCIA = 'MADRID'
ORDER BY ULTIMA_PODA ASC;

/*2.7 Las ciudades que tienen algún tipo de pino plantado (observa bien las 
      especies, hay diversos pinos). También debe mostrarse la especie de pino.
      Hay que tener en cuenta que pueden insertarse nuevos tipos de pino en la 
      base de datos, y la consulta debe seguir siendo válida.*/
SELECT DISTINCT POBLACION, ESPECIE FROM EJEMPLAR_ARBOL
WHERE ESPECIE LIKE 'PINO%';

/*2.8 Las poblaciones que tienen más de una palabra. Hay que mostrar la 
      población y su provincia, ordenadas por provincia.*/
SELECT POBLACION, PROVINCIA FROM EJEMPLAR_ARBOL
WHERE POBLACION LIKE '% %'
ORDER BY PROVINCIA ASC;

/*2.9 Los árboles que están enfermos (campo estado) y no tienen riego de 
      ningún tipo (campo riego).*/
SELECT * FROM EJEMPLAR_ARBOL
WHERE ESTADO = 'ENFERMO' AND RIEGO IS NULL;

/*2.10 Los árboles plantados en las ciudades de Madrid y Barcelona, los años 
       2000, 2010 y 2015, ordenados por ciudad y dentro de ciudad por altura.*/
SELECT * FROM EJEMPLAR_ARBOL
WHERE POBLACION IN('MADRID','BARCELONA') AND AÑO_PLANT IN(2000,2010,2015)
ORDER BY POBLACION ASC, ALTURA_CM ASC;