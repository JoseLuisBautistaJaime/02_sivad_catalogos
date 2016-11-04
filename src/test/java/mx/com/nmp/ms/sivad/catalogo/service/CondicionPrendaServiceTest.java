package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.CondicionPrenda;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Clase que realiza las pruebas de unidad de CondicionPrendaService.
 *
 * @author jbautista
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class CondicionPrendaServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CondicionPrendaServiceTest.class);

    private static final String DOMINIO_PRUEBA = "Diamantes";
    private static final String TIPO_PRUEBA = "CondicionPrenda";
    private static final String DESCRIPCION_PRUEBA = "Catálogo de Condiciones de Prenda";
    private static final String VALOR_DEFULT = "ETIQUETA_PRUEBA";
    private static final DateTime ULTIMA_ACTUALIZACION_PRUEBA = new DateTime(0L, DateTimeZone.UTC);
    private static final String ETIQUETA_PRUEBA = "ETIQUETA_PRUEBA";
    private static final String ABREVIATURA_PRUEBA = "ABREVIATURA_PRUEBA";
    private static final String ETIQUETA_PRUEBA_EDIT = "ETIQUETA_PRUEBA_EDIT";
    private static final String ABREVIATURA_PRUEBA_EDIT = "ABREVIATURA_PRUEBA_EDIT";

    @Inject
    private CondicionPrendaService condicionPrendaService;

    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    private ConfiguracionCatalogo configuracionCatalogo;

    /**
     * Metodo para guardar configuracon del catalogo.
     */
    @Before
    public void setUp() {
        ConfiguracionCatalogo configuracionCatalogoPrueba = new ConfiguracionCatalogo();
        configuracionCatalogoPrueba.setTipo(TIPO_PRUEBA);
        configuracionCatalogoPrueba.setDescripcion(DESCRIPCION_PRUEBA);
        configuracionCatalogoPrueba.setDominio(DOMINIO_PRUEBA);
        configuracionCatalogoPrueba.setValorDefault(VALOR_DEFULT);
        configuracionCatalogoPrueba.setUltimaActualizacion(ULTIMA_ACTUALIZACION_PRUEBA);
        configuracionCatalogo = configuracionCatalogoRepository.save(configuracionCatalogoPrueba);
    }

    /**
     * Prueba para guardado de elementos.
     */

    @Test
    @Transactional
    public void testAgregarCondicionPrenda() {
        LOGGER.info(">> testAgregarCondicionPrenda");

        assertNotNull(configuracionCatalogo);

        CondicionPrenda condicionPrendaPrueba = new CondicionPrenda();
        condicionPrendaPrueba.setEtiqueta(ETIQUETA_PRUEBA);
        condicionPrendaPrueba.setAbreviatura(ABREVIATURA_PRUEBA);

        CondicionPrenda condicionPrendaAdd = condicionPrendaService.save(condicionPrendaPrueba);

        assertNotNull(condicionPrendaAdd);
        assertEquals(ABREVIATURA_PRUEBA, condicionPrendaAdd.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA, condicionPrendaAdd.getEtiqueta());
        assertTrue(ULTIMA_ACTUALIZACION_PRUEBA.toLocalDateTime().isBefore(condicionPrendaAdd.getConfiguracion().getUltimaActualizacion().toLocalDateTime()));
    }

    /**
     * prueba para modificacion de elementos
     */

    @Test
    @Transactional
    public void testActualizarCondicionPrenda() {
        LOGGER.info(">> testActualizarCondicionPrenda");

        CondicionPrenda condicionPrendaPrueba = new CondicionPrenda();
        condicionPrendaPrueba.setEtiqueta(ETIQUETA_PRUEBA);
        condicionPrendaPrueba.setAbreviatura(ABREVIATURA_PRUEBA);

        CondicionPrenda condicionPrendaAdd = condicionPrendaService.save(condicionPrendaPrueba);

        assertNotNull(condicionPrendaAdd);
        CondicionPrenda condicionPrendaEdit = new CondicionPrenda();
        condicionPrendaEdit.setEtiqueta(ETIQUETA_PRUEBA_EDIT);
        condicionPrendaEdit.setAbreviatura(ABREVIATURA_PRUEBA_EDIT);

        CondicionPrenda condicionPrendaUpdate = condicionPrendaService.update(ABREVIATURA_PRUEBA, condicionPrendaEdit);

        assertEquals(ABREVIATURA_PRUEBA_EDIT, condicionPrendaUpdate.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA_EDIT, condicionPrendaUpdate.getEtiqueta());
    }

    /**
     * Prueba para elimacion de elementos.
     */
    @Test
    @Transactional
    public void testEliminarCondicionPrenda() {
        LOGGER.info(">> testEliminarCondicionPrenda");

        CondicionPrenda condicionPrendaPrueba = new CondicionPrenda();
        condicionPrendaPrueba.setEtiqueta(ETIQUETA_PRUEBA);
        condicionPrendaPrueba.setAbreviatura(ABREVIATURA_PRUEBA);

        CondicionPrenda condicionPrendaAdd = condicionPrendaService.save(condicionPrendaPrueba);

        assertNotNull(condicionPrendaAdd);
        assertTrue(condicionPrendaService.findbyAbreviatura(ABREVIATURA_PRUEBA) != null);

        condicionPrendaService.delete(ABREVIATURA_PRUEBA);
        assertTrue(condicionPrendaService.findbyAbreviatura(ABREVIATURA_PRUEBA) == null);

    }

}
