/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.RangoOro;
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
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link RangoOro}
 * @see RangoOroService
 *
 * @author mmarquez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class RangoOroServiceTest {
    private static final String ABREVIATURA_F1 = "F1";
    private static final String ETIQUETA_F1 = "Pedaceria y Piezas Rotas";

    private static final String ABREVIATURA_F2 = "F2";
    private static final String ETIQUETA_F2 = "Buen Estado Personalizadas";

    private static final String ABREVIATURA_XXX = "xXx";

    private static final String ABREVIATURA_TEST = "TEST";
    private static final String ETIQUETA_TEST = "Test";

    @Inject
    private RangoOroService rangoOroService;

    @Test(expected = CatalogoNotFoundException.class)
    public void saveSinConfiguracionTest() {
        rangoOroService.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
    }

    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveSinDatosTest() {
        rangoOroService.save(creatEntidad(null, null));
    }

    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveDatosVaciosTest() {
        rangoOroService.save(creatEntidad("", ""));
    }

    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void saveDuplicadoTest() {
        rangoOroService.save(creatEntidad(ABREVIATURA_F1, ETIQUETA_F1));
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    public void saveTest() {
        RangoOro result = rangoOroService.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getIdElemento());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateElementoNullTest() {
        rangoOroService.saveAndFlush(null, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateAbreviaturaObjNullTest() {
        rangoOroService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateAbreviaturaObjVaciaTest() {
        rangoOroService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), "  ");
    }

    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateSinDatosNoElementoTest() {
        rangoOroService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateNoElementoTest() {
        rangoOroService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void updateDuplicadoTest() {
        rangoOroService.saveAndFlush(creatEntidad(ABREVIATURA_F2, ETIQUETA_TEST), ABREVIATURA_F1);
        rangoOroService.getAll();
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    public void updateAbrNullTest() {
        RangoOro result = rangoOroService.saveAndFlush(creatEntidad(null, ETIQUETA_TEST), ABREVIATURA_F1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_F1);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    public void updateEtqNullTest() {
        RangoOro result = rangoOroService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, null), ABREVIATURA_F1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_F1);
        Assert.assertNotEquals(result.getAbreviatura(), ABREVIATURA_F1);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    public void updateAmbNullTest() {
        RangoOro result = rangoOroService.saveAndFlush(creatEntidad(null, null), ABREVIATURA_F1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_F1);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_F1);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    public void updateTest() {
        RangoOro result = rangoOroService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_F1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosTest() {
        rangoOroService.delete(ABREVIATURA_F1);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosNoElementoTest() {
        rangoOroService.delete(ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void deleteNoElementoTest() {
        rangoOroService.delete(ABREVIATURA_XXX);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-rango_oro-h2.sql")
    public void deleteTest() {
        rangoOroService.delete(ABREVIATURA_F1);
    }

    private static RangoOro creatEntidad(String abr, String etq) {
        RangoOro rangoOro = new RangoOro();

        rangoOro.setAbreviatura(abr);
        rangoOro.setEtiqueta(etq);

        return rangoOro;
    }
}
