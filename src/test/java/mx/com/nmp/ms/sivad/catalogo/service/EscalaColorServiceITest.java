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
    private static final Long RANGO_DEFAULT = 1L;

    private static final String ABREVIATURA_XXX = "xXx";

    private static final String ABREVIATURA_CASI_INCOLORO = "CASI_INCOLORO";

    private static final String ABREVIATURA_TEST = "TEST";
    private static final String ETIQUETA_TEST = "Test";

    @Inject
    private EscalaColorService test;

    @Test(expected = CatalogoNotFoundException.class)
    public void saveSinConfiguracionTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveSinDatosTest() {
        test.save(creatEntidad(null, null, null));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveDatosVaciosTest() {
        test.save(creatEntidad("", "", 0L));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void saveDuplicadoTest() {
        test.save(creatEntidad(ABREVIATURA_INCOLORO, ETIQUETA_INCOLORO, RANGO_DEFAULT));
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void saveTest() {
        EscalaColor result = test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT));
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
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateSinDatosNoElementoTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT), ABREVIATURA_XXX, RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateNoElementoTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT), ABREVIATURA_XXX, RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void updateDuplicadoTest() {
        test.update(creatEntidad(ABREVIATURA_CASI_INCOLORO, ETIQUETA_TEST, RANGO_DEFAULT), ABREVIATURA_INCOLORO, RANGO_DEFAULT);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void updateAbrNullTest() {
        EscalaColor result = test.update(creatEntidad(null, ETIQUETA_TEST, RANGO_DEFAULT), ABREVIATURA_INCOLORO, RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_INCOLORO);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void updateEtqNullTest() {
        EscalaColor result = test.update(creatEntidad(ABREVIATURA_TEST, null, RANGO_DEFAULT), ABREVIATURA_INCOLORO, RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_INCOLORO);
        Assert.assertNotEquals(result.getAbreviatura(), ABREVIATURA_INCOLORO);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void updateAmbNullTest() {
        EscalaColor result = test.update(creatEntidad(null, null, null), ABREVIATURA_INCOLORO, RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_INCOLORO);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_INCOLORO);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void updateTest() {
        EscalaColor result = test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT), ABREVIATURA_INCOLORO, RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosTest() {
        test.delete(ABREVIATURA_INCOLORO, RANGO_DEFAULT);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosNoElementoTest() {
        test.delete(ABREVIATURA_XXX, RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void deleteNoElementoTest() {
        test.delete(ABREVIATURA_XXX, RANGO_DEFAULT);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void deleteTest() {
        EscalaColor result = test.delete(ABREVIATURA_INCOLORO, RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_INCOLORO);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_INCOLORO);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void deleteRelacionadoTest() {
        test.delete(ABREVIATURA_CASI_INCOLORO, RANGO_DEFAULT);
        test.getAll();
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void addPadresNoElementoTest() {
        test.addPadres(ABREVIATURA_XXX, Collections.singletonList(ABREVIATURA_XXX), RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void addPadresNoPadresTest() {
        test.addPadres(ABREVIATURA_CASI_INCOLORO, Arrays.asList(ABREVIATURA_XXX, ABREVIATURA_XXX), RANGO_DEFAULT);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void addPadresNoPadreSiPadreTest() {
        EscalaColor result = test.addPadres(ABREVIATURA_CASI_INCOLORO,
            Arrays.asList(ABREVIATURA_XXX, "BLANCO_COMERCIAL", ABREVIATURA_XXX), RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPadres());
        Assert.assertEquals(result.getPadres().size(), 2);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void addPadresSiPadreTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT));
        EscalaColor result = test.addPadres(ABREVIATURA_TEST,
            Arrays.asList("BLANCO_NATURAL", "BLANCO_COMERCIAL"), RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPadres());
        Assert.assertEquals(result.getPadres().size(), 2);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void removePadresNoElementoTest() {
        test.removePadre(ABREVIATURA_XXX, ABREVIATURA_XXX, RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void removePadresNoPadreTest() {
        test.removePadre(ABREVIATURA_INCOLORO, ABREVIATURA_XXX, RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = IndexOutOfBoundsException.class)
    public void removePadresNoContienePadreTest() {
        test.removePadre(ABREVIATURA_INCOLORO, "BLANCO_COMERCIAL", RANGO_DEFAULT);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    @Test(expected = IndexOutOfBoundsException.class)
    public void removePadresPadresNullTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST, RANGO_DEFAULT));
        test.removePadre(ABREVIATURA_TEST, "COLOR_D_E", RANGO_DEFAULT);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_escala_color-h2.sql")
    public void removePadresTest() {
        test.removePadre(ABREVIATURA_INCOLORO, "COLOR_D_E", RANGO_DEFAULT);
        EscalaColor result = test.removePadre(ABREVIATURA_INCOLORO, "BLANCO_NATURAL", RANGO_DEFAULT);
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getPadres());
        Assert.assertEquals(result.getPadres().size(), 0);
    }

    private static EscalaColor creatEntidad(String abr, String etq, Long rango) {
        EscalaColor co = new EscalaColor();

        co.setAbreviatura(abr);
        co.setEtiqueta(etq);

        RangoPeso rangoPeso = new RangoPeso();
        rangoPeso.setIdElemento(rango);
        co.setRango(rangoPeso);

        return co;
    }
}
