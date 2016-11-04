INSERT INTO CNF_CONFIGURACION_CATALOGO(ID, DOMINIO, TIPO, VALOR_DEFAULT, DESCRIPCION)
VALUES (14, 'Diamantes', 'GradoColor', 'GRADO_COLOR_D', 'Catálogo que define el grado de color de un diamante.');


INSERT INTO CAT_DIAMANTE_GRADO_COLOR(ABREVIATURA, ETIQUETA, ID_CONFIGURACION)
VALUES ('GRADO_COLOR_D', 'D', 14);
INSERT INTO CAT_DIAMANTE_GRADO_COLOR(ABREVIATURA, ETIQUETA, ID_CONFIGURACION)
VALUES ('GRADO_COLOR_E', 'E', 14);
