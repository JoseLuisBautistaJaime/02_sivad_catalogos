package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.CertificadoDiamantes;
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
 * Clase que realiza las pruebas de unidad de Claridad.
 *
 * @author roramirez
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class CertificadoDiamantesServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CertificadoDiamantesServiceTest.class);

    private static final String DOMINIO_PRUEBA = "Diamantes";
    private static final String TIPO_PRUEBA = "CertificadoDiamantes";
    private static final String DESCRIPCION_PRUEBA = "Catálogo de Certificado Diamantes";
    private static final String VALOR_DEFULT = "ETIQUETA_PRUEBA";
    private static final DateTime ULTIMA_ACTUALIZACION_PRUEBA = new DateTime(0L, DateTimeZone.UTC);
    private static final String ETIQUETA_PRUEBA = "ETIQUETA_PRUEBA";
    private static final String ABREVIATURA_PRUEBA = "ABREVIATURA_PRUEBA";
    private static final String ETIQUETA_PRUEBA_EDIT = "ETIQUETA_PRUEBA_EDIT";
    private static final String ABREVIATURA_PRUEBA_EDIT = "ABREVIATURA_PRUEBA_EDIT";

    @Inject
    private CertificadoDiamantesService certificadoDiamantesService;

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
        assertNotNull(configuracionCatalogo);

        CertificadoDiamantes certificadoDiamantes = createElement(ETIQUETA_PRUEBA, ABREVIATURA_PRUEBA);
        CertificadoDiamantes certificadoAdd = certificadoDiamantesService.save(certificadoDiamantes);

        assertNotNull(certificadoAdd);
        assertEquals(ABREVIATURA_PRUEBA, certificadoAdd.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA, certificadoAdd.getEtiqueta());
        assertTrue(ULTIMA_ACTUALIZACION_PRUEBA.toLocalDateTime().isBefore(certificadoAdd.getConfiguracion().getUltimaActualizacion().toLocalDateTime()));

    }

    /**
     * Prueba para actualizar de elementos.
     */
    @Test
    @Transactional
    public void testActualizar() {
        LOGGER.info(">> testActualizar");

        CertificadoDiamantes certificadoDiamantes = createElement(ETIQUETA_PRUEBA, ABREVIATURA_PRUEBA);
        CertificadoDiamantes certAdd = certificadoDiamantesService.save(certificadoDiamantes);

        assertNotNull(certAdd);

        CertificadoDiamantes certificadoDiamantesEdit = createElement(ETIQUETA_PRUEBA_EDIT, ABREVIATURA_PRUEBA_EDIT);
        CertificadoDiamantes certUpdate =  certificadoDiamantesService.update(ABREVIATURA_PRUEBA, certificadoDiamantesEdit );

        assertEquals(ABREVIATURA_PRUEBA_EDIT, certUpdate.getAbreviatura());
        assertEquals(ETIQUETA_PRUEBA_EDIT, certUpdate.getEtiqueta());

    }

    /**
     * Prueba para eliminar elementos.
     */
    @Test
    @Transactional
    public void testEliminar() {
        LOGGER.info(">> testEliminar");

        CertificadoDiamantes certificadoDiamantes = createElement(ETIQUETA_PRUEBA, ABREVIATURA_PRUEBA);
        CertificadoDiamantes certAdd = certificadoDiamantesService.save(certificadoDiamantes);
        assertNotNull(certAdd);

        assertNotNull(certificadoDiamantesService.get(ABREVIATURA_PRUEBA));
        certificadoDiamantesService.delete(ABREVIATURA_PRUEBA);

    }

    public CertificadoDiamantes createElement(String ETIQUETA, String ABREVIATURA ){
        CertificadoDiamantes certificadoDiamantes = new CertificadoDiamantes();
        certificadoDiamantes.setEtiqueta(ETIQUETA);
        certificadoDiamantes.setAbreviatura(ABREVIATURA);
        return certificadoDiamantes;
    }
}
