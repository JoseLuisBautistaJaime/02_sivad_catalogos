INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (20,'Perfiles','Perfil','Catálogo de perfiles',today());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (21,'Ramos','Ramo','Catálogo de ramos',today());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (22,'Subramos','Subramo','Catálogo de subramos',today());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (23,'Sucursales','Sucursal','Catálogo de sucursales',today());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (24,'Contratos','TipoContrato','Catálogo de tipo de contratos',today());
INSERT INTO cnf_configuracion_catalogo (ID,DOMINIO, TIPO, DESCRIPCION, ULTIMA_ACTUALIZACION) VALUES (25,'Operaciones','OperacionesCaja','Catálogo de las operaciones de caja',today());
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, descripcion) VALUES (4,'Alhajas','QuilatajeOro','Catálogo de Quilataje Oro');
INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (2,'Alhajas','Metal','AU','Catálogo de Metales');


-- Catálogo de Perfiles
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (2,'V' ,'Valuador',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'A' ,'Amarrador',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (4,'AD' ,'Auxiliar de deposito',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (80,'CRD' ,'Corredor',20);
INSERT INTO cat_perfil(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (81,'MCO' ,'Mesa de Control Operativo',20);
-- Catálogo de Ramos
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1,'AL','Alhajas',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (2,'VE','Vehículos',21);
INSERT INTO cat_ramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (7,'SR','Sin Resguardo',21);
-- Catálogo de Subramos
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1,'RJ','Relojes',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (2,'AL','Alhajas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'MN','Monedas',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (4,'DI','Diamantes',22);
INSERT INTO cat_subramo(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (5,'AU','Automoviles',22);
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
-- Catálogo de Tipo de contratos
INSERT INTO cat_tipo_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (146,'PL','PAGOS LIBRES',24);
INSERT INTO cat_tipo_contrato(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (145,'CL','CLASICO',24);
-- Catálogo de Operación de Caja
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (1,'PP','Pagar Prestamo',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (3,'VB','Venta con Billete',25);
INSERT INTO cat_operacion_caja(id_elemento,abreviatura,etiqueta,id_configuracion) VALUES (198,'RFE','Cobro Refrendo Extemporaneo',25);

--
-- INICIA - DATOS CATÁLOGO:'METALES'
--
INSERT INTO cat_metal(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1,'AU','Oro', 2);
INSERT INTO cat_metal(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2,'PT','Platino', 2);
INSERT INTO cat_metal(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3,'AG','Plata', 2);
INSERT INTO cat_metal(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4,'PD','Plata-Paladio', 2);

--
-- INICIA - DATOS CATÁLOGO:'QUILATAJE ORO'
--
INSERT INTO cat_quilataje_oro(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1,'8_Q','8', 4);
INSERT INTO cat_quilataje_oro(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2,'10_Q','10', 4);
INSERT INTO cat_quilataje_oro(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3,'12_Q','12', 4);
INSERT INTO cat_quilataje_oro(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (4,'14_Q','14', 4);
INSERT INTO cat_quilataje_oro(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (5,'16_Q','16', 4);
INSERT INTO cat_quilataje_oro(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (6,'18_Q','18', 4);
INSERT INTO cat_quilataje_oro(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (7,'22_Q','22', 4);
INSERT INTO cat_quilataje_oro(elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (8,'24_Q','24', 4);

-- relacion entre ramo y subramo
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (1,1);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (1,2);
INSERT INTO cat_ramo_subramo(elemento_padre,elemento_hijo) VALUES (1,3);

