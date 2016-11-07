/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.Color;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link Color}
 * @see ColorService
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class ColorServiceITest {
    private static final String ABREVIATURA_COLOR_D_E = "COLOR_D_E";
    private static final String ETIQUETA_COLOR_D_E = "";

    private static final String ABREVIATURA_XXX = "xXx";

    private static final String ABREVIATURA_BLANCO_NATURAL = "BLANCO_NATURAL";

    private static final String ABREVIATURA_TEST = "TEST";
    private static final String ETIQUETA_TEST = "Test";

    @Inject
    private  ColorService test;

    @Test(expected = CatalogoNotFoundException.class)
    public void saveSinConfiguracionTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveSinDatosTest() {
        test.save(creatEntidad(null, null));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveDatosVaciosTest() {
        test.save(creatEntidad("", ""));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void saveDuplicadoTest() {
        test.save(creatEntidad(ABREVIATURA_COLOR_D_E, ETIQUETA_COLOR_D_E));
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    public void saveTest() {
        Color result = test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
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
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateSinDatosNoElementoTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateNoElementoTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void updateDuplicadoTest() {
        test.update(creatEntidad(ABREVIATURA_BLANCO_NATURAL, ETIQUETA_TEST), ABREVIATURA_COLOR_D_E);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    public void updateAbrNullTest() {
        Color result = test.update(creatEntidad(null, ETIQUETA_TEST), ABREVIATURA_COLOR_D_E);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_COLOR_D_E);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    public void updateEtqNullTest() {
        Color result = test.update(creatEntidad(ABREVIATURA_TEST, null), ABREVIATURA_COLOR_D_E);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_COLOR_D_E);
        Assert.assertNotEquals(result.getAbreviatura(), ABREVIATURA_COLOR_D_E);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    public void updateAmbNullTest() {
        Color result = test.update(creatEntidad(null, null), ABREVIATURA_COLOR_D_E);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_COLOR_D_E);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_COLOR_D_E);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    public void updateTest() {
        Color result = test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_COLOR_D_E);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosTest() {
        test.delete(ABREVIATURA_COLOR_D_E);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosNoElementoTest() {
        test.delete(ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void deleteNoElementoTest() {
        test.delete(ABREVIATURA_XXX);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    public void deleteTest() {
        Color result = test.delete(ABREVIATURA_COLOR_D_E);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_COLOR_D_E);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_COLOR_D_E);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void deleteRelacionadoTest() {
        test.delete(ABREVIATURA_BLANCO_NATURAL);
        test.getAll();
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void addPadresNoElementoTest() {
        test.addPadres(ABREVIATURA_XXX, Collections.singletonList(ABREVIATURA_XXX));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void addPadresNoPadresTest() {
        test.addPadres(ABREVIATURA_BLANCO_NATURAL, Arrays.asList(ABREVIATURA_XXX, ABREVIATURA_XXX));
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    public void addPadresNoPadreSiPadreTest() {
        Color result = test.addPadres(ABREVIATURA_BLANCO_NATURAL,
            Arrays.asList(ABREVIATURA_XXX, "GRADO_COLOR_D", ABREVIATURA_XXX));
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPadres());
        Assert.assertEquals(result.getPadres().size(), 3);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    public void addPadresSiPadreTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
        Color result = test.addPadres(ABREVIATURA_TEST,
            Arrays.asList("GRADO_COLOR_D", "GRADO_COLOR_E"));
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPadres());
        Assert.assertEquals(result.getPadres().size(), 2);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void removePadresNoElementoTest() {
        test.removePadre(ABREVIATURA_XXX, ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void removePadresNoPadreTest() {
        test.removePadre(ABREVIATURA_COLOR_D_E, ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = IndexOutOfBoundsException.class)
    public void removePadresNoContienePadreTest() {
        test.removePadre(ABREVIATURA_COLOR_D_E, "GRADO_COLOR_F");
    }

    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    @Test(expected = IndexOutOfBoundsException.class)
    public void removePadresPadresNullTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
        test.removePadre(ABREVIATURA_TEST, "GRADO_COLOR_F");
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_color-h2.sql")
    public void removePadresTest() {
        test.removePadre(ABREVIATURA_BLANCO_NATURAL, "GRADO_COLOR_F");
        Color result = test.removePadre(ABREVIATURA_BLANCO_NATURAL, "GRADO_COLOR_G");
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPadres());
        Assert.assertEquals(result.getPadres().size(), 0);
    }

    private static Color creatEntidad(String abr, String etq) {
        Color co = new Color();

        co.setAbreviatura(abr);
        co.setEtiqueta(etq);

        return co;
    }
}
