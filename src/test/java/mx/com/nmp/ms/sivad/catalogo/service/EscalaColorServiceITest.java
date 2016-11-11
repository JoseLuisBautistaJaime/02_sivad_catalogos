/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.EscalaColor;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.Collections;

/**
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link EscalaColor}
 * @see EscalaColorService
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class EscalaColorServiceITest {
    private static final String ABREVIATURA_INCOLORO = "INCOLORO";
    private static final String ETIQUETA_INCOLORO = "Incoloro";

    private static final String ABREVIATURA_XXX = "xXx";

    private static final String ABREVIATURA_CASI_INCOLORO = "CASI_INCOLORO";

    private static final String ABREVIATURA_TEST = "TEST";
    private static final String ETIQUETA_TEST = "Test";

    @Inject
    private EscalaColorService test;

    @Test(expected = CatalogoNotFoundException.class)
    public void saveSinConfiguracionTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveSinDatosTest() {
        test.save(creatEntidad(null, null));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveDatosVaciosTest() {
        test.save(creatEntidad("", ""));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void saveDuplicadoTest() {
        test.save(creatEntidad(ABREVIATURA_INCOLORO, ETIQUETA_INCOLORO));
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void saveTest() {
        EscalaColor result = test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getIdElemento());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateElementoNullTest() {
        test.update(null, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateAbreviaturaObjNullTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateAbreviaturaObjVaciaTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), "  ");
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateSinDatosNoElementoTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateNoElementoTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void updateDuplicadoTest() {
        test.update(creatEntidad(ABREVIATURA_CASI_INCOLORO, ETIQUETA_TEST), ABREVIATURA_INCOLORO);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void updateAbrNullTest() {
        EscalaColor result = test.update(creatEntidad(null, ETIQUETA_TEST), ABREVIATURA_INCOLORO);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_INCOLORO);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void updateEtqNullTest() {
        EscalaColor result = test.update(creatEntidad(ABREVIATURA_TEST, null), ABREVIATURA_INCOLORO);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_INCOLORO);
        Assert.assertNotEquals(result.getAbreviatura(), ABREVIATURA_INCOLORO);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void updateAmbNullTest() {
        EscalaColor result = test.update(creatEntidad(null, null), ABREVIATURA_INCOLORO);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_INCOLORO);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_INCOLORO);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void updateTest() {
        EscalaColor result = test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_INCOLORO);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosTest() {
        test.delete(ABREVIATURA_INCOLORO);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosNoElementoTest() {
        test.delete(ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void deleteNoElementoTest() {
        test.delete(ABREVIATURA_XXX);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void deleteTest() {
        EscalaColor result = test.delete(ABREVIATURA_INCOLORO);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_INCOLORO);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_INCOLORO);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void deleteRelacionadoTest() {
        test.delete(ABREVIATURA_CASI_INCOLORO);
        test.getAll();
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void addPadresNoElementoTest() {
        test.addPadres(ABREVIATURA_XXX, Collections.singletonList(ABREVIATURA_XXX));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void addPadresNoPadresTest() {
        test.addPadres(ABREVIATURA_CASI_INCOLORO, Arrays.asList(ABREVIATURA_XXX, ABREVIATURA_XXX));
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void addPadresNoPadreSiPadreTest() {
        EscalaColor result = test.addPadres(ABREVIATURA_CASI_INCOLORO,
            Arrays.asList(ABREVIATURA_XXX, "BLANCO_COMERCIAL", ABREVIATURA_XXX));
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPadres());
        Assert.assertEquals(result.getPadres().size(), 2);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void addPadresSiPadreTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
        EscalaColor result = test.addPadres(ABREVIATURA_TEST,
            Arrays.asList("BLANCO_NATURAL", "BLANCO_COMERCIAL"));
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPadres());
        Assert.assertEquals(result.getPadres().size(), 2);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void removePadresNoElementoTest() {
        test.removePadre(ABREVIATURA_XXX, ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void removePadresNoPadreTest() {
        test.removePadre(ABREVIATURA_INCOLORO, ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = IndexOutOfBoundsException.class)
    public void removePadresNoContienePadreTest() {
        test.removePadre(ABREVIATURA_INCOLORO, "BLANCO_COMERCIAL");
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = IndexOutOfBoundsException.class)
    public void removePadresPadresNullTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
        test.removePadre(ABREVIATURA_TEST, "COLOR_D_E");
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void removePadresTest() {
        test.removePadre(ABREVIATURA_INCOLORO, "COLOR_D_E");
        EscalaColor result = test.removePadre(ABREVIATURA_INCOLORO, "BLANCO_NATURAL");
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPadres());
        Assert.assertEquals(result.getPadres().size(), 0);
    }

    private static EscalaColor creatEntidad(String abr, String etq) {
        EscalaColor co = new EscalaColor();

        co.setAbreviatura(abr);
        co.setEtiqueta(etq);

        return co;
    }
}