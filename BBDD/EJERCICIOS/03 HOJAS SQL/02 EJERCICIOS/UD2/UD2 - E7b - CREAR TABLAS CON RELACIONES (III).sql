DROP TABLE tlfno_trabajador;
DROP TABLE trabajador;

CREATE TABLE trabajador 
(
    nif VARCHAR2(9),
    nombre VARCHAR2(50),
    edad NUMBER(3),
    puesto VARCHAR2(50),
        PRIMARY KEY(nif)
);

CREATE TABLE tlfno_trabajador
(
    telefono NUMBER(9),
    nif VARCHAR2(9),
        PRIMARY KEY(telefono, nif),
        FOREIGN KEY(nif) REFERENCES trabajador(nif)
);

INSERT INTO trabajador VALUES ('46000000W', 'Rubén Ruiz', 33, 
                               'Técnico de mantenimiento');
INSERT INTO trabajador VALUES ('35000000T', 'Ana Isabel Mateos', 42,
                               'Conductora');
                               
INSERT INTO tlfno_trabajador VALUES (916725899, '46000000W');
INSERT INTO tlfno_trabajador VALUES (612000003, '46000000W');
INSERT INTO tlfno_trabajador VALUES (916725899, '35000000T');
INSERT INTO tlfno_trabajador VALUES (610500001, '35000000T');

SELECT * FROM trabajador;
SELECT * FROM tlfno_trabajador;

SELECT 
    t.nombre as NOMBRE, 
    t.nif as DNI,
    t.edad as EDAD,
    t.puesto as TIPO_DE_TRABAJO,
    t_t.telefono as TLFNO
FROM trabajador t
INNER JOIN tlfno_trabajador t_t
ON t.nif = t_t.nif
ORDER BY t.nombre ASC;