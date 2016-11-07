/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.RangoMetal;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link RangoMetal}
 * @see RangoMetalService
 *
 * @author mmarquez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class RangoMetalServiceTest {
    private static final String ABREVIATURA_F1 = "F1";
    private static final String ETIQUETA_F1 = "Factor 1";

    private static final String ABREVIATURA_F2 = "DE";

    private static final String ABREVIATURA_XXX = "xXx";

    private static final String ABREVIATURA_TEST = "TEST";
    private static final String ETIQUETA_TEST = "Test";

    @Inject
    private RangoMetalService rangoMetalService;

    @Test(expected = CatalogoNotFoundException.class)
    public void saveSinConfiguracionTest() {
        rangoMetalService.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
    }

    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    @Test(expected = Exception.class)
    public void saveSinDatosTest() {
        rangoMetalService.save(creatEntidad(null, null));
    }

    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    @Test(expected = Exception.class)
    public void saveDatosVaciosTest() {
        rangoMetalService.save(creatEntidad("", ""));
    }

    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    @Test(expected = Exception.class)
    public void saveDuplicadoTest() {
        rangoMetalService.save(creatEntidad(ABREVIATURA_F1, ETIQUETA_F1));
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    public void saveTest() {
        RangoMetal result = rangoMetalService.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getIdElemento());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateElementoNullTest() {
        rangoMetalService.saveAndFlush(null, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateAbreviaturaObjNullTest() {
        rangoMetalService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateAbreviaturaObjVaciaTest() {
        rangoMetalService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), "  ");
    }

    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    @Test(expected = Exception.class)
    public void updateSinDatosNoElementoTest() {
        rangoMetalService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    //@Test(expected = Exception.class)
    public void updateNoElementoTest() {
        rangoMetalService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    @Test(expected = Exception.class)
    public void updateDuplicadoTest() {
        rangoMetalService.saveAndFlush(creatEntidad(ABREVIATURA_F2, ETIQUETA_TEST), ABREVIATURA_F1);
        rangoMetalService.getAll();
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    public void updateAbrNullTest() {
        RangoMetal result = rangoMetalService.saveAndFlush(creatEntidad(null, ETIQUETA_TEST), ABREVIATURA_F1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_F1);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    public void updateEtqNullTest() {
        RangoMetal result = rangoMetalService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, null), ABREVIATURA_F1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_F1);
        Assert.assertNotEquals(result.getAbreviatura(), ABREVIATURA_F1);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    public void updateAmbNullTest() {
        RangoMetal result = rangoMetalService.saveAndFlush(creatEntidad(null, null), ABREVIATURA_F1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_F1);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_F1);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    public void updateTest() {
        RangoMetal result = rangoMetalService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_F1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test(expected = Exception.class)
    public void deleteSinDatosTest() {
        rangoMetalService.delete(ABREVIATURA_F1);
    }

    @Test(expected = Exception.class)
    public void deleteSinDatosNoElementoTest() {
        rangoMetalService.delete(ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    @Test(expected = Exception.class)
    public void deleteNoElementoTest() {
        rangoMetalService.delete(ABREVIATURA_XXX);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-rango_metal-h2.sql")
    public void deleteTest() {
        rangoMetalService.delete(ABREVIATURA_F1);
    }

    private static RangoMetal creatEntidad(String abr, String etq) {
        RangoMetal rangoMetal = new RangoMetal();

        rangoMetal.setAbreviatura(abr);
        rangoMetal.setEtiqueta(etq);

        return rangoMetal;
    }
}
