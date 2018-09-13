package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.ClaridadDiamante;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.RangoPeso;
import mx.com.nmp.ms.sivad.catalogo.repository.ConfiguracionCatalogoRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import static org.junit.Assert.*;


/**
 * Clase que realiza las pruebas de unidad de Claridad.
 *
 * @author roramirez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class ClaridadServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClaridadServiceTest.class);

    private static final String DOMINIO_PRUEBA = "Diamantes";
    private static final String TIPO_PRUEBA = "ClaridadDiamante";
    private static final String DESCRIPCION_PRUEBA = "Catálogo de Claridad";
    private static final String VALOR_DEFULT = "ETIQUETA_PRUEBA";
    private static final DateTime ULTIMA_ACTUALIZACION_PRUEBA = new DateTime(0L, DateTimeZone.UTC);
    private static final String ETIQUETA_PRUEBA = "ETIQUETA_PRUEBA";
    private static final String ABREVIATURA_PRUEBA = "ABREVIATURA_PRUEBA";
    private static final String ETIQUETA_PRUEBA_EDIT = "ETIQUETA_PRUEBA_EDIT";
    private static final String ABREVIATURA_PRUEBA_EDIT = "ABREVIATURA_PRUEBA_E";
    private static final Long ID_RANGO = 1L;

    @Inject
    private ClaridadDiamanteService claridadDiamanteService;

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
    public void testAgregar() {
        LOGGER.info(">> testAgregar");
        assertNotNull(configuracionCatalogo);

        //ClaridadDiamante claridadDiamante = createElement(ETIQUETA_PRUEBA, ABREVIATURA_PRUEBA);
        ClaridadDiamante claridadDiamante = new ClaridadDiamante();
        claridadDiamante.setEtiqueta(ETIQUETA_PRUEBA);
        claridadDiamante.setAbreviatura(ABREVIATURA_PRUEBA);
        ClaridadDiamante claridadAdd = claridadDiamanteService.save(claridadDiamante);

        assertNotNull(claridadAdd);
        assertEquals(ABREVIATURA_PRUEBA, claridadAdd.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA, claridadAdd.getEtiqueta());
        assertTrue(ULTIMA_ACTUALIZACION_PRUEBA.toLocalDateTime().isBefore(claridadAdd.getConfiguracion().getUltimaActualizacion().toLocalDateTime()));
    }

    /**
     * Prueba para actualizar de elementos.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_claridad-h2.sql")
    public void testActualizar() {
        LOGGER.info(">> testActualizar");

        ClaridadDiamante claridadDiamante = createElement(ETIQUETA_PRUEBA, ABREVIATURA_PRUEBA, ID_RANGO);
        ClaridadDiamante clariAdd = claridadDiamanteService.save(claridadDiamante);

        assertNotNull(clariAdd);

        ClaridadDiamante claridadDiamanteEdit = createElement(ETIQUETA_PRUEBA_EDIT, ABREVIATURA_PRUEBA_EDIT, ID_RANGO);
        ClaridadDiamante claridadUpdate =  claridadDiamanteService.update(ABREVIATURA_PRUEBA, ID_RANGO, claridadDiamanteEdit, false);

        assertEquals(ABREVIATURA_PRUEBA_EDIT, claridadUpdate.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA_EDIT, claridadUpdate.getEtiqueta());

    }

    /**
     * Prueba para eliminar elementos.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_claridad-h2.sql")
    public void testEliminar() {
        LOGGER.info(">> testEliminar");

        ClaridadDiamante claridadDiamante = createElement(ETIQUETA_PRUEBA, ABREVIATURA_PRUEBA, ID_RANGO);
        ClaridadDiamante claridadAdd = claridadDiamanteService.save(claridadDiamante);
        assertNotNull(claridadAdd);

        assertNotNull(claridadDiamanteService.get(ABREVIATURA_PRUEBA, ID_RANGO));
        claridadDiamanteService.delete(ABREVIATURA_PRUEBA, ID_RANGO);

    }

    private ClaridadDiamante createElement(String ETIQUETA, String ABREVIATURA, Long rango){
        ClaridadDiamante claridadDiamante = new ClaridadDiamante();
        claridadDiamante.setEtiqueta(ETIQUETA);
        claridadDiamante.setAbreviatura(ABREVIATURA);
        RangoPeso rangoPeso = new RangoPeso();
        rangoPeso.setIdElemento(rango);
        claridadDiamante.setRango(rangoPeso);
        return claridadDiamante;
    }


}
