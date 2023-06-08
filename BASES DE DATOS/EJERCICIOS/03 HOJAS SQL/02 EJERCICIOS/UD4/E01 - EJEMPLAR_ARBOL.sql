CREATE TABLE EJEMPLAR_ARBOL(
    ESPECIE VARCHAR2(20),
    POBLACION VARCHAR2(30),
    PROVINCIA VARCHAR2(20),
    ORDEN_REG NUMBER(4),
    A�O_PLANT NUMBER(7),
    PULGON VARCHAR2(2) CHECK (PULGON IN ('SI','NO')),
    COCHINILLA VARCHAR2(2) CHECK (COCHINILLA IN ('SI','NO')),
    ALTURA_CM NUMBER(7),
    ESTADO VARCHAR2(7) CHECK (ESTADO IN ('SANO','ENFERMO')),
    RIEGO VARCHAR2(10),
    REC_PERIODICIDAD_PODA VARCHAR2(10),
    ULTIMA_PODA VARCHAR2(15),
        CONSTRAINT PK_EJEMPLAR_ARBOL 
            PRIMARY KEY (ESPECIE,POBLACION,PROVINCIA,ORDEN_REG)
);

--1.1
SELECT * FROM EJEMPLAR_ARBOL;
--1.2
SELECT DISTINCT ESPECIE, ALTURA_CM FROM EJEMPLAR_ARBOL
ORDER BY ESPECIE ASC, ALTURA_CM DESC;
--1.3
SELECT DISTINCT A.ESPECIE FROM EJEMPLAR_ARBOL "A";
--1.4
SELECT * FROM EJEMPLAR_ARBOL
WHERE POBLACION='COSLADA'
ORDER BY A�O_PLANT DESC;
--1.5
SELECT A�O_PLANT, ALTURA_CM "ALTURA EN CENT�METROS" FROM EJEMPLAR_ARBOL
WHERE ESPECIE='ENCINA';
--1.6
SELECT DISTINCT ESPECIE, ESTADO FROM EJEMPLAR_ARBOL
ORDER BY ESTADO DESC;
--1.7
SELECT DISTINCT ESPECIE FROM EJEMPLAR_ARBOL
WHERE ESTADO='ENFERMO'
ORDER BY ESPECIE ASC;
--1.8
SELECT DISTINCT POBLACION FROM EJEMPLAR_ARBOL 
WHERE COCHINILLA='NO' AND PULGON='NO' AND ESTADO='ENFERMO'
ORDER BY POBLACION ASC;
--1.9
SELECT DISTINCT ESPECIE FROM EJEMPLAR_ARBOL
WHERE POBLACION='RIVAS-VACIAMADRID' AND COCHINILLA='SI';
--1.10
SELECT ESPECIE, A�O_PLANT, ALTURA_CM FROM EJEMPLAR_ARBOL
WHERE PROVINCIA='GUADALAJARA'
ORDER BY A�O_PLANT ASC, ALTURA_CM DESC;