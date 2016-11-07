/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeDiamante;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Utilizada para probar la los metodos dela clase QuilatajeDiamanteService.
 *
 * @author jbautista
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class QuilatajeDiamanteServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuilatajeDiamanteServiceTest.class);

    private static final String CAT_ABREVIATURA_AGREGAR = "0.75_Q";
    private static final String CAT_ABREVIATURA_DEFAULT = "0.25_Q";
    private static final String CAT_ABREVIATURA_DEFAULT_MODIFICAR = "0.5_Q";
    private static final String CAT_ABREVIATURA_MODIFICAR = "0.6_Q";
    private static final String CAT_ABREVIATURA_NO_EXISTE = "0.55_Q";

    private static final String CAT_ETIQUETA_AGREGAR = "0.75";
    private static final String CAT_ETIQUETA_DEFAULT = "0.25";
    private static final String CAT_ETIQUETA_MODIFICAR = "0.6";

    @Inject
    private QuilatajeDiamanteService quilatajeDiamanteService;

    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void testAgregarQuilatajeDiamante() {
        LOGGER.info(">> testAgregarQuilatajeDiamante");

        try {
            QuilatajeDiamante quilatajeDiamante = crearQuilatajeDiamante(CAT_ABREVIATURA_AGREGAR, CAT_ETIQUETA_AGREGAR);
            List<QuilatajeDiamante> resultListActual = quilatajeDiamanteService.getAll();
            QuilatajeDiamante result = quilatajeDiamanteService.save(quilatajeDiamante);
            List<QuilatajeDiamante> resultListNuevo = quilatajeDiamanteService.getAll();

            assertNotNull(result);
            assertNotNull(result.getIdElemento());
            assertEquals(CAT_ABREVIATURA_AGREGAR, result.getAbreviatura());
            assertEquals(CAT_ETIQUETA_AGREGAR, result.getEtiqueta());
            assertNotNull(result.getConfiguracion());
            assertEquals(resultListActual.size() + 1, resultListNuevo.size());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }

    /**
     * Utilizado para registrar un guardado fallido.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void testAgregarQuilatajeDiamanteNoDumplicado() {
        LOGGER.info(">> testAgregarQuilatajeDiamanteNoDumplicado");

        String etiqueta_duplic = "0.75";

        try {
            QuilatajeDiamante quilatajeDiamanteDuplicado = crearQuilatajeDiamante(CAT_ABREVIATURA_DEFAULT, etiqueta_duplic);
            quilatajeDiamanteService.save(quilatajeDiamanteDuplicado);
            fail();
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }

    /**
     * Utilizado para eliminar un elemento del catálogo exitosamente.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void testEliminarQuilatajeDiamante() {
        LOGGER.info(">> testEliminarQuilatajeDiamante");

        try {
            quilatajeDiamanteService.delete(CAT_ABREVIATURA_DEFAULT);
            assertTrue(true);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }

    /**
     * Utilizado para eliminar un elemento del catálogo de forma fallida.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void testEliminarQuilatajeDiamanteNoExiste() {
        LOGGER.info(">> testEliminarQuilatajeDiamanteNoExiste");

        try {
            quilatajeDiamanteService.delete(CAT_ABREVIATURA_NO_EXISTE);
            fail();
        } catch (CatalogoNotFoundException e) {
            assertNotNull(e);
            assertEquals("El catalogo QuilatajeDiamante no contiene un elemento con la " +
                "abreviatura: [" + CAT_ABREVIATURA_NO_EXISTE + "].", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }

    /**
     * Utilizado para actualizar un elemento del catálogo de forma exitosa (abreviatura y etiqueta).
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void testModificarQuilatajeDiamante() {
        LOGGER.info(">> testModificarQuilatajeDiamante");

        try {
            QuilatajeDiamante quilatajeDiamanteMod = crearQuilatajeDiamante(CAT_ABREVIATURA_MODIFICAR, CAT_ETIQUETA_MODIFICAR);
            QuilatajeDiamante resultModif = quilatajeDiamanteService.update(CAT_ABREVIATURA_DEFAULT, quilatajeDiamanteMod);
            assertNotNull(resultModif);
            assertNotNull(resultModif.getIdElemento());
            assertEquals(CAT_ABREVIATURA_MODIFICAR, resultModif.getAbreviatura());
            assertEquals(CAT_ETIQUETA_MODIFICAR, resultModif.getEtiqueta());
            assertNotNull(resultModif.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }

    /**
     * Utilizado para obtener un elemento del catálogo de forma exitosa.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void testObtenerQuilatajeDiamante() {
        LOGGER.info(">> testObtenerQuilatajeDiamante");

        try {
            QuilatajeDiamante result = quilatajeDiamanteService.get(CAT_ABREVIATURA_DEFAULT);
            assertNotNull(result);
            assertNotNull(result.getIdElemento());
            assertEquals(CAT_ABREVIATURA_DEFAULT, result.getAbreviatura());
            assertEquals(CAT_ETIQUETA_DEFAULT, result.getEtiqueta());
            assertNotNull(result.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }

    /**
     * Utilizado para obtener un elemento del catalogo de forma fallida.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void testObtenerQuilatajeDiamanteFail() {
        LOGGER.info(">> testObtenerQuilatajeDiamanteFail");

        try {
            quilatajeDiamanteService.get(CAT_ABREVIATURA_NO_EXISTE);
            fail();
        } catch (CatalogoNotFoundException e) {
            assertNotNull(e);
            assertEquals("El catalogo QuilatajeDiamante no contiene un elemento con la " +
                "abreviatura: [" + CAT_ABREVIATURA_NO_EXISTE + "].", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }

    /**
     * Utilizado para obtener todos los elementos del catálogo.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-diamante-h2-2.sql")
    public void testObtenerQuilatajesDiamante() {
        LOGGER.info(">> testObtenerQuilatajesDiamante");

        List<QuilatajeDiamante> result = quilatajeDiamanteService.getAll();
        assertNotNull(result);
        assertTrue(result.size() > 0);

        for (int x = 0; x < result.size(); x++) {
            LOGGER.debug("Abreviatura: [{}]", result.get(x).getAbreviatura());
            LOGGER.debug("Etiqueta: [{}]", result.get(x).getEtiqueta());
        }
    }

    /**
     * Utilizado para obtener todos los elementos del catálogo (sin elementos).
     */
    @Test
    @Transactional
    public void testObtenerQuilatajesDiamanteSinElementos() {
        LOGGER.info(">> testObtenerQuilatajesDiamanteSinElementos");

        List<QuilatajeDiamante> result = quilatajeDiamanteService.getAll();
        assertNotNull(result);
        assertTrue(result.size() == 0);
    }

    /**
     * Metodo auxiliar utilizado para crear una instancia de la clase QuilatajeDiamante.
     *
     * @param abreviatura La abreviatura.
     * @param etiqueta La etiqueta.
     * @return La instancia creada.
     */
    private QuilatajeDiamante crearQuilatajeDiamante(String abreviatura, String etiqueta) {
        QuilatajeDiamante quilatajeDiamante = new QuilatajeDiamante();
        quilatajeDiamante.setAbreviatura(abreviatura);
        quilatajeDiamante.setEtiqueta(etiqueta);
        return quilatajeDiamante;
    }

}
