
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


-- Se agrega la configuracion de los rangos

INSERT INTO cnf_configuracion_catalogo (id, dominio, tipo, valor_default, descripcion) VALUES (19, 'Rango Pesos', 'RangoPeso', '0.01_0.29', 'Catalogo Rango Pesos');
INSERT INTO cat_rango_peso (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (1, '0.01_0.29', '0.01 al 0.29', 19);
INSERT INTO cat_rango_peso (elemento_id, abreviatura, etiqueta, id_configuracion) VALUES (2, '0.30_20', '0.30 al 20', 19);


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

ALTER TABLE cat_diamante_color_escala_color ADD CONSTRAINT FK_cat_diamante_color_escala_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_rango_peso(elemento_id);

ALTER TABLE cat_diamante_grado_color_color ADD CONSTRAINT FK_cat_diamante_grado_color_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_rango_peso(elemento_id);

ALTER TABLE cat_diamante_escala_color_grupo_color ADD CONSTRAINT FK_cat_diamante_escala_color_grupo_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_rango_peso(elemento_id);


-- Se agrega llave foranea

ALTER TABLE cat_diamante_color ADD CONSTRAINT FK_cat_diamante_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_diamante_color(elemento_id);
ALTER TABLE cat_diamante_escala_color ADD CONSTRAINT FK_cat_diamante_escala_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_diamante_escala_color(elemento_id);
ALTER TABLE cat_diamante_grado_color ADD CONSTRAINT FK_cat_diamante_grado_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_diamante_grado_color(elemento_id);
ALTER TABLE cat_diamante_grupo_color ADD CONSTRAINT FK_cat_diamante_grupo_color_id_rango
FOREIGN KEY(id_rango) REFERENCES cat_diamante_grupo_color(elemento_id);


-- Se elimina llave unica

ALTER TABLE cat_diamante_color DROP INDEX UK_CAT_DIAMANTE_COLOR_ABREVIATURA;
ALTER TABLE cat_diamante_escala_color DROP INDEX UK_CAT_DIAMANTE_ESCALA_COLOR_ABREVIATURA;
ALTER TABLE cat_diamante_grado_color DROP INDEX UK_CAT_DIAMANTE_GRADO_COLOR_ABREVIATURA;
ALTER TABLE cat_diamante_grupo_color DROP INDEX UK_CAT_CAT_DIAMANTE_GRUPO_COLOR_ABREVIATURA;


-- Se agrega llave unica (abreviatura y rango)

ALTER TABLE cat_diamante_color ADD CONSTRAINT UK_CAT_DIAMANTE_COLOR_ABR_RANGO
UNIQUE(abreviatura, id_rango);
ALTER TABLE cat_diamante_escala_color ADD CONSTRAINT UK_CAT_DIAMANTE_ESCALA_COLOR_ABR_RANGO
UNIQUE(abreviatura, id_rango);
ALTER TABLE cat_diamante_grado_color ADD CONSTRAINT UK_CAT_DIAMANTE_GRADO_COLOR_ABR_RANGO
UNIQUE(abreviatura, id_rango);
ALTER TABLE cat_diamante_grupo_color ADD CONSTRAINT UK_CAT_DIAMANTE_GRUPO_COLOR_ABR_RANGO
UNIQUE(abreviatura, id_rango);

