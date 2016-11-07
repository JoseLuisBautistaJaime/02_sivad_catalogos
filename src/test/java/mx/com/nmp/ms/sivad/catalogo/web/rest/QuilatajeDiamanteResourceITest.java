/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.service.QuilatajeDiamanteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Clase de prueba para el Controlador REST QuilatajeDiamanteResource.
 *
 * @author jbautista
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class QuilatajeDiamanteResourceITest {

    @Inject
    private QuilatajeDiamanteService quilatajeDiamanteService;

    @Inject
    private QuilatajeDiamanteResource quilatajeDiamanteResource;

    private MockMvc mockQuilatajeDiamanteService;

    /**
     * Establecer las condiciones iniciales.
     */
    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockQuilatajeDiamanteService = MockMvcBuilders.standaloneSetup(quilatajeDiamanteResource).build();
    }

    /**
     * Utilizado para obtener todos los elementos del catalogo (con datos).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void getAllTest() throws Exception {
        mockQuilatajeDiamanteService.perform(get("/catalogos/diamantes/quilatajes_diamantes"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.dominio").value(ConfiguracionCatalogoEnum.QUILATAJE_DIAMANTE.getDominioUnwrap()))
            .andExpect(jsonPath("$.tipo").value(ConfiguracionCatalogoEnum.QUILATAJE_DIAMANTE.getTipo()))
            .andExpect(jsonPath("$.listaValores[0].abreviatura").value("0_25_Q"))
            .andExpect(jsonPath("$.listaValores[0].etiqueta").value("0.25"))
            .andExpect(jsonPath("$.listaValores[1].abreviatura").value("0_5_Q"))
            .andExpect(jsonPath("$.listaValores[1].etiqueta").value("0.5"));
    }

    /**
     * Utilizado para obtener todos los elementos del catalogo (sin datos).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    public void getAllSinDatosTest() throws Exception {
        mockQuilatajeDiamanteService.perform(get("/catalogos/diamantes/quilatajes_diamantes"))
            .andExpect(status().isOk())
            .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener todos los elementos del catalogo (con datos y el parámetro dependencias = false).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void getAllDependenciasFalseTestTest() throws Exception {
        mockQuilatajeDiamanteService.perform(get("/catalogos/diamantes/quilatajes_diamantes?dependencias=false"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.dominio").value(ConfiguracionCatalogoEnum.QUILATAJE_DIAMANTE.getDominioUnwrap()))
            .andExpect(jsonPath("$.tipo").value(ConfiguracionCatalogoEnum.QUILATAJE_DIAMANTE.getTipo()))
            .andExpect(jsonPath("$.listaValores[0].abreviatura").value("0_25_Q"))
            .andExpect(jsonPath("$.listaValores[0].etiqueta").value("0.25"))
            .andExpect(jsonPath("$.listaValores[1].abreviatura").value("0_5_Q"))
            .andExpect(jsonPath("$.listaValores[1].etiqueta").value("0.5"));
    }

    /**
     * Utilizado para obtener todos los elementos del catalogo (sin datos y el parámetro dependencias = false).
     *
     * @throws Exception
     */
    @Test
    public void getAllSinDatosDependenciasFalseTest() throws Exception {
        mockQuilatajeDiamanteService.perform(get("/catalogos/diamantes/quilatajes_diamantes?dependencias=false"))
            .andExpect(status().isOk())
            .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener todos los elementos del catalogo (con datos y el parámetro dependencias = true).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void getAllDependenciasTrueTest() throws Exception {
        mockQuilatajeDiamanteService.perform(get("/catalogos/diamantes/quilatajes_diamantes?dependencias=true"))
            .andExpect(status().isNotAcceptable())
            .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener todos los elementos del catalogo (sin datos y el parámetro dependencias = true).
     *
     * @throws Exception
     */
    @Test
    public void getAllSinDatosDependenciasTrueTest() throws Exception {
        mockQuilatajeDiamanteService.perform(get("/catalogos/diamantes/quilatajes_diamantes?dependencias=true"))
            .andExpect(status().isNotAcceptable())
            .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener todos los elementos del catalogo (con datos y el parámetro dependencias sin valor).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void getAllDependenciasSinValorTest() throws Exception {
        mockQuilatajeDiamanteService.perform(get("/catalogos/diamantes/quilatajes_diamantes?dependencias="))
            .andExpect(status().isBadRequest())
            .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener todos los elementos del catalogo (sin datos y el parámetro dependencias sin valor).
     *
     * @throws Exception
     */
    @Test
    public void getAllSinDatosDependenciasSinValorTest() throws Exception {
        mockQuilatajeDiamanteService.perform(get("/catalogos/diamantes/quilatajes_diamantes?dependencias="))
            .andExpect(status().isBadRequest())
            .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener un elemento del catalogo (con datos).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void getOneTest() throws Exception {
        mockQuilatajeDiamanteService.perform(get("/catalogos/diamantes/quilatajes_diamantes/0_25_Q"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.dominio").value(ConfiguracionCatalogoEnum.QUILATAJE_DIAMANTE.getDominioUnwrap()))
            .andExpect(jsonPath("$.tipo").value(ConfiguracionCatalogoEnum.QUILATAJE_DIAMANTE.getTipo()))
            .andExpect(jsonPath("$.listaValores[0].abreviatura").value("0_25_Q"))
            .andExpect(jsonPath("$.listaValores[0].etiqueta").value("0.25"));
    }

    /**
     * Utilizado para obtener un elemento del catalogo que no existe (sin datos).
     *
     * @throws Exception
     */
    @Test
    public void getOneSinDatosTest() throws Exception {
        mockQuilatajeDiamanteService.perform(get("/catalogos/diamantes/alhajas/quilatajes/9_Q"))
            .andExpect(status().isNotFound())
            .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener un elemento del catalogo que no existe (con datos).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void getOneNoElementoTest() throws Exception {
        mockQuilatajeDiamanteService.perform(get("/catalogos/diamantes/quilatajes_diamantes/NA"))
            .andExpect(status().isNotFound())
            .andExpect(content().bytes(new byte[0]));
    }
}
