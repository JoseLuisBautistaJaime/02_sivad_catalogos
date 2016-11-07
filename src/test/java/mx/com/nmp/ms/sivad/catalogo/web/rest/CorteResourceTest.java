/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.Corte;
import mx.com.nmp.ms.sivad.catalogo.service.CorteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link Corte}
 * @see CorteResource
 *
 * @author mmarquez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class CorteResourceTest {
    private static final String DOMINIO_PATH = "$.dominio";
    private static final String TIPO_PATH = "$.tipo";

    private static final String ABREVIATURA_PATH = "$.listaValores[*].abreviatura";
    private static final String ETIQUETA_PATH = "$.listaValores[*].etiqueta";

    private static final String ABREVIATURA_BR = "BR";
    private static final String ETIQUETA_BR = "Brillante";

    private static final String ABREVIATURA_PR = "PR";
    private static final String ETIQUETA_PR = "Princesa";

    @Inject
    private CorteService corteService;

    private MockMvc test;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        CorteResource corteResource = new CorteResource();
        ReflectionTestUtils.setField(corteResource, "corteService", corteService);

        test = MockMvcBuilders.standaloneSetup(corteResource).build();
    }

    /**
     * Prueba recuperar elementos con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllSinDatosTest() throws Exception {
        test.perform(get("/catalogos/diamantes/cortes"))
            .andExpect(status().isOk())
            .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Prueba recuperar elementos
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    public void getAllTest() throws Exception {
        ConfiguracionCatalogoEnum configuracionCatalogoEnum = ConfiguracionCatalogoEnum.CORTE;

        test.perform(get("/catalogos/diamantes/cortes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath(DOMINIO_PATH).value(configuracionCatalogoEnum.getDominioUnwrap()))
                .andExpect(jsonPath(TIPO_PATH).value(configuracionCatalogoEnum.getTipo()))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_BR)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_BR)))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_PR)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_PR)));
    }

    /**
     * Prueba recuperar elementos con parametro {@code dependencias=false} con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllSinDatosDependenciasFalseTest() throws Exception {
        test.perform(get("/catalogos/diamantes/cortes?dependencias=false"))
                .andExpect(status().isOk())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Prueba recuperar elementos con parametro {@code dependencias=true} con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllSinDatosDependenciasTrueTest() throws Exception {
        test.perform(get("/catalogos/diamantes/cortes?dependencias=true"))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Prueba recuperar elementos con parametro {@code dependencias=true} con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    public void getAllDependenciasTrueTest() throws Exception {
        test.perform(get("/catalogos/diamantes/cortes?dependencias=true"))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * * Prueba recuperar elementos con parametro {@code dependencias=} sin valor
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllDependenciasSinValorTest() throws Exception {
        test.perform(get("/catalogos/diamantes/cortes?dependencias="))
                .andExpect(status().isBadRequest())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Prueba recuperar elementos con parametro {@code dependencias=false}
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    public void getAllDependenciasFalseTest() throws Exception {
        ConfiguracionCatalogoEnum configuracionCatalogoEnum = ConfiguracionCatalogoEnum.CORTE;

        test.perform(get("/catalogos/diamantes/cortes?dependencias=false"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath(DOMINIO_PATH).value(configuracionCatalogoEnum.getDominioUnwrap()))
                .andExpect(jsonPath(TIPO_PATH).value(configuracionCatalogoEnum.getTipo()))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_BR)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_BR)))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_PR)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_PR)));
    }

    /**
     * Prueba recuperar un elemento con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getOneSinDatosTest() throws Exception {
        test.perform(get("/catalogos/diamantes/cortes/BR"))
                .andExpect(status().isNotFound())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Prueba recuperar un elemento no valido con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getOneSinDatosNoElementoTest() throws Exception {
        test.perform(get("/catalogos/diamantes/cortes/xXx"))
                .andExpect(status().isNotFound())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Prueba recuperar un elemento no valido
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    public void getOneNoElementoTest() throws Exception {
        test.perform(get("/catalogos/diamantes/cortes/xXx"))
                .andExpect(status().isNotFound())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Prueba recuperar un elemento
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    public void getOneTest() throws Exception {
        ConfiguracionCatalogoEnum configuracionCatalogoEnum = ConfiguracionCatalogoEnum.CORTE;

        test.perform(get("/catalogos/diamantes/cortes/BR"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath(DOMINIO_PATH).value(configuracionCatalogoEnum.getDominioUnwrap()))
                .andExpect(jsonPath(TIPO_PATH).value(configuracionCatalogoEnum.getTipo()))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_BR)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_BR)));
    }
}
