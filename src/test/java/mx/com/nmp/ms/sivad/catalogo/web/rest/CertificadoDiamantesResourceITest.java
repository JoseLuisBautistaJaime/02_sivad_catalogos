package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.CertificadoDiamantes;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.repository.CertificadoDiamantesRepository;
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
 * Clase que contiene las pruebas de servicios qu contien la clase CertificadoDiamantesResource
 *
 * Created by @roramirez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class CertificadoDiamantesResourceITest {

    private static final String DOMINIO_PRUEBA = "Diamantes";
    private static final String TIPO_PRUEBA = "CertificadoDiamantes";
    private static final String DESCRIPCION_PRUEBA = "Catálogo de Calidades Ley";
    private static final String VALOR_DEFULT = "ETIQUETA_PRUEBA";
    private static final DateTime ULTIMA_ACTUALIZACION_PRUEBA = new DateTime(0L, DateTimeZone.UTC);
    private static final String ABREVIATURA_PRUEBA_A = "AA";
    private static final String ETIQUETA_PRUEBA_A = "ETIQUETA_A";
    private static final String ABREVIATURA_PRUEBA_B = "BB";
    private static final String ETIQUETA_PRUEBA_B = "ETIQUETA_B";

    @Inject
    private CertificadoDiamantesResource certificadoDiamantesResource;

    @Inject
    private CertificadoDiamantesRepository certificadoDiamantesRepository;

    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    private MockMvc mockCertificadoDiamantesService;
    private ConfiguracionCatalogo configuracionCatalogo;

    CertificadoDiamantes prueba1;
    CertificadoDiamantes prueba2;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockCertificadoDiamantesService = MockMvcBuilders.standaloneSetup(certificadoDiamantesResource).build();
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

        CertificadoDiamantes certificadoDiamantesA = new CertificadoDiamantes();
        certificadoDiamantesA.setEtiqueta(ETIQUETA_PRUEBA_A);
        certificadoDiamantesA.setAbreviatura(ABREVIATURA_PRUEBA_A);
        certificadoDiamantesA.setConfiguracion(configuracionCatalogo);

        CertificadoDiamantes certificadoDiamantesB = new CertificadoDiamantes();
        certificadoDiamantesB.setEtiqueta(ETIQUETA_PRUEBA_B);
        certificadoDiamantesB.setAbreviatura(ABREVIATURA_PRUEBA_B);
        certificadoDiamantesB.setConfiguracion(configuracionCatalogo);

        prueba1 = certificadoDiamantesRepository.save(certificadoDiamantesA);
        prueba2 = certificadoDiamantesRepository.save(certificadoDiamantesB);

    }


    /**
     * Obtiene los elementos del catalogo.
     *
     * @throws Exception puede ser lanzada en la invocacion.
     */
    @Test
    @Transactional
    public void testResourceGetAll() throws Exception {
        mockCertificadoDiamantesService.perform(get("/catalogos/diamantes/certificados"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.Catalogo.dominio").value(configuracionCatalogo.getDominio()))
            .andExpect(jsonPath("$.Catalogo.tipo").value(configuracionCatalogo.getTipo()))
            .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value(ABREVIATURA_PRUEBA_A))
            .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value(ETIQUETA_PRUEBA_A))
            .andExpect(jsonPath("$.Catalogo.listaValores[1].abreviatura").value(ABREVIATURA_PRUEBA_B))
            .andExpect(jsonPath("$.Catalogo.listaValores[1].etiqueta").value(ETIQUETA_PRUEBA_B));
    }

    /**
     * Obtiene un elemento del catalogo especificado por abreviatura.
     *
     * @throws Exception puede ser lanzada en la invocacion.
     */
    @Test
    @Transactional
    public void testResourceGet() throws Exception {
        mockCertificadoDiamantesService.perform(get("/catalogos/diamantes/certificados/BB"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.Catalogo.dominio").value(configuracionCatalogo.getDominio()))
            .andExpect(jsonPath("$.Catalogo.tipo").value(configuracionCatalogo.getTipo()))
            .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value(ABREVIATURA_PRUEBA_B))
            .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value(ETIQUETA_PRUEBA_B));
    }

}
