--CREAR TABLA
CREATE TABLE empresario
(
    nif VARCHAR2(9) PRIMARY KEY,
    empresa VARCHAR2(30) UNIQUE NOT NULL,
    nombre VARCHAR2(30),
    mail VARCHAR2(50) UNIQUE 
                      CHECK (mail LIKE '%@%')
);

INSERT INTO empresario VALUES ('85000000H', 'Gesco SL', 'Juan Colindres', 
                               'director@gesco.es');
INSERT INTO empresario VALUES ('44000000C', 'BotCO', 'Julia Martín',
                               'info@bot.com');
INSERT INTO empresario VALUES ('13000000F', 'Tamar', 'Ana Palacios',
                               'informacion-tamar');
INSERT INTO empresario (nif, empresa, mail) VALUES ('77000000G', 'Tintor SA', 
                                                    'info12345@gmail.com');
INSERT INTO empresario VALUES ('75000000G', 'Next SA', 'Julia Martín',
                               'const-77@yahoo.es');
INSERT INTO empresario VALUES ('99000000D', 'Gesco SL', 'Adrián Palomares',
                               'subdir@gesco.es');
INSERT INTO empresario (nif, nombre, mail) VALUES ('47000000S', 'Sergio Olivares',
                                                   'serol_89@goggle.com');
INSERT INTO empresario VALUES ('62000000W', 'Alian', 'Jose María Lara',
                               'const-77@yahoo.es');
INSERT INTO empresario (nif, empresa, nombre) VALUES ('54000000Q', 'DisCoTK',
                                                      'Agustín Moya');
                                                      