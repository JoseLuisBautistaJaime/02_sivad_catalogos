---------------------------------------------------------------------------------------------------------------------
------------------------ SISTEMA DE OPERACION PRENDARIA EMERGENTE F1 --------------------------------
---------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS cat_perfil;
CREATE TABLE cat_perfil
(
    id_elemento BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);


DROP TABLE IF EXISTS cat_ramo;
CREATE TABLE cat_ramo
(
    id_elemento BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);

DROP TABLE IF EXISTS cat_subramo;
CREATE TABLE cat_subramo
(
    id_elemento BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);

DROP TABLE IF EXISTS cat_sucursal;
CREATE TABLE cat_sucursal
(
    id_elemento BIGINT UNSIGNED NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);


DROP TABLE IF EXISTS cat_tipo_contrato;
CREATE TABLE cat_tipo_contrato
(
    id_elemento BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);

DROP TABLE IF EXISTS cat_operacion_caja;
CREATE TABLE cat_operacion_caja
(
    id_elemento BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);

DROP TABLE IF EXISTS cat_contrato;
CREATE TABLE cat_contrato
(
    id_elemento BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);

DROP TABLE IF EXISTS cat_contrato_tipo_contrato;
CREATE TABLE cat_contrato_tipo_contrato(
    elemento_padre BIGINT NOT NULL,
    elemento_hijo BIGINT NOT NULL,
    PRIMARY KEY (elemento_padre, elemento_hijo)
);


DROP TABLE IF EXISTS cat_ramo_subramo;
CREATE TABLE cat_ramo_subramo(
    elemento_padre BIGINT NOT NULL,
    elemento_hijo BIGINT NOT NULL,
    PRIMARY KEY (elemento_padre, elemento_hijo)
);



ALTER TABLE cat_perfil ADD CONSTRAINT uk_cat_perfil_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_perfil ADD CONSTRAINT fk_cat_perfil_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_perfil_elemento_id ON cat_perfil(id_elemento);
CREATE INDEX cat_perfil_abreviatura ON cat_perfil(abreviatura);

ALTER TABLE cat_ramo ADD CONSTRAINT uk_cat_ramo_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_ramo ADD CONSTRAINT fk_cat_ramo_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_ramo_elemento_id ON cat_ramo(id_elemento);
CREATE INDEX cat_ramo_abreviatura ON cat_ramo(abreviatura);

ALTER TABLE cat_subramo ADD CONSTRAINT uk_cat_subramo_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_subramo ADD CONSTRAINT fk_cat_subramo_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_subramo_elemento_id ON cat_subramo(id_elemento);
CREATE INDEX cat_subramo_abreviatura ON cat_subramo(abreviatura);


ALTER TABLE cat_sucursal ADD CONSTRAINT uk_cat_sucursal_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_sucursal ADD CONSTRAINT fk_cat_sucursal_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_sucursal_elemento_id ON cat_sucursal(id_elemento);
CREATE INDEX cat_sucursal_abreviatura ON cat_sucursal(abreviatura);

ALTER TABLE cat_tipo_contrato ADD CONSTRAINT uk_cat_tipo_contrato_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_tipo_contrato ADD CONSTRAINT fk_cat_tipo_contrato_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_tipo_contrato_elemento_id ON cat_tipo_contrato(id_elemento);
CREATE INDEX cat_tipo_contrato_abreviatura ON cat_tipo_contrato(abreviatura);

ALTER TABLE cat_operacion_caja ADD CONSTRAINT uk_cat_operacion_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_operacion_caja ADD CONSTRAINT fk_cat_operacion_caja_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_operacion_caja_elemento_id ON cat_operacion_caja(id_elemento);
CREATE INDEX cat_operacion_caja_abreviatura ON cat_operacion_caja(abreviatura);

ALTER TABLE cat_contrato ADD CONSTRAINT uk_cat_contrato_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_contrato ADD CONSTRAINT fk_cat_contrato_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_cat_contrato_elemento_id ON cat_contrato(id_elemento);
CREATE INDEX cat_cat_contrato_abreviatura ON cat_contrato(abreviatura);

ALTER TABLE cat_ramo_subramo ADD CONSTRAINT fk_cat_ramo_subramo_elemento_padre
FOREIGN KEY(elemento_padre) REFERENCES cat_ramo(id_elemento);
ALTER TABLE cat_ramo_subramo ADD CONSTRAINT fk_cat_ramo_subramo_elemento_hijo
FOREIGN KEY(elemento_hijo) REFERENCES cat_subramo(id_elemento);

ALTER TABLE cat_contrato_tipo_contrato ADD CONSTRAINT fk_cat_contrato_tipo_contrato_elemento_padre
FOREIGN KEY(elemento_padre) REFERENCES cat_contrato(id_elemento);
ALTER TABLE cat_contrato_tipo_contrato ADD CONSTRAINT fk_cat_contrato_tipo_contrato_elemento_hijo
FOREIGN KEY(elemento_hijo) REFERENCES cat_tipo_contrato(id_elemento);

----------------------------------------------------------------------------------------------------------------------
-- SISTEMA DE OPERACION PRENDARIA EMERGENTE
-- ----------------------------------------------------------------------------------------------------------------------
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (20,'Perfiles', 'Perfil', 'Cat�logo de perfiles',now());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (21,'Ramos', 'Ramo', 'Cat�logo de ramos',now());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (22,'Subramos', 'Subramo', 'Cat�logo de subramos',now());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (23,'Sucursales', 'Sucursal', 'Cat�logo de sucursales',now());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (24,'TipoContrato','TipoContrato','Cat�logo de tipo de contratos',now());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (25,'Operaciones','OperacionesCaja','Cat�logo de las operaciones de caja',now());

INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (26,'Contratos','Contrato','Cat�logo de las operaciones de caja',now());

-- Cat�logo de Perfiles
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (2,'V' ,'Valuador',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'A' ,'Amarrador',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (4,'AD' ,'Auxiliar de deposito',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (5,'JA' ,'Jefe de Almoneda',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (6,'G' ,'Gerente',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (12,'AA' ,'Auxiliar de Jefe de Almoneda',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (27,'AG' ,'Auxiliar de gerente',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (28,'CA' ,'Cajero de almoneda',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (29,'CI' ,'Cajero de indemnizaci�n',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (30,'CE' ,'Cajero de empe�o',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (31,'CR' ,'Cajero de refrendo',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (32,'CD' ,'Cajero de desempe�o',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (33,'DI' ,'Cajero de divisas',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (34,'DE' ,'Depositario',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (35,'EN' ,'Entregador',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (36,'RE' ,'Responsable de entrada de dep�sito',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (37,'RS' ,'Responsable de salida de dep�sito',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (38,'EX' ,'Expendedor',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (39,'CG' ,'Cajero General',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (40,'RI' ,'Responsible de Indemnizaci�n',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (50,'PO' ,'Perito Valuador Inspector Operativo',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (53,'EC' ,'Ejecutivo de Caja',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (54,'AX' ,'Cajero Auxiliar',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (55,'AEC' ,'Auxiliar de Ejecutivo de Caja',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (62,'GPV' ,'Gerente Perito Valuador',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (63,'DA' ,'Responsable Depositario Amarrador',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (64,'CML' ,'Cajero Multiple',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (69,'WS' ,'Administrador Proyecci�n',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (68,'AOP' ,'Auxiliar de Operaci�n',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (70,'ACO' ,'Analista de Concentradora',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (72,'' ,'Gerente de Concentradora',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (77,'GDB' ,'Gerente de Bodega',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (78,'GDJ' ,'Gerente de Joyer�a',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (80,'CRD' ,'Corredor',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (81,'MCO' ,'Mesa de Control Operativo',20);
-- Cat�logo de Ramos
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1,'AL','Alhajas',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (2,'VE','Veh�culos',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'GE','Generos',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (4,'VA','Varios',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (5,'VAP','Varios Articulos Peque�os',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (6,'RJ','Relojes',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (7,'SR','Sin Resguardo',21);
-- Cat�logo de Subramos
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1,'RJ','Relojes',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (2,'AL','Alhajas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'MN','Monedas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (4,'DI','Diamantes',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (5,'AU','Automoviles',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (6,'GE','Generos',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (7,'HE','Herramientas Electricas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (8,'HM','Herramientas Mecanicas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (9,'CE','Camaras Electronicas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (10,'CM','Camaras Mecanicas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (11,'VA','Varios Chicos',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (12,'AR','Artes',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (13,'BC','Brazos Maquinas de Coser',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (14,'LI','Libros',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (15,'ME','Maquinas de Escribir',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (16,'RG','Radio Grabadoras',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (17,'VC','Videocaseteras',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (18,'LC','Licuadoras',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (19,'VJ','Vajillas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (20,'BT','Baterias de Cocina',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (21,'IM','Instrumentos Musicales',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (22,'EL','Electrodomesticos',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (23,'SA','Salas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (24,'RE','Recamaras',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (25,'CO','Comedores',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (26,'LB','Linea Blanca',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (27,'TV','Televisores y Pantallas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (28,'OT','Otros',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (29,'DC','Discos Compactos',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (30,'CV','Camara de Video',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (31,'PR','Prism�ticos',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (32,'BI','Bicicletas (Fijas y Movibles)',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (33,'MO','Modulares y Minicomponentes',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (34,'AE','Art�culos de Escritorio',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (35,'CT','Cortadoras',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (36,'BL','Basculas de Balanzon',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (37,'BP','Basculas de Plataforma',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (38,'CR','Compresores',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (39,'MT','Motores',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (40,'OR','Organos Musicales',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (41,'SN','Super Nintendo',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (42,'PD','Pedrer�a',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (43,'CL','Celulares',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (44,'OS','Otros',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (45,'AAP','Accesorios y art�culos personales',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (46,'AD','Art�culos decorativos',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (47,'AV','Audio y video',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (48,'CA','C�maras',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (49,'EC','Equipo de c�mputo',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (50,'JV','Juego de video',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (51,'R6','Alta Relojer�a - Gama Alta',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (52,'R5','Alta Relojer�a - Gama Media Alta',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (53,'R4','Relojes Comerciales - Gama Media',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (54,'R3','Relojes Comerciales - Gama Media Baja',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (55,'R2','Relojes Boutique - Gama Baja',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (56,'R1','Relojes de Oro',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (57,'MC','Motocicletas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (58,'SR','Sin Resguardo',22);

-- Cat�logo de Sucursales
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (0,'suc0','Casa Matriz-Centro Hist�rico, Cuauht�moc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1,'suc1','Victoria-Centro Hist�rico, Cuauht�moc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (2,'suc2','El Carmen-Centro Hist�rico, Cuauht�moc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'suc3','Escandon-Miguel Hidalgo, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (4,'suc4','Isabel la Cat�lica/Izazaga-Cuauht�moc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (5,'suc5','Morelos Hortelanos-Venustiano Carranza, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (6,'suc6','Orizaba-Orizaba Pte., VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (7,'suc7','Veracruz-Callej�n Reforma, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (8,'suc8','Metro Portales-Benito Ju�rez, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (9,'suc9','Le�n-Miguel Alem�n, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (10,'suc10','Puente de Alvarado-Cuauht�moc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (11,'suc11','Refineria-Azcapotzalco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (12,'suc12','Toluca-Centro, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (13,'suc13','Morelia-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (14,'suc14','Miguel Angel de Quevedo-Coyoac�n, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (15,'suc15','San Luis Potos�-Centro, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (172,'suc172','M�rida-Circuito Itzaes, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (234,'suc234','Puerto Vallarta-Fluvial Vallarta, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (221,'suc221','Metro Culhuac�n, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (241,'suc241','Miramontes-Coyoac�n, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (231,'suc231','Morelia-Torre�n Nuevo, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (238,'suc238','Xalapa-Plaza Cristal, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (242,'suc242','Canc�n-Mercado 28, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (16,'suc16','Aguascalientes-Centro, AGS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (17,'suc17','Sta. Maria Insurgentes-Cuauht�moc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (18,'suc18','Guadalajara-R. Michel, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (19,'suc19','Torre�n-Centro, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (20,'suc20','Guadalajara-Parque Morelos, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (21,'suc21','Peralvillo-Cuauht�moc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (22,'suc22','Monterrey-Av. Guerrero, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (23,'suc23','Durango-Centro, DGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (24,'suc24','Chihuahua-Centro, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (25,'suc25','Guadalajara-�lvaro Obreg�n, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (27,'suc27','Santo Tom�s- Azcapotzalco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (28,'suc28','M�rida-Centro, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (29,'suc29','Xalapa-Los Sauces, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (30,'suc30','Monterrey-Av.Col�n, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (31,'suc31','Quer�taro-Centro, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (32,'suc32','Chetumal-Efra�n Aguilar, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (33,'suc33','Tepic-Allende I-Tepic, NAY',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (34,'suc34','Colima-Centro, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (35,'suc35','Veracruz-Ju�rez, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (244,'suc244','Tampico-Norte, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (246,'suc246','Monterrey-Av. Lincoln, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (248,'suc248','Los Mochis-Gabriel Leyva, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (36,'suc36','Quer�taro-Tecnol�gico, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (37,'suc37','Havre D.F.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (38,'suc38','Plaza Arag�n-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (39,'suc39','Xochimilco-Centro, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (40,'suc40','Guadalajara-Plaza Atemajac, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (41,'suc41','M�rida-Santiago, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (42,'suc42','Mazatl�n-Centro, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (43,'suc43','Tercera Sur,Tuxtla Guti�rrez, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (44,'suc44','Zacatecas-Centro, ZAC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (45,'suc45','Campeche-Centro, CAMP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (46,'suc46','Av. Del Taller D.F.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (47,'suc47','C�rdoba-Centro Avenida 2, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (48,'suc48','Veracruz-Cuauht�moc, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (49,'suc49','Villahermosa-Centro, TAB',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (50,'suc50','Tampico-Centro, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (51,'suc51','Ermita Toltecas-Iztapalapa, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (52,'suc52','Xalapa-Zamora, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (53,'suc53','Canc�n-L�pez Portillo, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (54,'suc54','Poza Rica-Centro Obrera, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (55,'suc55','Monterrey-Av.Cuauht�moc, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (56,'suc56','Cuernavaca-Lerdo de Tejada Centro, MOR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (57,'suc57','Acapulco-Parada del Vaquero Centro, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (58,'suc58','Uruapan-Morelos, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (59,'suc59','Tlaquepaque-Central Nueva, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (60,'suc60','La Venta-Cuautitl�n Izcalli, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (61,'suc61','Clouthier-Metepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (62,'suc62','La Romana-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (63,'suc63','Irapuato-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (64,'suc64','Iguala-Bandera Nacional Centro, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (65,'suc65','La Paz-Centro, BCS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (66,'suc66','Tapachula-Centro, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (67,'suc67','Tijuana-Plaza Las Brisas, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (68,'suc68','Nuevo Laredo-Centro, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (69,'suc69','San Nicol�s de Los Garza-Centro, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (70,'suc70','Le�n-L�pez Mateos, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (71,'suc71','Matamoros-Centro, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (72,'suc72','M�rida-Plaza Royal Am�ricas, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (73,'suc73','Celaya-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (74,'suc74','Coatzacoalcos-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (75,'suc75','Ju�rez-Centro, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (76,'suc76','Morelia-L�zaro C�rdenas, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (77,'suc77','Mexicali-Centro C�vico, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (78,'suc78','Puerto Vallarta-Boulevard Francisco Medina, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (79,'suc79','Chilpancingo-L�zaro C�rdenas, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (80,'suc80','Ixtapaluca - Centro, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (81,'suc81','Lopez Mateos-Cd. Neza, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (82,'suc82','Tecom�n-Las Palmas, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (83,'suc83','Boca del R�o-Plaza Santa Ana, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (84,'suc84','Cuautla-Reforma, MOR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (85,'suc85','Morelos-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (86,'suc86','Aguascalientes-Central Camionera, AGS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (171,'suc171','Apatzing�n-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (87,'suc87','Ciudad del Carmen-Centro, CAMP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (88,'suc88','Le�n-Insurgentes T1, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (89,'suc89','San Juan del R�o-Centro, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (90,'suc90','Plaza de la Constituci�n-Texcoco, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (91,'suc91','Tuxpan-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (92,'suc92','G�mez Palacio-Centro, DGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (93,'suc93','Mart�nez de La Torre-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (94,'suc94','Culiac�n-Centro, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (95,'suc95','Tlaquepaque-Centro, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (96,'suc96','Puebla-Norte 8 Centro, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (97,'suc97','M�rida-Plaza Fiesta, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (98,'suc98','Chetumal-Zaragoza Centro, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (99,'suc99','Saltillo-Centro, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (100,'suc100','Veracruz-Cuauht�moc, Alcocer, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (101,'suc101','Zamora-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (102,'suc102','Ciudad Madero-Centro, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (103,'suc103','Ciudad Obreg�n-Centro, SON',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (104,'suc104','Tepic-Allende II, NAY',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (105,'suc105','Centro-Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (106,'suc106','Morelia-Madero Pte., MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (187,'suc187','Comalcalco-Reforma, TAB',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (107,'suc107','Veracruz-Cuauht�moc Norte, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (108,'suc108','Monterrey-Chapultepec, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (109,'suc109','Manzanillo-Centro, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (110,'suc110','Chihuahua-Av.Tecnol�gico, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (111,'suc111','Zapopan-Centro, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (112,'suc112','Oaxaca-Centro, OAX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (113,'suc113','Veracruz-El Coyol, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (114,'suc114','C�rdenas-Zona Remodelada, TAB',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (115,'suc115','Hermosillo-Centro, SON',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (116,'suc116','Tollocan-Toluca, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (117,'suc117','Orizaba-Circunvalaci�n Oriente, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (118,'suc118','La Villa-Gustavo A. Madero, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (119,'suc119','Villa de �lvarez-Centro, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (120,'suc120','San Luis Potos�-B. Anaya, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (121,'suc121','Tuxtla Guti�rrez-Parque Marimba, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (122,'suc122','Guadalupe-Plaza Los Cristales, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (123,'suc123','General Escobedo-HEB Escobedo, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (124,'suc124','Guadalupe-Metro Exposici�n, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (125,'suc125','Las Alamedas-Atizap�n, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (126,'suc126','C�rdoba-Avenida 3 Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (127,'suc127','Guadalajara-Sta. Teresita, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (128,'suc128','Acapulco-Magallanes Cuauht�moc, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (129,'suc129','Ciudad del Carmen-Calle 31, CAMP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (190,'suc190','Reynosa-Boulevard Hidalgo, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (130,'suc130','Monterrey-Metro Mitras, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (131,'suc131','Canc�n-Canc�n Mall, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (132,'suc132','Xalapa-Avenida Xalapa, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (133,'suc133','Veracruz-Astilleros, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (134,'suc134','Apodaca-Plaza Fresnos, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (135,'suc135','Monterrey-Plaza Aztl�n, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (136,'suc136','Guadalajara-GranTerraza Oblatos,JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (137,'suc137','Guadalajara-Alcalde, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (138,'suc138','Tacubaya-Miguel Hidalgo, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (139,'suc139','San Juan de Arag�n-Gustavo A. Madero, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (140,'suc140','M�rida-Chich�n, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (141,'suc141','La V�a-Cuautitl�n, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (142,'suc142','Centro Comercial las Am�ricas, Ecatepec MEX.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (143,'suc143','Miramontes-Coyoac�n, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (144,'suc144','Plaza Cantil-Coyoac�n, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (145,'suc145','Quer�taro-Plaza El Sol, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (146,'suc146','Tepic-Avenida M�xico, NAY',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (147,'suc147','M�rida-Chuburn�, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (148,'suc148','Av. Cuauht�moc, Chalco, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (149,'suc149','Le�n-Plaza Hidalgo, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (150,'suc150','Torre�n-Central de Abastos, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (151,'suc151','Maravillas-Cd. Neza, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (191,'suc191','La Piedad-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (192,'suc192','Zit�cuaro-Revoluci�n Sur, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (152,'suc152','Boca del R�o-Ej�rcito Mexicano, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (170,'suc170','Rojo G�mez Agricola Oriental-Iztacalco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (157,'suc157','Villa Nicol�s Romero, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (160,'suc160','Plaza las Flores- Coacalco, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (153,'suc153','Valle Dorado-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (188,'suc188','Plaza Toltecas-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (184,'suc184','Ermita Barrio San Miguel-Iztapalapa, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (200,'suc200','San Cristobal-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (210,'suc210','Be Grand Rio Magdalena, �lvaro Obreg�n, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (194,'suc194','Temoaya-Cuautitl�n Izcalli, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (156,'suc156','Avenida 8-Venustiano Carranza, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (164,'suc164','Xalapa-Manuel �vila Camacho, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (169,'suc169','Boca del R�o-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (206,'suc206','Santa Catarina-Plaza La Puerta, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (209,'suc209','Tonal�-Lomas de Tonal�, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (205,'suc205','M�rida-Macroplaza, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (161,'suc161','Guadalupe-Plaza Molinete, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (203,'suc203','Tlajomulco-Multiplaza del Valle, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (159,'suc159','Tierra Blanca-Ju�rez, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (162,'suc162','Tehuac�n-Independencia Poniente, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (163,'suc163','Morelia-Plazuela Carrillo, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (166,'suc166','Papantla-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (167,'suc167','San Juan Bautista Tuxtepec-5 de Mayo, OAX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (173,'suc173','Metro Muzquiz-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (179,'suc179','Poza Rica-Boulevard, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (180,'suc180','Acapulco-Plaza Sendero, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (168,'suc168','Los Reyes-La Paz, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (182,'suc182','Lago de Guadalupe-Atizap�n, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (154,'suc154','Cozumel-Centro, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (155,'suc155','Irapuato-Las Reynas, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (158,'suc158','Minatitl�n-Parquecito Hidalgo, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (165,'suc165','Tecom�n-Baldino D�valos, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (174,'suc174','Comit�n-Belisario Dom�nguez, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (175,'suc175','Salamanca-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (176,'suc176','Zapopan-Mariano Otero, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (177,'suc177','Cd. Ju�rez-Plaza San Carlos, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (183,'suc183','Colima-Francisco I. Madero, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (186,'suc186','Tulyehualco-Tl�huac, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (178,'suc178','Coatepec-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (185,'suc185','Zihuatanejo-Los Mangos Centro, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (189,'suc189','Acayucan-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (195,'suc195','Durango-Centro Comercial Paseo Durango, DGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (196,'suc196','Cuernavaca-Plan de Ayala, MOR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (197,'suc197','Salina Cruz-Centro, OAX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (198,'suc198','Zapopan-Patria, JAL.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (201,'suc201','San Andr�s Tuxtla-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (202,'suc202','Aguascalientes-Petr�leos, AGS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (204,'suc204','Valladolid-Plaza Bella Valladolid, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (211,'suc211','Multiplaza Arenera-Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (193,'suc193','Monclova-Centro, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (199,'suc199','Zacapu, Mich.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (208,'suc208','Ciudad Valles-Centro, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (212,'suc212','Veracruz- Parque Zamora, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (181,'suc181','L�zaro C�rdenas-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (207,'suc207','Plaza Dorada, Ciudad Juarez, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (214,'suc214','Las Aguilas-Cd. Neza, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (217,'suc217','Tonal�-R�o Nilo, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (218,'suc218','San Jos� de los Cedros-Cuajimalpa, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (213,'suc213','Jamaica-Venustiano Carranza, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (215,'suc215','Fuentes del Valle-Tultitl�n, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (216,'suc216','Santa Clara-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (224,'suc224','Benito Ju�rez-Sun Mall Vip, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (222,'suc222','San Luis Potos�-Mu�oz, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (226,'suc226','Urbiplaza-Tlalpan, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (219,'suc219','M�rida-Francisco de Montejo, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (227,'suc227','Insurgentes Roma Sur-Cuauht�moc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (228,'suc228','Federico G�mez-Zumpango, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (236,'suc236','Gustavo Baz-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (240,'suc240','Guadalupe-Eloy Cavazos, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (233,'suc233','Le�n-Mariano Escobedo, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (232,'suc232','Quer�taro-Pie de la Cuesta, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (245,'suc245','Veracruz-D�az Mir�n, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (220,'suc220','Cd. Guzm�n-Centro, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (225,'suc225','M�rida-Santa Rosa, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (230,'suc230','Puebla-Capu, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (243,'suc243','Guadalajara-Presa Laurel, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (229,'suc229','Puebla-Blvd. Valsequillo, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (252,'suc252','San Felipe-Gustavo A. Madero, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (251,'suc251','Tuxtla Guti�rrez-Plaza del Sol, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (247,'suc247','Picacho, Ajusco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (250,'suc250','Tulancingo-Centro, HGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (501,'suc501','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (502,'suc502','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (235,'suc235','Pachuca-Centro, HGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (253,'suc253','Carretera Federal-Tec�mac, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (255,'suc255','Guasave-Centro, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (503,'suc503','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (504,'suc504','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (505,'suc505','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (506,'suc506','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (507,'suc507','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (508,'suc508','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (509,'suc509','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (510,'suc510','Real de 14',23);

INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (511,'suc511','Real de 14',23);

INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (512,'suc512','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (280,'suc280','Vallejo-Gustavo A. Madero, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (282,'suc282','Culiac�n-Sanalona-Guadalupe Victoria, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (513,'suc513','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (514,'suc514','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (515,'suc515','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (516,'suc516','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (517,'suc517','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (518,'suc518','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (519,'suc519','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (520,'suc520','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (237,'suc237','Guanajuato-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (254,'suc254','San Mart�n Texmelucan-Libertad Sur Zona Centro, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (256,'suc256','Tenayuca-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (257,'suc257','Plaza Urban Center, Rioja',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (258,'suc258','Vasco de Quiroga-Santa Fe, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (260,'suc260','Apodaca-Plaza Morelos, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (261,'suc261','Solidaridad-Playa del Carmen, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (263,'suc263','Guadalajara-Lomas de Polanco, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (264,'suc264','Tijuana-Centro, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (265,'suc265','Atlixco-Independencia, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (266,'suc266','H�roes de Tecamac, MEX.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (283,'suc283','Tijuana-Mariano Matamoros Ruta Independencia, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (223,'suc223','Chihuahua-Plaza Dostoievsky, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (239,'suc239','Puebla-Reforma Centro, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (249,'suc249','Insurgentes San �ngel-Alvaro Obreg�n, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (259,'suc259','Piedras Negras-San Vicente Chicoloapan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (267,'suc267','Ensenada-Centro, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (268,'suc268','Juan Diego-Valle de Chalco Solidaridad, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (269,'suc269','San Luis Potos�-Himno Nacional, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (271,'suc271','Plaza Atizap�n-Atizap�n, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (272,'suc272','Quer�taro-Plaza Candiles, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (273,'suc273','Plaza Vista Norte, G.A.M-CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (274,'suc274','Chihuahua-Fuentes Mares, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (275,'suc275','Plaza Arboledas, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (262,'suc262','Morole�n-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (285,'suc285','Acapulco-Renacimiento, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (521,'suc521','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (522,'suc522','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (523,'suc523','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (600,'suc600','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (524,'suc524','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (525,'suc525','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (526,'suc526','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (527,'suc527','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (599,'suc599','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (528,'suc528','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (529,'suc529','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (530,'suc530','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (531,'suc531','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (532,'suc532','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (533,'suc533','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (534,'suc534','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (535,'suc535','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (536,'suc536','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (537,'suc537','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (538,'suc538','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (539,'suc539','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (540,'suc540','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (541,'suc541','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (284,'suc284','Metropolitana-Cd. Neza, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (286,'suc286','Chimalhuac�n-Del Pe��n, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (542,'suc542','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (543,'suc543','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (544,'suc544','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (545,'suc545','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (546,'suc546','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (598,'suc598','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (547,'suc547','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (548,'suc548','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (549,'suc549','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (550,'suc550','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (551,'suc551','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (552,'suc552','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (597,'suc597','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (553,'suc553','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (554,'suc554','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (555,'suc555','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (556,'suc556','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (596,'suc596','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (288,'suc288','Coatzacoalcos-Universidad, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (289,'suc289','Mexicali-Nuevo Mexicali, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (557,'suc557','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (558,'suc558','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (559,'suc559','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (560,'suc560','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (595,'suc595','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (594,'suc594','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (593,'suc593','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (592,'suc592','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (591,'suc591','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (590,'suc590','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (589,'suc589','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (588,'suc588','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (587,'suc587','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (586,'suc586','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (585,'suc585','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (584,'suc584','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (583,'suc583','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (582,'suc582','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (290,'suc290','Sat�lite-Arquitectos, Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (291,'suc291','Aguascalientes-Haciendas, AGS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (581,'suc581','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (580,'suc580','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (579,'suc579','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (578,'suc578','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (577,'suc577','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (576,'suc576','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (575,'suc575','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (574,'suc574','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (573,'suc573','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (572,'suc572','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (571,'suc571','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (570,'suc570','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (569,'suc569','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (568,'suc568','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (567,'suc567','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (566,'suc566','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (565,'suc565','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (564,'suc564','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (292,'suc292','Gran Sur-Coyoac�n, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (293,'suc293','Doctores-Hospital General, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (563,'suc563','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (562,'suc562','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (561,'suc561','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (270,'suc270','San Nicol�s de los Garza-Av. Universidad, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (276,'suc276','Paseo Reynosa, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (277,'suc277','Matamoros-Plaza HEB, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (279,'suc279','Saltillo-Venustiano Carranza, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (281,'suc281','Iztapalapa-Santa Cruz Meyehualco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (278,'suc278','San Jer�nimo L�dice, �lvaro Obreg�n CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (287,'suc287','Torre�n-Triana, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (294,'suc294','Puebla-Las �nimas, PUE.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (295,'suc295','Obreg�n-Central Camionera, SON',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (296,'suc296','Campeche-�lvaro Obreg�n, CAMP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (297,'suc297','Xalapa-Atenas Veracruzana, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (298,'suc298','Guadalajara-Independencia Norte, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (299,'suc299','Puebla-Plaza Loreto, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (300,'suc300','Hermosillo-Plaza Sendero, SON',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (301,'suc301','Apodaca-Plaza Sendero La Concordia, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (302,'suc302','San Pedro Garza Garc�a-Bazar San Agust�n, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (303,'suc303','Pachuca-Nuevo Hidalgo, HGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (304,'suc304','Lindavista-Montevideo, GAM. CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (305,'suc305','F�lix Cuevas-Benito Ju�rez, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (306,'suc306','Mazatl�n-Ju�rez Av. de las Am�ricas, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (307,'suc307','El Molinito-Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (308,'suc308','Tesist�n-Zapopan, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (310,'suc310','Las Armas-Azcapotzalco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (309,'suc309','Villahermosa-Av. Constituci�n, TAB',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1001,'suc1001','Concentradora',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (311,'suc311','Toluca-Alfredo del Mazo, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (312,'suc312','Insurgentes Sur Fuentes Brotantes-Tlalpan, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (313,'suc313','Torres de Sat�lite La Abeja-Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1002,'suc1002','WTC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (314,'suc314','Monterrey-Solidaridad, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (315,'suc315','Tlalpan-Metro Xola, Benito Ju�rez, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (316,'suc316','Centro Comercial Santa Fe-Cuajimalpa, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (900,'suc900','Avenida Paseo de la Reforma No',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (318,'suc318','Popocat�petl-Benito Juarez, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (320,'suc320','Apizaco-Centro, TLAX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1005,'suc1005','Venta en l�nea',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (319,'suc319','Mercado de Sonora, Venustiano Carranza, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (317,'suc317','Metro Tacuba, Miguel Hidalgo, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1008,'suc1008','Compra Cumplido',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1003,'suc1003','Outlet',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1004,'suc1004','Joyer�a externa',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1006,'suc1006','Centro de distribuci�n',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1007,'suc1007','Autos sin resguardo',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (321,'suc321','Cumbres Elite Monterrey, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (322,'suc322','Jiutepec, Cuernavaca, MOR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (323,'suc323','Pino Suarez, Metepec - MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1009,'suc1009','Servicio a Clientes',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1010,'suc1010','Cr�dito',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (324,'suc324','Garza Sada - Monterrey, N.L.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (700,'suc700','Tienda Monte Corporativo-CDMX',23);
-- Cat�logo de Tipo de contratos
INSERT INTO cat_tipo_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (146,'PL','PAGOS LIBRES',24);
INSERT INTO cat_tipo_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (145,'CL','CLASICO',24);
-- Cat�logo de Operaci�n de Caja
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1,'PP','Pagar Prestamo',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'VB','Venta con Billete',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (6,'DS','Cobro Desempeno',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (8,'RF','Cobro Refrendo',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (9,'CI','Cobro Reimpresion Billete',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (10,'RB','Cobro Reposicion Billete',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (11,'BA','Cobro de Cargo Anticipado a Valuador',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (14,'PD','Pagar Demasia',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (15,'GA','Cobro Almacenaje',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (17,'AS','Servicio Avaluo',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (82,'DN','Devolucion Mercancia',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (116,'APL','Abono-Pagos Libres',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (118,'CCE','Apartado Monte',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (124,'REE','Cobro para Reempe�o',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (132,'CRC','Cobro Reimpresi�n Car�tula',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (198,'RFE','Cobro Refrendo Extemporaneo',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1004,'CK','Cancelacion Corte Caja',25);
-- Cat�logo contrato
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1,'1','Contrato Normal',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (2,'2','Contrato Interes Semanal',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'3','Contrato Condonacion 2o Mes',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (4,'4','Contrato Interes Semanal para 20 Marzo',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (5,'5','Contrato Interes Semanal 1er Mes 1.5%',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (6,'6','Contrato Interes Semanal 3%',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (7,'7','Contrato Interes Semanal 3.5%',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (8,'8','Contrato Interes Semanal Cond 2o mes Prom Int 3%',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (9,'9','Contrato Interes Semanal Cond 2o mes Prom Int 3.5%',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (10,'10','Contrato 2 Interes Semanal 1% y Mensual 3%',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (11,'11','Contrato Promocion Interes Semanal 1% y Mensual 3%',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (12,'12','Contrato Promocion Interes Semanal 1% y Mensual 3.5%',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (13,'13','Contrato Interes Semanal 1% y Mensual 3%',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (14,'14','Contrato Interes Semanal Congelar Meses Interes a 2',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (15,'15','Contrato Interes Semanal Congelar Meses Interes a 1',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (16,'16','Contrato Interes Semanal Condonar 2 Meses Interes',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (17,'17','Contrato Interes Semanal Congelar Meses Interes a 4',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (18,'18','Contrato Interes Semanal Congelar Meses Interes a 3',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (20,'20','Contrato Pagos Libres',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (21,'21','Contrato Interes Semanal Condonar 3 Meses Interes',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (22,'22','Contrato Interes Semanal Condonar 4 Meses Interes',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (23,'23','Contrato Pagos Libres Condonar 4 meses',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (24,'24','Contrato Pagos Libres Condonacion',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (27,'27','Contrato Interes Semanal 1% y Mensual 3% aplica IVASI',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (28,'28','Contrato Pagos Libres - IVASI',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (31,'31','Contrato Interes Diario Clasico - PROFECO',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (32,'32','Contrato Interes Diario Pagos Libres - PROFECO',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (33,'33','Contrato Interes Diario Clasico - PROFECO T 3.5',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (34,'34','Contrato Interes Diario Pagos Libres - PROFECO T 4',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (35,'35','Contrato Interes Diario Clasico Sin resguardo',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (38,'38','Contrato Interes Diario Clasico - PROFECO SIVA3',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (39,'39','Contrato Interes Diario Pagos Libres - PROFECO SIVA3',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (40,'40','Contrato Interes Diario Clasico - PROFECO T 3.5 SIVA3',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (41,'41','Contrato Interes Diario Pagos Libres - PROFECO T 4 SIVA3',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (42,'42','Contrato Interes Diario Clasico Sin resguardo SIVA3',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (43,'43','Contrato Interes Diario Clasico Condonaciones Sismo Septiembre 2017',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (44,'44','Contrato Interes Diario Clasico - Ofertas F2',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (45,'45','Contrato Interes Diario Pagos Libres - Ofertas F2',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (46,'46','Contrato Interes Diario Clasico - BILLETE PROFECO 2018',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (47,'47','Contrato Interes Diario Pagos Libres - BILLETE PROFECO 2018',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (48,'48','Contrato Interes Diario Clasico Apoyo Sucursales',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (49,'49','Contrato Interes Diario Clasico Profeco 2019',26);
INSERT INTO cat_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (50,'50','Contrato Interes Diario Pagos Libres Profeco 2019',26);

-- relacion entre ramo y subramo
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (1,1);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (1,2);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (1,3);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (1,4);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (2,5);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (3,6);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,7);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,8);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,9);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,10);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,11);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,12);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,13);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,14);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,15);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,16);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,17);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,18);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,19);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,20);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,21);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,22);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,23);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,24);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,25);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,26);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,27);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,28);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,29);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,30);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,31);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,32);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,33);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,34);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,35);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,36);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,37);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,38);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,39);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,40);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,41);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (1,42);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (4,43);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (1,44);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (5,45);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (5,46);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (5,47);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (5,48);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (5,49);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (5,50);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (6,51);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (6,52);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (6,53);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (6,54);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (6,55);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (6,56);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (2,57);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (7,58);

-- relaci�n entre contrato y tipo contrato
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (1,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (2,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (3,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (4,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (5,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (6,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (7,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (8,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (9,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (10,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (11,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (12,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (13,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (14,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (15,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (16,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (17,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (18,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (20,146);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (21,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (22,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (23,146);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (24,146);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (27,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (28,146);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (31,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (32,146);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (33,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (34,146);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (35,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (38,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (39,146);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (40,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (41,146);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (42,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (43,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (44,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (45,146);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (46,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (47,146);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (48,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (49,145);
INSERT INTO cat_contrato_tipo_contrato(elemento_padre,elemento_hijo) VALUES (50,146);

