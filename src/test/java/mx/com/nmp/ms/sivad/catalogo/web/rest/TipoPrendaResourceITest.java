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
import mx.com.nmp.ms.sivad.catalogo.domain.TipoPrenda;
import mx.com.nmp.ms.sivad.catalogo.service.TipoPrendaService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link TipoPrenda}
 * @see TipoPrendaResource
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class TipoPrendaResourceITest {
    private static final String DOMINIO_PATH = "$.Catalogo.dominio";
    private static final String TIPO_PATH = "$.Catalogo.tipo";

    private static final String ABREVIATURA_PATH = "$.Catalogo.listaValores[*].abreviatura";
    private static final String ETIQUETA_PATH = "$.Catalogo.listaValores[*].etiqueta";

    private static final String ABREVIATURA_ANILLO = "ANILLO";
    private static final String ETIQUETA_ANILLO = "Anillo";

    private static final String ABREVIATURA_PULSERA = "PULSERA";
    private static final String ETIQUETA_PULSERA = "Pulsera";

    @Inject
    private TipoPrendaService tipoPrendaService;

    private MockMvc test;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        TipoPrendaResource tpr = new TipoPrendaResource();
        ReflectionTestUtils.setField(tpr, "tipoPrendaService", tipoPrendaService);

        test = MockMvcBuilders.standaloneSetup(tpr).build();
    }

    /**
     * Prueba recuperar elementos con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllSinDatosTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/tipos"))
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
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    public void getAllTest() throws Exception {
        ConfiguracionCatalogoEnum tpe = ConfiguracionCatalogoEnum.TIPO_PRENDA;

        test.perform(get("/catalogos/diamantes/alhajas/tipos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath(DOMINIO_PATH).value(tpe.getDominioUnwrap()))
                .andExpect(jsonPath(TIPO_PATH).value(tpe.getTipo()))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_ANILLO)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_ANILLO)))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_PULSERA)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_PULSERA)));
    }

    /**
     * Prueba recuperar elementos con parametro {@code dependencias=false} con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllSinDatosDependenciasFalseTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/tipos?dependencias=false"))
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
        test.perform(get("/catalogos/diamantes/alhajas/tipos?dependencias=true"))
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
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    public void getAllDependenciasTrueTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/tipos?dependencias=true"))
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
        test.perform(get("/catalogos/diamantes/alhajas/tipos?dependencias="))
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
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    public void getAllDependenciasFalseTest() throws Exception {
        ConfiguracionCatalogoEnum tpe = ConfiguracionCatalogoEnum.TIPO_PRENDA;

        test.perform(get("/catalogos/diamantes/alhajas/tipos?dependencias=false"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath(DOMINIO_PATH).value(tpe.getDominioUnwrap()))
                .andExpect(jsonPath(TIPO_PATH).value(tpe.getTipo()))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_ANILLO)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_ANILLO)))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_PULSERA)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_PULSERA)));
    }

    /**
     * Prueba recuperar un elemento con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getOneSinDatosTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/tipos/ANILLO"))
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
        test.perform(get("/catalogos/diamantes/alhajas/tipos/xXx"))
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
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    public void getOneNoElementoTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/tipos/xXx"))
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
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    public void getOneTest() throws Exception {
        ConfiguracionCatalogoEnum tpe = ConfiguracionCatalogoEnum.TIPO_PRENDA;

        test.perform(get("/catalogos/diamantes/alhajas/tipos/ANILLO"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath(DOMINIO_PATH).value(tpe.getDominioUnwrap()))
                .andExpect(jsonPath(TIPO_PATH).value(tpe.getTipo()))
                .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_ANILLO)))
                .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_ANILLO)));
    }
}
