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
INSERT INTO cat_certificado_diamantes (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'AJ', 'Alta Joyería', 9);

--
-- INICIA - DATOS CATÁLOGO: 'TIPOS DE PIEDRA COMPLEMENTARIA'
--
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'CI', 'Circón', 10);
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
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (9, 1, 'FL', 'Flanders');

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
UPDATE cat_sub_corte SET corte='1' WHERE corte = '2';


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
