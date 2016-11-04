/**
 * Proyecto:        NMP - Microservicio de Catálogos
 * Quarksoft S.A.P.I. de C.V. – Todos los derechos reservados. Para uso exclusivo de Nacional Monte de Piedad.
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeOro;
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
 * Utilizada para probar la lógica de QuilatajeOroService.
 *
 * @author ngonzalez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class QuilatajeOroServiceTest {

    /**
     * Utilizada para manipular los mensajes informativos y de error.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(QuilatajeOroServiceTest.class);

    private static final String CAT_ABREVIATURA_AGREGAR = "24_Q";
    private static final String CAT_ABREVIATURA_DEFAULT = "14_Q";
    private static final String CAT_ABREVIATURA_DEFAULT_MODIFICAR = "12_Q";
    private static final String CAT_ABREVIATURA_MODIFICAR = "18_Q";
    private static final String CAT_ABREVIATURA_NO_EXISTE = "30_Q";

    private static final String CAT_ETIQUETA_AGREGAR = "24_Q";
    private static final String CAT_ETIQUETA_DEFAULT = "14";
    private static final String CAT_ETIQUETA_MODIFICAR = "18";

    /**
     * Referencia al servicio QuilatajeOroService.
     */
    @Inject
    private QuilatajeOroService quilatajeOroService;



    // METODOS

    /**
     * Utilizado para registrar un guardado exitoso.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void testAgregarElementoCatalogo_1() {
        LOGGER.info(">> testAgregarElementoCatalogo_1");

        try {
            QuilatajeOro quilatajeOro = crearQuilatajeOro(CAT_ABREVIATURA_AGREGAR, CAT_ETIQUETA_AGREGAR);
            List<QuilatajeOro> resultListActual = quilatajeOroService.getAll();
            QuilatajeOro result = quilatajeOroService.save(quilatajeOro);
            List<QuilatajeOro> resultListNuevo = quilatajeOroService.getAll();

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
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void testAgregarElementoCatalogo_2() {
        LOGGER.info(">> testAgregarElementoCatalogo_2");

        String etiqueta_2 = "10";

        try {
            QuilatajeOro quilatajeOroDuplicado = crearQuilatajeOro(CAT_ABREVIATURA_DEFAULT, etiqueta_2);
            quilatajeOroService.save(quilatajeOroDuplicado);
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
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void testEliminarElementoCatalogo_1() {
        LOGGER.info(">> testEliminarElementoCatalogo_1");

        try {
            quilatajeOroService.delete(CAT_ABREVIATURA_DEFAULT);
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
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void testEliminarElementoCatalogo_2() {
        LOGGER.info(">> testEliminarElementoCatalogo_2");

        try {
            quilatajeOroService.delete(CAT_ABREVIATURA_NO_EXISTE);
            fail();
        } catch (CatalogoNotFoundException e) {
            assertNotNull(e);
            assertEquals("El catalogo QuilatajeOro no contiene un elemento con la " +
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
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void testModificarElementoCatalogo_1() {
        LOGGER.info(">> testModificarElementoCatalogo_1");

        try {
            QuilatajeOro quilatajeOroMod = crearQuilatajeOro(CAT_ABREVIATURA_MODIFICAR, CAT_ETIQUETA_MODIFICAR);
            QuilatajeOro resultMod = quilatajeOroService.update(CAT_ABREVIATURA_DEFAULT, quilatajeOroMod);
            assertNotNull(resultMod);
            assertNotNull(resultMod.getIdElemento());
            assertEquals(CAT_ABREVIATURA_MODIFICAR, resultMod.getAbreviatura());
            assertEquals(CAT_ETIQUETA_MODIFICAR, resultMod.getEtiqueta());
            assertNotNull(resultMod.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }

    /**
     * Utilizado para actualizar un elemento del catálogo de forma exitosa (solo etiqueta).
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void testModificarElementoCatalogo_2() {
        LOGGER.info(">> testModificarElementoCatalogo_2");

        try {
            QuilatajeOro quilatajeOroMod = crearQuilatajeOro(null, CAT_ETIQUETA_MODIFICAR);
            QuilatajeOro resultMod = quilatajeOroService.update(CAT_ABREVIATURA_DEFAULT, quilatajeOroMod);
            assertNotNull(resultMod);
            assertNotNull(resultMod.getIdElemento());
            assertEquals(CAT_ABREVIATURA_DEFAULT, resultMod.getAbreviatura());
            assertEquals(CAT_ETIQUETA_MODIFICAR, resultMod.getEtiqueta());
            assertNotNull(resultMod.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }

    /**
     * Utilizado para actualizar un elemento del catálogo de forma exitosa (solo abreviatura).
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void testModificarElementoCatalogo_3() {
        LOGGER.info(">> testModificarElementoCatalogo_3");

        try {
            QuilatajeOro quilatajeOroMod = crearQuilatajeOro(CAT_ABREVIATURA_MODIFICAR, null);
            QuilatajeOro resultMod = quilatajeOroService.update(CAT_ABREVIATURA_DEFAULT, quilatajeOroMod);
            assertNotNull(resultMod);
            assertNotNull(resultMod.getIdElemento());
            assertEquals(CAT_ABREVIATURA_MODIFICAR, resultMod.getAbreviatura());
            assertEquals(CAT_ETIQUETA_DEFAULT, resultMod.getEtiqueta());
            assertNotNull(resultMod.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }

    /**
     * Utilizado para actualizar un elemento del catálogo de forma exitosa (abreviatura existente).
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void testModificarElementoCatalogo_4() {
        LOGGER.info(">> testModificarElementoCatalogo_4");

        try {
            QuilatajeOro quilatajeOroMod = crearQuilatajeOro(CAT_ABREVIATURA_DEFAULT_MODIFICAR, null);
            quilatajeOroService.update(CAT_ABREVIATURA_DEFAULT, quilatajeOroMod);
            fail();
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
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
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void testObtenerElementoCatalogo_1() {
        LOGGER.info(">> testObtenerElementoCatalogo_1");

        try {
            QuilatajeOro result = quilatajeOroService.get(CAT_ABREVIATURA_DEFAULT);
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
     * Utilizado para obtener un elemento del catálogo de forma fallida.
     */
    @Test
    @Transactional
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void testObtenerElementoCatalogo_2() {
        LOGGER.info(">> testObtenerElementoCatalogo_2");

        try {
            quilatajeOroService.get(CAT_ABREVIATURA_NO_EXISTE);
            fail();
        } catch (CatalogoNotFoundException e) {
            assertNotNull(e);
            assertEquals("El catalogo QuilatajeOro no contiene un elemento con la " +
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
    @Sql("/bd/test-data-quilataje-oro-h2.sql")
    public void testObtenerTodosElementosCatalogo_1() {
        LOGGER.info(">> testObtenerTodosElementosCatalogo_1");

        List<QuilatajeOro> result = quilatajeOroService.getAll();
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
    public void testObtenerTodosElementosCatalogo_2() {
        LOGGER.info(">> testObtenerTodosElementosCatalogo_2");

        List<QuilatajeOro> result = quilatajeOroService.getAll();
        assertNotNull(result);
        assertTrue(result.size() == 0);
    }

    /**
     * Metodo auxiliar utilizado para crear una instancia de la clase QuilatajeOro.
     *
     * @param abreviatura La abreviatura.
     * @param etiqueta La etiqueta.
     * @return La instancia creada.
     */
    private QuilatajeOro crearQuilatajeOro(String abreviatura, String etiqueta) {
        QuilatajeOro quilatajeOro = new QuilatajeOro();
        quilatajeOro.setAbreviatura(abreviatura);
        quilatajeOro.setEtiqueta(etiqueta);
        return quilatajeOro;
    }

}