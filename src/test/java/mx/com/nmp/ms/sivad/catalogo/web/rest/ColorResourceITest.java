package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.Color;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.service.ColorService;
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
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link Color}
 * @see ColorResource
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class ColorResourceITest {
    private static final String DOMINIO_PATH = "$.Catalogo.dominio";
    private static final String TIPO_PATH = "$.Catalogo.tipo";

    private static final String ABREVIATURA_PADRES_PATH = "$.Catalogo.listaValores[*].padres[*].abreviatura";
    private static final String ABREVIATURA_PATH = "$.Catalogo.listaValores[*].abreviatura";
    private static final String ETIQUETA_PATH = "$.Catalogo.listaValores[*].etiqueta";

    private static final String ABREVIATURA_COLOR_D_E = "COLOR_D_E";
    private static final String ETIQUETA_COLOR_D_E = "";

    private static final String ABREVIATURA_BLANCO_NATURAL = "BLANCO_NATURAL";
    private static final String ETIQUETA_BLANCO_NATURAL = "Blanco natural";

    @Inject
    private ColorService colorService;

    private MockMvc test;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ColorResource cr = new ColorResource();
        ReflectionTestUtils.setField(cr, "colorService", colorService);

        test = MockMvcBuilders.standaloneSetup(cr).build();
    }

    /**
     * Prueba recuperar elementos con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllSinDatosTest() throws Exception {
        test.perform(get("/catalogos/diamantes/color/familia1"))
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
    @Sql("/bd/test-data-diamante_color-h2.sql")
    public void getAllTest() throws Exception {
        ConfiguracionCatalogoEnum tpe = ConfiguracionCatalogoEnum.COLOR;

        test.perform(get("/catalogos/diamantes/color/familia1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath(DOMINIO_PATH).value(tpe.getDominioUnwrap()))
            .andExpect(jsonPath(TIPO_PATH).value(tpe.getTipo()))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_COLOR_D_E)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_COLOR_D_E)))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_BLANCO_NATURAL)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_BLANCO_NATURAL)));
    }

    /**
     * Prueba recuperar elementos con parametro {@code dependencias=false} con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllSinDatosDependenciasFalseTest() throws Exception {
        test.perform(get("/catalogos/diamantes/color/familia1?dependencias=false"))
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
        test.perform(get("/catalogos/diamantes/color/familia1?dependencias=true"))
            .andExpect(status().isOk())
            .andExpect(content().bytes(new byte[0]));
    }

    /**
     * Prueba recuperar elementos con parametro {@code dependencias=true} con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    public void getAllDependenciasTrueTest() throws Exception {
        ConfiguracionCatalogoEnum tpe = ConfiguracionCatalogoEnum.COLOR;

        test.perform(get("/catalogos/diamantes/color/familia1?dependencias=true"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath(DOMINIO_PATH).value(tpe.getDominioUnwrap()))
            .andExpect(jsonPath(TIPO_PATH).value(tpe.getTipo()))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_COLOR_D_E)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_COLOR_D_E)))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_BLANCO_NATURAL)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_BLANCO_NATURAL)))
            .andExpect(jsonPath(ABREVIATURA_PADRES_PATH).value(hasItem("GRADO_COLOR_D")))
            .andExpect(jsonPath(ABREVIATURA_PADRES_PATH).value(hasItem("GRADO_COLOR_E")))
            .andExpect(jsonPath(ABREVIATURA_PADRES_PATH).value(hasItem("GRADO_COLOR_F")))
            .andExpect(jsonPath(ABREVIATURA_PADRES_PATH).value(hasItem("GRADO_COLOR_G")));
    }

    /**
     * * Prueba recuperar elementos con parametro {@code dependencias=} sin valor
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllDependenciasSinValorTest() throws Exception {
        test.perform(get("/catalogos/diamantes/color/familia1?dependencias="))
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
    @Sql("/bd/test-data-diamante_color-h2.sql")
    public void getAllDependenciasFalseTest() throws Exception {
        ConfiguracionCatalogoEnum tpe = ConfiguracionCatalogoEnum.COLOR;

        test.perform(get("/catalogos/diamantes/color/familia1?dependencias=false"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath(DOMINIO_PATH).value(tpe.getDominioUnwrap()))
            .andExpect(jsonPath(TIPO_PATH).value(tpe.getTipo()))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_COLOR_D_E)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_COLOR_D_E)))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_BLANCO_NATURAL)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_BLANCO_NATURAL)));
    }
}
