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
import mx.com.nmp.ms.sivad.catalogo.domain.RangoOro;
import mx.com.nmp.ms.sivad.catalogo.service.RangoOroService;
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
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link RangoOro}
 * @see RangoOroResource
 *
 * @author mmarquez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class RangoOroResourceTest {
    private static final String DOMINIO_PATH = "$.dominio";
    private static final String TIPO_PATH = "$.tipo";

    private static final String ABREVIATURA_PATH = "$.listaValores[*].abreviatura";
    private static final String ETIQUETA_PATH = "$.listaValores[*].etiqueta";

    private static final String ABREVIATURA_F1 = "F1";
    private static final String ETIQUETA_F1 = "Pedaceria y Piezas Rotas";

    private static final String ABREVIATURA_F2 = "F2";
    private static final String ETIQUETA_F2 = "Buen Estado Personalizadas";

    @Inject
    private RangoOroService rangoOroService;

    private MockMvc test;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RangoOroResource rangoOroResource = new RangoOroResource();
        ReflectionTestUtils.setField(rangoOroResource, "rangoOroService", rangoOroService);

        test = MockMvcBuilders.standaloneSetup(rangoOroResource).build();
    }

    /**
     * Prueba recuperar elementos con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllSinDatosTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/rangosOro"))
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
    @Sql("/bd/test-data-rango_oro-h2.sql")
    public void getAllTest() throws Exception {
        ConfiguracionCatalogoEnum configuracionCatalogoEnum = ConfiguracionCatalogoEnum.RANGO_ORO;

        test.perform(get("/catalogos/diamantes/alhajas/rangosOro"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath(DOMINIO_PATH).value(configuracionCatalogoEnum.getDominioUnwrap()))
                .andExpect(jsonPath(TIPO_PATH).value(configuracionCatalogoEnum.getTipo()))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_F1)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_F1)))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_F2)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_F2)));
    }

    /**
     * Prueba recuperar elementos con parametro {@code dependencias=false} con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllSinDatosDependenciasFalseTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/rangosOro?dependencias=false"))
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
        test.perform(get("/catalogos/diamantes/alhajas/rangosOro?dependencias=true"))
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
    @Sql("/bd/test-data-rango_oro-h2.sql")
    public void getAllDependenciasTrueTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/rangosOro?dependencias=true"))
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
        test.perform(get("/catalogos/diamantes/alhajas/rangosOro?dependencias="))
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
    @Sql("/bd/test-data-rango_oro-h2.sql")
    public void getAllDependenciasFalseTest() throws Exception {
        ConfiguracionCatalogoEnum configuracionCatalogoEnum = ConfiguracionCatalogoEnum.RANGO_ORO;

        test.perform(get("/catalogos/diamantes/alhajas/rangosOro?dependencias=false"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath(DOMINIO_PATH).value(configuracionCatalogoEnum.getDominioUnwrap()))
                .andExpect(jsonPath(TIPO_PATH).value(configuracionCatalogoEnum.getTipo()))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_F1)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_F1)))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_F2)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_F2)));
    }

    /**
     * Prueba recuperar un elemento con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getOneSinDatosTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/rangosOro/F1"))
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
        test.perform(get("/catalogos/diamantes/alhajas/rangosOro/xXx"))
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
    @Sql("/bd/test-data-rango_oro-h2.sql")
    public void getOneNoElementoTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/rangosOro/xXx"))
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
    @Sql("/bd/test-data-rango_oro-h2.sql")
    public void getOneTest() throws Exception {
        ConfiguracionCatalogoEnum configuracionCatalogoEnum = ConfiguracionCatalogoEnum.RANGO_ORO;

        test.perform(get("/catalogos/diamantes/alhajas/rangosOro/F1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath(DOMINIO_PATH).value(configuracionCatalogoEnum.getDominioUnwrap()))
                .andExpect(jsonPath(TIPO_PATH).value(configuracionCatalogoEnum.getTipo()))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_F1)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_F1)));
    }
}
