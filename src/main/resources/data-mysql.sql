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
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, 'SI2', 'SI2', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, 'SI3', 'SI3', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, 'I1', 'I1', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (10, 'I2', 'I2', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (11, 'I3', 'I3', 11);

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
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'ARETES', 'Aretes', 13);
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
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (13, 'MANCUERNILLAS', 'Mancuernillas', 13);
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
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (11, 'N', 'N', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (12, 'O_Z', 'O-Z', 14);

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
INSERT INTO cat_diamante_grado_color_color (elemento_padre, elemento_hijo) VALUES (12, 6);

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
INSERT INTO cat_diamante_color_escala_color (elemento_padre, elemento_hijo) VALUES (6, 4);
INSERT INTO cat_diamante_color_escala_color (elemento_padre, elemento_hijo) VALUES (6, 5);

--
-- INICIA - DATOS CATÁLOGO: 'GRUPO COLOR'
--
INSERT INTO cat_diamante_grupo_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'D_E', 'D-E', 17);
INSERT INTO cat_diamante_grupo_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'F_G', 'F-G', 17);
INSERT INTO cat_diamante_grupo_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'H_I', 'H-I', 17);
INSERT INTO cat_diamante_grupo_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'J_K', 'J-K', 17);
INSERT INTO cat_diamante_grupo_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'L_M', 'L-M', 17);
INSERT INTO cat_diamante_grupo_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'N_Z', 'N-Z', 17);

INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (1, 1);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (1, 2);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (2, 2);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (2, 3);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (2, 4);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (3, 4);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (3, 5);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (4, 5);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (4, 6);
INSERT INTO cat_diamante_escala_color_grupo_color (elemento_padre, elemento_hijo) VALUES (5, 6);

--
-- INICIA - DATOS CATÁLOGO: 'QUILATAJE DIAMANTE'
--
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 1, '0.001', '0.001', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 2, '0.002', '0.001', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 3, '0.003', '0.001', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 4, '0.004', '0.001', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 5, '0.005', '0.001', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 6, '0.006', '0.001', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 7, '0.007', '0.001', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 8, '0.008', '0.001', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES ( 9, '0.009', '0.001', 18);
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
