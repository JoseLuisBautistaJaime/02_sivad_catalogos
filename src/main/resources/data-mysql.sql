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
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (24,'Contratos','TipoContrato','Catálogo de tipo de contratos',now());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (25,'Operaciones','OperacionesCaja','Catálogo de las operaciones de caja',now());


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
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (0,'suc0','Casa Matriz-Centro Histórico, Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1,'suc1','Victoria-Centro Histórico, Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (2,'suc2','El Carmen-Centro Histórico, Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'suc3','Escandon-Miguel Hidalgo, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (4,'suc4','Isabel la Católica/Izazaga-Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (5,'suc5','Morelos Hortelanos-Venustiano Carranza, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (6,'suc6','Orizaba-Orizaba Pte., VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (7,'suc7','Veracruz-Callejón Reforma, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (8,'suc8','Metro Portales-Benito Juárez, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (9,'suc9','León-Miguel Alemán, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (10,'suc10','Puente de Alvarado-Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (11,'suc11','Refineria-Azcapotzalco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (12,'suc12','Toluca-Centro, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (13,'suc13','Morelia-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (14,'suc14','Miguel Angel de Quevedo-Coyoacán, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (15,'suc15','San Luis Potosí-Centro, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (172,'suc172','Mérida-Circuito Itzaes, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (234,'suc234','Puerto Vallarta-Fluvial Vallarta, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (221,'suc221','Metro Culhuacán, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (241,'suc241','Miramontes-Coyoacán, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (231,'suc231','Morelia-Torreón Nuevo, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (238,'suc238','Xalapa-Plaza Cristal, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (242,'suc242','Cancún-Mercado 28, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (16,'suc16','Aguascalientes-Centro, AGS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (17,'suc17','Sta. Maria Insurgentes-Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (18,'suc18','Guadalajara-R. Michel, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (19,'suc19','Torreón-Centro, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (20,'suc20','Guadalajara-Parque Morelos, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (21,'suc21','Peralvillo-Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (22,'suc22','Monterrey-Av. Guerrero, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (23,'suc23','Durango-Centro, DGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (24,'suc24','Chihuahua-Centro, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (25,'suc25','Guadalajara-Álvaro Obregón, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (27,'suc27','Santo Tomás- Azcapotzalco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (28,'suc28','Mérida-Centro, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (29,'suc29','Xalapa-Los Sauces, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (30,'suc30','Monterrey-Av.Colón, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (31,'suc31','Querétaro-Centro, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (32,'suc32','Chetumal-Efraín Aguilar, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (33,'suc33','Tepic-Allende I-Tepic, NAY',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (34,'suc34','Colima-Centro, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (35,'suc35','Veracruz-Juárez, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (244,'suc244','Tampico-Norte, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (246,'suc246','Monterrey-Av. Lincoln, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (248,'suc248','Los Mochis-Gabriel Leyva, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (36,'suc36','Querétaro-Tecnológico, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (37,'suc37','Havre D.F.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (38,'suc38','Plaza Aragón-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (39,'suc39','Xochimilco-Centro, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (40,'suc40','Guadalajara-Plaza Atemajac, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (41,'suc41','Mérida-Santiago, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (42,'suc42','Mazatlán-Centro, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (43,'suc43','Tercera Sur,Tuxtla Gutiérrez, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (44,'suc44','Zacatecas-Centro, ZAC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (45,'suc45','Campeche-Centro, CAMP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (46,'suc46','Av. Del Taller D.F.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (47,'suc47','Córdoba-Centro Avenida 2, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (48,'suc48','Veracruz-Cuauhtémoc, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (49,'suc49','Villahermosa-Centro, TAB',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (50,'suc50','Tampico-Centro, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (51,'suc51','Ermita Toltecas-Iztapalapa, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (52,'suc52','Xalapa-Zamora, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (53,'suc53','Cancún-López Portillo, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (54,'suc54','Poza Rica-Centro Obrera, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (55,'suc55','Monterrey-Av.Cuauhtémoc, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (56,'suc56','Cuernavaca-Lerdo de Tejada Centro, MOR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (57,'suc57','Acapulco-Parada del Vaquero Centro, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (58,'suc58','Uruapan-Morelos, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (59,'suc59','Tlaquepaque-Central Nueva, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (60,'suc60','La Venta-Cuautitlán Izcalli, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (61,'suc61','Clouthier-Metepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (62,'suc62','La Romana-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (63,'suc63','Irapuato-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (64,'suc64','Iguala-Bandera Nacional Centro, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (65,'suc65','La Paz-Centro, BCS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (66,'suc66','Tapachula-Centro, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (67,'suc67','Tijuana-Plaza Las Brisas, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (68,'suc68','Nuevo Laredo-Centro, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (69,'suc69','San Nicolás de Los Garza-Centro, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (70,'suc70','León-López Mateos, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (71,'suc71','Matamoros-Centro, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (72,'suc72','Mérida-Plaza Royal Américas, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (73,'suc73','Celaya-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (74,'suc74','Coatzacoalcos-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (75,'suc75','Juárez-Centro, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (76,'suc76','Morelia-Lázaro Cárdenas, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (77,'suc77','Mexicali-Centro Cívico, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (78,'suc78','Puerto Vallarta-Boulevard Francisco Medina, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (79,'suc79','Chilpancingo-Lázaro Cárdenas, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (80,'suc80','Ixtapaluca - Centro, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (81,'suc81','Lopez Mateos-Cd. Neza, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (82,'suc82','Tecomán-Las Palmas, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (83,'suc83','Boca del Río-Plaza Santa Ana, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (84,'suc84','Cuautla-Reforma, MOR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (85,'suc85','Morelos-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (86,'suc86','Aguascalientes-Central Camionera, AGS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (171,'suc171','Apatzingán-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (87,'suc87','Ciudad del Carmen-Centro, CAMP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (88,'suc88','León-Insurgentes T1, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (89,'suc89','San Juan del Río-Centro, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (90,'suc90','Plaza de la Constitución-Texcoco, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (91,'suc91','Tuxpan-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (92,'suc92','Gómez Palacio-Centro, DGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (93,'suc93','Martínez de La Torre-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (94,'suc94','Culiacán-Centro, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (95,'suc95','Tlaquepaque-Centro, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (96,'suc96','Puebla-Norte 8 Centro, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (97,'suc97','Mérida-Plaza Fiesta, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (98,'suc98','Chetumal-Zaragoza Centro, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (99,'suc99','Saltillo-Centro, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (100,'suc100','Veracruz-Cuauhtémoc, Alcocer, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (101,'suc101','Zamora-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (102,'suc102','Ciudad Madero-Centro, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (103,'suc103','Ciudad Obregón-Centro, SON',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (104,'suc104','Tepic-Allende II, NAY',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (105,'suc105','Centro-Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (106,'suc106','Morelia-Madero Pte., MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (187,'suc187','Comalcalco-Reforma, TAB',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (107,'suc107','Veracruz-Cuauhtémoc Norte, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (108,'suc108','Monterrey-Chapultepec, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (109,'suc109','Manzanillo-Centro, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (110,'suc110','Chihuahua-Av.Tecnológico, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (111,'suc111','Zapopan-Centro, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (112,'suc112','Oaxaca-Centro, OAX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (113,'suc113','Veracruz-El Coyol, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (114,'suc114','Cárdenas-Zona Remodelada, TAB',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (115,'suc115','Hermosillo-Centro, SON',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (116,'suc116','Tollocan-Toluca, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (117,'suc117','Orizaba-Circunvalación Oriente, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (118,'suc118','La Villa-Gustavo A. Madero, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (119,'suc119','Villa de Álvarez-Centro, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (120,'suc120','San Luis Potosí-B. Anaya, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (121,'suc121','Tuxtla Gutiérrez-Parque Marimba, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (122,'suc122','Guadalupe-Plaza Los Cristales, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (123,'suc123','General Escobedo-HEB Escobedo, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (124,'suc124','Guadalupe-Metro Exposición, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (125,'suc125','Las Alamedas-Atizapán, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (126,'suc126','Córdoba-Avenida 3 Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (127,'suc127','Guadalajara-Sta. Teresita, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (128,'suc128','Acapulco-Magallanes Cuauhtémoc, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (129,'suc129','Ciudad del Carmen-Calle 31, CAMP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (190,'suc190','Reynosa-Boulevard Hidalgo, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (130,'suc130','Monterrey-Metro Mitras, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (131,'suc131','Cancún-Cancún Mall, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (132,'suc132','Xalapa-Avenida Xalapa, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (133,'suc133','Veracruz-Astilleros, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (134,'suc134','Apodaca-Plaza Fresnos, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (135,'suc135','Monterrey-Plaza Aztlán, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (136,'suc136','Guadalajara-GranTerraza Oblatos,JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (137,'suc137','Guadalajara-Alcalde, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (138,'suc138','Tacubaya-Miguel Hidalgo, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (139,'suc139','San Juan de Aragón-Gustavo A. Madero, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (140,'suc140','Mérida-Chichén, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (141,'suc141','La Vía-Cuautitlán, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (142,'suc142','Centro Comercial las Américas, Ecatepec MEX.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (143,'suc143','Miramontes-Coyoacán, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (144,'suc144','Plaza Cantil-Coyoacán, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (145,'suc145','Querétaro-Plaza El Sol, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (146,'suc146','Tepic-Avenida México, NAY',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (147,'suc147','Mérida-Chuburná, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (148,'suc148','Av. Cuauhtémoc, Chalco, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (149,'suc149','León-Plaza Hidalgo, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (150,'suc150','Torreón-Central de Abastos, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (151,'suc151','Maravillas-Cd. Neza, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (191,'suc191','La Piedad-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (192,'suc192','Zitácuaro-Revolución Sur, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (152,'suc152','Boca del Río-Ejército Mexicano, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (170,'suc170','Rojo Gómez Agricola Oriental-Iztacalco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (157,'suc157','Villa Nicolás Romero, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (160,'suc160','Plaza las Flores- Coacalco, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (153,'suc153','Valle Dorado-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (188,'suc188','Plaza Toltecas-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (184,'suc184','Ermita Barrio San Miguel-Iztapalapa, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (200,'suc200','San Cristobal-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (210,'suc210','Be Grand Rio Magdalena, Álvaro Obregón, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (194,'suc194','Temoaya-Cuautitlán Izcalli, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (156,'suc156','Avenida 8-Venustiano Carranza, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (164,'suc164','Xalapa-Manuel Ávila Camacho, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (169,'suc169','Boca del Río-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (206,'suc206','Santa Catarina-Plaza La Puerta, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (209,'suc209','Tonalá-Lomas de Tonalá, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (205,'suc205','Mérida-Macroplaza, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (161,'suc161','Guadalupe-Plaza Molinete, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (203,'suc203','Tlajomulco-Multiplaza del Valle, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (159,'suc159','Tierra Blanca-Juárez, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (162,'suc162','Tehuacán-Independencia Poniente, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (163,'suc163','Morelia-Plazuela Carrillo, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (166,'suc166','Papantla-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (167,'suc167','San Juan Bautista Tuxtepec-5 de Mayo, OAX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (173,'suc173','Metro Muzquiz-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (179,'suc179','Poza Rica-Boulevard, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (180,'suc180','Acapulco-Plaza Sendero, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (168,'suc168','Los Reyes-La Paz, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (182,'suc182','Lago de Guadalupe-Atizapán, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (154,'suc154','Cozumel-Centro, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (155,'suc155','Irapuato-Las Reynas, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (158,'suc158','Minatitlán-Parquecito Hidalgo, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (165,'suc165','Tecomán-Baldino Dávalos, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (174,'suc174','Comitán-Belisario Domínguez, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (175,'suc175','Salamanca-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (176,'suc176','Zapopan-Mariano Otero, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (177,'suc177','Cd. Juárez-Plaza San Carlos, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (183,'suc183','Colima-Francisco I. Madero, COL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (186,'suc186','Tulyehualco-Tláhuac, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (178,'suc178','Coatepec-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (185,'suc185','Zihuatanejo-Los Mangos Centro, GRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (189,'suc189','Acayucan-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (195,'suc195','Durango-Centro Comercial Paseo Durango, DGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (196,'suc196','Cuernavaca-Plan de Ayala, MOR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (197,'suc197','Salina Cruz-Centro, OAX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (198,'suc198','Zapopan-Patria, JAL.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (201,'suc201','San Andrés Tuxtla-Centro, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (202,'suc202','Aguascalientes-Petróleos, AGS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (204,'suc204','Valladolid-Plaza Bella Valladolid, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (211,'suc211','Multiplaza Arenera-Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (193,'suc193','Monclova-Centro, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (199,'suc199','Zacapu, Mich.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (208,'suc208','Ciudad Valles-Centro, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (212,'suc212','Veracruz- Parque Zamora, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (181,'suc181','Lázaro Cárdenas-Centro, MICH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (207,'suc207','Plaza Dorada, Ciudad Juarez, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (214,'suc214','Las Aguilas-Cd. Neza, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (217,'suc217','Tonalá-Río Nilo, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (218,'suc218','San José de los Cedros-Cuajimalpa, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (213,'suc213','Jamaica-Venustiano Carranza, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (215,'suc215','Fuentes del Valle-Tultitlán, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (216,'suc216','Santa Clara-Ecatepec, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (224,'suc224','Benito Juárez-Sun Mall Vip, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (222,'suc222','San Luis Potosí-Muñoz, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (226,'suc226','Urbiplaza-Tlalpan, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (219,'suc219','Mérida-Francisco de Montejo, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (227,'suc227','Insurgentes Roma Sur-Cuauhtémoc, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (228,'suc228','Federico Gómez-Zumpango, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (236,'suc236','Gustavo Baz-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (240,'suc240','Guadalupe-Eloy Cavazos, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (233,'suc233','León-Mariano Escobedo, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (232,'suc232','Querétaro-Pie de la Cuesta, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (245,'suc245','Veracruz-Díaz Mirón, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (220,'suc220','Cd. Guzmán-Centro, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (225,'suc225','Mérida-Santa Rosa, YUC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (230,'suc230','Puebla-Capu, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (243,'suc243','Guadalajara-Presa Laurel, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (229,'suc229','Puebla-Blvd. Valsequillo, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (252,'suc252','San Felipe-Gustavo A. Madero, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (251,'suc251','Tuxtla Gutiérrez-Plaza del Sol, CHIS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (247,'suc247','Picacho, Ajusco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (250,'suc250','Tulancingo-Centro, HGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (501,'suc501','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (502,'suc502','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (235,'suc235','Pachuca-Centro, HGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (253,'suc253','Carretera Federal-Tecámac, MEX',23);
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
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (282,'suc282','Culiacán-Sanalona-Guadalupe Victoria, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (513,'suc513','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (514,'suc514','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (515,'suc515','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (516,'suc516','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (517,'suc517','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (518,'suc518','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (519,'suc519','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (520,'suc520','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (237,'suc237','Guanajuato-Centro, GTO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (254,'suc254','San Martín Texmelucan-Libertad Sur Zona Centro, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (256,'suc256','Tenayuca-Tlalnepantla, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (257,'suc257','Plaza Urban Center, Rioja',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (258,'suc258','Vasco de Quiroga-Santa Fe, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (260,'suc260','Apodaca-Plaza Morelos, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (261,'suc261','Solidaridad-Playa del Carmen, QR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (263,'suc263','Guadalajara-Lomas de Polanco, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (264,'suc264','Tijuana-Centro, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (265,'suc265','Atlixco-Independencia, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (266,'suc266','Héroes de Tecamac, MEX.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (283,'suc283','Tijuana-Mariano Matamoros Ruta Independencia, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (223,'suc223','Chihuahua-Plaza Dostoievsky, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (239,'suc239','Puebla-Reforma Centro, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (249,'suc249','Insurgentes San Ángel-Alvaro Obregón, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (259,'suc259','Piedras Negras-San Vicente Chicoloapan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (267,'suc267','Ensenada-Centro, BCN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (268,'suc268','Juan Diego-Valle de Chalco Solidaridad, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (269,'suc269','San Luis Potosí-Himno Nacional, SLP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (271,'suc271','Plaza Atizapán-Atizapán, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (272,'suc272','Querétaro-Plaza Candiles, QRO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (273,'suc273','Plaza Vista Norte, G.A.M-CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (274,'suc274','Chihuahua-Fuentes Mares, CHIH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (275,'suc275','Plaza Arboledas, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (262,'suc262','Moroleón-Centro, GTO',23);
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
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (286,'suc286','Chimalhuacán-Del Peñón, MEX',23);
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
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (290,'suc290','Satélite-Arquitectos, Naucalpan, MEX',23);
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
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (292,'suc292','Gran Sur-Coyoacán, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (293,'suc293','Doctores-Hospital General, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (563,'suc563','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (562,'suc562','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (561,'suc561','Real de 14',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (270,'suc270','San Nicolás de los Garza-Av. Universidad, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (276,'suc276','Paseo Reynosa, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (277,'suc277','Matamoros-Plaza HEB, TAMPS',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (279,'suc279','Saltillo-Venustiano Carranza, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (281,'suc281','Iztapalapa-Santa Cruz Meyehualco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (278,'suc278','San Jerónimo Lídice, Álvaro Obregón CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (287,'suc287','Torreón-Triana, COAH',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (294,'suc294','Puebla-Las Ánimas, PUE.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (295,'suc295','Obregón-Central Camionera, SON',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (296,'suc296','Campeche-Álvaro Obregón, CAMP',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (297,'suc297','Xalapa-Atenas Veracruzana, VER',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (298,'suc298','Guadalajara-Independencia Norte, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (299,'suc299','Puebla-Plaza Loreto, PUE',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (300,'suc300','Hermosillo-Plaza Sendero, SON',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (301,'suc301','Apodaca-Plaza Sendero La Concordia, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (302,'suc302','San Pedro Garza García-Bazar San Agustín, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (303,'suc303','Pachuca-Nuevo Hidalgo, HGO',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (304,'suc304','Lindavista-Montevideo, GAM. CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (305,'suc305','Félix Cuevas-Benito Juárez, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (306,'suc306','Mazatlán-Juárez Av. de las Américas, SIN',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (307,'suc307','El Molinito-Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (308,'suc308','Tesistán-Zapopan, JAL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (310,'suc310','Las Armas-Azcapotzalco, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (309,'suc309','Villahermosa-Av. Constitución, TAB',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1001,'suc1001','Concentradora',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (311,'suc311','Toluca-Alfredo del Mazo, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (312,'suc312','Insurgentes Sur Fuentes Brotantes-Tlalpan, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (313,'suc313','Torres de Satélite La Abeja-Naucalpan, MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1002,'suc1002','WTC',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (314,'suc314','Monterrey-Solidaridad, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (315,'suc315','Tlalpan-Metro Xola, Benito Juárez, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (316,'suc316','Centro Comercial Santa Fe-Cuajimalpa, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (900,'suc900','Avenida Paseo de la Reforma No',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (318,'suc318','Popocatépetl-Benito Juarez, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (320,'suc320','Apizaco-Centro, TLAX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1005,'suc1005','Venta en línea',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (319,'suc319','Mercado de Sonora, Venustiano Carranza, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (317,'suc317','Metro Tacuba, Miguel Hidalgo, CDMX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1008,'suc1008','Compra Cumplido',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1003,'suc1003','Outlet',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1004,'suc1004','Joyería externa',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1006,'suc1006','Centro de distribución',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1007,'suc1007','Autos sin resguardo',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (321,'suc321','Cumbres Elite Monterrey, NL',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (322,'suc322','Jiutepec, Cuernavaca, MOR',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (323,'suc323','Pino Suarez, Metepec - MEX',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1009,'suc1009','Servicio a Clientes',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1010,'suc1010','Crédito',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (324,'suc324','Garza Sada - Monterrey, N.L.',23);
INSERT INTO cat_sucursal(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (700,'suc700','Tienda Monte Corporativo-CDMX',23);
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
