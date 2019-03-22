--
-- Utilizado para crear la BD (mysql) para perfiles cloud.
--

DROP TABLE IF EXISTS journal_entity_event;
CREATE TABLE journal_entity_event
(
    id BIGINT NOT NULL,
    class VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS journal_custom_event;
CREATE TABLE journal_custom_event
(
    id BIGINT NOT NULL,
    comment VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS journal_event_data;
CREATE TABLE journal_event_data
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    event BIGINT NOT NULL,
    property VARCHAR(255) NOT NULL,
    value VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS journal_event;
CREATE TABLE journal_event
(
    id BIGINT AUTO_INCREMENT NOT NULL,
    principal VARCHAR(50) NOT NULL,
    date TIMESTAMP,
    type VARCHAR(255),
    PRIMARY KEY (id)
);

ALTER TABLE journal_entity_event ADD FOREIGN KEY (id) REFERENCES journal_event (id);
ALTER TABLE journal_custom_event ADD FOREIGN KEY (id) REFERENCES journal_event (id);
ALTER TABLE journal_event_data ADD FOREIGN KEY (event) REFERENCES journal_event (id);

--
-- CREACION TABLAS PARA CATALOGO TIPO PRENDA
--
DROP TABLE IF EXISTS cat_diamante_tipo_prenda;
CREATE TABLE cat_diamante_tipo_prenda(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- FIN CREACION TABLAS PARA CATALOGO TIPO PRENDA
--


--
-- CREACION TABLA "CAT_COLOR_ORO"
--
DROP TABLE IF EXISTS cat_color_oro;
CREATE TABLE cat_color_oro
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLA "CAT_QUILATAJE_ORO"
--
DROP TABLE IF EXISTS cat_quilataje_oro;
CREATE TABLE cat_quilataje_oro
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLA "CAT_CONDICION_PRENDA"
--
DROP TABLE IF EXISTS cat_condicion_prenda;
CREATE TABLE cat_condicion_prenda
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLA "CAT_MOTIVO_BAJA_PRESTAMO"
--
DROP TABLE IF EXISTS cat_motivo_baja_prestamo;
CREATE TABLE cat_motivo_baja_prestamo
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);


--
-- CREACION TABLA "CAT_METAL"
--
DROP TABLE IF EXISTS cat_metal;
CREATE TABLE cat_metal
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLA "CAT_CALIDAD_LEY"
--
DROP TABLE IF EXISTS cat_calidad_ley;
CREATE TABLE cat_calidad_ley
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLA "CAT_TIPO_PIEDRA_COMPLEMENTARIA"
--
DROP TABLE IF EXISTS cat_tipo_piedra_complementaria;
CREATE TABLE cat_tipo_piedra_complementaria
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20),
    etiqueta VARCHAR(150),
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLA "CAT_CERTIFICADO_DIAMANTES"
--
DROP TABLE IF EXISTS cat_certificado_diamantes;
CREATE TABLE cat_certificado_diamantes
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20),
    etiqueta VARCHAR(150),
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLA "CAT_CLARIDAD_DIAMANTE"
--
DROP TABLE IF EXISTS cat_claridad_diamante;
CREATE TABLE cat_claridad_diamante
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLA "CAT_RANGO_ORO"
--
DROP TABLE IF EXISTS cat_rango_oro;
CREATE TABLE cat_rango_oro
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLA "CAT_RANGO_METAL"
--
DROP TABLE IF EXISTS cat_rango_metal;
CREATE TABLE cat_rango_metal
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLA "CAT_SUB_CORTE"
--
DROP TABLE IF EXISTS cat_sub_corte;
CREATE TABLE cat_sub_corte
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
	corte BIGINT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLA "CAT_CORTE"
--
DROP TABLE IF EXISTS cat_corte;
CREATE TABLE cat_corte
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLAS PARA CATALOGOS DE COLOR Y FAMILIAS COLORES
--

DROP TABLE IF EXISTS cat_diamante_grado_color_color;
CREATE TABLE cat_diamante_grado_color_color(
    elemento_padre BIGINT NOT NULL,
    elemento_hijo BIGINT NOT NULL,
    PRIMARY KEY (elemento_padre, elemento_hijo)
);

DROP TABLE IF EXISTS cat_diamante_grado_color;
CREATE TABLE cat_diamante_grado_color(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);


DROP TABLE IF EXISTS cat_diamante_color_escala_color;
CREATE TABLE cat_diamante_color_escala_color(
    elemento_padre BIGINT NOT NULL,
    elemento_hijo BIGINT NOT NULL,
    PRIMARY KEY (elemento_padre, elemento_hijo)
);

DROP TABLE IF EXISTS cat_diamante_color;
CREATE TABLE cat_diamante_color(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

DROP TABLE IF EXISTS cat_diamante_escala_color_grupo_color;
CREATE TABLE cat_diamante_escala_color_grupo_color(
    elemento_padre BIGINT NOT NULL,
    elemento_hijo BIGINT NOT NULL,
    PRIMARY KEY (elemento_padre, elemento_hijo)
);

DROP TABLE IF EXISTS cat_diamante_escala_color;
CREATE TABLE cat_diamante_escala_color(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

DROP TABLE IF EXISTS cat_diamante_grupo_color;
CREATE TABLE cat_diamante_grupo_color(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

--
-- CREACION TABLAS PARA CATALOGOS DE COLOR Y FAMILIAS COLORES
--

--
-- CREACION TABLA "CAT_QUILATAJE_DIAMANTE"
--
DROP TABLE IF EXISTS cat_quilataje_diamante;
CREATE TABLE cat_quilataje_diamante
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

DROP TABLE IF EXISTS cnf_configuracion_catalogo;
CREATE TABLE cnf_configuracion_catalogo(
    id BIGINT AUTO_INCREMENT NOT NULL,
    dominio VARCHAR(12) NOT NULL,
    tipo VARCHAR(25) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    ultima_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    valor_default VARCHAR(20),
    PRIMARY KEY (id)
);

ALTER TABLE cnf_configuracion_catalogo ADD CONSTRAINT uk_cnf_configuracion_catalogo_valor_default
UNIQUE(valor_default);
ALTER TABLE cat_diamante_tipo_prenda ADD CONSTRAINT uk_cat_diamante_tipo_prenda_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_diamante_tipo_prenda ADD CONSTRAINT fk_cat_diamante_tipo_prenda_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_diamante_tipo_prenda_elemento_id ON cat_diamante_tipo_prenda(elemento_id);
CREATE INDEX cat_diamante_tipo_prenda_abreviatura ON cat_diamante_tipo_prenda(abreviatura);

CREATE INDEX configuracion_catalogo_id ON cnf_configuracion_catalogo(id);
CREATE INDEX configuracion_catalogo_dominio ON cnf_configuracion_catalogo(dominio);
CREATE INDEX configuracion_catalogo_tipo ON cnf_configuracion_catalogo(tipo);

ALTER TABLE cat_color_oro ADD CONSTRAINT uk_cat_color_oro_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_color_oro ADD CONSTRAINT fk_cat_color_oro_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_color_oro_elemento_id ON cat_color_oro(elemento_id);
CREATE INDEX cat_color_oro_abreviatura ON cat_color_oro(abreviatura);

ALTER TABLE cat_quilataje_oro ADD CONSTRAINT uk_cat_quilataje_oro_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_quilataje_oro ADD CONSTRAINT fk_cat_quilataje_oro_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_quilataje_oro_elemento_id ON cat_quilataje_oro(elemento_id);
CREATE INDEX cat_quilataje_oro_abreviatura ON cat_quilataje_oro(abreviatura);

ALTER TABLE cat_condicion_prenda ADD CONSTRAINT uk_cat_condicion_prenda_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_condicion_prenda ADD CONSTRAINT fk_cat_condicion_prenda_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_condicion_prenda_elemento_id ON cat_condicion_prenda(elemento_id);
CREATE INDEX cat_condicion_prenda_abreviatura ON cat_condicion_prenda(abreviatura);

ALTER TABLE cat_motivo_baja_prestamo ADD CONSTRAINT uk_cat_motivo_baja_prestamo_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_motivo_baja_prestamo ADD CONSTRAINT fk_cat_motivo_baja_prestamo_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_motivo_baja_prestamo_elemento_id ON cat_motivo_baja_prestamo(elemento_id);
CREATE INDEX cat_motivo_baja_prestamo_abreviatura ON cat_motivo_baja_prestamo(abreviatura);

ALTER TABLE cat_metal ADD CONSTRAINT uk_cat_metal_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_metal ADD CONSTRAINT fk_cat_metal_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_metal_elemento_id ON cat_metal(elemento_id);
CREATE INDEX cat_metal_abreviatura ON cat_metal(abreviatura);

ALTER TABLE cat_calidad_ley ADD CONSTRAINT uk_cat_calidad_ley_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_calidad_ley ADD CONSTRAINT fk_cat_calidad_ley_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_calidad_ley_elemento_id ON cat_calidad_ley(elemento_id);
CREATE INDEX cat_calidad_ley_abreviatura ON cat_calidad_ley(abreviatura);

ALTER TABLE cat_tipo_piedra_complementaria ADD FOREIGN KEY (id_configuracion) REFERENCES cnf_configuracion_catalogo (id);

ALTER TABLE cat_tipo_piedra_complementaria ADD CONSTRAINT uk_cat_tipo_piedra_complementaria_abreviatura
UNIQUE(abreviatura);

CREATE INDEX cat_tipo_piedra_complementaria_elemento_id ON cat_tipo_piedra_complementaria(elemento_id);
CREATE INDEX cat_tipo_piedra_complementaria_abreviatura ON cat_tipo_piedra_complementaria(abreviatura);

ALTER TABLE cat_certificado_diamantes ADD FOREIGN KEY (id_configuracion) REFERENCES cnf_configuracion_catalogo (id);

ALTER TABLE cat_certificado_diamantes ADD CONSTRAINT uk_cat_certificado_diamantes_abreviatura
UNIQUE(abreviatura);

CREATE INDEX cat_certificado_diamantes_elemento_id ON cat_certificado_diamantes(elemento_id);
CREATE INDEX cat_certificado_diamantes_abreviatura ON cat_certificado_diamantes(abreviatura);

ALTER TABLE cat_claridad_diamante ADD FOREIGN KEY  (id_configuracion) REFERENCES cnf_configuracion_catalogo (id);

ALTER TABLE cat_claridad_diamante ADD CONSTRAINT uk_cat_claridad_diamante_abreviatura
UNIQUE(abreviatura);

CREATE INDEX cat_claridad_diamante_elemento_id ON cat_claridad_diamante(elemento_id);
CREATE INDEX cat_claridad_diamante_abreviatura ON cat_claridad_diamante(abreviatura);

ALTER TABLE cat_rango_oro ADD CONSTRAINT uk_cat_rango_oro_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_rango_oro ADD CONSTRAINT fk_cat_rango_oro_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_rango_oro_elemento_id ON cat_rango_oro(elemento_id);
CREATE INDEX cat_rango_oro_abreviatura ON cat_rango_oro(abreviatura);

ALTER TABLE cat_rango_metal ADD CONSTRAINT uk_cat_rango_metal_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_rango_metal ADD CONSTRAINT fk_cat_rango_metal_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_rango_metal_elemento_id ON cat_rango_metal(elemento_id);
CREATE INDEX cat_rango_metal_abreviatura ON cat_rango_metal(abreviatura);

ALTER TABLE cat_corte ADD CONSTRAINT uk_cat_corte_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_corte ADD CONSTRAINT fk_cat_corte_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_corte_elemento_id ON cat_corte(elemento_id);
CREATE INDEX cat_corte_abreviatura ON cat_corte(abreviatura);

ALTER TABLE cat_sub_corte ADD CONSTRAINT uk_cat_sub_corte_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_sub_corte ADD CONSTRAINT fk_cat_sub_corte_id_corte
FOREIGN KEY(corte) REFERENCES cat_corte(elemento_id);

CREATE INDEX cat_sub_corte_elemento_id ON cat_sub_corte(elemento_id);
CREATE INDEX cat_sub_corte_abreviatura ON cat_sub_corte(abreviatura);

ALTER TABLE cat_diamante_grupo_color ADD CONSTRAINT uk_cat_cat_diamante_grupo_color_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_diamante_grado_color ADD CONSTRAINT fk_cat_diamante_grado_color_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

ALTER TABLE cat_diamante_grado_color_color ADD CONSTRAINT fk_cat_diamante_grado_color_color_elemento_padre
FOREIGN KEY(elemento_padre) REFERENCES cat_diamante_grado_color(elemento_id);
ALTER TABLE cat_diamante_grado_color_color ADD CONSTRAINT fk_cat_diamante_grado_color_color_elemento_hijo
FOREIGN KEY(elemento_hijo) REFERENCES cat_diamante_color(elemento_id);

ALTER TABLE cat_diamante_color ADD CONSTRAINT fk_cat_diamante_color_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

ALTER TABLE cat_diamante_color_escala_color ADD CONSTRAINT fk_cat_diamante_color_escala_color_elemento_padre
FOREIGN KEY(elemento_padre) REFERENCES cat_diamante_color(elemento_id);
ALTER TABLE cat_diamante_color_escala_color ADD CONSTRAINT fk_cat_diamante_color_escala_color_elemento_hijo
FOREIGN KEY(elemento_hijo) REFERENCES cat_diamante_escala_color(elemento_id);

ALTER TABLE cat_diamante_escala_color ADD CONSTRAINT fk_cat_diamante_escala_color_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

ALTER TABLE cat_diamante_escala_color_grupo_color ADD CONSTRAINT fk_cat_diamante_escala_color_grupo_color_elemento_padre
FOREIGN KEY(elemento_padre) REFERENCES cat_diamante_escala_color(elemento_id);
ALTER TABLE cat_diamante_escala_color_grupo_color ADD CONSTRAINT fk_cat_diamante_escala_color_grupo_color_elemento_hijo
FOREIGN KEY(elemento_hijo) REFERENCES cat_diamante_grupo_color(elemento_id);

ALTER TABLE cat_diamante_grupo_color ADD CONSTRAINT fk_cat_diamante_grupo_color_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX idx_cat_diamante_grado_color_elemento_id ON cat_diamante_grado_color(elemento_id);
CREATE INDEX idx_cat_diamante_grado_color_abreviatura ON cat_diamante_grado_color(abreviatura);

CREATE INDEX idx_cat_diamante_color_elemento_id ON cat_diamante_color(elemento_id);
CREATE INDEX idx_cat_diamante_color_abreviatura ON cat_diamante_color(abreviatura);

CREATE INDEX idx_cat_diamante_escala_color_elemento_id ON cat_diamante_escala_color(elemento_id);
CREATE INDEX idx_cat_diamante_escala_color_abreviatura ON cat_diamante_escala_color(abreviatura);

CREATE INDEX idx_cat_diamante_grupo_color_elemento_id ON cat_diamante_grupo_color(elemento_id);
CREATE INDEX idx_cat_diamante_grupo_color_abreviatura ON cat_diamante_grupo_color(abreviatura);

ALTER TABLE cat_diamante_grado_color ADD CONSTRAINT uk_cat_diamante_grado_color_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_diamante_color ADD CONSTRAINT uk_cat_diamante_color_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_diamante_escala_color ADD CONSTRAINT uk_cat_diamante_escala_color_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_quilataje_diamante ADD CONSTRAINT uk_cat_quilataje_diamante_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_quilataje_diamante ADD CONSTRAINT fk_cat_quilataje_diamante_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_quilataje_diamante_elemento_id ON cat_quilataje_diamante(elemento_id);
CREATE INDEX cat_quilataje_diamante_abreviatura ON cat_quilataje_diamante(abreviatura);






---------------------------------------------------------------------------------------------------------------------
------------------------ SIVA DIAMANTES FASE 2 ----------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------


--
-- CREACION TABLA "cat_rango_peso"
--
DROP TABLE IF EXISTS cat_rango_peso;
CREATE TABLE cat_rango_peso
(
    elemento_id BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(150) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (elemento_id)
);

ALTER TABLE cat_rango_peso ADD CONSTRAINT uk_cat_rango_peso_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_rango_peso ADD CONSTRAINT fk_cat_rango_peso_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_rango_peso_elemento_id ON cat_rango_peso(elemento_id);
CREATE INDEX cat_rango_peso_abreviatura ON cat_rango_peso(abreviatura);


--
-- Nueva tabla relacion claridad padre - hijo
--
DROP TABLE IF EXISTS cat_claridad_diamante_claridad;
CREATE TABLE cat_claridad_diamante_claridad(
    elemento_padre BIGINT NOT NULL,
    elemento_hijo BIGINT NOT NULL,
    id_rango BIGINT NOT NULL DEFAULT 1,
    PRIMARY KEY (elemento_padre, elemento_hijo, id_rango)
);


-- Se agrega la configuracion de los rangos

INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (19, 'Diamantes', 'RangoPeso', '0.01_0.29', 'Catalogo Rango Pesos');
INSERT INTO cat_rango_peso (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, '0', 'Default', 19);
INSERT INTO cat_rango_peso (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, '0.01_0.29', '0.01 al 0.29', 19);
INSERT INTO cat_rango_peso (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (3, '0.30_20', '0.30 al 20', 19);



-- Se agrega nuevo campo rango a todas las tablas de colores

ALTER TABLE cat_diamante_color ADD (
    id_rango BIGINT NOT NULL DEFAULT 1
);
ALTER TABLE cat_diamante_escala_color ADD (
	id_rango BIGINT NOT NULL DEFAULT 1
);
ALTER TABLE cat_diamante_grado_color ADD (
	id_rango BIGINT NOT NULL DEFAULT 1
);
ALTER TABLE cat_diamante_grupo_color ADD (
	id_rango BIGINT NOT NULL DEFAULT 1
);
ALTER TABLE cat_diamante_color_escala_color ADD (
    id_rango BIGINT NOT NULL DEFAULT 1
);
ALTER TABLE cat_diamante_grado_color_color ADD (
    id_rango BIGINT NOT NULL DEFAULT 1
);
ALTER TABLE cat_diamante_escala_color_grupo_color ADD (
    id_rango BIGINT NOT NULL DEFAULT 1
);
ALTER TABLE cat_claridad_diamante ADD (
	id_rango BIGINT NOT NULL DEFAULT 1,
	padre TINYINT(1) NOT NULL DEFAULT '0'
);


-- Se agrega llave foranea

ALTER TABLE cat_diamante_color ADD CONSTRAINT FK_cat_diamante_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_rango_peso(elemento_id);

ALTER TABLE cat_diamante_escala_color ADD CONSTRAINT FK_cat_diamante_escala_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_rango_peso(elemento_id);

ALTER TABLE cat_diamante_grado_color ADD CONSTRAINT FK_cat_diamante_grado_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_rango_peso(elemento_id);

ALTER TABLE cat_diamante_grupo_color ADD CONSTRAINT FK_cat_diamante_grupo_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_rango_peso(elemento_id);

ALTER TABLE cat_diamante_color_escala_color ADD CONSTRAINT FK_cat_diamante_color_escala_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_rango_peso(elemento_id);

ALTER TABLE cat_diamante_grado_color_color ADD CONSTRAINT FK_cat_diamante_grado_color_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_rango_peso(elemento_id);

ALTER TABLE cat_diamante_escala_color_grupo_color ADD CONSTRAINT FK_cat_diamante_escala_color_grupo_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_rango_peso(elemento_id);

ALTER TABLE cat_claridad_diamante ADD CONSTRAINT FK_cat_claridad_diamante_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_rango_peso(elemento_id);

ALTER TABLE cat_claridad_diamante_claridad ADD CONSTRAINT FK_cat_claridad_diamante_claridad_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_rango_peso(elemento_id);


-- Se elimina llave unica

ALTER TABLE cat_diamante_color DROP INDEX UK_CAT_DIAMANTE_COLOR_ABREVIATURA;
ALTER TABLE cat_diamante_escala_color DROP INDEX UK_CAT_DIAMANTE_ESCALA_COLOR_ABREVIATURA;
ALTER TABLE cat_diamante_grado_color DROP INDEX UK_CAT_DIAMANTE_GRADO_COLOR_ABREVIATURA;
ALTER TABLE cat_diamante_grupo_color DROP INDEX UK_CAT_CAT_DIAMANTE_GRUPO_COLOR_ABREVIATURA;
ALTER TABLE cat_claridad_diamante DROP INDEX UK_CAT_CLARIDAD_DIAMANTE_ABREVIATURA;


-- Se agrega llave unica (abreviatura y rango)

ALTER TABLE cat_diamante_color ADD CONSTRAINT UK_CAT_DIAMANTE_COLOR_ABR_RANGO
UNIQUE(abreviatura, id_rango);
ALTER TABLE cat_diamante_escala_color ADD CONSTRAINT UK_CAT_DIAMANTE_ESCALA_COLOR_ABR_RANGO
UNIQUE(abreviatura, id_rango);
ALTER TABLE cat_diamante_grado_color ADD CONSTRAINT UK_CAT_DIAMANTE_GRADO_COLOR_ABR_RANGO
UNIQUE(abreviatura, id_rango);
ALTER TABLE cat_diamante_grupo_color ADD CONSTRAINT UK_CAT_DIAMANTE_GRUPO_COLOR_ABR_RANGO
UNIQUE(abreviatura, id_rango);
ALTER TABLE cat_claridad_diamante ADD CONSTRAINT UK_CAT_DIAMANTE_CLARIDAD_ABR_RANGO_PADRE
UNIQUE(abreviatura, id_rango, padre);


---------------------------------------------------------------------------------------------------------------------
------------------------ SISTEMA DE OPERACION PRENDARIA EMERGENTE F1 --------------------------------
---------------------------------------------------------------------------------------------------------------------


DROP TABLE IF EXISTS cat_perfil;
CREATE TABLE cat_perfil
(
    id_elemento BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);


DROP TABLE IF EXISTS cat_ramo;
CREATE TABLE cat_ramo
(
    id_elemento BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);

DROP TABLE IF EXISTS cat_subramo;
CREATE TABLE cat_subramo
(
    id_elemento BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);

DROP TABLE IF EXISTS cat_sucursal;
CREATE TABLE cat_sucursal
(
    id_elemento BIGINT UNSIGNED NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);


DROP TABLE IF EXISTS cat_tipo_contrato;
CREATE TABLE cat_tipo_contrato
(
    id_elemento BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);

DROP TABLE IF EXISTS cat_operacion_caja;
CREATE TABLE cat_operacion_caja
(
    id_elemento BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);

DROP TABLE IF EXISTS cat_contrato;
CREATE TABLE cat_contrato
(
    id_elemento BIGINT AUTO_INCREMENT NOT NULL,
    abreviatura VARCHAR(20) NOT NULL,
    etiqueta VARCHAR(255) NOT NULL,
    id_configuracion BIGINT NOT NULL,
    PRIMARY KEY (id_elemento)
);

DROP TABLE IF EXISTS cat_contrato_tipo_contrato;
CREATE TABLE cat_contrato_tipo_contrato(
    elemento_padre BIGINT NOT NULL,
    elemento_hijo BIGINT NOT NULL,
    PRIMARY KEY (elemento_padre, elemento_hijo)
);


DROP TABLE IF EXISTS cat_ramo_subramo;
CREATE TABLE cat_ramo_subramo(
    elemento_padre BIGINT NOT NULL,
    elemento_hijo BIGINT NOT NULL,
    PRIMARY KEY (elemento_padre, elemento_hijo)
);



ALTER TABLE cat_perfil ADD CONSTRAINT uk_cat_perfil_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_perfil ADD CONSTRAINT fk_cat_perfil_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_perfil_elemento_id ON cat_perfil(id_elemento);
CREATE INDEX cat_perfil_abreviatura ON cat_perfil(abreviatura);

ALTER TABLE cat_ramo ADD CONSTRAINT uk_cat_ramo_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_ramo ADD CONSTRAINT fk_cat_ramo_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_ramo_elemento_id ON cat_ramo(id_elemento);
CREATE INDEX cat_ramo_abreviatura ON cat_ramo(abreviatura);

ALTER TABLE cat_subramo ADD CONSTRAINT uk_cat_subramo_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_subramo ADD CONSTRAINT fk_cat_subramo_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_subramo_elemento_id ON cat_subramo(id_elemento);
CREATE INDEX cat_subramo_abreviatura ON cat_subramo(abreviatura);


ALTER TABLE cat_sucursal ADD CONSTRAINT uk_cat_sucursal_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_sucursal ADD CONSTRAINT fk_cat_sucursal_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_sucursal_elemento_id ON cat_sucursal(id_elemento);
CREATE INDEX cat_sucursal_abreviatura ON cat_sucursal(abreviatura);

ALTER TABLE cat_tipo_contrato ADD CONSTRAINT uk_cat_tipo_contrato_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_tipo_contrato ADD CONSTRAINT fk_cat_tipo_contrato_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_tipo_contrato_elemento_id ON cat_tipo_contrato(id_elemento);
CREATE INDEX cat_tipo_contrato_abreviatura ON cat_tipo_contrato(abreviatura);

ALTER TABLE cat_operacion_caja ADD CONSTRAINT uk_cat_operacion_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_operacion_caja ADD CONSTRAINT fk_cat_operacion_caja_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_operacion_caja_elemento_id ON cat_operacion_caja(id_elemento);
CREATE INDEX cat_operacion_caja_abreviatura ON cat_operacion_caja(abreviatura);

ALTER TABLE cat_contrato ADD CONSTRAINT uk_cat_contrato_abreviatura
UNIQUE(abreviatura);

ALTER TABLE cat_contrato ADD CONSTRAINT fk_cat_contrato_id_configuracion
FOREIGN KEY(id_configuracion) REFERENCES cnf_configuracion_catalogo(id);

CREATE INDEX cat_cat_contrato_elemento_id ON cat_contrato(id_elemento);
CREATE INDEX cat_cat_contrato_abreviatura ON cat_contrato(abreviatura);

ALTER TABLE cat_ramo_subramo ADD CONSTRAINT fk_cat_ramo_subramo_elemento_padre
FOREIGN KEY(elemento_padre) REFERENCES cat_ramo(id_elemento);
ALTER TABLE cat_ramo_subramo ADD CONSTRAINT fk_cat_ramo_subramo_elemento_hijo
FOREIGN KEY(elemento_hijo) REFERENCES cat_subramo(id_elemento);

ALTER TABLE cat_contrato_tipo_contrato ADD CONSTRAINT fk_cat_contrato_tipo_contrato_elemento_padre
FOREIGN KEY(elemento_padre) REFERENCES cat_contrato(id_elemento);
ALTER TABLE cat_contrato_tipo_contrato ADD CONSTRAINT fk_cat_contrato_tipo_contrato_elemento_hijo
FOREIGN KEY(elemento_hijo) REFERENCES cat_tipo_contrato(id_elemento);
