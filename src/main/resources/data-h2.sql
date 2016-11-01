--
-- Utilizado para poblar la BD (h2) utilizada con el perfil de desarrollo.
--

INSERT INTO catalogo_prueba(abreviatura, descripcion, catalogo) VALUES ('CAT1', 'Catalogo 1', 'DB-h2');
INSERT INTO catalogo_prueba(abreviatura, descripcion, catalogo) VALUES ('CAT2', 'Catalogo 2', 'DB-h2');
INSERT INTO catalogo_prueba(abreviatura, descripcion, catalogo) VALUES ('CAT3', 'Catalogo 3', 'DB-h2');

INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, descripcion) VALUES (3, 'Alhajas', 'ColorOro', 'Catálogo de color del oro');
INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, descripcion) VALUES (4, 'Alhajas', 'QuilatajeOro', 'Catálogo de quilatajes del oro');

INSERT INTO CAT_COLOR_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('ORO_AMARILLO', 'Amarillo', 3);
INSERT INTO CAT_COLOR_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('ORO_BLANCO', 'Blanco', 3);
UPDATE CNF_CONFIGURACION_CATALOGO SET valor_default = 'Amarillo' WHERE id = 3;

INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('ORO_8_QUILATES', '8', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('ORO_10_QUILATES', '10', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('ORO_12_QUILATES', '12', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('ORO_14_QUILATES', '14', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('ORO_16_QUILATES', '16', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('ORO_18_QUILATES', '18', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('ORO_22_QUILATES', '22', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('ORO_24_QUILATES', '24', 4);
UPDATE CNF_CONFIGURACION_CATALOGO SET valor_default = '14' WHERE id = 4;