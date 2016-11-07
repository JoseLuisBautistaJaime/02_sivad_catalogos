--
-- Datos de prueba para catálogo Quilataje Diamante.
--

INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, valor_default, descripcion) VALUES (18,'Diamantes','QuilatajeDiamante','0_25_Q','Catálogo de Quilatajes Diamantes');

INSERT INTO CAT_QUILATAJE_DIAMANTE(abreviatura, etiqueta, id_configuracion) VALUES ('0_25_Q','0.25', 18);
INSERT INTO CAT_QUILATAJE_DIAMANTE(abreviatura, etiqueta, id_configuracion) VALUES ('0_5_Q','0.5', 18);
