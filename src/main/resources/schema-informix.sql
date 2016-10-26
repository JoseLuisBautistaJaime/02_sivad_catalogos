--
-- Utilizado para crear la BD (informix) utilizada con el perfil de ensamble.
--

CREATE TABLE CATALOGO_PRUEBA
(
    ID SERIAL8 NOT NULL,
    ABREVIATURA VARCHAR(255) NOT NULL,
    DESCRIPCION VARCHAR(255),
    CATALOGO VARCHAR(255)
);


CREATE TABLE JOURNAL_EVENT
(
    ID SERIAL8 NOT NULL,
    PRINCIPAL VARCHAR(50) NOT NULL,
    DATE DATETIME  YEAR TO SECOND NOT NULL,
    TYPE VARCHAR(255),
    PRIMARY KEY (ID)
);


CREATE TABLE JOURNAL_ENTITY_EVENT
(
    ID INT8 NOT NULL,
    CLASS VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (ID) REFERENCES JOURNAL_EVENT (ID) CONSTRAINT JOURNAL_ENTITY_EVENT_JOURNAL_EVENT_DATA
);


CREATE TABLE JOURNAL_CUSTOM_EVENT
(
    ID INT8 NOT NULL,
    COMMENT VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (ID) REFERENCES JOURNAL_EVENT (ID) CONSTRAINT JOURNAL_CUSTOM_EVENT_JOURNAL_EVENT_DATA
);


CREATE TABLE JOURNAL_EVENT_DATA
(
    ID SERIAL8 NOT NULL,
    EVENT INT8 NOT NULL,
    PROPERTY VARCHAR(255) NOT NULL,
    VALUE VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (EVENT) REFERENCES JOURNAL_EVENT(ID) CONSTRAINT REF_JOURNAL_EVENT_JOURNAL_EVENT_DATA
);
