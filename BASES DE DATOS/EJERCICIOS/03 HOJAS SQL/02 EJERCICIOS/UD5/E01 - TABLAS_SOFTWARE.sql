drop table software_beta;
drop table software_preproduccion;
drop table software;
drop table software_old;

create table software_beta(
programa varchar2(10),
version number(3,1),
descripcion varchar2(30),
tipo_graficos varchar(10) check (tipo_graficos in('vectorial','mapa bits')),
clasificacion varchar(30),
empresa varchar(20),
primary key (programa,version)
);

create table software_preproduccion(
programa varchar2(10),
version number(3,1),
descripcion varchar2(30),
tipo_graficos varchar(10) check (tipo_graficos in('vectorial','mapa bits')),
clasificacion varchar(30),
empresa varchar(20),
primary key (programa,version)
);

create table software(
programa varchar2(10),
version number(3,1),
descripcion varchar2(30),
tipo_graficos varchar(10) check (tipo_graficos in('vectorial','mapa bits')),
clasificacion varchar(30),
comercializacion date not null,
empresa varchar(20),
primary key (programa,version)
);

create table software_old(
programa varchar2(10),
version number(3,1),
descripcion varchar2(30),
tipo_graficos varchar(10) check (tipo_graficos in('vectorial','mapa bits')),
clasificacion varchar(30),
comercializacion date not null,
retirada date not null,
empresa varchar(20),
primary key (programa,version)
);

insert into software_beta values('BD_34',1.1,'Base de datos relacional',NULL,'Base Datos', 'XPRO');
insert into software_beta values('GoCrazy',3.5,'Juego de habilidad','vectorial','Juego', 'XPRO');
insert into software_beta values('XimTR',2,'Crea blogs','mapa bits','CMS', 'Next SL');
insert into software_beta values('XimTR',3,'Crea blogs avanzados','vectorial','CMS', 'Next SL');
insert into software_beta values('Notas',1.5,'Editor de notas',NULL,'ofimatica', 'AHF');
insert into software_beta values('CalcKID',1,'Hoja de cálculo para niños','mapa bits','ofimatica', 'AHF');
insert into software_beta values('bdKID',1,'Base de datos para niños','mapa bits','Base Datos', 'AHF');
insert into software_beta values('blocKID',1,'Editor de textos para niños','mapa bits','ofimatica', 'AHF');
insert into software_beta values('CalcPRO',2,'Hoja de cálculo avanzada','mapa bits','ofimatica', 'AHF');
insert into software_beta values('bdPRO',2.1,'Base de datos avanzada','mapa bits','Base Datos', 'AHF');
insert into software_beta values('blocPRO',3.1,'Editor de textos avanzado','mapa bits','ofimatica', 'AHF');
insert into software_beta values('eCommc-HGB',4.1,'Crea tiendas online','vectorial','CMS', 'HGBoot');
insert into software_beta values('ShopXXI',2.1,'Crea tiendas online','vectorial','CMS', 'XPRO');
insert into software_beta values('eMall',3.9,'Crea tiendas online','mapa bits','CMS', 'eLICE');
insert into software_beta values('+PUZZLES',1,'Juego rompecabezas','vectorial','Juego', 'HGBoot');
insert into software_beta values('SOLIT',1,'Juego solitario','mapa bits','Juego', 'DumpTH');
commit;

--1.1
INSERT INTO SOFTWARE_BETA
SELECT PROGRAMA, (VERSION + 1), DESCRIPCION, TIPO_GRAFICOS, 
    CLASIFICACION, EMPRESA
FROM SOFTWARE_BETA
WHERE EMPRESA = 'AHF';

--1.2
SELECT *
FROM SOFTWARE_BETA
WHERE EMPRESA = 'AHF'
ORDER BY PROGRAMA ASC, VERSION ASC;

--1.3
INSERT INTO SOFTWARE_PREPRODUCCION
SELECT *
FROM SOFTWARE_BETA
WHERE CLASIFICACION != 'Juego';

--1.4
SELECT COUNT(*)
FROM SOFTWARE_PREPRODUCCION;

SELECT COUNT(*)
FROM SOFTWARE_BETA
WHERE CLASIFICACION != 'Juego';

--1.5
DELETE
FROM SOFTWARE_PREPRODUCCION
WHERE EMPRESA = 'AHF'
    AND VERSION < 2;

--1.6
DELETE
FROM SOFTWARE_PREPRODUCCION
WHERE EMPRESA = 'AHF'
    AND CLASIFICACION = 'Base Datos';
    
--1.7
DELETE
FROM SOFTWARE_BETA
WHERE (PROGRAMA, VERSION) IN (SELECT PROGRAMA, VERSION
                              FROM SOFTWARE_PREPRODUCCION);

--1.8
SELECT DISTINCT EMPRESA
FROM SOFTWARE_PREPRODUCCION;

--1.9
UPDATE SOFTWARE_BETA
SET EMPRESA = 'DumpTH'
WHERE EMPRESA = 'HGBoot'
    AND CLASIFICACION = 'Juego';

--1.10
UPDATE SOFTWARE_PREPRODUCCION
SET TIPO_GRAFICOS = 'mapa bits'
WHERE TIPO_GRAFICOS = 'vectorial'
    AND EMPRESA IN (SELECT EMPRESA
                    FROM SOFTWARE_BETA
                    WHERE CLASIFICACION = 'Juego');

--1.11
INSERT INTO SOFTWARE
SELECT PROGRAMA, VERSION, DESCRIPCION, TIPO_GRAFICOS, CLASIFICACION, 
    '11-05-2021', EMPRESA
FROM SOFTWARE_PREPRODUCCION
WHERE EMPRESA != 'AHF';

--1.12
INSERT INTO SOFTWARE
SELECT PROGRAMA, VERSION, DESCRIPCION, TIPO_GRAFICOS, CLASIFICACION,
    SYSDATE, EMPRESA
FROM SOFTWARE_BETA
WHERE EMPRESA = 'DumpTH'
    AND CLASIFICACION = 'Juego';

--1.13
DELETE FROM SOFTWARE_PREPRODUCCION
WHERE (PROGRAMA, VERSION) IN (SELECT PROGRAMA, VERSION
                              FROM SOFTWARE);

--1.14
INSERT INTO SOFTWARE_OLD
SELECT PROGRAMA, VERSION, DESCRIPCION, TIPO_GRAFICOS, CLASIFICACION, 
    COMERCIALIZACION, SYSDATE, EMPRESA
FROM SOFTWARE
WHERE EMPRESA = 'DumpTH'
    AND CLASIFICACION = 'Juego';

--1.15
DELETE
FROM SOFTWARE
WHERE EMPRESA = 'DumpTH'
    AND CLASIFICACION = 'Juego';

--1.16
UPDATE SOFTWARE
SET EMPRESA = 'AH+'
WHERE EMPRESA = 'AHF';

UPDATE SOFTWARE_BETA
SET EMPRESA = 'AH+'
WHERE EMPRESA = 'AHF';

UPDATE SOFTWARE_PREPRODUCCION
SET EMPRESA = 'AH+'
WHERE EMPRESA = 'AHF';

UPDATE SOFTWARE_OLD
SET EMPRESA = 'AH+'
WHERE EMPRESA = 'AHF';