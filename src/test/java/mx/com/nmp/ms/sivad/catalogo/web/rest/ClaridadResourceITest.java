package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.ClaridadDiamante;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.repository.ClaridadDiamanteRespository;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Clase que contiene las pruebas de servicios qu contien la clase ClaridadResource
 *
 * Created by @roramirez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class ClaridadResourceITest {

    private static final String DOMINIO_PRUEBA = "Diamantes";
    private static final String TIPO_PRUEBA = "ClaridadDiamante";
    private static final String DESCRIPCION_PRUEBA = "Catálogo de Calidades Ley";
    private static final String VALOR_DEFULT = "ETIQUETA_PRUEBA";
    private static final DateTime ULTIMA_ACTUALIZACION_PRUEBA = new DateTime(0L, DateTimeZone.UTC);
    private static final String ABREVIATURA_PRUEBA_A = "AA";
    private static final String ETIQUETA_PRUEBA_A = "ETIQUETA_A";
    private static final String ABREVIATURA_PRUEBA_B = "BB";
    private static final String ETIQUETA_PRUEBA_B = "ETIQUETA_B";

    @Inject
    private ClaridadDiamanteResource claridadDiamanteResource;

    @Inject
    private ClaridadDiamanteRespository claridadDiamanteRespository;

    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    private MockMvc mockClaridadDiamanteService;
    private ConfiguracionCatalogo configuracionCatalogo;

    private ClaridadDiamante prueba1;
    private ClaridadDiamante prueba2;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockClaridadDiamanteService = MockMvcBuilders.standaloneSetup(claridadDiamanteResource).build();
    }

    @Before
    public void initTest() {

        ConfiguracionCatalogo configuracionCatalogoPrueba = new ConfiguracionCatalogo();
        configuracionCatalogoPrueba.setTipo(TIPO_PRUEBA);
        configuracionCatalogoPrueba.setDescripcion(DESCRIPCION_PRUEBA);
        configuracionCatalogoPrueba.setDominio(DOMINIO_PRUEBA);
        configuracionCatalogoPrueba.setValorDefault(VALOR_DEFULT);
        configuracionCatalogoPrueba.setUltimaActualizacion(ULTIMA_ACTUALIZACION_PRUEBA);
        configuracionCatalogo = configuracionCatalogoRepository.saveAndFlush(configuracionCatalogoPrueba);

        configuracionCatalogoRepository.save(configuracionCatalogo);

        ClaridadDiamante claridadDiamanteA = new ClaridadDiamante();
        claridadDiamanteA.setEtiqueta(ETIQUETA_PRUEBA_A);
        claridadDiamanteA.setAbreviatura(ABREVIATURA_PRUEBA_A);
        claridadDiamanteA.setConfiguracion(configuracionCatalogo);

        ClaridadDiamante claridadDiamanteB = new ClaridadDiamante();
        claridadDiamanteB.setEtiqueta(ETIQUETA_PRUEBA_B);
        claridadDiamanteB.setAbreviatura(ABREVIATURA_PRUEBA_B);
        claridadDiamanteB.setConfiguracion(configuracionCatalogo);

        prueba1 = claridadDiamanteRespository.save(claridadDiamanteA);
        prueba2 = claridadDiamanteRespository.save(claridadDiamanteB);

    }

    /**
     * Obtiene los elementos del catalogo.
     *
     * @throws Exception puede ser lanzada en la invocacion.
     */
    @Test
    @Transactional
    public void testResourceGetAll() throws Exception {
        mockClaridadDiamanteService.perform(get("/catalogos/diamantes/claridades"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.dominio").value(configuracionCatalogo.getDominio()))
            .andExpect(jsonPath("$.tipo").value(configuracionCatalogo.getTipo()))
            .andExpect(jsonPath("$.listaValores[0].abreviatura").value(ABREVIATURA_PRUEBA_A))
            .andExpect(jsonPath("$.listaValores[0].etiqueta").value(ETIQUETA_PRUEBA_A))
            .andExpect(jsonPath("$.listaValores[1].abreviatura").value(ABREVIATURA_PRUEBA_B))
            .andExpect(jsonPath("$.listaValores[1].etiqueta").value(ETIQUETA_PRUEBA_B));
    }

    /**
     * Obtiene un elemento del catalogo especificado por abreviatura.
     *
     * @throws Exception puede ser lanzada en la invocacion.
     */
    @Test
    @Transactional
    public void testResourceGet() throws Exception {
        mockClaridadDiamanteService.perform(get("/catalogos/diamantes/claridades/BB"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.dominio").value(configuracionCatalogo.getDominio()))
            .andExpect(jsonPath("$.tipo").value(configuracionCatalogo.getTipo()))
            .andExpect(jsonPath("$.listaValores[0].abreviatura").value(ABREVIATURA_PRUEBA_B))
            .andExpect(jsonPath("$.listaValores[0].etiqueta").value(ETIQUETA_PRUEBA_B));
    }
}
