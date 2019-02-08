--
-- Utilizado para crear la BD (h2) utilizada con el perfil de desarrollo.
--

DROP TABLE IF EXISTS CATALOGO_PRUEBA;
CREATE TABLE CATALOGO_PRUEBA
(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ABREVIATURA VARCHAR(255) NOT NULL,
    DESCRIPCION VARCHAR(255),
    CATALOGO VARCHAR(255)
);


DROP TABLE IF EXISTS JOURNAL_EVENT;
CREATE TABLE JOURNAL_EVENT
(
    ID BIGINT AUTO_INCREMENT NOT NULL,
    PRINCIPAL VARCHAR(50) NOT NULL,
    DATE TIMESTAMP,
    TYPE VARCHAR(255),
    PRIMARY KEY (ID)
);


DROP TABLE IF EXISTS JOURNAL_ENTITY_EVENT;
CREATE TABLE JOURNAL_ENTITY_EVENT
(
    ID BIGINT NOT NULL,
    CLASS VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);
ALTER TABLE JOURNAL_ENTITY_EVENT ADD FOREIGN KEY (ID) REFERENCES JOURNAL_EVENT (ID);


DROP TABLE IF EXISTS JOURNAL_CUSTOM_EVENT;
CREATE TABLE JOURNAL_CUSTOM_EVENT
(
    ID BIGINT NOT NULL,
    COMMENT VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);
ALTER TABLE JOURNAL_CUSTOM_EVENT ADD FOREIGN KEY (ID) REFERENCES JOURNAL_EVENT (ID);


DROP TABLE IF EXISTS JOURNAL_EVENT_DATA;
CREATE TABLE JOURNAL_EVENT_DATA
(
    ID BIGINT AUTO_INCREMENT NOT NULL,
    EVENT BIGINT NOT NULL,
    PROPERTY VARCHAR(255) NOT NULL,
    VALUE VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);
ALTER TABLE JOURNAL_EVENT_DATA ADD FOREIGN KEY (EVENT) REFERENCES JOURNAL_EVENT (ID);


DROP TABLE IF EXISTS CNF_CONFIGURACION_CATALOGO;
CREATE TABLE CNF_CONFIGURACION_CATALOGO(
  ID BIGINT AUTO_INCREMENT NOT NULL,
  DOMINIO VARCHAR(12) NOT NULL,
  TIPO VARCHAR(25) NOT NULL,
  DESCRIPCION VARCHAR(255) NOT NULL,
  ULTIMA_ACTUALIZACION TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
  VALOR_DEFAULT VARCHAR(20)
);
ALTER TABLE CNF_CONFIGURACION_CATALOGO ADD CONSTRAINT PK_CNF_CONFIGURACION_CATALOGO_ID
  PRIMARY KEY(ID);
ALTER TABLE CNF_CONFIGURACION_CATALOGO ADD CONSTRAINT UK_CNF_CONFIGURACION_CATALOGO_VALOR_DEFAULT
  UNIQUE(VALOR_DEFAULT);


--
-- CREACION TABLAS PARA CATALOGO TIPO PRENDA
--
DROP TABLE IF EXISTS CAT_DIAMANTE_TIPO_PRENDA;
CREATE TABLE CAT_DIAMANTE_TIPO_PRENDA(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);
ALTER TABLE CAT_DIAMANTE_TIPO_PRENDA ADD CONSTRAINT PK_CAT_DIAMANTE_TIPO_PRENDA_ELEMENTO_ID
  PRIMARY KEY(ELEMENTO_ID);
ALTER TABLE CAT_DIAMANTE_TIPO_PRENDA ADD CONSTRAINT UK_CAT_DIAMANTE_TIPO_PRENDA_ABREVIATURA
  UNIQUE(ABREVIATURA);


ALTER TABLE CAT_DIAMANTE_TIPO_PRENDA ADD CONSTRAINT FK_CAT_DIAMANTE_TIPO_PRENDA_ID_CONFIGURACION
  FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);

CREATE INDEX CAT_DIAMANTE_TIPO_PRENDA_ELEMENTO_ID ON CAT_DIAMANTE_TIPO_PRENDA(ELEMENTO_ID);
CREATE INDEX CAT_DIAMANTE_TIPO_PRENDA_ABREVIATURA ON CAT_DIAMANTE_TIPO_PRENDA(ABREVIATURA);
--
-- FIN CREACION TABLAS PARA CATALOGO TIPO PRENDA
--


CREATE INDEX CONFIGURACION_CATALOGO_ID ON CNF_CONFIGURACION_CATALOGO(ID);
CREATE INDEX CONFIGURACION_CATALOGO_DOMINIO ON CNF_CONFIGURACION_CATALOGO(DOMINIO);
CREATE INDEX CONFIGURACION_CATALOGO_TIPO ON CNF_CONFIGURACION_CATALOGO(TIPO);



--
-- CREACION TABLA "CAT_COLOR_ORO"
--
DROP TABLE IF EXISTS CAT_COLOR_ORO;
CREATE TABLE CAT_COLOR_ORO
(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);

ALTER TABLE CAT_COLOR_ORO ADD CONSTRAINT PK_CAT_COLOR_ORO_ELEMENTO_ID
  PRIMARY KEY(ELEMENTO_ID);

ALTER TABLE CAT_COLOR_ORO ADD CONSTRAINT UK_CAT_COLOR_ORO_ABREVIATURA
  UNIQUE(ABREVIATURA);

ALTER TABLE CAT_COLOR_ORO ADD CONSTRAINT FK_CAT_COLOR_ORO_ID_CONFIGURACION
  FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);

CREATE INDEX CAT_COLOR_ORO_ELEMENTO_ID ON CAT_COLOR_ORO(ELEMENTO_ID);
CREATE INDEX CAT_COLOR_ORO_ABREVIATURA ON CAT_COLOR_ORO(ABREVIATURA);

--
-- CREACION TABLA "CAT_QUILATAJE_ORO"
--
DROP TABLE IF EXISTS CAT_QUILATAJE_ORO;
CREATE TABLE CAT_QUILATAJE_ORO
(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);

ALTER TABLE CAT_QUILATAJE_ORO ADD CONSTRAINT PK_CAT_QUILATAJE_ORO_ELEMENTO_ID
  PRIMARY KEY(ELEMENTO_ID);

ALTER TABLE CAT_QUILATAJE_ORO ADD CONSTRAINT UK_CAT_QUILATAJE_ORO_ABREVIATURA
  UNIQUE(ABREVIATURA);

ALTER TABLE CAT_QUILATAJE_ORO ADD CONSTRAINT FK_CAT_QUILATAJE_ORO_ID_CONFIGURACION
  FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);

CREATE INDEX CAT_QUILATAJE_ORO_ELEMENTO_ID ON CAT_QUILATAJE_ORO(ELEMENTO_ID);
CREATE INDEX CAT_QUILATAJE_ORO_ABREVIATURA ON CAT_QUILATAJE_ORO(ABREVIATURA);

--
-- CREACION TABLA "CAT_CONDICION_PRENDA"
--
DROP TABLE IF EXISTS CAT_CONDICION_PRENDA;
CREATE TABLE CAT_CONDICION_PRENDA
(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);

ALTER TABLE CAT_CONDICION_PRENDA ADD CONSTRAINT PK_CAT_CONDICION_PRENDA_ELEMENTO_ID
  PRIMARY KEY(ELEMENTO_ID);

ALTER TABLE CAT_CONDICION_PRENDA ADD CONSTRAINT UK_CAT_CONDICION_PRENDA_ABREVIATURA
  UNIQUE(ABREVIATURA);

ALTER TABLE CAT_CONDICION_PRENDA ADD CONSTRAINT FK_CAT_CONDICION_PRENDA_ID_CONFIGURACION
  FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);

CREATE INDEX CAT_CONDICION_PRENDA_ELEMENTO_ID ON CAT_CONDICION_PRENDA(ELEMENTO_ID);
CREATE INDEX CAT_CONDICION_PRENDA_ABREVIATURA ON CAT_CONDICION_PRENDA(ABREVIATURA);


--
-- CREACION TABLA "CAT_MOTIVO_BAJA_PRESTAMO"
--
DROP TABLE IF EXISTS CAT_MOTIVO_BAJA_PRESTAMO;
CREATE TABLE CAT_MOTIVO_BAJA_PRESTAMO
(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);

ALTER TABLE CAT_MOTIVO_BAJA_PRESTAMO ADD CONSTRAINT PK_CAT_MOTIVO_BAJA_PRESTAMO_ELEMENTO_ID
  PRIMARY KEY(ELEMENTO_ID);

ALTER TABLE CAT_MOTIVO_BAJA_PRESTAMO ADD CONSTRAINT UK_CAT_MOTIVO_BAJA_PRESTAMO_ABREVIATURA
  UNIQUE(ABREVIATURA);

ALTER TABLE CAT_MOTIVO_BAJA_PRESTAMO ADD CONSTRAINT FK_CAT_MOTIVO_BAJA_PRESTAMO_ID_CONFIGURACION
  FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);

CREATE INDEX CAT_MOTIVO_BAJA_PRESTAMO_ELEMENTO_ID ON CAT_MOTIVO_BAJA_PRESTAMO(ELEMENTO_ID);
CREATE INDEX CAT_MOTIVO_BAJA_PRESTAMO_ABREVIATURA ON CAT_MOTIVO_BAJA_PRESTAMO(ABREVIATURA);


--
-- CREACION TABLA "CAT_METAL"
--
DROP TABLE IF EXISTS CAT_METAL;
CREATE TABLE CAT_METAL
(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);

ALTER TABLE CAT_METAL ADD CONSTRAINT PK_CAT_METAL_ELEMENTO_ID
  PRIMARY KEY(ELEMENTO_ID);

ALTER TABLE CAT_METAL ADD CONSTRAINT UK_CAT_METAL_ABREVIATURA
  UNIQUE(ABREVIATURA);

ALTER TABLE CAT_METAL ADD CONSTRAINT FK_CAT_METAL_ID_CONFIGURACION
  FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);

CREATE INDEX CAT_METAL_ELEMENTO_ID ON CAT_METAL(ELEMENTO_ID);
CREATE INDEX CAT_METAL_ABREVIATURA ON CAT_METAL(ABREVIATURA);

--
-- CREACION TABLA "CAT_CALIDAD_LEY"
--
DROP TABLE IF EXISTS CAT_CALIDAD_LEY;
CREATE TABLE CAT_CALIDAD_LEY
(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);

ALTER TABLE CAT_CALIDAD_LEY ADD CONSTRAINT PK_CAT_CALIDAD_LEY_ELEMENTO_ID
  PRIMARY KEY(ELEMENTO_ID);

ALTER TABLE CAT_CALIDAD_LEY ADD CONSTRAINT UK_CAT_CALIDAD_LEY_ABREVIATURA
  UNIQUE(ABREVIATURA);

ALTER TABLE CAT_CALIDAD_LEY ADD CONSTRAINT FK_CAT_CALIDAD_LEY_ID_CONFIGURACION
  FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);

CREATE INDEX CAT_CALIDAD_LEY_ELEMENTO_ID ON CAT_CALIDAD_LEY(ELEMENTO_ID);
CREATE INDEX CAT_CALIDAD_LEY_ABREVIATURA ON CAT_CALIDAD_LEY(ABREVIATURA);


--
-- CREACION TABLA "CAT_TIPO_PIEDRA_COMPLEMENTARIA"
--
DROP TABLE IF EXISTS CAT_TIPO_PIEDRA_COMPLEMENTARIA;
CREATE TABLE CAT_TIPO_PIEDRA_COMPLEMENTARIA
(
    ELEMENTO_ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ABREVIATURA VARCHAR(20),
    ETIQUETA VARCHAR(150),
    ID_CONFIGURACION BIGINT NOT NULL
);
ALTER TABLE CAT_TIPO_PIEDRA_COMPLEMENTARIA ADD FOREIGN KEY (ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO (ID);

ALTER TABLE CAT_TIPO_PIEDRA_COMPLEMENTARIA ADD CONSTRAINT UK_CAT_TIPO_PIEDRA_COMPLEMENTARIA_ABREVIATURA
UNIQUE(ABREVIATURA);

CREATE INDEX CAT_TIPO_PIEDRA_COMPLEMENTARIA_ELEMENTO_ID ON CAT_TIPO_PIEDRA_COMPLEMENTARIA(ELEMENTO_ID);
CREATE INDEX CAT_TIPO_PIEDRA_COMPLEMENTARIA_ABREVIATURA ON CAT_TIPO_PIEDRA_COMPLEMENTARIA(ABREVIATURA);

--
-- CREACION TABLA "CAT_CERTIFICADO_DIAMANTES"
--
DROP TABLE IF EXISTS CAT_CERTIFICADO_DIAMANTES;
CREATE TABLE CAT_CERTIFICADO_DIAMANTES
(
    ELEMENTO_ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ABREVIATURA VARCHAR(20),
    ETIQUETA VARCHAR(150),
    ID_CONFIGURACION BIGINT NOT NULL
);
ALTER TABLE CAT_CERTIFICADO_DIAMANTES ADD FOREIGN KEY (ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO (ID);

ALTER TABLE CAT_CERTIFICADO_DIAMANTES ADD CONSTRAINT UK_CAT_CERTIFICADO_DIAMANTES_ABREVIATURA
UNIQUE(ABREVIATURA);

CREATE INDEX CAT_CERTIFICADO_DIAMANTES_ELEMENTO_ID ON CAT_CERTIFICADO_DIAMANTES(ELEMENTO_ID);
CREATE INDEX CAT_CERTIFICADO_DIAMANTES_ABREVIATURA ON CAT_CERTIFICADO_DIAMANTES(ABREVIATURA);

--
-- CREACION TABLA "CAT_CLARIDAD_DIAMANTE"
--
DROP TABLE IF EXISTS CAT_CLARIDAD_DIAMANTE;
CREATE TABLE CAT_CLARIDAD_DIAMANTE
(
  ELEMENTO_ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);

ALTER TABLE CAT_CLARIDAD_DIAMANTE ADD FOREIGN KEY  (ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO (ID);

ALTER TABLE CAT_CLARIDAD_DIAMANTE ADD CONSTRAINT UK_CAT_CLARIDAD_DIAMANTE_ABREVIATURA
  UNIQUE(ABREVIATURA);

CREATE INDEX CAT_CLARIDAD_DIAMANTE_ELEMENTO_ID ON CAT_CLARIDAD_DIAMANTE(ELEMENTO_ID);
CREATE INDEX CAT_CLARIDAD_DIAMANTE_ABREVIATURA ON CAT_CLARIDAD_DIAMANTE(ABREVIATURA);

--
-- CREACION TABLA "CAT_RANGO_ORO"
--
DROP TABLE IF EXISTS CAT_RANGO_ORO;
CREATE TABLE CAT_RANGO_ORO
(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);

ALTER TABLE CAT_RANGO_ORO ADD CONSTRAINT PK_CAT_RANGO_ORO_ELEMENTO_ID
  PRIMARY KEY(ELEMENTO_ID);

ALTER TABLE CAT_RANGO_ORO ADD CONSTRAINT UK_CAT_RANGO_ORO_ABREVIATURA
  UNIQUE(ABREVIATURA);

ALTER TABLE CAT_RANGO_ORO ADD CONSTRAINT FK_CAT_RANGO_ORO_ID_CONFIGURACION
  FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);

CREATE INDEX CAT_RANGO_ORO_ELEMENTO_ID ON CAT_RANGO_ORO(ELEMENTO_ID);
CREATE INDEX CAT_RANGO_ORO_ABREVIATURA ON CAT_RANGO_ORO(ABREVIATURA);

--
-- CREACION TABLA "CAT_RANGO_METAL"
--
DROP TABLE IF EXISTS CAT_RANGO_METAL;
CREATE TABLE CAT_RANGO_METAL
(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);

ALTER TABLE CAT_RANGO_METAL ADD CONSTRAINT PK_CAT_RANGO_METAL_ELEMENTO_ID
  PRIMARY KEY(ELEMENTO_ID);

ALTER TABLE CAT_RANGO_METAL ADD CONSTRAINT UK_CAT_RANGO_METAL_ABREVIATURA
  UNIQUE(ABREVIATURA);

ALTER TABLE CAT_RANGO_METAL ADD CONSTRAINT FK_CAT_RANGO_METAL_ID_CONFIGURACION
  FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);

CREATE INDEX CAT_RANGO_METAL_ELEMENTO_ID ON CAT_RANGO_METAL(ELEMENTO_ID);
CREATE INDEX CAT_RANGO_METAL_ABREVIATURA ON CAT_RANGO_METAL(ABREVIATURA);

--
-- CREACION TABLA "CAT_CORTE"
--
DROP TABLE IF EXISTS CAT_CORTE;
CREATE TABLE CAT_CORTE
(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);

ALTER TABLE CAT_CORTE ADD CONSTRAINT PK_CAT_CORTE_ELEMENTO_ID
  PRIMARY KEY(ELEMENTO_ID);

ALTER TABLE CAT_CORTE ADD CONSTRAINT UK_CAT_CORTE_ABREVIATURA
  UNIQUE(ABREVIATURA);

ALTER TABLE CAT_CORTE ADD CONSTRAINT FK_CAT_CORTE_ID_CONFIGURACION
  FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);

CREATE INDEX CAT_CORTE_ELEMENTO_ID ON CAT_CORTE(ELEMENTO_ID);
CREATE INDEX CAT_CORTE_ABREVIATURA ON CAT_CORTE(ABREVIATURA);


--
-- CREACION TABLA "CAT_SUB_CORTE"
--
DROP TABLE IF EXISTS CAT_SUB_CORTE;
CREATE TABLE CAT_SUB_CORTE
(
    ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
    CORTE BIGINT NOT NULL,
    ABREVIATURA VARCHAR(20) NOT NULL,
    ETIQUETA VARCHAR(150) NOT NULL
);

ALTER TABLE CAT_SUB_CORTE ADD CONSTRAINT PK_CAT_SUB_CORTE_ELEMENTO_ID
PRIMARY KEY(ELEMENTO_ID);

ALTER TABLE CAT_SUB_CORTE ADD CONSTRAINT UK_CAT_SUB_CORTE_ABREVIATURA
UNIQUE(ABREVIATURA);

ALTER TABLE CAT_SUB_CORTE ADD CONSTRAINT FK_CAT_SUB_CORTE_ID_CORTE
FOREIGN KEY(CORTE) REFERENCES CAT_CORTE(ELEMENTO_ID);

CREATE INDEX CAT_SUB_CORTE_ELEMENTO_ID ON CAT_SUB_CORTE(ELEMENTO_ID);
CREATE INDEX CAT_SUB_CORTE_ABREVIATURA ON CAT_SUB_CORTE(ABREVIATURA);




--
-- CREACION TABLAS PARA CATALOGOS DE COLOR Y FAMILIAS COLORES
--
DROP TABLE IF EXISTS CAT_DIAMANTE_GRADO_COLOR;
CREATE TABLE CAT_DIAMANTE_GRADO_COLOR(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);
ALTER TABLE CAT_DIAMANTE_GRADO_COLOR ADD CONSTRAINT PK_CAT_DIAMANTE_GRADO_COLOR_ELEMENTO_ID
PRIMARY KEY(ELEMENTO_ID);
ALTER TABLE CAT_DIAMANTE_GRADO_COLOR ADD CONSTRAINT UK_CAT_DIAMANTE_GRADO_COLOR_ABREVIATURA
UNIQUE(ABREVIATURA);


DROP TABLE IF EXISTS CAT_DIAMANTE_GRADO_COLOR_COLOR;
CREATE TABLE CAT_DIAMANTE_GRADO_COLOR_COLOR(
  ELEMENTO_PADRE BIGINT NOT NULL,
  ELEMENTO_HIJO BIGINT NOT NULL
);
ALTER TABLE CAT_DIAMANTE_GRADO_COLOR_COLOR ADD CONSTRAINT PK_CAT_DIAMANTE_GRADO_COLOR_COLOR
PRIMARY KEY(ELEMENTO_PADRE, ELEMENTO_HIJO);


DROP TABLE IF EXISTS CAT_DIAMANTE_COLOR;
CREATE TABLE CAT_DIAMANTE_COLOR(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);
ALTER TABLE CAT_DIAMANTE_COLOR ADD CONSTRAINT PK_CAT_DIAMANTE_COLOR_ELEMENTO_ID
PRIMARY KEY(ELEMENTO_ID);
ALTER TABLE CAT_DIAMANTE_COLOR ADD CONSTRAINT UK_CAT_DIAMANTE_COLOR_ABREVIATURA
UNIQUE(ABREVIATURA);


DROP TABLE IF EXISTS CAT_DIAMANTE_COLOR_ESCALA_COLOR;
CREATE TABLE CAT_DIAMANTE_COLOR_ESCALA_COLOR(
  ELEMENTO_PADRE BIGINT NOT NULL,
  ELEMENTO_HIJO BIGINT NOT NULL
);
ALTER TABLE CAT_DIAMANTE_COLOR_ESCALA_COLOR ADD CONSTRAINT PK_CAT_DIAMANTE_COLOR_ESCALA_COLOR
PRIMARY KEY(ELEMENTO_PADRE, ELEMENTO_HIJO);


DROP TABLE IF EXISTS CAT_DIAMANTE_ESCALA_COLOR;
CREATE TABLE CAT_DIAMANTE_ESCALA_COLOR(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);
ALTER TABLE CAT_DIAMANTE_ESCALA_COLOR ADD CONSTRAINT PK_CAT_DIAMANTE_ESCALA_COLOR_ELEMENTO_ID
PRIMARY KEY(ELEMENTO_ID);
ALTER TABLE CAT_DIAMANTE_ESCALA_COLOR ADD CONSTRAINT UK_CAT_DIAMANTE_ESCALA_COLOR_ABREVIATURA
UNIQUE(ABREVIATURA);


DROP TABLE IF EXISTS CAT_DIAMANTE_ESCALA_COLOR_GRUPO_COLOR;
CREATE TABLE CAT_DIAMANTE_ESCALA_COLOR_GRUPO_COLOR(
  ELEMENTO_PADRE BIGINT NOT NULL,
  ELEMENTO_HIJO BIGINT NOT NULL
);
ALTER TABLE CAT_DIAMANTE_ESCALA_COLOR_GRUPO_COLOR ADD CONSTRAINT PK_CAT_DIAMANTE_ESCALA_COLOR_GRUPO_COLOR
PRIMARY KEY(ELEMENTO_PADRE, ELEMENTO_HIJO);


DROP TABLE IF EXISTS CAT_DIAMANTE_GRUPO_COLOR;
CREATE TABLE CAT_DIAMANTE_GRUPO_COLOR(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,

  ID_CONFIGURACION BIGINT NOT NULL
);
ALTER TABLE CAT_DIAMANTE_GRUPO_COLOR ADD CONSTRAINT PK_CAT_DIAMANTE_GRUPO_COLOR_ELEMENTO_ID
PRIMARY KEY(ELEMENTO_ID);
ALTER TABLE CAT_DIAMANTE_GRUPO_COLOR ADD CONSTRAINT UK_CAT_CAT_DIAMANTE_GRUPO_COLOR_ABREVIATURA
UNIQUE(ABREVIATURA);


ALTER TABLE CAT_DIAMANTE_GRADO_COLOR ADD CONSTRAINT FK_CAT_DIAMANTE_GRADO_COLOR_ID_CONFIGURACION
FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);


ALTER TABLE CAT_DIAMANTE_GRADO_COLOR_COLOR ADD CONSTRAINT FK_CAT_DIAMANTE_GRADO_COLOR_COLOR_ELEMENTO_PADRE
FOREIGN KEY(ELEMENTO_PADRE) REFERENCES CAT_DIAMANTE_GRADO_COLOR(ELEMENTO_ID);
ALTER TABLE CAT_DIAMANTE_GRADO_COLOR_COLOR ADD CONSTRAINT FK_CAT_DIAMANTE_GRADO_COLOR_COLOR_ELEMENTO_HIJO
FOREIGN KEY(ELEMENTO_HIJO) REFERENCES CAT_DIAMANTE_COLOR(ELEMENTO_ID);


ALTER TABLE CAT_DIAMANTE_COLOR ADD CONSTRAINT FK_CAT_DIAMANTE_COLOR_ID_CONFIGURACION
FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);


ALTER TABLE CAT_DIAMANTE_COLOR_ESCALA_COLOR ADD CONSTRAINT FK_CAT_DIAMANTE_COLOR_ESCALA_COLOR_ELEMENTO_PADRE
FOREIGN KEY(ELEMENTO_PADRE) REFERENCES CAT_DIAMANTE_COLOR(ELEMENTO_ID);
ALTER TABLE CAT_DIAMANTE_COLOR_ESCALA_COLOR ADD CONSTRAINT FK_CAT_DIAMANTE_COLOR_ESCALA_COLOR_ELEMENTO_HIJO
FOREIGN KEY(ELEMENTO_HIJO) REFERENCES CAT_DIAMANTE_ESCALA_COLOR(ELEMENTO_ID);


ALTER TABLE CAT_DIAMANTE_ESCALA_COLOR ADD CONSTRAINT FK_CAT_DIAMANTE_ESCALA_COLOR_ID_CONFIGURACION
FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);


ALTER TABLE CAT_DIAMANTE_ESCALA_COLOR_GRUPO_COLOR ADD CONSTRAINT FK_CAT_DIAMANTE_ESCALA_COLOR_GRUPO_COLOR_ELEMENTO_PADRE
FOREIGN KEY(ELEMENTO_PADRE) REFERENCES CAT_DIAMANTE_ESCALA_COLOR(ELEMENTO_ID);
ALTER TABLE CAT_DIAMANTE_ESCALA_COLOR_GRUPO_COLOR ADD CONSTRAINT FK_CAT_DIAMANTE_ESCALA_COLOR_GRUPO_COLOR_ELEMENTO_HIJO
FOREIGN KEY(ELEMENTO_HIJO) REFERENCES CAT_DIAMANTE_GRUPO_COLOR(ELEMENTO_ID);


ALTER TABLE CAT_DIAMANTE_GRUPO_COLOR ADD CONSTRAINT FK_CAT_DIAMANTE_GRUPO_COLOR_ID_CONFIGURACION
FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);


CREATE INDEX IDX_CAT_DIAMANTE_GRADO_COLOR_ELEMENTO_ID ON CAT_DIAMANTE_GRADO_COLOR(ELEMENTO_ID);
CREATE INDEX IDX_CAT_DIAMANTE_GRADO_COLOR_ABREVIATURA ON CAT_DIAMANTE_GRADO_COLOR(ABREVIATURA);


CREATE INDEX IDX_CAT_DIAMANTE_COLOR_ELEMENTO_ID ON CAT_DIAMANTE_COLOR(ELEMENTO_ID);
CREATE INDEX IDX_CAT_DIAMANTE_COLOR_ABREVIATURA ON CAT_DIAMANTE_COLOR(ABREVIATURA);


CREATE INDEX IDX_CAT_DIAMANTE_ESCALA_COLOR_ELEMENTO_ID ON CAT_DIAMANTE_ESCALA_COLOR(ELEMENTO_ID);
CREATE INDEX IDX_CAT_DIAMANTE_ESCALA_COLOR_ABREVIATURA ON CAT_DIAMANTE_ESCALA_COLOR(ABREVIATURA);


CREATE INDEX IDX_CAT_DIAMANTE_GRUPO_COLOR_ELEMENTO_ID ON CAT_DIAMANTE_GRUPO_COLOR(ELEMENTO_ID);
CREATE INDEX IDX_CAT_DIAMANTE_GRUPO_COLOR_ABREVIATURA ON CAT_DIAMANTE_GRUPO_COLOR(ABREVIATURA);
--
-- CREACION TABLAS PARA CATALOGOS DE COLOR Y FAMILIAS COLORES
--

--
-- CREACION TABLA "CAT_QUILATAJE_DIAMANTE"
--
DROP TABLE IF EXISTS CAT_QUILATAJE_DIAMANTE;
CREATE TABLE CAT_QUILATAJE_DIAMANTE
(
  ELEMENTO_ID BIGINT AUTO_INCREMENT NOT NULL,
  ABREVIATURA VARCHAR(20) NOT NULL,
  ETIQUETA VARCHAR(150) NOT NULL,
  ID_CONFIGURACION BIGINT NOT NULL
);

ALTER TABLE CAT_QUILATAJE_DIAMANTE ADD CONSTRAINT PK_CAT_QUILATAJE_DIAMANTE_ELEMENTO_ID
  PRIMARY KEY(ELEMENTO_ID);

ALTER TABLE CAT_QUILATAJE_DIAMANTE ADD CONSTRAINT UK_CAT_QUILATAJE_DIAMANTE_ABREVIATURA
  UNIQUE(ABREVIATURA);

ALTER TABLE CAT_QUILATAJE_DIAMANTE ADD CONSTRAINT FK_CAT_QUILATAJE_DIAMANTE_ID_CONFIGURACION
  FOREIGN KEY(ID_CONFIGURACION) REFERENCES CNF_CONFIGURACION_CATALOGO(ID);

CREATE INDEX CAT_QUILATAJE_DIAMANTE_ELEMENTO_ID ON CAT_QUILATAJE_DIAMANTE(ELEMENTO_ID);
CREATE INDEX CAT_QUILATAJE_DIAMANTE_ABREVIATURA ON CAT_QUILATAJE_DIAMANTE(ABREVIATURA);



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
    id_elemento BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
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

ALTER TABLE cat_ramo_subramo ADD CONSTRAINT fk_cat_ramo_subramo_elemento_padre
FOREIGN KEY(elemento_padre) REFERENCES cat_ramo(id_elemento);
ALTER TABLE cat_ramo_subramo ADD CONSTRAINT fk_cat_ramo_subramo_elemento_hijo
FOREIGN KEY(elemento_hijo) REFERENCES cat_subramo(id_elemento);



