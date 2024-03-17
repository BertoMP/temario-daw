DROP DATABASE DRAGONBALL;

CREATE DATABASE DRAGONBALL;

USE
DRAGONBALL;

CREATE TABLE CHARACTERS
(
    ID          INTEGER     AUTO_INCREMENT,
    NAME        VARCHAR(50),
    KI_POWER    INTEGER,
    RACE        VARCHAR(50),
    GENDER      VARCHAR(10),
    DESCRIPTION VARCHAR(255),

    CONSTRAINT PK_CHARACTERS PRIMARY KEY (ID)
);

INSERT INTO CHARACTERS(NAME, KI_POWER, RACE, GENDER, DESCRIPTION)
    VALUES
        ('Goku', 60000000, 'Saiyan', 'Hombre',
         'El protagonista de la serie, conocido por su gran poder y personalidad amigable.'),
        ('Vegeta', 54000000, 'Saiyan', 'Hombre',
         'El príncipe Saiyan, inicialmente rival de Goku pero luego aliado poderoso.'),
        ('Piccolo', 2000000, 'Namekiano', 'Hombre',
         'Namekiano sabio y poderoso, a menudo actúa como mentor y estratega'),
        ('Bulma', 0, 'Humana', 'Mujer',
         'Es hija del Dr. Brief y su esposa Panchy, hermana menor de Tights y una gran amiga de Son Goku.'),
        ('Freezer', 530000, 'Frieza', 'Hombre',
         'Freezer es el tirano espacial y el principal antagonista de la saga de Freezer.'),
        ('Cell', 250000000, 'Androide', 'Hombre',
         'Es un bioandroide creado por el Dr. Gero, quien vino del futuro con la intención de vengarse de Goku'),
        ('Gohan', 40000000, 'Saiyan', 'Hombre',
         'Hijo de Goku, tiene un gran potencial y es conocido por su bondad'),
        ('Krillin', 1500000, 'Humano', 'Hombre',
         'Amigo cercano de Goku y experto artista marcial'),
        ('Chi-Chi', 0, 'Humano', 'Mujer',
         'Esposa de Goku y madre de Gohan. Es la princesa del Monte Fry-pan.'),
        ('Mutenroshi', 500000, 'Humano', 'Hombre',
         'Maestro de artes marciales y mentor de Goku.'),
        ('Majin Buu', 8000000000, 'Majin', 'Hombre',
         'También conocido como Boo original, es la forma original y pura de Majin-Boo');

CREATE TABLE PLANETS
(
    ID          INTEGER     AUTO_INCREMENT,
    NAME        VARCHAR(50),
    TYPE        VARCHAR(50),
    POPULATION  INTEGER,
    DESCRIPTION VARCHAR(255),

    CONSTRAINT PK_PLANETS PRIMARY KEY (ID)
);

INSERT INTO PLANETS(NAME, TYPE, POPULATION, DESCRIPTION)
VALUES
    ('Tierra', 'Terrestre', 7000000000,
     'Hogar de muchos personajes clave, incluyendo a Goku y sus amigos.'),
    ('Namek', 'Namekiano', 100,
     'Planeta natal de la raza Namekiana, conocido por sus paisajes verdes y las Esferas del Dragón.'),
    ('Vegeta', 'Saiyan', 5000000,
     'El planeta original de los Saiyan, gobernado por el Rey Vegeta.'),
    ('Planeta Freezer 79', 'Controlado por Freezer', 0,
     'Uno de los planetas controlados por Freezer, conocido por sus condiciones severas.'),
    ('Yardrat', 'Alienígena', 1000,
     'Hogar de la raza Yardrat, conocida por su técnica de Transmisión Instantánea.'),
    ('Nuevo Namek', 'Namekiano', 0,
     'Un nuevo planeta Namek creado después de la destrucción del Namek original.'),
    ('Planeta Majin', 'Majin', 0,
     'Lugar de nacimiento de Majin Buu, también conocido como la Estrella Oscura.'),
    ('Planeta del Rey Kai', 'Extraterrestre', 5,
     'El pequeño planeta donde reside y entrena el Rey Kai junto a Goku.'),
    ('Planeta Vampa', 'Desconocido', 0,
     'Hogar de Broly en la película Dragon Ball Super: Broly.'),
    ('Namek Falso', 'Artificial', 0,
     'Una versión falsa de Namek creada por las Fuerzas Ginyu durante la Saga de Namek.');

CREATE TABLE CHARACTERS_PLANETS (
    CHARACTER_ID    INTEGER,
    PLANET_ID       INTEGER,

    CONSTRAINT PK_CHARACTERS_PLANETS PRIMARY KEY (CHARACTER_ID, PLANET_ID),
    CONSTRAINT FK_CHARACTERS_PLANETS FOREIGN KEY (CHARACTER_ID) REFERENCES CHARACTERS(ID),
    CONSTRAINT FK_PLANETS_CHARACTERS FOREIGN KEY (PLANET_ID) REFERENCES PLANETS(ID)
);

INSERT INTO CHARACTERS_PLANETS (CHARACTER_ID, PLANET_ID)
VALUES
    (1, 1),
    (1, 3),
    (2, 3),
    (3, 2),
    (4, 1),
    (5, 4),
    (6, 4),
    (7, 2),
    (8, 1),
    (9, 1),
    (10, 8),
    (11, 7);