INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (19, 'Diamantes', 'RangoPeso', '0.01_0.29', 'Catalogo Rango Pesos');
INSERT INTO cat_rango_peso (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, '0', 'Default', 19);

INSERT INTO CNF_CONFIGURACION_CATALOGO(ID, DOMINIO, TIPO, VALOR_DEFAULT, DESCRIPCION)
VALUES (14, 'Diamantes', 'GradoColor', 'D', 'Catálogo que define el grado de color de un diamante.');


INSERT INTO CAT_DIAMANTE_GRADO_COLOR(ELEMENTO_ID, ABREVIATURA, ETIQUETA, ID_CONFIGURACION, ID_RANGO)
VALUES (1, 'D', 'D', 14, 1);
INSERT INTO CAT_DIAMANTE_GRADO_COLOR(ELEMENTO_ID, ABREVIATURA, ETIQUETA, ID_CONFIGURACION, ID_RANGO)
VALUES (2, 'E', 'E', 14, 1);




--
-- Datos de relacion
--
INSERT INTO CNF_CONFIGURACION_CATALOGO(ID, DOMINIO, TIPO, DESCRIPCION)
VALUES (15, 'Diamantes', 'Color', 'Catálogo que define el color de un diamante.');
INSERT INTO CAT_DIAMANTE_COLOR(ELEMENTO_ID, ABREVIATURA, ETIQUETA, ID_CONFIGURACION, ID_RANGO)
VALUES (1, 'COLOR_D_E', '', 15, 1);
INSERT INTO CAT_DIAMANTE_GRADO_COLOR_COLOR(ELEMENTO_PADRE, ELEMENTO_HIJO, ID_RANGO)
VALUES (2, 1, 1);

