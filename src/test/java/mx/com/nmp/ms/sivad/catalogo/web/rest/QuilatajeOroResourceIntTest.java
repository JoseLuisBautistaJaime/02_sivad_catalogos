/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.service.QuilatajeOroService;
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

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Clase de prueba para el Controlador REST QuilatajeOroResource.
 *
 * @author ngonzalez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class QuilatajeOroResourceIntTest {

    /**
     * Referencia al servicio de QuilatajeOroService.
     */
    @Inject
    QuilatajeOroService quilatajeOroService;

    /**
     * Mock utilizado para las pruebas.
     */
    private MockMvc test;



    // METODOS

    /**
     * Establecer las condiciones iniciales.
     */
    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        QuilatajeOroResource quilatajeOroResource = new QuilatajeOroResource();
        ReflectionTestUtils.setField(quilatajeOroResource, "quilatajeOroService", quilatajeOroService);
        test = MockMvcBuilders.standaloneSetup(quilatajeOroResource).build();
    }

    /**
     * Utilizado para obtener todos los elementos del catálogo (con datos).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void getAllTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/quilatajes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.QUILATAJE_ORO.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.QUILATAJE_ORO.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("12_Q"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("12"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].abreviatura").value("14_Q"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].etiqueta").value("14"));
    }

    /**
     * Utilizado para obtener todos los elementos del catálogo (sin datos).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    public void getAllSinDatosTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/quilatajes"))
                .andExpect(status().isOk())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener todos los elementos del catálogo (con datos y el parámetro dependencias = false).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void getAllDependenciasFalseTestTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/quilatajes?dependencias=false"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.QUILATAJE_ORO.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.QUILATAJE_ORO.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("12_Q"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("12"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].abreviatura").value("14_Q"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].etiqueta").value("14"));
    }

    /**
     * Utilizado para obtener todos los elementos del catálogo (sin datos y el parámetro dependencias = false).
     *
     * @throws Exception
     */
    @Test
    public void getAllSinDatosDependenciasFalseTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/quilatajes?dependencias=false"))
                .andExpect(status().isOk())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener todos los elementos del catálogo (con datos y el parámetro dependencias = true).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void getAllDependenciasTrueTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/quilatajes?dependencias=true"))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener todos los elementos del catálogo (sin datos y el parámetro dependencias = true).
     *
     * @throws Exception
     */
    @Test
    public void getAllSinDatosDependenciasTrueTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/quilatajes?dependencias=true"))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener todos los elementos del catálogo (con datos y el parámetro dependencias sin valor).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void getAllDependenciasSinValorTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/quilatajes?dependencias="))
                .andExpect(status().isBadRequest())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener todos los elementos del catálogo (sin datos y el parámetro dependencias sin valor).
     *
     * @throws Exception
     */
    @Test
    public void getAllSinDatosDependenciasSinValorTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/quilatajes?dependencias="))
                .andExpect(status().isBadRequest())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener un elemento del catálogo (con datos).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void getOneTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/quilatajes/12_Q"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.QUILATAJE_ORO.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.QUILATAJE_ORO.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("12_Q"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("12"));
    }

    /**
     * Utilizado para obtener un elemento del catálogo que no existe (sin datos).
     *
     * @throws Exception
     */
    @Test
    public void getOneSinDatosTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/quilatajes/12_Q"))
                .andExpect(status().isNotFound())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener un elemento del catálogo que no existe (con datos).
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void getOneNoElementoTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/quilatajes/XXX"))
                .andExpect(status().isNotFound())
                .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Utilizado para obtener un elemento del catálogo que no existe (sin datos).
     *
     * @throws Exception
     */
    @Test
    public void getOneSinDatosNoElementoTest() throws Exception {
        test.perform(get("/catalogos/diamantes/alhajas/quilatajes/XXX"))
                .andExpect(status().isNotFound())
                .andExpect(content().bytes(new byte[0]));
    }

}
