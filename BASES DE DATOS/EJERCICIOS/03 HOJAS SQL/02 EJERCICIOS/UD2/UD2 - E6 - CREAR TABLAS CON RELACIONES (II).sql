CREATE TABLE persona
(
    dni VARCHAR2(9) PRIMARY KEY,
    nombre VARCHAR2(20),
    edad NUMBER(3),
    padre VARCHAR2(9) REFERENCES persona(dni)
);

INSERT INTO persona VALUES ('10000000A', 'Juan', 32, NULL);
/* Otra forma de ponerlo sería:
INSERT INTO persona (dni, nombre, edad) VALUES ('10000000A', 'Juan', 32);
De esta forma no será necesario declarar el NULL*/
INSERT INTO persona VALUES ('20000000A', 'Luis', 54, NULL);
INSERT INTO persona VALUES ('40000000A', 'Luis', 18, '20000000A');
INSERT INTO persona VALUES ('30000000A', 'Daniel', 73, NULL);
INSERT INTO persona VALUES ('50000000A', 'Alberto', 51, '30000000A');
INSERT INTO persona VALUES ('60000000A', 'Eva', 51, '50000000A');

SELECT * FROM persona;