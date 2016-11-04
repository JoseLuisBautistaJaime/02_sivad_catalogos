package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.CalidadLey;
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
 * Clase que realiza las pruebas de unidad de CalidadLeyService.
 *
 * @author jbautista
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class CalidadLeyServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalidadLeyServiceTest.class);

    private static final String DOMINIO_PRUEBA = "Alhajas";
    private static final String TIPO_PRUEBA = "CalidadLey";
    private static final String DESCRIPCION_PRUEBA = "Catálogo de Calidades Ley";
    private static final String VALOR_DEFULT = "ETIQUETA_PRUEBA";
    private static final DateTime ULTIMA_ACTUALIZACION_PRUEBA = new DateTime(0L, DateTimeZone.UTC);
    private static final String ETIQUETA_PRUEBA = "ETIQUETA_PRUEBA";
    private static final String ABREVIATURA_PRUEBA = "ABREVIATURA_PRUEBA";
    private static final String ETIQUETA_PRUEBA_EDIT = "ETIQUETA_PRUEBA_EDIT";
    private static final String ABREVIATURA_PRUEBA_EDIT = "ABREVIATURA_PRUEBA_EDIT";

    @Inject
    private CalidadLeyService calidadLeyService;

    @Inject
    private ConfiguracionCatalogoRepository configuracionCatalogoRepository;

    private ConfiguracionCatalogo configuracionCatalogo;

    /**
     * Metodo para guardar configuracion del catalogo.
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
    public void testAgregarCalidadLey() {
        LOGGER.info(">> testAgregarCalidadLey");

        assertNotNull(configuracionCatalogo);

        CalidadLey calidadLeyPrueba = new CalidadLey();
        calidadLeyPrueba.setEtiqueta(ETIQUETA_PRUEBA);
        calidadLeyPrueba.setAbreviatura(ABREVIATURA_PRUEBA);

        CalidadLey calidadLeyAdd = calidadLeyService.save(calidadLeyPrueba);

        assertNotNull(calidadLeyAdd);
        assertEquals(ABREVIATURA_PRUEBA, calidadLeyAdd.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA, calidadLeyAdd.getEtiqueta());
        assertTrue(ULTIMA_ACTUALIZACION_PRUEBA.toLocalDateTime().isBefore(calidadLeyAdd.getConfiguracion().getUltimaActualizacion().toLocalDateTime()));
    }

    /**
     * prueba para modificacion de elementos
     */

    @Test
    @Transactional
    public void testActualizarCalidadLey() {
        LOGGER.info(">> testActualizarCalidadLey");

        CalidadLey calidadLeyPrueba = new CalidadLey();
        calidadLeyPrueba.setEtiqueta(ETIQUETA_PRUEBA);
        calidadLeyPrueba.setAbreviatura(ABREVIATURA_PRUEBA);

        CalidadLey calidadLeyAdd = calidadLeyService.save(calidadLeyPrueba);

        assertNotNull(calidadLeyAdd);

        CalidadLey calidadLeyEdit = new CalidadLey();
        calidadLeyEdit.setEtiqueta(ETIQUETA_PRUEBA_EDIT);
        calidadLeyEdit.setAbreviatura(ABREVIATURA_PRUEBA_EDIT);

        CalidadLey calidadLeyUpdate = calidadLeyService.update(ABREVIATURA_PRUEBA, calidadLeyEdit);

        assertEquals(ABREVIATURA_PRUEBA_EDIT, calidadLeyUpdate.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA_EDIT, calidadLeyUpdate.getEtiqueta());
    }

    /**
     * Prueba para elimacion de elementos.
     */
    @Test
    @Transactional
    public void testEliminarCalidadLey() {
        LOGGER.info(">> testEliminarCalidadLey");

        CalidadLey calidadLeyPrueba = new CalidadLey();
        calidadLeyPrueba.setEtiqueta(ETIQUETA_PRUEBA);
        calidadLeyPrueba.setAbreviatura(ABREVIATURA_PRUEBA);

        CalidadLey calidadLeyAdd = calidadLeyService.save(calidadLeyPrueba);

        assertNotNull(calidadLeyAdd);
        assertTrue(calidadLeyService.findbyAbreviatura(ABREVIATURA_PRUEBA) != null);

        calidadLeyService.delete(ABREVIATURA_PRUEBA);
        assertTrue(calidadLeyService.findbyAbreviatura(ABREVIATURA_PRUEBA) == null);

    }

}
