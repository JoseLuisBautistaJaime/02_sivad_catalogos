
-- DELETED
DELETE FROM cat_diamante_escala_color_grupo_color WHERE id_rango IN (2,3);
DELETE FROM cat_diamante_color_escala_color WHERE id_rango IN (2,3);
DELETE FROM cat_diamante_grado_color_color WHERE id_rango IN (2,3);
DELETE FROM cat_claridad_diamante_claridad WHERE id_rango IN (2,3);

DELETE FROM cat_diamante_grupo_color WHERE id_rango IN (2,3);
DELETE FROM cat_diamante_escala_color WHERE id_rango IN (2,3);
DELETE FROM cat_diamante_color WHERE id_rango IN (2,3);
DELETE FROM cat_diamante_grado_color WHERE id_rango IN (2,3);
DELETE FROM cat_claridad_diamante WHERE id_rango IN (2,3);


-- Catalogo Grupo Color - Rango 0.01 al 0.29
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(7,'F','D-F',17,2);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(8,'H','G-H',17,2);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(9,'J','I-J',17,2);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(10,'L','K-L',17,2);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(11,'N','M-N',17,2);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(12,'R','O-R',17,2);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(13,'Z','S-Z',17,2);

-- Catalogo Grupo Color - Rango 0.30 al 20
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(14,'E','D-E',17,3);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(15,'F','E-F',17,3);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(16,'G','F-G',17,3);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(17,'H','G-H',17,3);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(18,'I','H-I',17,3);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(19,'J','I-J',17,3);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(20,'K','J-K',17,3);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(21,'M','L-M',17,3);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(22,'N','M-N',17,3);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(23,'R','O-R',17,3);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(24,'Z','S-Z',17,3);



-- Catalogo Escala Color - Rango 0.01 al 0.29
INSERT INTO cat_diamante_escala_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(6,'INCOLORO','Incoloro',16,2);
INSERT INTO cat_diamante_escala_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(7,'CASI_INCOLORO','Casi incoloro',16,2);
INSERT INTO cat_diamante_escala_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(8,'AMARILLO_TENUE','Amarillo tenue',16,2);
INSERT INTO cat_diamante_escala_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(9,'AMARILLO_LIGERO','Amarillo ligero',16,2);
INSERT INTO cat_diamante_escala_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(10,'AMARILLO','Amarillo',16,2);

-- Catalogo Escala Color - Rango 0.30 al 20
INSERT INTO cat_diamante_escala_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(11,'INCOLORO','Incoloro',16,3);
INSERT INTO cat_diamante_escala_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(12,'CASI_INCOLORO','Casi incoloro',16,3);
INSERT INTO cat_diamante_escala_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(13,'AMARILLO_TENUE','Amarillo tenue',16,3);
INSERT INTO cat_diamante_escala_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(14,'AMARILLO_LIGERO','Amarillo ligero',16,3);
INSERT INTO cat_diamante_escala_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(15,'AMARILLO','Amarillo',16,3);


-- Catalogo Color - Rango 0.01 al 0.29
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(7,'COLOR_D',' ',15,2);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(8,'BLANCO_NATURAL','Blanco natural',15,2);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(9,'BLANCO_COMERCIAL','Blanco comercial',15,2);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(10,'LIGERO_COLOR','Ligero color',15,2);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(11,'COLOR','Color',15,2);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(12,'COLOR_N','Color N',15,2);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(13,'COLOR_O_Z','Color O-Z',15,2);

-- Catalogo Color - Rango 0.30 al 20
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(14,'COLOR_D','0',15,3);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(15,'BLANCO_NATURAL','Blanco natural',15,3);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(16,'BLANCO_COMERCIAL','Blanco comercial',15,3);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(17,'LIGERO_COLOR','Ligero color',15,3);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(18,'COLOR','Color',15,3);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(19,'COLOR_N','Color N',15,3);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(20,'COLOR_O_Z','Color O-Z',15,3);



-- Catalogo Grado Color - Rango 0.01 al 0.29
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(12,'D','D',14,2);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(13,'E','E',14,2);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(14,'F','F',14,2);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(15,'G','G',14,2);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(16,'H','H',14,2);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(17,'I','I',14,2);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(18,'J','J',14,2);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(19,'K','K',14,2);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(20,'L','L',14,2);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(21,'M','M',14,2);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(22,'N','N',14,2);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(23,'O-Z','O-Z',14,2);

-- Catalogo Grado Color - Rango 0.30 al 20
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(24,'D','D',14,3);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(25,'E','E',14,3);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(26,'F','F',14,3);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(27,'G','G',14,3);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(28,'H','H',14,3);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(29,'I','I',14,3);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(30,'J','J',14,3);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(31,'K','K',14,3);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(32,'L','L',14,3);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(33,'M','M',14,3);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(34,'N','N',14,3);
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(35,'O-Z','O-Z',14,3);




-- Dependencias ---------------------------------------------------

-- Dependencias Escala Color/Grupo Color - Rango 0.01 al 0.29
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(7,6,2);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(8,7,2);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(9,7,2);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(10,8,2);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(11,9,2);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(12,10,2);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(13,10,2);

-- Dependencias Escala Color/Grupo Color - Rango 0.30 al 20
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(14,11,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(15,11,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(16,11,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(16,12,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(17,12,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(18,12,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(19,12,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(20,12,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(20,13,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(21,13,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(21,14,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(22,14,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(23,15,3);
INSERT INTO cat_diamante_escala_color_grupo_color(elemento_hijo, elemento_padre, id_rango) VALUES(24,15,3);


-- Dependencias Color/Escala Color - Rango 0.01 al 0.29
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(6,8,2);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(6,7,2);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(7,9,2);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(7,10,2);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(8,10,2);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(8,11,2);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(9,11,2);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(9,12,2);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(10,13,2);

-- Dependencias Color/Escala Color - Rango 0.30 al 20
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(11,14,3);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(11,15,3);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(12,16,3);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(12,17,3);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(13,17,3);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(13,18,3);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(14,18,3);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(14,19,3);
INSERT INTO cat_diamante_color_escala_color(elemento_hijo, elemento_padre, id_rango) VALUES(15,20,3);


-- Dependencias Grado Color/Color - Rango 0.01 al 0.29
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(7,12,2);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(8,14,2);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(8,13,2);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(9,15,2);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(9,16,2);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(9,17,2);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(10,18,2);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(10,19,2);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(11,20,2);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(11,21,2);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(12,22,2);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(13,23,2);

-- Dependencias Grado Color/Color - Rango 0.30 al 20
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(14,24,3);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(15,25,3);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(15,26,3);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(16,27,3);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(16,28,3);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(16,29,3);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(17,30,3);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(17,31,3);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(18,32,3);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(18,33,3);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(19,34,3);
INSERT INTO cat_diamante_grado_color_color(elemento_hijo, elemento_padre, id_rango) VALUES(20,35,3);



-- Claridad - Rango 0.01 al 0.29
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(7,'IF-VVS','IF-VVS',11,2);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(8,'VS','VS',11,2);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(9,'SI1','SI1',11,2);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(10,'SI2','SI2',11,2);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(11,'I1','I1',11,2);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(12,'I2','I2',11,2);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(13,'I3','I3',11,2);
-- Padres
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(14,'IF','IF',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(15,'WS1','WS1',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(16,'WS2','WS2',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(17,'VS1','VS1',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(18,'VS2','VS2',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(19,'SI1_1','SI1 padre',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(20,'SI2_1','SI2 padre',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(21,'I1_1','I1 padre',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(22,'I2_1','I2 padre',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(23,'I3_1','I3 padre',11,2,1);


-- Claridad - Rango 0.30 al 20
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(24,'IF','IF',11,3);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(25,'WS1','WS1',11,3);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(26,'WS2','WS2',11,3);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(27,'VS1','VS1',11,3);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(28,'VS2','VS2',11,3);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(29,'SI1','SI1',11,3);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(30,'SI2','SI2',11,3);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(31,'I1','I1',11,3);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(32,'I2','I2',11,3);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(33,'I3','I3',11,3);


-- Relacion claridad - claridad

INSERT INTO cat_claridad_diamante_claridad(elemento_hijo, elemento_padre, id_rango) VALUES(7,14,2);
INSERT INTO cat_claridad_diamante_claridad(elemento_hijo, elemento_padre, id_rango) VALUES(7,15,2);
INSERT INTO cat_claridad_diamante_claridad(elemento_hijo, elemento_padre, id_rango) VALUES(7,16,2);
INSERT INTO cat_claridad_diamante_claridad(elemento_hijo, elemento_padre, id_rango) VALUES(8,17,2);
INSERT INTO cat_claridad_diamante_claridad(elemento_hijo, elemento_padre, id_rango) VALUES(8,18,2);

INSERT INTO cat_claridad_diamante_claridad(elemento_hijo, elemento_padre, id_rango) VALUES(9,19,2);
INSERT INTO cat_claridad_diamante_claridad(elemento_hijo, elemento_padre, id_rango) VALUES(10,20,2);
INSERT INTO cat_claridad_diamante_claridad(elemento_hijo, elemento_padre, id_rango) VALUES(11,21,2);
INSERT INTO cat_claridad_diamante_claridad(elemento_hijo, elemento_padre, id_rango) VALUES(12,22,2);
INSERT INTO cat_claridad_diamante_claridad(elemento_hijo, elemento_padre, id_rango) VALUES(13,23,2);
