/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.GrupoColor;
import mx.com.nmp.ms.sivad.catalogo.domain.RangoPeso;
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
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link GrupoColor}
 * @see EscalaColorService
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class GrupoColorServiceITest {
    private static final String ABREVIATURA_D_E = "D_E";
    private static final String ETIQUETA_D_E = "D-E";
    private static final Long RANGO_DEFAULT = 1L;

    private static final String ABREVIATURA_XXX = "xXx";

    private static final String ABREVIATURA_F_G = "F_G";

    private static final String ABREVIATURA_TEST = "TEST";
    private static final String ETIQUETA_TEST = "Test";

    @Inject
    private GrupoColorService test;

    @Test(expected = CatalogoNotFoundException.class)
    public void saveSinConfiguracionTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveSinDatosTest() {
        test.save(creatEntidad(null, null, null));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveDatosVaciosTest() {
        test.save(creatEntidad("", "", 0L));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void saveDuplicadoTest() {
        test.save(creatEntidad(ABREVIATURA_D_E, ETIQUETA_D_E, RANGO_DEFAULT));
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    public void saveTest() {
        GrupoColor result = test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT));
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getIdElemento());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateElementoNullTest() {
        test.update(null, "", RANGO_DEFAULT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateAbreviaturaObjNullTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT), null, RANGO_DEFAULT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateAbreviaturaObjVaciaTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT), "  ", RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateSinDatosNoElementoTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT), ABREVIATURA_XXX, RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateNoElementoTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT), ABREVIATURA_XXX, RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void updateDuplicadoTest() {
        test.update(creatEntidad(ABREVIATURA_F_G, ETIQUETA_TEST, RANGO_DEFAULT), ABREVIATURA_D_E, RANGO_DEFAULT);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    public void updateAbrNullTest() {
        GrupoColor result = test.update(creatEntidad(null, ETIQUETA_TEST, null), ABREVIATURA_D_E, RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_D_E);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    public void updateEtqNullTest() {
        GrupoColor result = test.update(creatEntidad(ABREVIATURA_TEST, null, null), ABREVIATURA_D_E, RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_D_E);
        Assert.assertNotEquals(result.getAbreviatura(), ABREVIATURA_D_E);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    public void updateAmbNullTest() {
        GrupoColor result = test.update(creatEntidad(null, null, null), ABREVIATURA_D_E, RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_D_E);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_D_E);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    public void updateTest() {
        GrupoColor result = test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT), ABREVIATURA_D_E, RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosTest() {
        test.delete(ABREVIATURA_D_E, RANGO_DEFAULT);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosNoElementoTest() {
        test.delete(ABREVIATURA_XXX, RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void deleteNoElementoTest() {
        test.delete(ABREVIATURA_XXX, RANGO_DEFAULT);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    public void deleteTest() {
        GrupoColor result = test.delete(ABREVIATURA_D_E, RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_D_E);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_D_E);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void addPadresNoElementoTest() {
        test.addPadres(ABREVIATURA_XXX, Collections.singletonList(ABREVIATURA_XXX), RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void addPadresNoPadresTest() {
        test.addPadres(ABREVIATURA_F_G, Arrays.asList(ABREVIATURA_XXX, ABREVIATURA_XXX), RANGO_DEFAULT);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    public void addPadresNoPadreSiPadreTest() {
        GrupoColor result = test.addPadres(ABREVIATURA_F_G,
            Arrays.asList(ABREVIATURA_XXX, "AMARILLO_TENUE", ABREVIATURA_XXX), RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPadres());
        Assert.assertEquals(result.getPadres().size(), 3);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    public void addPadresSiPadreTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT));
        GrupoColor result = test.addPadres(ABREVIATURA_TEST,
            Arrays.asList("CASI_INCOLORO", "AMARILLO_TENUE"), RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPadres());
        Assert.assertEquals(result.getPadres().size(), 2);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void removePadresNoElementoTest() {
        test.removePadre(ABREVIATURA_XXX, ABREVIATURA_XXX, RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void removePadresNoPadreTest() {
        test.removePadre(ABREVIATURA_D_E, ABREVIATURA_XXX, RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = IndexOutOfBoundsException.class)
    public void removePadresNoContienePadreTest() {
        test.removePadre(ABREVIATURA_D_E, "AMARILLO_TENUE", RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    @Test(expected = IndexOutOfBoundsException.class)
    public void removePadresPadresNullTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT));
        test.removePadre(ABREVIATURA_TEST, "AMARILLO_TENUE", RANGO_DEFAULT);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_grupo_color-h2.sql")
    public void removePadresTest() {
        GrupoColor result = test.removePadre(ABREVIATURA_D_E, "INCOLORO", RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPadres());
        Assert.assertEquals(result.getPadres().size(), 0);
    }

    private static GrupoColor creatEntidad(String abr, String etq, Long rango) {
        GrupoColor co = new GrupoColor();

        co.setAbreviatura(abr);
        co.setEtiqueta(etq);

        RangoPeso rangoPeso = new RangoPeso();
        rangoPeso.setIdElemento(rango);
        co.setRango(rangoPeso);

        return co;
    }
}
