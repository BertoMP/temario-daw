--CREAR TABLA
CREATE TABLE monte
(
    nombre VARCHAR2(50),
    provincia VARCHAR2(50),
    altura NUMBER(4),
        PRIMARY KEY (nombre),
        CHECK (altura > 2000),
        CHECK (altura IS NOT NULL)
);

--INSERTAR REGISTROS
INSERT INTO monte VALUES ('Mulhacén', 'Granada', 3479);
INSERT INTO monte VALUES ('Aneto', 'Huesca', 3404);
INSERT INTO monte VALUES ('Teide', 'Santa Cruz de Tenerife', 3718);
INSERT INTO monte VALUES ('Naranjo de Bulnes', 'Asturias', 2519);

--INSERTAR REGISTROS NO VALIDOS
INSERT INTO monte VALUES ('Mulhacén', 'Granada', 3480);
/* Da error ORA-00001 porque se está repitiendo la PK ya que se ha
   insertado el mismo nombre de monte en la fila 1. */
INSERT INTO monte VALUES ('Puig Major', 'Islas Baleares', 1445);
/* Da error ORA-02290 porque se está introduciendo una altura menor
   a la obligatoria por la cláusula CHECK. */
INSERT INTO monte VALUES ('Almanzor', 'Ávila', NULL);
/* Da error ORA-02290 porque se está dejando el campo altura como
   NULL algo que incumple la cláusla CHEK IS NOT NULL que se le ha asignado
   al campo a la hora de crear la tabla. */
