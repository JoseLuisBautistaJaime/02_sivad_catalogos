package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.Metal;
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
 * Clase que realiza las pruebas de unidad de MetalService.
 *
 * @author jbautista
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class MetalServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MetalServiceTest.class);

    private static final String DOMINIO_PRUEBA = "Alhajas";
    private static final String TIPO_PRUEBA = "Metal";
    private static final String DESCRIPCION_PRUEBA = "Catálogo de Metales";
    private static final String VALOR_DEFULT = "ETIQUETA_PRUEBA";
    private static final DateTime ULTIMA_ACTUALIZACION_PRUEBA = new DateTime(0L, DateTimeZone.UTC);
    private static final String ETIQUETA_PRUEBA = "ETIQUETA_PRUEBA";
    private static final String ABREVIATURA_PRUEBA = "ABREVIATURA_PRUEBA";
    private static final String ETIQUETA_PRUEBA_EDIT = "ETIQUETA_PRUEBA_EDIT";
    private static final String ABREVIATURA_PRUEBA_EDIT = "ABREVIATURA_PRUEBA_EDIT";

    @Inject
    private MetalService metalService;

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
    public void testAgregarMetal() {
        LOGGER.info(">> testAgregarMetal");

        assertNotNull(configuracionCatalogo);

        Metal metalPrueba = new Metal();
        metalPrueba.setEtiqueta(ETIQUETA_PRUEBA);
        metalPrueba.setAbreviatura(ABREVIATURA_PRUEBA);

        Metal metalAdd = metalService.save(metalPrueba);

        assertNotNull(metalAdd);
        assertEquals(ABREVIATURA_PRUEBA, metalAdd.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA, metalAdd.getEtiqueta());
        assertTrue(ULTIMA_ACTUALIZACION_PRUEBA.toLocalDateTime().isBefore(metalAdd.getConfiguracion().getUltimaActualizacion().toLocalDateTime()));
    }

    /**
     * prueba para modificacion de elementos
     */

    @Test
    @Transactional
    public void testActualizarMetal() {
        LOGGER.info(">> testActualizarMetal");

        Metal metalPrueba = new Metal();
        metalPrueba.setEtiqueta(ETIQUETA_PRUEBA);
        metalPrueba.setAbreviatura(ABREVIATURA_PRUEBA);
        Metal metalAdd = metalService.save(metalPrueba);

        assertNotNull(metalAdd);
        Metal metalPruebaEdit = new Metal();
        metalPruebaEdit.setEtiqueta(ETIQUETA_PRUEBA_EDIT);
        metalPruebaEdit.setAbreviatura(ABREVIATURA_PRUEBA_EDIT);

        Metal metalUpdate = metalService.update(ABREVIATURA_PRUEBA, metalPruebaEdit);

        assertEquals(ABREVIATURA_PRUEBA_EDIT, metalUpdate.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA_EDIT, metalUpdate.getEtiqueta());
    }

    /**
     * Prueba para elimacion de elementos.
     */
    @Test
    @Transactional
    public void testEliminarMetal() {
        LOGGER.info(">> testEliminarMetal");

        Metal metalPrueba = new Metal();
        metalPrueba.setEtiqueta(ETIQUETA_PRUEBA);
        metalPrueba.setAbreviatura(ABREVIATURA_PRUEBA);

        Metal metalAdd = metalService.save(metalPrueba);
        assertNotNull(metalAdd);
        assertTrue(metalService.findbyAbreviatura(ABREVIATURA_PRUEBA) != null);

        metalService.delete(ABREVIATURA_PRUEBA);
        assertTrue(metalService.findbyAbreviatura(ABREVIATURA_PRUEBA) == null);

    }

}
