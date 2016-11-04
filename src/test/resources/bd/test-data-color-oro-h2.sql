--
-- Datos de prueba para catálogo Color Oro.
--

INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, descripcion) VALUES (3, 'Alhajas', 'ColorOro', 'Catálogo de Color Oro');

INSERT INTO CAT_COLOR_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('BL', 'Blanco', 3);
INSERT INTO CAT_COLOR_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('MO', 'Morado', 3);