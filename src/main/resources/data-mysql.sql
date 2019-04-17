--
-- Utilizado para poblar la BD (mysql) utilizada con los perfiles local y cloud.
--


--
-- INICIA - DATOS CONFIGURACIÓN CATÁLOGO
--
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (1, 'Alhajas', 'CondicionPrenda', 'EX', 'Catálogo de Condiciones de la Prenda');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (2, 'Alhajas', 'Metal', 'AU', 'Catálogo de Metales');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (3, 'Alhajas', 'ColorOro', 'Catálogo de Color Oro');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (4, 'Alhajas', 'QuilatajeOro', 'Catálogo de Quilataje Oro');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (5, 'Alhajas', 'CalidadLey', 'Catálogo de Calidades Ley');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (6, 'Alhajas', 'RangoOro', 'Catálogo de Rango Oro');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (7, 'Alhajas', 'RangoMetal', 'Catálogo de Rango Metal');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (8, 'Diamantes', 'MotivoBajaPrestamo', 'MTA', 'Catálogo de Motivos de Baja de Préstamo');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (9, 'Diamantes', 'CertificadoDiamantes', 'Catálogo de Certificados de Diamante');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (10, 'Diamantes', 'TipoPiedraComplementaria', 'Catálogo de Tipos de Piedra Complementaria');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (11, 'Diamantes', 'ClaridadDiamante', 'Catálogo de Claridades de Diamante');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (12, 'Diamantes', 'Corte', 'Catálogo de Cortes de Diamante');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (13, 'Alhajas', 'TipoPrenda', 'ANILLO', 'Catálogo que define los tipos de prenda.');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (14, 'Diamantes', 'GradoColor', 'D', 'Catálogo que define el grado de color de un diamante.');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (15, 'Diamantes', 'Color', 'Catálogo que define el color de un diamante.');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (16, 'Diamantes', 'EscalaColor', 'Catálogo que define la escala de color de un diamante.');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (17, 'Diamantes', 'GrupoColor', 'Catálogo que define el grupo de color de un diamante.');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (18, 'Diamantes', 'QuilatajeDiamante', '0.25_Q', 'Catálogo de Quilatajes de Diamante');

--
-- INICIA - DATOS CATÁLOGO: 'CONDICIÓN PRENDA'
--
INSERT INTO cat_condicion_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'EX', 'Excelente', 1);
INSERT INTO cat_condicion_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'BN', 'Bueno', 1);
INSERT INTO cat_condicion_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'RE', 'Regular', 1);

--
-- INICIA - DATOS CATÁLOGO: 'METALES'
--
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'AU', 'Oro', 2);
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'PT', 'Platino', 2);
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'AG', 'Plata', 2);
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'PD', 'Plata-Paladio', 2);

--
-- INICIA - DATOS CATÁLOGO: 'COLOR ORO'
--
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'AU_AM', 'Amarillo', 3);
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'AU_BL', 'Blanco', 3);
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'AU_RO', 'Rojo', 3);
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'AU_RS', 'Rosa', 3);
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'AU_VE', 'Verde', 3);
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'AU_AZ', 'Azul', 3);
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, 'AU_PU', 'Purpura', 3);
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, 'AU_NE', 'Negro', 3);
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, 'AU_CO', 'Combinado', 3);

--
-- INICIA - DATOS CATÁLOGO: 'QUILATAJE ORO'
--
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, '8_Q', '8', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, '10_Q', '10', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, '12_Q', '12', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, '14_Q', '14', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, '16_Q', '16', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, '18_Q', '18', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, '22_Q', '22', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, '24_Q', '24', 4);

--
-- INICIA - DATOS CATÁLOGO: 'CALIDAD LEY'
--
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'CL_999', '0.999', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'CL_925', '0.925', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'CL_900', '0.900', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'CL_720', '0.720', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'CL_500', '0.500', 5);

--
-- INICIA - DATOS CATÁLOGO: 'RANGO ORO'
--
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'F1', 'Pedacería y Piezas Rotas', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'F2', 'Buen Estado Personalizadas', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'F3', 'Buen Estado Sin Personalizar', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'F4', 'Piezas Nuevas', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'F5', 'Marcas Comerciales', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'F6', 'Alta Joyería', 6);

--
-- INICIA - DATOS CATÁLOGO: 'RANGO METAL'
--
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'F1', 'Factor 1', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'DE', 'Diseño y Estado', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'MC', 'Marca', 7);

--
-- INICIA - DATOS CATÁLOGO: 'MOTIVOS DE BAJA DE PRÉSTAMO'
--
INSERT INTO cat_motivo_baja_prestamo (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'MBP_CL', 'Solicitado por el Cliente', 8);
INSERT INTO cat_motivo_baja_prestamo (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'MBP_PV', 'A consideración del Perito Valuador', 8);

--
-- INICIA - DATOS CATÁLOGO: 'CERTIFICADOS DE DIAMANTES'
--
INSERT INTO cat_certificado_diamantes (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'GI', 'GIA', 9);
INSERT INTO cat_certificado_diamantes (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'HR', 'HRD Antwerp', 9);
INSERT INTO cat_certificado_diamantes (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'IG', 'IGE', 9);

--
-- INICIA - DATOS CATÁLOGO: 'TIPOS DE PIEDRA COMPLEMENTARIA'
--
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'CI', 'Zircón', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'CU', 'Cuarzo', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'ES', 'Esmeralda', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'GR', 'Granate', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'JA', 'Jade', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'LA', 'Lapislázuli', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, 'PE', 'Perla', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, 'RU', 'Rubí', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, 'TO', 'Topacio', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (10, 'ZA', 'Zafiro', 10);

--
-- INICIA - DATOS CATÁLOGO: 'CLARIDAD DIAMANTE'
--
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'IF', 'IF', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'VVS1', 'VVS1', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'VVS2', 'VVS2', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'VS1', 'VS1', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'VS2', 'VS2', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'SI1', 'SI1', 11);

-- ----------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'CORTE DIAMANTE'
-- ----------------------------------------------------------------------------------------------------------------------
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'Round', 'Round', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'Pear', 'Pear', 12);

INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (1, 1, 'BR', 'Brillante');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (2, 1, 'AN', 'Antiguo');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (3, 1, 'CJ', 'Cojin');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (4, 1, 'CO', 'Corazón');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (5, 1, 'MA', 'Marquesa');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (6, 1, 'OV', 'Oval');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (7, 1, 'BA', 'Baguette');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (8, 1, 'AS', 'Asscher');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (9, 1, 'FL', 'Flandes');

INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (10, 2, 'PE', 'Pera');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (11, 2, 'ES', 'Esmeralda');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (12, 2, 'RA', 'Radiant');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (13, 2, 'PR', 'Princesa');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (14, 2, 'TR', 'Trillion');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (15, 1, 'ME', 'Melee');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (16, 2, 'OT', 'Otro');


--
-- INICIA - DATOS CATÁLOGO: 'TIPO PRENDA'
--
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'ANILLO', 'Anillo', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'ARETES', 'Juego de aretes', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'ARGOLLA', 'Argolla', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'BRAZALETE', 'Brazalete', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'CADENA', 'Cadena', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'DIADEMA', 'Diadema', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, 'DIJE', 'Dije', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, 'ESCALOGRAMA', 'Escalograma', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, 'ESCLAVA', 'Esclava', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (10, 'FISTOL', 'Fistol', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (11, 'GARGANTILLA', 'Gargantilla', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (12, 'HEBILLA', 'Hebilla', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (13, 'MANCUERNILLAS', 'Juego de mancuernillas', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (14, 'PIN', 'Pin', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (15, 'PRENDEDOR', 'Prendedor', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (16, 'PULSERA', 'Pulsera', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (17, 'OTRO', 'Otro', 13);


--
-- INICIA - DATOS CATÁLOGO: 'GRADO COLOR'
--
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'D', 'D', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'E', 'E', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'F', 'F', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'G', 'G', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'H', 'H', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'I', 'I', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, 'J', 'J', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, 'K', 'K', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, 'L', 'L', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (10, 'M', 'M', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (11, 'N', 'N, O-Z', 14);


--
-- INICIA - DATOS CATÁLOGO: 'COLOR'
--
INSERT INTO cat_diamante_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'COLOR_D_E', '', 15);
INSERT INTO cat_diamante_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'BLANCO_NATURAL', 'Blanco natural', 15);
INSERT INTO cat_diamante_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'BLANCO_COMERCIAL', 'Blanco comercial', 15);
INSERT INTO cat_diamante_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'LIGERO_COLOR', 'Ligero color', 15);
INSERT INTO cat_diamante_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'COLOR', 'Color', 15);
INSERT INTO cat_diamante_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'COLOR_N_O_Z', '', 15);

INSERT INTO cat_diamante_grado_color_color (elemento_padre, elemento_hijo) VALUES (1, 1);
INSERT INTO cat_diamante_grado_color_color (elemento_padre, elemento_hijo) VALUES (2, 1);
INSERT INTO cat_diamante_grado_color_color (elemento_padre, elemento_hijo) VALUES (3, 2);
INSERT INTO cat_diamante_grado_color_color (elemento_padre, elemento_hijo) VALUES (4, 2);
INSERT INTO cat_diamante_grado_color_color (elemento_padre, elemento_hijo) VALUES (5, 3);
INSERT INTO cat_diamante_grado_color_color (elemento_padre, elemento_hijo) VALUES (6, 3);
INSERT INTO cat_diamante_grado_color_color (elemento_padre, elemento_hijo) VALUES (7, 4);
INSERT INTO cat_diamante_grado_color_color (elemento_padre, elemento_hijo) VALUES (8, 4);
INSERT INTO cat_diamante_grado_color_color (elemento_padre, elemento_hijo) VALUES (9, 5);
INSERT INTO cat_diamante_grado_color_color (elemento_padre, elemento_hijo) VALUES (10, 5);
INSERT INTO cat_diamante_grado_color_color (elemento_padre, elemento_hijo) VALUES (11, 6);


--
-- INICIA - DATOS CATÁLOGO: 'ESCALA COLOR'
--
INSERT INTO cat_diamante_escala_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'INCOLORO', 'Incoloro', 16);
INSERT INTO cat_diamante_escala_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'CASI_INCOLORO', 'Casi incoloro', 16);
INSERT INTO cat_diamante_escala_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'AMARILLO_TENUE', 'Amarillo tenue', 16);
INSERT INTO cat_diamante_escala_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'AMARILLO_LIGERO', 'Amarillo ligero', 16);
INSERT INTO cat_diamante_escala_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'AMARILLO', 'Amarillo', 16);

INSERT INTO cat_diamante_color_escala_color (elemento_padre, elemento_hijo) VALUES (1, 1);
INSERT INTO cat_diamante_color_escala_color (elemento_padre, elemento_hijo) VALUES (2, 1);
INSERT INTO cat_diamante_color_escala_color (elemento_padre, elemento_hijo) VALUES (2, 2);
INSERT INTO cat_diamante_color_escala_color (elemento_padre, elemento_hijo) VALUES (3, 2);
INSERT INTO cat_diamante_color_escala_color (elemento_padre, elemento_hijo) VALUES (4, 2);
INSERT INTO cat_diamante_color_escala_color (elemento_padre, elemento_hijo) VALUES (4, 3);
INSERT INTO cat_diamante_color_escala_color (elemento_padre, elemento_hijo) VALUES (5, 3);
INSERT INTO cat_diamante_color_escala_color (elemento_padre, elemento_hijo) VALUES (5, 4);
INSERT INTO cat_diamante_color_escala_color (elemento_padre, elemento_hijo) VALUES (6, 5);


--
-- INICIA - DATOS CATÁLOGO: 'GRUPO COLOR'
--
INSERT INTO cat_diamante_grupo_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'E', 'D-E', 17);
INSERT INTO cat_diamante_grupo_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'G', 'F-G', 17);
INSERT INTO cat_diamante_grupo_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'I', 'H-I', 17);
INSERT INTO cat_diamante_grupo_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'K', 'J-K', 17);
INSERT INTO cat_diamante_grupo_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'L', 'L-M', 17);
INSERT INTO cat_diamante_grupo_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'M', 'N-Z', 17);

INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (1, 1);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (1, 2);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (2, 2);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (2, 3);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (2, 4);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (3, 4);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (3, 5);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (4, 5);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (5, 6);


--
-- INICIA - DATOS CATÁLOGO: 'QUILATAJE DIAMANTE'
--
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 1, '0.001', '0.001', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 2, '0.002', '0.002', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 3, '0.003', '0.003', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 4, '0.004', '0.004', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 5, '0.005', '0.005', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 6, '0.006', '0.006', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 7, '0.007', '0.007', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 8, '0.008', '0.008', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 9, '0.009', '0.009', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (10, '0.01', '0.01', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (11, '0.02', '0.02', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (12, '0.03', '0.03', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (13, '0.04', '0.04', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (14, '0.05', '0.05', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (15, '0.06', '0.06', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (16, '0.07', '0.07', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (17, '0.08', '0.08', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (18, '0.09', '0.09', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (19, '0.10', '0.10', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (20, '0.11', '0.11', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (21, '0.12', '0.12', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (22, '0.13', '0.13', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (23, '0.14', '0.14', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (24, '0.15', '0.15', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (25, '0.16', '0.16', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (26, '0.17', '0.17', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (27, '0.18', '0.18', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (28, '0.19', '0.19', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (29, '0.20', '0.20', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (30, '0.21', '0.21', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (31, '0.22', '0.22', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (32, '0.26', '0.23 - 0.29', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (33, '0.35', '0.30 - 0.39', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (34, '0.45', '0.40 - 0.49', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (35, '0.60', '0.50 - 0.69', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (36, '0.80', '0.70 - 0.89', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (37, '0.95', '0.90 - 0.99', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (38, '1.25', '1.00 - 1.49', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (39, '1.75', '1.50 - 1.99', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (40, '2.50', '2.00 - 2.99', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (41, '3.50', '3.00 - 3.99', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (42, '4.50', '4.00 - 4.99', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (43, '5.50', '5.00 - 5.99', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (44, '10.50', '10.00 - 10.99', 18);






---------------------------------------------------------------------------------------------------------------------
------------------------ SIVA DIAMANTES FASE 2 ----------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------


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

DELETE FROM cat_sub_corte WHERE ELEMENTO_ID='15';
DELETE FROM cat_sub_corte WHERE ELEMENTO_ID='16';
UPDATE cat_sub_corte SET corte='1' WHERE corte = '2';
UPDATE cat_sub_corte SET etiqueta='Brillante Redondo' WHERE elemento_id='1';
UPDATE cat_sub_corte SET etiqueta='Acojinado' WHERE elemento_id='3';
UPDATE cat_sub_corte SET etiqueta='Radiante' WHERE elemento_id='12';
UPDATE cat_sub_corte SET etiqueta='Trillante' WHERE elemento_id='14';


INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (16, 1, 'TP', 'Trapecio');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (17, 1, '8X', '8x8');
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (18, 1, 'OT', 'Otro');
-- Se homologan los nombres del catálogo como en Midas
UPDATE cat_rango_oro SET etiqueta='Rotas y Pedacería' WHERE elemento_id=1;
UPDATE cat_rango_oro SET etiqueta='Personalizado' WHERE elemento_id=2;
UPDATE cat_rango_oro SET etiqueta='Sin Personalizar' WHERE elemento_id=3;
UPDATE cat_rango_oro SET etiqueta='Buen Estado Sin Personalizar' WHERE elemento_id=4;
UPDATE cat_rango_oro SET etiqueta='Marcas Comerciales y Piezas Nuevas' WHERE elemento_id=5;

-- Se agregan los elemntos en calidad ley faltantes
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'CL_950', '0.950', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, 'CL_850', '0.850', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, 'CL_800', '0.800', 5);


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
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(21,'L','L-M',17,3);
INSERT INTO cat_diamante_grupo_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(22,'M','M-N',17,3);
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
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(7,'COLOR_D','',15,2);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(8,'BLANCO_NATURAL','Blanco natural',15,2);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(9,'BLANCO_COMERCIAL','Blanco comercial',15,2);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(10,'LIGERO_COLOR','Ligero color',15,2);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(11,'COLOR','Color',15,2);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(12,'COLOR_N','',15,2);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(13,'COLOR_O_Z','',15,2);

-- Catalogo Color - Rango 0.30 al 20
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(14,'COLOR_D','',15,3);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(15,'BLANCO_NATURAL','Blanco natural',15,3);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(16,'BLANCO_COMERCIAL','Blanco comercial',15,3);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(17,'LIGERO_COLOR','Ligero color',15,3);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(18,'COLOR','Color',15,3);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(19,'COLOR_N','',15,3);
INSERT INTO cat_diamante_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(20,'COLOR_O_Z','',15,3);



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
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(23,'Z','O-Z',14,2);

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
INSERT INTO cat_diamante_grado_color(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(35,'Z','O-Z',14,3);




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
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(7,'IF','IF-VVS',11,2);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(8,'VS1','VS',11,2);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(9,'SI1','SI1',11,2);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(10,'SI2','SI2',11,2);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(11,'I1','I1',11,2);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(12,'I2','I2',11,2);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(13,'I3','I3',11,2);
-- Padres
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(14,'IF','IF',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(15,'VVS1','VVS1',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(16,'VVS2','VVS2',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(17,'VS1','VS1',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(18,'VS2','VS2',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(19,'SI1_1','SI1 padre',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(20,'SI2_1','SI2 padre',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(21,'I1_1','I1 padre',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(22,'I2_1','I2 padre',11,2,1);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango, padre) VALUES(23,'I3_1','I3 padre',11,2,1);


-- Claridad - Rango 0.30 al 20
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(24,'IF','IF',11,3);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(25,'VVS1','VVS1',11,3);
INSERT INTO cat_claridad_diamante(elemento_id, abreviatura, etiqueta, id_configuracion, id_rango) VALUES(26,'VVS2','VVS2',11,3);
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

----------------------------------------------------------------------------------------------------------------------
-- SISTEMA DE OPERACION PRENDARIA EMERGENTE
-- ----------------------------------------------------------------------------------------------------------------------
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (20,'Perfiles', 'Perfil', 'Catálogo de perfiles',now());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (21,'Ramos', 'Ramo', 'Catálogo de ramos',now());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (22,'Subramos', 'Subramo', 'Catálogo de subramos',now());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (23,'Sucursales', 'Sucursal', 'Catálogo de sucursales',now());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (24,'TipoContrato','TipoContrato','Catálogo de tipo de contratos',now());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (25,'Operaciones','OperacionesCaja','Catálogo de las operaciones de caja',now());

INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (26,'Contratos','Contrato','Catálogo de las operaciones de caja',now());

INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (27,'Reportes','Reporte','Catálogo de reportes',now());


-- Catálogo de Perfiles
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (2,'V' ,'Valuador',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'A' ,'Amarrador',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (4,'AD' ,'Auxiliar de deposito',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (5,'JA' ,'Jefe de Almoneda',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (6,'G' ,'Gerente',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (12,'AA' ,'Auxiliar de Jefe de Almoneda',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (27,'AG' ,'Auxiliar de gerente',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (28,'CA' ,'Cajero de almoneda',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (29,'CI' ,'Cajero de indemnización',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (30,'CE' ,'Cajero de empeño',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (31,'CR' ,'Cajero de refrendo',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (32,'CD' ,'Cajero de desempeño',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (33,'DI' ,'Cajero de divisas',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (34,'DE' ,'Depositario',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (35,'EN' ,'Entregador',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (36,'RE' ,'Responsable de entrada de depósito',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (37,'RS' ,'Responsable de salida de depósito',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (38,'EX' ,'Expendedor',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (39,'CG' ,'Cajero General',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (40,'RI' ,'Responsible de Indemnización',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (50,'PO' ,'Perito Valuador Inspector Operativo',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (53,'EC' ,'Ejecutivo de Caja',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (54,'AX' ,'Cajero Auxiliar',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (55,'AEC' ,'Auxiliar de Ejecutivo de Caja',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (62,'GPV' ,'Gerente Perito Valuador',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (63,'DA' ,'Responsable Depositario Amarrador',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (64,'CML' ,'Cajero Multiple',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (69,'WS' ,'Administrador Proyección',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (68,'AOP' ,'Auxiliar de Operación',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (70,'ACO' ,'Analista de Concentradora',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (72,'' ,'Gerente de Concentradora',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (77,'GDB' ,'Gerente de Bodega',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (78,'GDJ' ,'Gerente de Joyería',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (80,'CRD' ,'Corredor',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (81,'MCO' ,'Mesa de Control Operativo',20);
-- Catálogo de Ramos
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1,'AL','Alhajas',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (2,'VE','Vehículos',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'GE','Generos',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (4,'VA','Varios',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (5,'VAP','Varios Articulos Pequeños',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (6,'RJ','Relojes',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (7,'SR','Sin Resguardo',21);
-- Catálogo de Subramos
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
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (31,'PR','Prismáticos',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (32,'BI','Bicicletas (Fijas y Movibles)',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (33,'MO','Modulares y Minicomponentes',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (34,'AE','Artículos de Escritorio',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (35,'CT','Cortadoras',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (36,'BL','Basculas de Balanzon',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (37,'BP','Basculas de Plataforma',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (38,'CR','Compresores',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (39,'MT','Motores',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (40,'OR','Organos Musicales',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (41,'SN','Super Nintendo',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (42,'PD','Pedrería',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (43,'CL','Celulares',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (44,'OS','Otros',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (45,'AAP','Accesorios y artículos personales',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (46,'AD','Artículos decorativos',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (47,'AV','Audio y video',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (48,'CA','Cámaras',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (49,'EC','Equipo de cómputo',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (50,'JV','Juego de video',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (51,'R6','Alta Relojería - Gama Alta',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (52,'R5','Alta Relojería - Gama Media Alta',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (53,'R4','Relojes Comerciales - Gama Media',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (54,'R3','Relojes Comerciales - Gama Media Baja',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (55,'R2','Relojes Boutique - Gama Baja',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (56,'R1','Relojes de Oro',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (57,'MC','Motocicletas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (58,'SR','Sin Resguardo',22);

-- Catálogo de Sucursales
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (0,'0','Casa Matriz-Centro Histórico, Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1,'1','Victoria-Centro Histórico, Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (2,'2','El Carmen-Centro Histórico, Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'3','Escandon-Miguel Hidalgo, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (4,'4','Isabel la Católica/Izazaga-Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (5,'5','Morelos Hortelanos-Venustiano Carranza, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (6,'6','Orizaba-Orizaba Pte., VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (7,'7','Veracruz-Callejón Reforma, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (8,'8','Metro Portales-Benito Juárez, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (9,'9','León-Miguel Alemán, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (10,'10','Puente de Alvarado-Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (11,'11','Refineria-Azcapotzalco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (12,'12','Toluca-Centro, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (13,'13','Morelia-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (14,'14','Miguel Angel de Quevedo-Coyoacán, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (15,'15','San Luis Potosí-Centro, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (172,'172','Mérida-Circuito Itzaes, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (234,'234','Puerto Vallarta-Fluvial Vallarta, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (221,'221','Metro Culhuacán, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (241,'241','Miramontes-Coyoacán, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (231,'231','Morelia-Torreón Nuevo, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (238,'238','Xalapa-Plaza Cristal, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (242,'242','Cancún-Mercado 28, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (16,'16','Aguascalientes-Centro, AGS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (17,'17','Sta. Maria Insurgentes-Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (18,'18','Guadalajara-R. Michel, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (19,'19','Torreón-Centro, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (20,'20','Guadalajara-Parque Morelos, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (21,'21','Peralvillo-Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (22,'22','Monterrey-Av. Guerrero, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (23,'23','Durango-Centro, DGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (24,'24','Chihuahua-Centro, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (25,'25','Guadalajara-Álvaro Obregón, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (27,'27','Santo Tomás- Azcapotzalco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (28,'28','Mérida-Centro, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (29,'29','Xalapa-Los Sauces, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (30,'30','Monterrey-Av.Colón, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (31,'31','Querétaro-Centro, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (32,'32','Chetumal-Efraín Aguilar, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (33,'33','Tepic-Allende I-Tepic, NAY',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (34,'34','Colima-Centro, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (35,'35','Veracruz-Juárez, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (244,'244','Tampico-Norte, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (246,'246','Monterrey-Av. Lincoln, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (248,'248','Los Mochis-Gabriel Leyva, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (36,'36','Querétaro-Tecnológico, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (37,'37','Havre D.F.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (38,'38','Plaza Aragón-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (39,'39','Xochimilco-Centro, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (40,'40','Guadalajara-Plaza Atemajac, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (41,'41','Mérida-Santiago, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (42,'42','Mazatlán-Centro, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (43,'43','Tercera Sur,Tuxtla Gutiérrez, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (44,'44','Zacatecas-Centro, ZAC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (45,'45','Campeche-Centro, CAMP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (46,'46','Av. Del Taller D.F.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (47,'47','Córdoba-Centro Avenida 2, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (48,'48','Veracruz-Cuauhtémoc, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (49,'49','Villahermosa-Centro, TAB',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (50,'50','Tampico-Centro, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (51,'51','Ermita Toltecas-Iztapalapa, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (52,'52','Xalapa-Zamora, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (53,'53','Cancún-López Portillo, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (54,'54','Poza Rica-Centro Obrera, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (55,'55','Monterrey-Av.Cuauhtémoc, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (56,'56','Cuernavaca-Lerdo de Tejada Centro, MOR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (57,'57','Acapulco-Parada del Vaquero Centro, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (58,'58','Uruapan-Morelos, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (59,'59','Tlaquepaque-Central Nueva, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (60,'60','La Venta-Cuautitlán Izcalli, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (61,'61','Clouthier-Metepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (62,'62','La Romana-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (63,'63','Irapuato-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (64,'64','Iguala-Bandera Nacional Centro, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (65,'65','La Paz-Centro, BCS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (66,'66','Tapachula-Centro, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (67,'67','Tijuana-Plaza Las Brisas, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (68,'68','Nuevo Laredo-Centro, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (69,'69','San Nicolás de Los Garza-Centro, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (70,'70','León-López Mateos, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (71,'71','Matamoros-Centro, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (72,'72','Mérida-Plaza Royal Américas, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (73,'73','Celaya-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (74,'74','Coatzacoalcos-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (75,'75','Juárez-Centro, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (76,'76','Morelia-Lázaro Cárdenas, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (77,'77','Mexicali-Centro Cívico, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (78,'78','Puerto Vallarta-Boulevard Francisco Medina, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (79,'79','Chilpancingo-Lázaro Cárdenas, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (80,'80','Ixtapaluca - Centro, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (81,'81','Lopez Mateos-Cd. Neza, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (82,'82','Tecomán-Las Palmas, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (83,'83','Boca del Río-Plaza Santa Ana, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (84,'84','Cuautla-Reforma, MOR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (85,'85','Morelos-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (86,'86','Aguascalientes-Central Camionera, AGS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (171,'171','Apatzingán-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (87,'87','Ciudad del Carmen-Centro, CAMP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (88,'88','León-Insurgentes T1, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (89,'89','San Juan del Río-Centro, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (90,'90','Plaza de la Constitución-Texcoco, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (91,'91','Tuxpan-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (92,'92','Gómez Palacio-Centro, DGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (93,'93','Martínez de La Torre-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (94,'94','Culiacán-Centro, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (95,'95','Tlaquepaque-Centro, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (96,'96','Puebla-Norte 8 Centro, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (97,'97','Mérida-Plaza Fiesta, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (98,'98','Chetumal-Zaragoza Centro, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (99,'99','Saltillo-Centro, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (100,'100','Veracruz-Cuauhtémoc, Alcocer, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (101,'101','Zamora-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (102,'102','Ciudad Madero-Centro, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (103,'103','Ciudad Obregón-Centro, SON',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (104,'104','Tepic-Allende II, NAY',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (105,'105','Centro-Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (106,'106','Morelia-Madero Pte., MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (187,'187','Comalcalco-Reforma, TAB',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (107,'107','Veracruz-Cuauhtémoc Norte, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (108,'108','Monterrey-Chapultepec, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (109,'109','Manzanillo-Centro, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (110,'110','Chihuahua-Av.Tecnológico, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (111,'111','Zapopan-Centro, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (112,'112','Oaxaca-Centro, OAX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (113,'113','Veracruz-El Coyol, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (114,'114','Cárdenas-Zona Remodelada, TAB',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (115,'115','Hermosillo-Centro, SON',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (116,'116','Tollocan-Toluca, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (117,'117','Orizaba-Circunvalación Oriente, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (118,'118','La Villa-Gustavo A. Madero, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (119,'119','Villa de Álvarez-Centro, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (120,'120','San Luis Potosí-B. Anaya, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (121,'121','Tuxtla Gutiérrez-Parque Marimba, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (122,'122','Guadalupe-Plaza Los Cristales, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (123,'123','General Escobedo-HEB Escobedo, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (124,'124','Guadalupe-Metro Exposición, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (125,'125','Las Alamedas-Atizapán, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (126,'126','Córdoba-Avenida 3 Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (127,'127','Guadalajara-Sta. Teresita, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (128,'128','Acapulco-Magallanes Cuauhtémoc, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (129,'129','Ciudad del Carmen-Calle 31, CAMP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (190,'190','Reynosa-Boulevard Hidalgo, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (130,'130','Monterrey-Metro Mitras, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (131,'131','Cancún-Cancún Mall, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (132,'132','Xalapa-Avenida Xalapa, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (133,'133','Veracruz-Astilleros, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (134,'134','Apodaca-Plaza Fresnos, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (135,'135','Monterrey-Plaza Aztlán, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (136,'136','Guadalajara-GranTerraza Oblatos,JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (137,'137','Guadalajara-Alcalde, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (138,'138','Tacubaya-Miguel Hidalgo, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (139,'139','San Juan de Aragón-Gustavo A. Madero, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (140,'140','Mérida-Chichén, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (141,'141','La Vía-Cuautitlán, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (142,'142','Centro Comercial las Américas, Ecatepec MEX.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (143,'143','Miramontes-Coyoacán, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (144,'144','Plaza Cantil-Coyoacán, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (145,'145','Querétaro-Plaza El Sol, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (146,'146','Tepic-Avenida México, NAY',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (147,'147','Mérida-Chuburná, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (148,'148','Av. Cuauhtémoc, Chalco, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (149,'149','León-Plaza Hidalgo, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (150,'150','Torreón-Central de Abastos, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (151,'151','Maravillas-Cd. Neza, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (191,'191','La Piedad-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (192,'192','Zitácuaro-Revolución Sur, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (152,'152','Boca del Río-Ejército Mexicano, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (170,'170','Rojo Gómez Agricola Oriental-Iztacalco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (157,'157','Villa Nicolás Romero, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (160,'160','Plaza las Flores- Coacalco, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (153,'153','Valle Dorado-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (188,'188','Plaza Toltecas-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (184,'184','Ermita Barrio San Miguel-Iztapalapa, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (200,'200','San Cristobal-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (210,'210','Be Grand Rio Magdalena, Álvaro Obregón, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (194,'194','Temoaya-Cuautitlán Izcalli, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (156,'156','Avenida 8-Venustiano Carranza, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (164,'164','Xalapa-Manuel Ávila Camacho, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (169,'169','Boca del Río-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (206,'206','Santa Catarina-Plaza La Puerta, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (209,'209','Tonalá-Lomas de Tonalá, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (205,'205','Mérida-Macroplaza, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (161,'161','Guadalupe-Plaza Molinete, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (203,'203','Tlajomulco-Multiplaza del Valle, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (159,'159','Tierra Blanca-Juárez, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (162,'162','Tehuacán-Independencia Poniente, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (163,'163','Morelia-Plazuela Carrillo, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (166,'166','Papantla-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (167,'167','San Juan Bautista Tuxtepec-5 de Mayo, OAX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (173,'173','Metro Muzquiz-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (179,'179','Poza Rica-Boulevard, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (180,'180','Acapulco-Plaza Sendero, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (168,'168','Los Reyes-La Paz, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (182,'182','Lago de Guadalupe-Atizapán, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (154,'154','Cozumel-Centro, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (155,'155','Irapuato-Las Reynas, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (158,'158','Minatitlán-Parquecito Hidalgo, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (165,'165','Tecomán-Baldino Dávalos, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (174,'174','Comitán-Belisario Domínguez, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (175,'175','Salamanca-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (176,'176','Zapopan-Mariano Otero, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (177,'177','Cd. Juárez-Plaza San Carlos, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (183,'183','Colima-Francisco I. Madero, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (186,'186','Tulyehualco-Tláhuac, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (178,'178','Coatepec-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (185,'185','Zihuatanejo-Los Mangos Centro, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (189,'189','Acayucan-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (195,'195','Durango-Centro Comercial Paseo Durango, DGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (196,'196','Cuernavaca-Plan de Ayala, MOR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (197,'197','Salina Cruz-Centro, OAX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (198,'198','Zapopan-Patria, JAL.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (201,'201','San Andrés Tuxtla-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (202,'202','Aguascalientes-Petróleos, AGS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (204,'204','Valladolid-Plaza Bella Valladolid, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (211,'211','Multiplaza Arenera-Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (193,'193','Monclova-Centro, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (199,'199','Zacapu, Mich.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (208,'208','Ciudad Valles-Centro, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (212,'212','Veracruz- Parque Zamora, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (181,'181','Lázaro Cárdenas-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (207,'207','Plaza Dorada, Ciudad Juarez, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (214,'214','Las Aguilas-Cd. Neza, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (217,'217','Tonalá-Río Nilo, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (218,'218','San José de los Cedros-Cuajimalpa, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (213,'213','Jamaica-Venustiano Carranza, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (215,'215','Fuentes del Valle-Tultitlán, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (216,'216','Santa Clara-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (224,'224','Benito Juárez-Sun Mall Vip, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (222,'222','San Luis Potosí-Muñoz, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (226,'226','Urbiplaza-Tlalpan, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (219,'219','Mérida-Francisco de Montejo, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (227,'227','Insurgentes Roma Sur-Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (228,'228','Federico Gómez-Zumpango, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (236,'236','Gustavo Baz-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (240,'240','Guadalupe-Eloy Cavazos, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (233,'233','León-Mariano Escobedo, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (232,'232','Querétaro-Pie de la Cuesta, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (245,'245','Veracruz-Díaz Mirón, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (220,'220','Cd. Guzmán-Centro, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (225,'225','Mérida-Santa Rosa, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (230,'230','Puebla-Capu, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (243,'243','Guadalajara-Presa Laurel, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (229,'229','Puebla-Blvd. Valsequillo, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (252,'252','San Felipe-Gustavo A. Madero, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (251,'251','Tuxtla Gutiérrez-Plaza del Sol, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (247,'247','Picacho, Ajusco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (250,'250','Tulancingo-Centro, HGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (501,'501','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (502,'502','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (235,'235','Pachuca-Centro, HGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (253,'253','Carretera Federal-Tecámac, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (255,'255','Guasave-Centro, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (503,'503','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (504,'504','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (505,'505','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (506,'506','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (507,'507','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (508,'508','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (509,'509','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (510,'510','Real de 14',23);

INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (511,'511','Real de 14',23);

INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (512,'512','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (280,'280','Vallejo-Gustavo A. Madero, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (282,'282','Culiacán-Sanalona-Guadalupe Victoria, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (513,'513','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (514,'514','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (515,'515','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (516,'516','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (517,'517','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (518,'518','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (519,'519','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (520,'520','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (237,'237','Guanajuato-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (254,'254','San Martín Texmelucan-Libertad Sur Zona Centro, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (256,'256','Tenayuca-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (257,'257','Plaza Urban Center, Rioja',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (258,'258','Vasco de Quiroga-Santa Fe, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (260,'260','Apodaca-Plaza Morelos, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (261,'261','Solidaridad-Playa del Carmen, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (263,'263','Guadalajara-Lomas de Polanco, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (264,'264','Tijuana-Centro, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (265,'265','Atlixco-Independencia, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (266,'266','Héroes de Tecamac, MEX.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (283,'283','Tijuana-Mariano Matamoros Ruta Independencia, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (223,'223','Chihuahua-Plaza Dostoievsky, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (239,'239','Puebla-Reforma Centro, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (249,'249','Insurgentes San Ángel-Alvaro Obregón, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (259,'259','Piedras Negras-San Vicente Chicoloapan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (267,'267','Ensenada-Centro, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (268,'268','Juan Diego-Valle de Chalco Solidaridad, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (269,'269','San Luis Potosí-Himno Nacional, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (271,'271','Plaza Atizapán-Atizapán, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (272,'272','Querétaro-Plaza Candiles, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (273,'273','Plaza Vista Norte, G.A.M-CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (274,'274','Chihuahua-Fuentes Mares, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (275,'275','Plaza Arboledas, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (262,'262','Moroleón-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (285,'285','Acapulco-Renacimiento, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (521,'521','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (522,'522','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (523,'523','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (600,'600','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (524,'524','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (525,'525','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (526,'526','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (527,'527','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (599,'599','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (528,'528','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (529,'529','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (530,'530','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (531,'531','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (532,'532','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (533,'533','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (534,'534','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (535,'535','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (536,'536','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (537,'537','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (538,'538','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (539,'539','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (540,'540','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (541,'541','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (284,'284','Metropolitana-Cd. Neza, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (286,'286','Chimalhuacán-Del Peñón, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (542,'542','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (543,'543','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (544,'544','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (545,'545','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (546,'546','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (598,'598','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (547,'547','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (548,'548','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (549,'549','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (550,'550','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (551,'551','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (552,'552','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (597,'597','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (553,'553','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (554,'554','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (555,'555','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (556,'556','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (596,'596','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (288,'288','Coatzacoalcos-Universidad, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (289,'289','Mexicali-Nuevo Mexicali, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (557,'557','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (558,'558','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (559,'559','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (560,'560','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (595,'595','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (594,'594','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (593,'593','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (592,'592','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (591,'591','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (590,'590','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (589,'589','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (588,'588','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (587,'587','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (586,'586','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (585,'585','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (584,'584','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (583,'583','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (582,'582','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (290,'290','Satélite-Arquitectos, Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (291,'291','Aguascalientes-Haciendas, AGS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (581,'581','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (580,'580','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (579,'579','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (578,'578','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (577,'577','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (576,'576','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (575,'575','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (574,'574','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (573,'573','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (572,'572','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (571,'571','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (570,'570','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (569,'569','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (568,'568','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (567,'567','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (566,'566','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (565,'565','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (564,'564','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (292,'292','Gran Sur-Coyoacán, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (293,'293','Doctores-Hospital General, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (563,'563','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (562,'562','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (561,'561','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (270,'270','San Nicolás de los Garza-Av. Universidad, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (276,'276','Paseo Reynosa, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (277,'277','Matamoros-Plaza HEB, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (279,'279','Saltillo-Venustiano Carranza, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (281,'281','Iztapalapa-Santa Cruz Meyehualco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (278,'278','San Jerónimo Lídice, Álvaro Obregón CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (287,'287','Torreón-Triana, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (294,'294','Puebla-Las Ánimas, PUE.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (295,'295','Obregón-Central Camionera, SON',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (296,'296','Campeche-Álvaro Obregón, CAMP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (297,'297','Xalapa-Atenas Veracruzana, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (298,'298','Guadalajara-Independencia Norte, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (299,'299','Puebla-Plaza Loreto, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (300,'300','Hermosillo-Plaza Sendero, SON',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (301,'301','Apodaca-Plaza Sendero La Concordia, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (302,'302','San Pedro Garza García-Bazar San Agustín, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (303,'303','Pachuca-Nuevo Hidalgo, HGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (304,'304','Lindavista-Montevideo, GAM. CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (305,'305','Félix Cuevas-Benito Juárez, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (306,'306','Mazatlán-Juárez Av. de las Américas, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (307,'307','El Molinito-Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (308,'308','Tesistán-Zapopan, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (310,'310','Las Armas-Azcapotzalco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (309,'309','Villahermosa-Av. Constitución, TAB',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1001,'1001','Concentradora',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (311,'311','Toluca-Alfredo del Mazo, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (312,'312','Insurgentes Sur Fuentes Brotantes-Tlalpan, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (313,'313','Torres de Satélite La Abeja-Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1002,'1002','WTC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (314,'314','Monterrey-Solidaridad, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (315,'315','Tlalpan-Metro Xola, Benito Juárez, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (316,'316','Centro Comercial Santa Fe-Cuajimalpa, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (900,'900','Avenida Paseo de la Reforma No',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (318,'318','Popocatépetl-Benito Juarez, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (320,'320','Apizaco-Centro, TLAX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1005,'1005','Venta en línea',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (319,'319','Mercado de Sonora, Venustiano Carranza, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (317,'317','Metro Tacuba, Miguel Hidalgo, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1008,'1008','Compra Cumplido',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1003,'1003','Outlet',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1004,'1004','Joyería externa',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1006,'1006','Centro de distribución',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1007,'1007','Autos sin resguardo',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (321,'321','Cumbres Elite Monterrey, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (322,'322','Jiutepec, Cuernavaca, MOR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (323,'323','Pino Suarez, Metepec - MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1009,'1009','Servicio a Clientes',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1010,'1010','Crédito',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (324,'324','Garza Sada - Monterrey, N.L.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (700,'700','Tienda Monte Corporativo-CDMX',23);
-- Catálogo de Tipo de contratos
INSERT INTO cat_tipo_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (146,'PL','PAGOS LIBRES',24);
INSERT INTO cat_tipo_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (145,'CL','CLASICO',24);
-- Catálogo de Operación de Caja
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
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (124,'REE','Cobro para Reempeño',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (132,'CRC','Cobro Reimpresión Carátula',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (198,'RFE','Cobro Refrendo Extemporaneo',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1004,'CK','Cancelacion Corte Caja',25);
-- Catálogo contrato
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
-- Catálogo de reportes
INSERT INTO cat_reportes(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1,'RMP0001' ,'Reporte Detalle de Operaciones',27);

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

-- relación entre contrato y tipo contrato
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
