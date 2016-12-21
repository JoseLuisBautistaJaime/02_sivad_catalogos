package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.TipoPiedraComplementaria;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Clase que realiza las pruebas de unidad de Claridad.
 *
 * @author roramirez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class PiedraComplementariaServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClaridadServiceTest.class);

    private static final String DOMINIO_PRUEBA = "Diamantes";
    private static final String TIPO_PRUEBA = "TipoPiedraComplementaria";
    private static final String DESCRIPCION_PRUEBA = "Catálogo de tipo piedra complementaria ";
    private static final String VALOR_DEFULT = "ETIQUETA_PRUEBA";
    private static final DateTime ULTIMA_ACTUALIZACION_PRUEBA = new DateTime(0L, DateTimeZone.UTC);
    private static final String ETIQUETA_PRUEBA = "ETIQUETA_PRUEBA";
    private static final String ABREVIATURA_PRUEBA = "ABREVIATURA_PRUEBA";
    private static final String ETIQUETA_PRUEBA_EDIT = "ETIQUETA_PRUEBA_EDIT";
    private static final String ABREVIATURA_PRUEBA_EDIT = "ABREVIATURA_PRUEBA_E";

    @Inject
    private TipoPiedraComplementariaService tipoPiedraComplementariaService;

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

        TipoPiedraComplementaria tipoPiedraComplementaria = createElement(ETIQUETA_PRUEBA, ABREVIATURA_PRUEBA);
        TipoPiedraComplementaria complementariaAdd = tipoPiedraComplementariaService.save(tipoPiedraComplementaria);

        assertNotNull(complementariaAdd);
        assertEquals(ABREVIATURA_PRUEBA, complementariaAdd.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA, complementariaAdd.getEtiqueta());
        assertTrue(ULTIMA_ACTUALIZACION_PRUEBA.toLocalDateTime().isBefore(complementariaAdd.getConfiguracion().getUltimaActualizacion().toLocalDateTime()));

    }

    /**
     * Prueba para actualizar de elementos.
     */
    @Test
    @Transactional
    public void testActualizar() {
        LOGGER.info(">> testActualizar");

        TipoPiedraComplementaria tipoPiedraComplementaria = createElement(ETIQUETA_PRUEBA, ABREVIATURA_PRUEBA);
        TipoPiedraComplementaria compleAdd = tipoPiedraComplementariaService.save(tipoPiedraComplementaria);

        assertNotNull(compleAdd);

        TipoPiedraComplementaria tipoPiedraComplementariaEdit = createElement(ETIQUETA_PRUEBA_EDIT, ABREVIATURA_PRUEBA_EDIT);
        TipoPiedraComplementaria tipoPiedraUpdate =  tipoPiedraComplementariaService.update(ABREVIATURA_PRUEBA, tipoPiedraComplementariaEdit );

        assertEquals(ABREVIATURA_PRUEBA_EDIT, tipoPiedraUpdate.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA_EDIT, tipoPiedraUpdate.getEtiqueta());

    }

    /**
     * Prueba para eliminar elementos.
     */
    @Test
    @Transactional
    public void testEliminar() {
        LOGGER.info(">> testEliminar");

        TipoPiedraComplementaria tipoPiedraComplementaria = createElement(ETIQUETA_PRUEBA, ABREVIATURA_PRUEBA);
        TipoPiedraComplementaria complAdd = tipoPiedraComplementariaService.save(tipoPiedraComplementaria);
        assertNotNull(complAdd);

        assertNotNull(tipoPiedraComplementariaService.get(ABREVIATURA_PRUEBA));
        tipoPiedraComplementariaService.delete(ABREVIATURA_PRUEBA);
    }

    public TipoPiedraComplementaria createElement(String ETIQUETA, String ABREVIATURA ){
        TipoPiedraComplementaria tipoPiedraComplementaria = new TipoPiedraComplementaria();
            tipoPiedraComplementaria.setEtiqueta(ETIQUETA);
            tipoPiedraComplementaria.setAbreviatura(ABREVIATURA);
        return tipoPiedraComplementaria;
    }
}
