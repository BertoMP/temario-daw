-- REALIZA UNA ELIMINACIÓN DE LA BASE DE DATOS juego SI YA EXISTE.
DROP DATABASE IF EXISTS juego;

-- CREA LA BASE DE DATOS juego.
CREATE DATABASE juego;

-- UTILIZA LA BASE DE DATOS juego.
USE JUEGO;

-- CREACIÓN DE UNA TABLA HEROES
CREATE TABLE HEROES(
    ID			INT(2),
    NOMBRE		VARCHAR(50),
    ROL			VARCHAR(50),
    DIFICULTAD	VARCHAR(20),
    DESCRIPCION VARCHAR(300),
        CONSTRAINT PK_HEROES_ID PRIMARY KEY (ID)
);

-- INSERCIÓN DE REGISTROS EN LA TABLA HEROES
INSERT INTO HEROES (ID, NOMBRE, ROL, DIFICULTAD, DESCRIPCION)
    VALUES  (1, 'Valeria', 'Mago', 'Baja',
             'Joven aprendiz de magia que domina hechizos básicos de protección y curación.'),
            (2, 'Khan', 'Guerrero', 'Media',
             'Guerrero experto en tácticas de combate con espada y escudo. Posee una gran resistencia.'),
            (3, 'Ragnar', 'Bárbaro', 'Alta',
             'Feroz bárbaro conocido por su brutalidad en el combate cuerpo a cuerpo.'),
            (4, 'Aria', 'Mago', 'Alta',
             'Maga versátil que manipula la energía mística para desencadenar poderosos hechizos destructivos.'),
            (5, 'Helga', 'Guerrero', 'Baja',
             'Guerrera principiante con un gran corazón y habilidades en el manejo de la espada.'),
            (6, 'Drax', 'Bárbaro', 'Media',
             'Bárbaro de gran destreza que utiliza tácticas salvajes para desestabilizar a sus enemigos.'),
            (7, 'Serafina', 'Mago', 'Media',
             'Maga curiosa que experimenta con hechizos de control mental y manipulación elemental.'),
            (8, 'Ulric', 'Guerrero', 'Alta',
             'Guerrero imponente que domina diversas armas y técnicas de combate avanzadas.'),
            (9, 'Freyja', 'Bárbaro', 'Baja',
             'Bárbara astuta que utiliza la velocidad en lugar de la fuerza bruta para vencer a sus oponentes.'),
            (10, 'Lorelei', 'Mago', 'Alta',
             'Maga experta en ilusiones que confunden y desorientan a sus adversarios.'),
            (11, 'Thorin', 'Guerrero', 'Media',
             'Guerrero versátil que cambia de tácticas rápidamente durante el combate para confundir a sus enemigos.'),
            (12, 'Grendel', 'Bárbaro', 'Alta',
             'Bárbaro legendario conocido por su resistencia sobrehumana y su sed insaciable de batalla.'),
            (13, 'Nyx', 'Mago', 'Baja',
             'Maga en entrenamiento que busca dominar los elementos para proteger a sus compañeros.'),
            (14, 'Ivar', 'Guerrero', 'Alta',
             'Guerrero estratégico que lidera a sus aliados con valentía y habilidades tácticas superiores.'),
            (15, 'Hilda', 'Bárbaro', 'Media',
             'Bárbara ágil que utiliza su destreza para esquivar ataques y contraatacar con ferocidad.'),
            (16, 'Astrid', 'Mago', 'Baja',
             'Maga curiosa que busca nuevos hechizos para apoyar a sus aliados en combate.'),
            (17, 'Leif', 'Guerrero', 'Alta',
             'Guerrero intrépido que nunca retrocede ante un desafío, siempre buscando la victoria.'),
            (18, 'Eirik', 'Bárbaro', 'Media',
             'Bárbaro experimentado que canaliza la ira en cada golpe, dejando a sus oponentes atónitos.'),
            (19, 'Elysia', 'Mago', 'Alta',
             'Maga maestra en las artes arcanas, capaz de manipular la realidad con sus hechizos.'),
            (20, 'Rurik', 'Guerrero', 'Baja',
             'Guerrero en formación que busca perfeccionar su habilidad con la espada y el escudo.');

-- CREACIÓN DE UNA TABLA USERS
CREATE TABLE USERS(
    ID          INT(2),
    NOMBRE      VARCHAR(100),
    USUARIO     VARCHAR(100),
    PASSWORD    VARCHAR(100),
    EMAIL       VARCHAR(100),
        CONSTRAINT PK_USERS PRIMARY KEY (ID),
        CONSTRAINT UQ_USUARIO UNIQUE (USUARIO)
);