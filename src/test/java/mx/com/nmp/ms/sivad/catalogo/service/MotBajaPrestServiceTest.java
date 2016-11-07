package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.MotivoBajaPrestamo;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
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
 * Clase que realiza las pruebas de unidad de MotivoBajaPrestamoService.
 *
 * @author jbautista
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class MotBajaPrestServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MotBajaPrestServiceTest.class);

    private static final String DOMINIO_PRUEBA = "Diamantes";
    private static final String TIPO_PRUEBA = "MotivoBajaPrestamo";
    private static final String DESCRIPCION_PRUEBA = "Catálogo de Motivos de Baja de Prestamo";
    private static final String VALOR_DEFULT = "ETIQUETA_PRUEBA";
    private static final DateTime ULTIMA_ACTUALIZACION_PRUEBA = new DateTime(0L, DateTimeZone.UTC);
    private static final String ETIQUETA_PRUEBA = "ETIQUETA_PRUEBA";
    private static final String ABREVIATURA_PRUEBA = "ABREVIATURA_PRUEBA";
    private static final String ETIQUETA_PRUEBA_EDIT = "ETIQUETA_PRUEBA_EDIT";
    private static final String ABREVIATURA_PRUEBA_EDIT = "ABREVIATURA_PRUEBA_EDIT";

    @Inject
    private MotivoBajaPrestamoService motivoBajaPrestamoService;

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
    public void testAgregarMotBajPrestamo() {
        LOGGER.info(">> testAgregarMotBajPrestamo");

        assertNotNull(configuracionCatalogo);

        MotivoBajaPrestamo motBajPresPrueba = new MotivoBajaPrestamo();
        motBajPresPrueba.setEtiqueta(ETIQUETA_PRUEBA);
        motBajPresPrueba.setAbreviatura(ABREVIATURA_PRUEBA);

        MotivoBajaPrestamo motBajPresAdd = motivoBajaPrestamoService.save(motBajPresPrueba);

        assertNotNull(motBajPresAdd);
        assertEquals(ABREVIATURA_PRUEBA, motBajPresAdd.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA, motBajPresAdd.getEtiqueta());
        assertTrue(ULTIMA_ACTUALIZACION_PRUEBA.toLocalDateTime().isBefore(motBajPresAdd.getConfiguracion().getUltimaActualizacion().toLocalDateTime()));
    }

    /**
     * prueba para modificacion de elementos
     */

    @Test
    @Transactional
    public void testActualizarMotBajPrestamo() {
        LOGGER.info(">> testActualizarMotBajPrestamo");

        MotivoBajaPrestamo motBajPresPrueba = new MotivoBajaPrestamo();
        motBajPresPrueba.setEtiqueta(ETIQUETA_PRUEBA);
        motBajPresPrueba.setAbreviatura(ABREVIATURA_PRUEBA);

        MotivoBajaPrestamo motBajPresAdd = motivoBajaPrestamoService.save(motBajPresPrueba);

        assertNotNull(motBajPresAdd);
        MotivoBajaPrestamo motivoBajaPrestamoEdit = new MotivoBajaPrestamo();
        motivoBajaPrestamoEdit.setEtiqueta(ETIQUETA_PRUEBA_EDIT);
        motivoBajaPrestamoEdit.setAbreviatura(ABREVIATURA_PRUEBA_EDIT);

        MotivoBajaPrestamo motivoBajaPrestamoUpdate = motivoBajaPrestamoService.update(ABREVIATURA_PRUEBA, motivoBajaPrestamoEdit);

        assertEquals(ABREVIATURA_PRUEBA_EDIT, motivoBajaPrestamoUpdate.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA_EDIT, motivoBajaPrestamoUpdate.getEtiqueta());
    }

    /**
     * Prueba para elimacion de elementos.
     */
    @Test
    @Transactional
    public void testEliminarMotBajPrestamo() {
        LOGGER.info(">> testEliminarMotBajPrestamo");

        MotivoBajaPrestamo motBajPresPrueba = new MotivoBajaPrestamo();
        motBajPresPrueba.setEtiqueta(ETIQUETA_PRUEBA);
        motBajPresPrueba.setAbreviatura(ABREVIATURA_PRUEBA);

        MotivoBajaPrestamo motBajPresAdd = motivoBajaPrestamoService.save(motBajPresPrueba);
        assertNotNull(motBajPresAdd);
        assertTrue(motivoBajaPrestamoService.obtenerElementoAbreviatura(ABREVIATURA_PRUEBA) != null);

        motivoBajaPrestamoService.delete(ABREVIATURA_PRUEBA);
        try{
            motivoBajaPrestamoService.obtenerElementoAbreviatura(ABREVIATURA_PRUEBA);
        }catch (CatalogoNotFoundException e){
            assert (true);
        }

    }

}
