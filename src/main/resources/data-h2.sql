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

INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, valor_default, descripcion) VALUES (1,'Diamantes','CondicionPrenda','BN','Catálogo de Condiciones de la Prenda');
INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, valor_default, descripcion) VALUES (2,'Diamantes','CondicionPrenda','PSU','Catálogo Motivos de Baja de Prestamo');
INSERT INTO CAT_CONDICION_PRENDA(abreviatura, etiqueta, id_configuracion) VALUES ('BN','Buen Estado', 1);
INSERT INTO CAT_CONDICION_PRENDA(abreviatura, etiqueta, id_configuracion) VALUES ('RE','Regular', 1);
INSERT INTO CAT_CONDICION_PRENDA(abreviatura, etiqueta, id_configuracion) VALUES ('MA','Maltratada', 1);
INSERT INTO CAT_MOTIVO_BAJA_PRESTAMO(abreviatura, etiqueta, id_configuracion) VALUES ('PSU','Prenda Sucia', 2);

INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, descripcion) VALUES (5, 'Diamantes', 'TipoPiedraComplementaria', 'Catálogo piedra complementaria');
INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, descripcion) VALUES (6, 'Diamantes', 'CertificadoDiamantes', 'Catálogo de certificados');
INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, descripcion) VALUES (7, 'Diamantes', 'ClaridadDiamante', 'Catálogo de Claridades');


INSERT INTO CAT_TIPO_PIEDRA_COMPLEMENTARIA (abreviatura, etiqueta, id_configuracion) VALUES ('RB','Ruby', 5);
INSERT INTO CAT_TIPO_PIEDRA_COMPLEMENTARIA (abreviatura, etiqueta, id_configuracion) VALUES ('ES','Esmeralda', 5);
INSERT INTO CAT_TIPO_PIEDRA_COMPLEMENTARIA (abreviatura, etiqueta, id_configuracion) VALUES ('ZF','Zafiro', 5);
UPDATE CNF_CONFIGURACION_CATALOGO SET valor_default = 'RB' WHERE id = 5;


INSERT INTO CAT_CERTIFICADO_DIAMANTES (abreviatura, etiqueta, id_configuracion) VALUES ('MK','MK desc', 6);
INSERT INTO CAT_CERTIFICADO_DIAMANTES (abreviatura, etiqueta, id_configuracion) VALUES ('EGL','EGL desc', 6);
INSERT INTO CAT_CERTIFICADO_DIAMANTES (abreviatura, etiqueta, id_configuracion) VALUES ('EGEL','EGEL desc', 6);
UPDATE CNF_CONFIGURACION_CATALOGO SET valor_default = 'MK' WHERE id = 6;


INSERT INTO CAT_CLARIDAD_DIAMANTE (abreviatura, etiqueta, id_configuracion) VALUES ('IF','IF desc', 7);
INSERT INTO CAT_CLARIDAD_DIAMANTE (abreviatura, etiqueta, id_configuracion) VALUES ('VVS1','VVS1 desc', 7);
INSERT INTO CAT_CLARIDAD_DIAMANTE (abreviatura, etiqueta, id_configuracion) VALUES ('VVS2','VVS2 desc', 7);
UPDATE CNF_CONFIGURACION_CATALOGO SET valor_default = 'IF' WHERE id = 7;

INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, valor_default, descripcion) VALUES (8,'Alhajas','Metal','PL','Catálogo de Metales');
INSERT INTO CNF_CONFIGURACION_CATALOGO(id, dominio, tipo, valor_default, descripcion) VALUES (9,'Alhajas','Calidad Ley','SL','Catálogo de Calidades Ley');
INSERT INTO CAT_METAL(abreviatura, etiqueta, id_configuracion) VALUES ('PL','Plata', 8);
INSERT INTO CAT_CALIDAD_LEY(abreviatura, etiqueta, id_configuracion) VALUES ('SL','SegundaLey', 9);

