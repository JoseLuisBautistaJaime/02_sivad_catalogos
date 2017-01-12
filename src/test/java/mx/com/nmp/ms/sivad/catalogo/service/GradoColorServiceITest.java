/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.GradoColor;
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

/**
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link GradoColor}
 * @see GradoColorService
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class GradoColorServiceITest {
    private static final String ABREVIATURA_D = "D";
    private static final String ETIQUETA_D = "D";

    private static final String ABREVIATURA_XXX = "xXx";

    private static final String ABREVIATURA_E = "E";

    private static final String ABREVIATURA_TEST = "TEST";
    private static final String ETIQUETA_TEST = "Test";

    @Inject
    private GradoColorService test;

    @Test(expected = CatalogoNotFoundException.class)
    public void saveSinConfiguracionTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveSinDatosTest() {
        test.save(creatEntidad(null, null));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveDatosVaciosTest() {
        test.save(creatEntidad("", ""));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void saveDuplicadoTest() {
        test.save(creatEntidad(ABREVIATURA_D, ETIQUETA_D));
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    public void saveTest() {
        GradoColor result = test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
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
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateSinDatosNoElementoTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateNoElementoTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void updateDuplicadoTest() {
        test.update(creatEntidad(ABREVIATURA_E, ETIQUETA_TEST), ABREVIATURA_D);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    public void updateAbrNullTest() {
        GradoColor result = test.update(creatEntidad(null, ETIQUETA_TEST), ABREVIATURA_D);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_D);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    public void updateEtqNullTest() {
        GradoColor result = test.update(creatEntidad(ABREVIATURA_TEST, null), ABREVIATURA_D);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_D);
        Assert.assertNotEquals(result.getAbreviatura(), ABREVIATURA_D);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    public void updateAmbNullTest() {
        GradoColor result = test.update(creatEntidad(null, null), ABREVIATURA_D);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_D);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_D);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    public void updateTest() {
        GradoColor result = test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_D);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosTest() {
        test.delete(ABREVIATURA_D);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosNoElementoTest() {
        test.delete(ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void deleteNoElementoTest() {
        test.delete(ABREVIATURA_XXX);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    public void deleteTest() {
        GradoColor result = test.delete(ABREVIATURA_D);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_D);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_D);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grado_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void deleteRelacionadoTest() {
        test.delete(ABREVIATURA_E);
        test.getAll();
    }

    private static GradoColor creatEntidad(String abr, String etq) {
        GradoColor tp = new GradoColor();

        tp.setAbreviatura(abr);
        tp.setEtiqueta(etq);

        return tp;
    }
}
