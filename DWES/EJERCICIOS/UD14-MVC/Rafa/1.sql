CREATE DATABASE mvc_ejemplo; 
use mvc_ejemplo; 
CREATE TABLE notas (
  id int(11) NOT NULL AUTO_INCREMENT,
  titulo varchar(75) NOT NULL,
  contenido text NOT NULL, 
PRIMARY KEY (id));

CREATE TABLE usuarios (
  nombre varchar(255) NOT NULL,
  contraseña varchar(255) NOT NULL, 
PRIMARY KEY (nombre));

insert into usuarios values(1,"Xavi","php");
insert into usuarios values(2,"Pepe","pepe25");
