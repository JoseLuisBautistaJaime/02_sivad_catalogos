package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.Metal;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import mx.com.nmp.ms.sivad.catalogo.repository.MetalRepository;
import mx.com.nmp.ms.sivad.catalogo.service.MetalService;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Clase que contiene las pruebas de servicios qu contien la clase MetalResource.
 *
 * Created by @jbautsta
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@WebAppConfiguration
public class MetalResourceITest {

    private static final String DOMINIO_PRUEBA = "Alhajas";
    private static final String TIPO_PRUEBA = "Metal";
    private static final String DESCRIPCION_PRUEBA = "Catálogo de Calidades Metales";
    private static final String VALOR_DEFULT = "AA";
    private static final DateTime ULTIMA_ACTUALIZACION_PRUEBA = new DateTime(0L, DateTimeZone.UTC);
    private static final String ABREVIATURA_PRUEBA_A = "AA";
    private static final String ETIQUETA_PRUEBA_A = "ETIQUETA_A";
    private static final String ABREVIATURA_PRUEBA_B = "BB";
    private static final String ETIQUETA_PRUEBA_B = "ETIQUETA_B";

    @Inject
    private MetalService metalService;

    @Inject
    private MetalResource metalResource;

    @Inject
    private MetalRepository MetalRepository;

    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    private MockMvc mockMetalService;
    private ConfiguracionCatalogo configuracionCatalogo;
    private Metal mtPruebaA;
    private Metal mtPruebaB;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMetalService = MockMvcBuilders.standaloneSetup(metalResource).build();
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

        Metal metalPruebaA = new Metal();
        metalPruebaA.setEtiqueta(ETIQUETA_PRUEBA_A);
        metalPruebaA.setAbreviatura(ABREVIATURA_PRUEBA_A);
        metalPruebaA.setConfiguracion(configuracionCatalogo);

        Metal metalPruebaB = new Metal();
        metalPruebaB.setEtiqueta(ETIQUETA_PRUEBA_B);
        metalPruebaB.setAbreviatura(ABREVIATURA_PRUEBA_B);
        metalPruebaB.setConfiguracion(configuracionCatalogo);

        mtPruebaA = MetalRepository.save(metalPruebaA);
        mtPruebaB = MetalRepository.save(metalPruebaB);
    }

    /**
     * Obtiene los elementos del catalogo.
     *
     * @throws Exception puede ser lanzada en la invocacion.
     */
    @Test
    @Transactional
    public void testResourceGetAll() throws Exception {
        mockMetalService.perform(get("/catalogos/diamantes/metales/"))
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
        mockMetalService.perform(get("/catalogos/diamantes/metales/BB"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.dominio").value(configuracionCatalogo.getDominio()))
                .andExpect(jsonPath("$.tipo").value(configuracionCatalogo.getTipo()))
                .andExpect(jsonPath("$.listaValores[0].abreviatura").value(ABREVIATURA_PRUEBA_B))
                .andExpect(jsonPath("$.listaValores[0].etiqueta").value(ETIQUETA_PRUEBA_B));
    }

    /**
     * Se realiza la prueba para obtener un elemento que no existe, NOT FOUND.
     *
     * @throws Exception puede ser lanzada en la invocacion.
     */
    @Test
    @Transactional
    public void testResourceGetInexist() throws Exception {
        mockMetalService.perform(get("/catalogos/diamantes/metales/NA"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().bytes(new byte[0]));
    }

}
