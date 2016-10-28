package mx.com.nmp.ms.sivad.catalogo.web.rest;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import mx.com.nmp.ms.sivad.catalogo.service.ConfiguracionCatalogoService;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Pruebas de integración para {@link ConfiguracionCatalogoResource}
 *
 * @author osanchez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class ConfiguracionCatalogoResourceIntTest {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    private static final String DOMINIO_DEFAULT = "ABC";
    private static final String TIPO_DEFAULT = "A";
    private static final String DESCRIPCION_DEFAULT = "AAAAA";
    private static final DateTime ULTIMA_ACTUALIZACION_DEFAULT = new DateTime(0L, DateTimeZone.UTC);
    private static final String ULTIMA_ACTUALIZACION_DEFAULT_STR = dateTimeFormatter.print(ULTIMA_ACTUALIZACION_DEFAULT);

    @Inject
    ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    @Inject
    ConfiguracionCatalogoService configuracionCatalogoService;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Inject
    EntityManager em;

    private MockMvc restMockMvc;

    private ConfiguracionCatalogo configuracionCatalogo;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ConfiguracionCatalogoResource ConfiguracionCatalogoResource = new ConfiguracionCatalogoResource();
        ReflectionTestUtils.setField(ConfiguracionCatalogoResource, "configuracionCatalogoService", configuracionCatalogoService);
        this.restMockMvc = MockMvcBuilders.standaloneSetup(ConfiguracionCatalogoResource)
                .setCustomArgumentResolvers(pageableArgumentResolver)
                .build();
    }

    /**
     * Crear una entidad para las pruebas
     * <p>
     * Es un metodo estático para que lo puedan usar otras pruebas
     * si utilizan una entidad que requiera la entidad actual
     */
    public static ConfiguracionCatalogo createEntity(EntityManager em) {
        ConfiguracionCatalogo ConfiguracionCatalogo = new ConfiguracionCatalogo()
                .dominio(DOMINIO_DEFAULT)
                .tipo(TIPO_DEFAULT)
                .descripcion(DESCRIPCION_DEFAULT)
                .ultimaActualizacion(ULTIMA_ACTUALIZACION_DEFAULT);
        return ConfiguracionCatalogo;
    }

    @Before
    public void initTest() {
        configuracionCatalogo = createEntity(em);
    }

    @Test
    @Transactional
    public void getAllCatalogEntries() throws Exception {
        // Initialize the database
        configuracionCatalogoRepository.saveAndFlush(configuracionCatalogo);

        // Get all the catalogEntries
        restMockMvc.perform(get("/catalogos/configuraciones?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(configuracionCatalogo.getId().intValue())))
                .andExpect(jsonPath("$.[*].dominio").value(hasItem(DOMINIO_DEFAULT.toString())))
                .andExpect(jsonPath("$.[*].tipo").value(hasItem(TIPO_DEFAULT.toString())))
                .andExpect(jsonPath("$.[*].descripcion").value(hasItem(DESCRIPCION_DEFAULT.toString())))
                .andExpect(jsonPath("$.[*].ultimaActualizacion").value(hasItem(ULTIMA_ACTUALIZACION_DEFAULT_STR)));
    }
}
