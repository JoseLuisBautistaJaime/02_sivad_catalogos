--
-- Utilizado para poblar la BD (h2) utilizada con el perfil de desarrollo.
--

INSERT INTO catalogo_prueba(abreviatura, descripcion, catalogo) VALUES ('CAT1', 'Catalogo 1', 'DB-h2');
INSERT INTO catalogo_prueba(abreviatura, descripcion, catalogo) VALUES ('CAT2', 'Catalogo 2', 'DB-h2');
INSERT INTO catalogo_prueba(abreviatura, descripcion, catalogo) VALUES ('CAT3', 'Catalogo 3', 'DB-h2');

INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, descripcion) VALUES (3, 'Alhajas', 'ColorOro', 'Catálogo de Color Oro');
INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, descripcion) VALUES (4, 'Alhajas', 'QuilatajeOro', 'Catálogo de Quilataje Oro');

INSERT INTO CAT_COLOR_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('AM', 'Amarillo', 3);
INSERT INTO CAT_COLOR_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('BL', 'Blanco', 3);
UPDATE CNF_CONFIGURACION_CATALOGO SET valor_default = 'AM' WHERE id = 3;

INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('8_Q', '8', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('10_Q', '10', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('12_Q', '12', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('14_Q', '14', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('16_Q', '16', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('18_Q', '18', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('22_Q', '22', 4);
INSERT INTO CAT_QUILATAJE_ORO(abreviatura, etiqueta, id_configuracion) VALUES ('24_Q', '24', 4);
UPDATE CNF_CONFIGURACION_CATALOGO SET valor_default = '14_Q' WHERE id = 4;

INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, valor_default, descripcion) VALUES (1,'Alhajas','diamantes','1','diamantes');
INSERT INTO CAT_CONDICION_PRENDA(abreviatura, etiqueta, id_configuracion) VALUES ('BN','Buen Estado', 1);
INSERT INTO CAT_CONDICION_PRENDA(abreviatura, etiqueta, id_configuracion) VALUES ('RE','Regular', 1);
INSERT INTO CAT_CONDICION_PRENDA(abreviatura, etiqueta, id_configuracion) VALUES ('MA','Maltratada', 1);
INSERT INTO CAT_MOTIVO_BAJA_PRESTAMO(abreviatura, etiqueta, id_configuracion) VALUES ('BAJ1','Motivo-Baja-1', 1);
