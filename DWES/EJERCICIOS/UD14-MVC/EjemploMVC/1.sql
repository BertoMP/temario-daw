CREATE DATABASE mvc_ejemplo; 
USE mvc_ejemplo;

CREATE TABLE NOTAS (
  ID        int(11)         AUTO_INCREMENT,
  TITULO    varchar(75)     NOT NULL,
  CONTENIDO TEXT            NOT NULL,
    CONSTRAINT PK_NOTAS PRIMARY KEY (ID)
);

INSERT INTO NOTAS (TITULO, CONTENIDO)
    VALUES ('Nota 1', 'Esta es la nota 1.'),
           ('Nota 2', 'Esta es la nota 2.'),
           ('Nota 3', 'Esta es la nota 3.'),
           ('Nota 4', 'Esta es la nota 4.'),
           ('Nota 5', 'Esta es la nota 5.'),
           ('Nota 6', 'Esta es la nota 6.'),
           ('Nota 7', 'Esta es la nota 7.'),
           ('Nota 8', 'Esta es la nota 8.'),
           ('Nota 9', 'Esta es la nota 9.'),
           ('Nota 10', 'Esta es la nota 10.'),
           ('Nota 11', 'Esta es la nota 11.'),
           ('Nota 12', 'Esta es la nota 12.'),
           ('Nota 13', 'Esta es la nota 13.'),
           ('Nota 14', 'Esta es la nota 14.'),
           ('Nota 15', 'Esta es la nota 15.'),
           ('Nota 16', 'Esta es la nota 16.'),
           ('Nota 17', 'Esta es la nota 17.'),
           ('Nota 18', 'Esta es la nota 18.'),
           ('Nota 19', 'Esta es la nota 19.'),
           ('Nota 20', 'Esta es la nota 20.'),
           ('Nota 21', 'Esta es la nota 21.'),
           ('Nota 22', 'Esta es la nota 22.'),
           ('Nota 23', 'Esta es la nota 23.'),
           ('Nota 24', 'Esta es la nota 24.'),
           ('Nota 25', 'Esta es la nota 25.'),
           ('Nota 26', 'Esta es la nota 26.'),
           ('Nota 27', 'Esta es la nota 27.'),
           ('Nota 28', 'Esta es la nota 28.'),
           ('Nota 29', 'Esta es la nota 29.'),
           ('Nota 30', 'Esta es la nota 30.'),
           ('Nota 31', 'Esta es la nota 31.'),
           ('Nota 32', 'Esta es la nota 32.'),
           ('Nota 33', 'Esta es la nota 33.'),
           ('Nota 34', 'Esta es la nota 34.'),
           ('Nota 35', 'Esta es la nota 35.'),
           ('Nota 36', 'Esta es la nota 36.'),
           ('Nota 37', 'Esta es la nota 37.'),
           ('Nota 38', 'Esta es la nota 38.'),
           ('Nota 39', 'Esta es la nota 39.'),
           ('Nota 40', 'Esta es la nota 40.'),
           ('Nota 41', 'Esta es la nota 41.'),
           ('Nota 42', 'Esta es la nota 42.'),
           ('Nota 43', 'Esta es la nota 43.'),
           ('Nota 44', 'Esta es la nota 44.'),
           ('Nota 45', 'Esta es la nota 45.'),
           ('Nota 46', 'Esta es la nota 46.'),
           ('Nota 47', 'Esta es la nota 47.'),
           ('Nota 48', 'Esta es la nota 48.'),
           ('Nota 49', 'Esta es la nota 49.'),
           ('Nota 50', 'Esta es la nota 50.');

CREATE TABLE USERS (
    USERNAME VARCHAR(20),
    PASSWORD VARCHAR(20) NOT NULL,
        CONSTRAINT PK_USERS PRIMARY KEY (USERNAME)
);

INSERT INTO USERS (USERNAME, PASSWORD)
    VALUES ('alberto, alberto');