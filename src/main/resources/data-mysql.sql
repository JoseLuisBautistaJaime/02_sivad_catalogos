--
-- Utilizado para poblar la BD (mysql) utilizada con los perfiles cloud.
--


--
-- INICIA - DATOS CONFIGURACI�N CAT�LOGO
--
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (1, 'Alhajas', 'CondicionPrenda', 'EX', 'Cat�logo de Condiciones de la Prenda');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (2, 'Alhajas', 'Metal', 'AU', 'Cat�logo de Metales');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (3, 'Alhajas', 'ColorOro', 'Cat�logo de Color Oro');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (4, 'Alhajas', 'QuilatajeOro', 'Cat�logo de Quilataje Oro');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (5, 'Alhajas', 'CalidadLey', 'Cat�logo de Calidades Ley');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (6, 'Alhajas', 'RangoOro', 'Cat�logo de Rango Oro');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (7, 'Alhajas', 'RangoMetal', 'Cat�logo de Rango Metal');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (8, 'Diamantes', 'MotivoBajaPrestamo', 'MTA', 'Cat�logo de Motivos de Baja de Pr�stamo');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (9, 'Diamantes', 'CertificadoDiamantes', 'Cat�logo de Certificados de Diamante');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (10, 'Diamantes', 'TipoPiedraComplementaria', 'Cat�logo de Tipos de Piedra Complementaria');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (11, 'Diamantes', 'ClaridadDiamante', 'Cat�logo de Claridades de Diamante');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (12, 'Diamantes', 'Corte', 'Cat�logo de Cortes de Diamante');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (13, 'Alhajas', 'TipoPrenda', 'ANILLO', 'Cat�logo que define los tipos de prenda.');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (14, 'Diamantes', 'GradoColor', 'GRADO_COLOR_D', 'Cat�logo que define el grado de color de un diamante.');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (15, 'Diamantes', 'Color', 'Cat�logo que define el color de un diamante.');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (16, 'Diamantes', 'EscalaColor', 'Cat�logo que define la escala de color de un diamante.');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (17, 'Diamantes', 'GrupoColor', 'Cat�logo que define el grupo de color de un diamante.');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (18, 'Diamantes', 'QuilatajeDiamante', '0.25_Q', 'Cat�logo de Quilatajes de Diamante');

--
-- INICIA - DATOS CAT�LOGO: 'CONDICI�N PRENDA'
--
INSERT INTO cat_condicion_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'EX', 'Excelente', 1);
INSERT INTO cat_condicion_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'BN', 'Buen Estado', 1);
INSERT INTO cat_condicion_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'RE', 'Regular', 1);

--
-- INICIA - DATOS CAT�LOGO: 'METALES'
--
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'AU', 'Oro', 2);
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'PT', 'Platino', 2);
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'AG', 'Plata', 2);
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'PD', 'Plata-Paladio', 2);
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'OM', 'Otro Metal', 2);

--
-- INICIA - DATOS CAT�LOGO: 'COLOR ORO'
--
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'AU_AM', 'Amarillo', 3);
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'AU_BL', 'Blanco', 3);

--
-- INICIA - DATOS CAT�LOGO: 'QUILATAJE ORO'
--
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, '8_Q', '8', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, '10_Q', '10', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, '12_Q', '12', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, '14_Q', '14', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, '16_Q', '16', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, '18_Q', '18', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, '21_Q', '21', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, '22_Q', '22', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, '24_Q', '24', 4);

--
-- INICIA - DATOS CAT�LOGO: 'CALIDAD LEY'
--
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'CL_999', '0.999', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'CL_925', '0.925', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'CL_900', '0.900', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'CL_720', '0.720', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'CL_500', '0.500', 5);

--
-- INICIA - DATOS CAT�LOGO: 'RANGO ORO'
--
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'F1', 'Pedacer�a y Piezas Rotas', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'F2', 'Buen Estado Personalizadas', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'F3', 'Buen Estado Sin Personalizar', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'F4', 'Piezas Nuevas', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'F5', 'Marcas Comerciales', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'F6', 'Alta Joyer�a', 6);

--
-- INICIA - DATOS CAT�LOGO: 'RANGO METAL'
--
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'F1', 'Factor 1', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'DE', 'Dise�o y Estado', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'MC', 'Marca', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'MO', 'Monedas con Oro', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'MS', 'Monedas sin Oro', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'RF', 'RJ-Fundir', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, 'RM', 'RJ-Marca', 7);

--
-- INICIA - DATOS CAT�LOGO: 'MOTIVOS DE BAJA DE PR�STAMO'
--
INSERT INTO cat_motivo_baja_prestamo (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'MTA', 'Motivo A', 8);
INSERT INTO cat_motivo_baja_prestamo (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'MTB', 'Motivo B', 8);

--
-- INICIA - DATOS CAT�LOGO: 'CERTIFICADOS DE DIAMANTES'
--
INSERT INTO cat_certificado_diamantes (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'GI', 'GIA', 9);
INSERT INTO cat_certificado_diamantes (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'HR', 'HRD Antwerp', 9);
INSERT INTO cat_certificado_diamantes (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'IG', 'IGE', 9);

--
-- INICIA - DATOS CAT�LOGO: 'TIPOS DE PIEDRA COMPLEMENTARIA'
--
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'CI', 'Circ�n', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'CU', 'Cuarzo', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'ES', 'Esmeralda', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'GR', 'Granate', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'JA', 'Jade', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'LA', 'Lapisl�zuli', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, 'PE', 'Perla', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, 'RU', 'Rub�', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, 'TO', 'Topacio', 10);
INSERT INTO cat_tipo_piedra_complementaria (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (10, 'ZA', 'Zafiro', 10);

--
-- INICIA - DATOS CAT�LOGO: 'CLARIDAD DIAMANTE'
--
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'IF', 'IF', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'VVS1', 'VVS1', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'VVS2', 'VVS2', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'VS1', 'VS1', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'VS2', 'VS2', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'SI1', 'SI1', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, 'SI2', 'SI2', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, 'P1', 'P1', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, 'P2', 'P2', 11);
INSERT INTO cat_claridad_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (10, 'P3', 'P3', 11);

--
-- INICIA - DATOS CAT�LOGO: 'CORTE DIAMANTE'
--
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'BR', 'Brillante', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'PR', 'Princesa', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'OV', 'Oval', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'PE', 'Pera', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'RA', 'Radiant', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'BA', 'Baguette', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, 'FL', 'Flanders', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, 'MA', 'Marquesa', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, 'CO', 'Coraz�n', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (10, 'ES', 'Esmeralda', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (11, 'CJ', 'Cojin', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (12, 'AS', 'Asscher', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (13, 'TR', 'Trillion', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (14, 'AN', 'Antiguo', 12);
INSERT INTO cat_corte (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (15, 'OT', 'Otro', 12);

--
-- INICIA - DATOS CAT�LOGO: 'TIPO PRENDA'
--
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'ANILLO', 'Anillo', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'PULSERA', 'Pulsera', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'BRAZALETE', 'Brazalete', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'COLLAR', 'Collar', 13);
INSERT INTO cat_diamante_tipo_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'JUEGO_DIAMANTES', 'Juego de Diamantes', 13);

--
-- INICIA - DATOS CAT�LOGO: 'GRADO COLOR'
--
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'GRADO_COLOR_D', 'D', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'GRADO_COLOR_E', 'E', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'GRADO_COLOR_F', 'F', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'GRADO_COLOR_G', 'G', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'GRADO_COLOR_H', 'H', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'GRADO_COLOR_I', 'I', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, 'GRADO_COLOR_J', 'J', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, 'GRADO_COLOR_K', 'K', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, 'GRADO_COLOR_L', 'L', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (10, 'GRADO_COLOR_M', 'M', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (11, 'GRADO_COLOR_N', 'N', 14);
INSERT INTO cat_diamante_grado_color (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (12, 'GRADO_COLOR_O_Z', 'O-Z', 14);

--
-- INICIA - DATOS CAT�LOGO: 'COLOR'
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
-- INICIA - DATOS CAT�LOGO: 'ESCALA COLOR'
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
-- INICIA - DATOS CAT�LOGO: 'GRUPO COLOR'
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
-- INICIA - DATOS CAT�LOGO: 'QUILATAJE DIAMANTE'
--
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, '0_25_Q', '0.25', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, '0_5_Q', '0.5', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, '0_75_Q', '0.75', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, '1_0_Q', '1.0', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, '1_5_Q', '1.5', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, '2_0_Q', '2.0', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, '3_0_Q', '3.0', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, '4_0_Q', '4.0', 18);
INSERT INTO cat_quilataje_diamante (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, '5_0_Q', '2.0', 18);