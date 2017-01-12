--
-- Utilizado para poblar la BD (h2) utilizada con el perfil de desarrollo.
--



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CONFIGURACIÓN CATÁLOGO
------------------------------------------------------------------------------------------------------------------------
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



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'CONDICIÓN PRENDA'
------------------------------------------------------------------------------------------------------------------------
INSERT INTO cat_condicion_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'EX', 'Excelente', 1);
INSERT INTO cat_condicion_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'BN', 'Buen Estado', 1);
INSERT INTO cat_condicion_prenda (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'RE', 'Regular', 1);



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'METALES'
------------------------------------------------------------------------------------------------------------------------
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'AU', 'Oro', 2);
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'PT', 'Platino', 2);
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'AG', 'Plata', 2);
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'PD', 'Plata-Paladio', 2);
INSERT INTO cat_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'OM', 'Otro Metal', 2);



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'COLOR ORO'
------------------------------------------------------------------------------------------------------------------------
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'AU_AM', 'Amarillo', 3);
INSERT INTO cat_color_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'AU_BL', 'Blanco', 3);



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'QUILATAJE ORO'
------------------------------------------------------------------------------------------------------------------------
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, '8_Q', '8', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, '10_Q', '10', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, '12_Q', '12', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, '14_Q', '14', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, '16_Q', '16', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, '18_Q', '18', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, '21_Q', '21', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, '22_Q', '22', 4);
INSERT INTO cat_quilataje_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, '24_Q', '24', 4);



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'CALIDAD LEY'
------------------------------------------------------------------------------------------------------------------------
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'CL_999', '0.999', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'CL_925', '0.925', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'CL_900', '0.900', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'CL_720', '0.720', 5);
INSERT INTO cat_calidad_ley (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'CL_500', '0.500', 5);



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'RANGO ORO'
------------------------------------------------------------------------------------------------------------------------
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'F1', 'Pedacería y Piezas Rotas', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'F2', 'Buen Estado Personalizadas', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'F3', 'Buen Estado Sin Personalizar', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'F4', 'Piezas Nuevas', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'F5', 'Marcas Comerciales', 6);
INSERT INTO cat_rango_oro (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'F6', 'Alta Joyería', 6);



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'RANGO METAL'
------------------------------------------------------------------------------------------------------------------------
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'F1', 'Factor 1', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'DE', 'Diseño y Estado', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'MC', 'Marca', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, 'MO', 'Monedas con Oro', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, 'MS', 'Monedas sin Oro', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, 'RF', 'RJ-Fundir', 7);
INSERT INTO cat_rango_metal (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, 'RM', 'RJ-Marca', 7);



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'MOTIVOS DE BAJA DE PRÉSTAMO'
------------------------------------------------------------------------------------------------------------------------
INSERT INTO cat_motivo_baja_prestamo (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'MTA', 'Motivo A', 8);
INSERT INTO cat_motivo_baja_prestamo (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'MTB', 'Motivo B', 8);



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'CERTIFICADOS DE DIAMANTES'
------------------------------------------------------------------------------------------------------------------------
INSERT INTO cat_certificado_diamantes (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, 'GI', 'GIA', 9);
INSERT INTO cat_certificado_diamantes (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, 'HR', 'HRD Antwerp', 9);
INSERT INTO cat_certificado_diamantes (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, 'IG', 'IGE', 9);



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'TIPOS DE PIEDRA COMPLEMENTARIA'
------------------------------------------------------------------------------------------------------------------------
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



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'CLARIDAD DIAMANTE'
------------------------------------------------------------------------------------------------------------------------
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



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'CORTE DIAMANTE'
------------------------------------------------------------------------------------------------------------------------
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
INSERT INTO cat_sub_corte (elemento_id, corte, abreviatura, etiqueta) VALUES (15, 2, 'OT', 'Otro');



RUNSCRIPT FROM 'classpath:/bd/data-diamante_tipo_prenda-h2.sql';
RUNSCRIPT FROM 'classpath:/bd/data-diamante_grado_color-h2.sql';
RUNSCRIPT FROM 'classpath:/bd/data-diamante_color-h2.sql';
RUNSCRIPT FROM 'classpath:/bd/data-diamante_escala_color-h2.sql';
RUNSCRIPT FROM 'classpath:/bd/data-diamante_grupo_color-h2.sql';



------------------------------------------------------------------------------------------------------------------------
-- INICIA - DATOS CATÁLOGO: 'QUILATAJE DIAMANTE'
------------------------------------------------------------------------------------------------------------------------
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (18, 'Diamantes', 'QuilatajeDiamante', '0.25_Q', 'Catálogo de Quilatajes de Diamante');
INSERT INTO cat_quilataje_diamante(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, '0_25_Q', '0.25', 18);
INSERT INTO cat_quilataje_diamante(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, '0_5_Q', '0.5', 18);
INSERT INTO cat_quilataje_diamante(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, '0_75_Q', '0.75', 18);
INSERT INTO cat_quilataje_diamante(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4, '1_0_Q', '1.0', 18);
INSERT INTO cat_quilataje_diamante(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5, '1_5_Q', '1.5', 18);
INSERT INTO cat_quilataje_diamante(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6, '2_0_Q', '2.0', 18);
INSERT INTO cat_quilataje_diamante(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7, '3_0_Q', '3.0', 18);
INSERT INTO cat_quilataje_diamante(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8, '4_0_Q', '4.0', 18);
INSERT INTO cat_quilataje_diamante(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (9, '5_0_Q', '2.0', 18);


