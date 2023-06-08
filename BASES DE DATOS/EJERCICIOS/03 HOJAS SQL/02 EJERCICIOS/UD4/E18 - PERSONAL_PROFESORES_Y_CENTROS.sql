DROP TABLE PERSONAL cascade constraints; 
DROP TABLE PROFESORES cascade constraints; 
DROP TABLE CENTROS cascade constraints; 

CREATE TABLE CENTROS (
 COD_CENTRO   NUMBER(4) primary key,
 TIPO_CENTRO  CHAR(1),
 NOMBRE VARCHAR2(30),
 DIRECCION VARCHAR2(26),
 TELEFONO VARCHAR2(10),
 NUM_PLAZAS NUMBER(4)
 ) ;
CREATE TABLE PERSONAL (
 COD_CENTRO   NUMBER(4) NOT NULL references CENTROS,
 DNI NUMBER(10),
 APELLIDOS VARCHAR2(30),
 FUNCION VARCHAR2(15),
 SALARIO NUMBER (10) ,
primary key (cod_centro,dni)
);
CREATE TABLE PROFESORES (
 COD_CENTRO   NUMBER(4) NOT NULL,
 DNI          NUMBER(10) ,
 APELLIDOS VARCHAR2(30),
 ESPECIALIDAD VARCHAR2(16) ,
primary key (cod_centro,dni),
foreign key (cod_centro,dni) references personal on delete cascade
) ;

INSERT INTO CENTROS VALUES (10,'S','IES El Quijote', 
'Avda. Los Molinos 25', '965-887654',538);
INSERT INTO CENTROS VALUES (15,'P','CP Los Danzantes', 'C/Las Musas s/n',
'985-112322',250);
INSERT INTO CENTROS VALUES (22,'S', 'IES Planeta Tierra', 'C/Mina 45',
'925-443400',300);
INSERT INTO CENTROS VALUES (45,'P', 'CP Manuel Hidalgo', 'C/Granada 5',
'926-202310',220);
INSERT INTO CENTROS VALUES (50,'S', 'IES Anto�ete', 'C/Los Toreros 21',
'989-406090',310);


INSERT INTO PERSONAL VALUES (10,1112345,'Mart�nez Salas, Fernando',
'PROFESOR', 32000);
INSERT INTO PERSONAL VALUES (10,4123005,'Bueno Zarco, Elisa', 
'PROFESOR', 32000);
INSERT INTO PERSONAL VALUES (10,4122025,'Montes Garc�a, M.Pilar', 
'PROFESOR', 32000);

INSERT INTO PERSONAL VALUES (15,1112346,'Rivera Silvestre, Ana',
'PROFESOR', 30500);
INSERT INTO PERSONAL VALUES (15,9800990, 'Ramos Ruiz, Luis',
'PROFESOR', 30500);
INSERT INTO PERSONAL VALUES (15,8660990, 'De Lucas Fdez, M.Angel',
'PROFESOR', 30500);

INSERT INTO PERSONAL VALUES (22,7650000, 'Ruiz Lafuente, Manuel',
'PROFESOR', 42000);
INSERT INTO PERSONAL VALUES (45,43526789, 'Serrano Lagu�a, Mar�a',
'PROFESOR', 40500);

INSERT INTO PERSONAL VALUES (10,4480099,'Ruano Cerezo, Manuel',
'ADMINISTRATIVO', 28000);
INSERT INTO PERSONAL VALUES (15,1002345,'Albarr�n Serrano, Alicia',
'ADMINISTRATIVO', 28000);
INSERT INTO PERSONAL VALUES (15,7002660,'Mu�oz Rey, Felicia',
'ADMINISTRATIVO', 36000);
INSERT INTO PERSONAL VALUES (22,5502678,'Mar�n Mar�n, Pedro',
'ADMINISTRATIVO', 23000);
INSERT INTO PERSONAL VALUES (22,6600980, 'Peinado Gil, Elena',
'CONSERJE', 20500);
INSERT INTO PERSONAL VALUES (45,4163222, 'Sarro Molina, Carmen',
'CONSERJE', 20500);

INSERT INTO PROFESORES VALUES (10,1112345,'Mart�nez Salas, Fernando',
'INFORM�TICA');
INSERT INTO PROFESORES VALUES (10,4123005,'Bueno Zarco, Elisa', 
'MATEM�TICAS');
INSERT INTO PROFESORES VALUES (10,4122025,'Montes Garc�a, M.Pilar', 
'MATEM�TICAS');

INSERT INTO PROFESORES VALUES (15,9800990, 'Ramos Ruiz, Luis',
	'LENGUA');
INSERT INTO PROFESORES VALUES (15,1112346,'Rivera Silvestre, Ana',
	'DIBUJO');
INSERT INTO PROFESORES VALUES (15,8660990, 'De Lucas Fdez, M.Angel',
'LENGUA');

INSERT INTO PROFESORES VALUES (22,7650000, 'Ruiz Lafuente, Manuel',
'MATEM�TICAS');
INSERT INTO PROFESORES VALUES (45,43526789, 'Serrano Lagu�a, Mar�a',
'INFORM�TICA');


commit;

/* a. Realiza una consulta en la que aparezca por cada centro y en cada 
      especialidad el n�mero de profesores. Si el centro no tiene profesores, 
      debe aparecer un 0 en la columna de n�mero de profesores y un gui�n (-) 
      en la especialidad. Las columnas a visualizar son: nombre de centro, 
      especialidad y n�mero de profesores. */
SELECT C.NOMBRE, NVL(P.ESPECIALIDAD,'-'), COUNT(P.DNI)
FROM PROFESORES P
RIGHT JOIN CENTROS C ON P.COD_CENTRO = C.COD_CENTRO
GROUP BY C.NOMBRE, P.ESPECIALIDAD;

/* b. Obt�n por cada centro el n�mero de empleados. Si el centro carece de 
      empleados, ha de aparecer un 0 como n�mero de empleados.*/
SELECT C.NOMBRE, COUNT(P.DNI)
FROM CENTROS C
LEFT JOIN PERSONAL P ON C.COD_CENTRO = P.COD_CENTRO
GROUP BY C.NOMBRE;

/* c. Obt�n la especialidad con menos profesores. */
SELECT ESPECIALIDAD
FROM PROFESORES
GROUP BY ESPECIALIDAD
HAVING COUNT(*) = (SELECT MIN(COUNT(*))
                   FROM PROFESORES
                   GROUP BY ESPECIALIDAD);