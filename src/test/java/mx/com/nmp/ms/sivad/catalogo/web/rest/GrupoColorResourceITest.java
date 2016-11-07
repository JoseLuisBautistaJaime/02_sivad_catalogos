package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.GrupoColor;
import mx.com.nmp.ms.sivad.catalogo.service.GrupoColorService;
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
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link GrupoColor}
 * @see GrupoColorResource
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class GrupoColorResourceITest {
    private static final String DOMINIO_PATH = "$.dominio";
    private static final String TIPO_PATH = "$.tipo";

    private static final String ABREVIATURA_PADRES_PATH = "$.listaValores[*].padres[*].abreviatura";
    private static final String ABREVIATURA_PATH = "$.listaValores[*].abreviatura";
    private static final String ETIQUETA_PATH = "$.listaValores[*].etiqueta";

    private static final String ABREVIATURA_D_E = "D_E";
    private static final String ETIQUETA_D_E = "D-E";

    private static final String ABREVIATURA_F_G = "F_G";
    private static final String ETIQUETA_F_G = "F-G";

    private static final String ABREVIATURA_H_I = "H_I";
    private static final String ETIQUETA_H_I = "H-I";

    @Inject
    private GrupoColorService grupoColorService;

    private MockMvc test;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        GrupoColorResource gcr = new GrupoColorResource();
        ReflectionTestUtils.setField(gcr, "grupoColorService", grupoColorService);

        test = MockMvcBuilders.standaloneSetup(gcr).build();
    }

    /**
     * Prueba recuperar elementos con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllSinDatosTest() throws Exception {
        test.perform(get("/catalogos/diamantes/color/familia3"))
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
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    public void getAllTest() throws Exception {
        ConfiguracionCatalogoEnum tpe = ConfiguracionCatalogoEnum.GRUPO_COLOR;

        test.perform(get("/catalogos/diamantes/color/familia3"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath(DOMINIO_PATH).value(tpe.getDominioUnwrap()))
            .andExpect(jsonPath(TIPO_PATH).value(tpe.getTipo()))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_D_E)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_D_E)))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_F_G)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_F_G)))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_H_I)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_H_I)));
    }

    /**
     * Prueba recuperar elementos con parametro {@code dependencias=false} con catálogo vacío
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllSinDatosDependenciasFalseTest() throws Exception {
        test.perform(get("/catalogos/diamantes/color/familia3?dependencias=false"))
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
        test.perform(get("/catalogos/diamantes/color/familia3?dependencias=true"))
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
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    public void getAllDependenciasTrueTest() throws Exception {
        ConfiguracionCatalogoEnum tpe = ConfiguracionCatalogoEnum.GRUPO_COLOR;

        test.perform(get("/catalogos/diamantes/color/familia3?dependencias=true"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath(DOMINIO_PATH).value(tpe.getDominioUnwrap()))
            .andExpect(jsonPath(TIPO_PATH).value(tpe.getTipo()))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_D_E)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_D_E)))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_F_G)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_F_G)))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_H_I)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_H_I)))
            .andExpect(jsonPath(ABREVIATURA_PADRES_PATH).value(hasItem("INCOLORO")))
            .andExpect(jsonPath(ABREVIATURA_PADRES_PATH).value(hasItem("CASI_INCOLORO")));
    }

    /**
     * * Prueba recuperar elementos con parametro {@code dependencias=} sin valor
     *
     * @throws Exception Cuando ocurre una error en la prueba.
     */
    @Test
    public void getAllDependenciasSinValorTest() throws Exception {
        test.perform(get("/catalogos/diamantes/color/familia3?dependencias="))
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
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    public void getAllDependenciasFalseTest() throws Exception {
        ConfiguracionCatalogoEnum tpe = ConfiguracionCatalogoEnum.GRUPO_COLOR;

        test.perform(get("/catalogos/diamantes/color/familia3?dependencias=false"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath(DOMINIO_PATH).value(tpe.getDominioUnwrap()))
            .andExpect(jsonPath(TIPO_PATH).value(tpe.getTipo()))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_D_E)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_D_E)))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_F_G)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_F_G)))
            .andExpect(jsonPath(ABREVIATURA_PATH).value(hasItem(ABREVIATURA_H_I)))
            .andExpect(jsonPath(ETIQUETA_PATH).value(hasItem(ETIQUETA_H_I)));
    }
}
