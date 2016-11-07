/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.Corte;
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataIntegrityViolationException;

import javax.inject.Inject;

/**
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link Corte}
 * @see CorteService
 *
 * @author mmarquez
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class CorteServiceTest {
    private static final String ABREVIATURA_F1 = "BR";
    private static final String ETIQUETA_F1 = "Brillante";

    private static final String ABREVIATURA_F2 = "PR";
    private static final String ETIQUETA_F2 = "Princesa";

    private static final String ABREVIATURA_XXX = "xXx";

    private static final String ABREVIATURA_TEST = "TEST";
    private static final String ETIQUETA_TEST = "Test";

    @Inject
    private CorteService corteService;

    @Test(expected = CatalogoNotFoundException.class)
    public void saveSinConfiguracionTest() {
        corteService.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
    }

    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    @Test(expected = Exception.class)
    public void saveSinDatosTest() {
        corteService.save(creatEntidad(null, null));
    }

    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    @Test(expected = Exception.class)
    public void saveDatosVaciosTest() {
        corteService.save(creatEntidad("", ""));
    }

    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void saveDuplicadoTest() {
        corteService.save(creatEntidad(ABREVIATURA_F1, ETIQUETA_F1));
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    public void saveTest() {
        Corte result = corteService.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getIdElemento());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateElementoNullTest() {
        corteService.saveAndFlush(null, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateAbreviaturaObjNullTest() {
        corteService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateAbreviaturaObjVaciaTest() {
        corteService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), "  ");
    }

    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    @Test(expected = Exception.class)
    public void updateSinDatosNoElementoTest() {
        corteService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    @Test(expected = Exception.class)
    public void updateNoElementoTest() {
        corteService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    @Test(expected = Exception.class)
    public void updateDuplicadoTest() {
        corteService.saveAndFlush(creatEntidad(ABREVIATURA_F2, ETIQUETA_TEST), ABREVIATURA_F1);
        corteService.getAll();
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    public void updateAbrNullTest() {
        Corte result = corteService.saveAndFlush(creatEntidad(null, ETIQUETA_TEST), ABREVIATURA_F1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_F1);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    public void updateEtqNullTest() {
        Corte result = corteService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, null), ABREVIATURA_F1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_F1);
        Assert.assertNotEquals(result.getAbreviatura(), ABREVIATURA_F1);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    public void updateAmbNullTest() {
        Corte result = corteService.saveAndFlush(creatEntidad(null, null), ABREVIATURA_F1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_F1);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_F1);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    public void updateTest() {
        Corte result = corteService.saveAndFlush(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_F1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test(expected = Exception.class)
    public void deleteSinDatosTest() {
        corteService.delete(ABREVIATURA_F1);
    }

    @Test(expected = Exception.class)
    public void deleteSinDatosNoElementoTest() {
        corteService.delete(ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    @Test(expected = Exception.class)
    public void deleteNoElementoTest() {
        corteService.delete(ABREVIATURA_XXX);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-corte-h2.sql")
    public void deleteTest() {
        corteService.delete(ABREVIATURA_F1);
    }

    private static Corte creatEntidad(String abr, String etq) {
        Corte corte = new Corte();

        corte.setAbreviatura(abr);
        corte.setEtiqueta(etq);

        return corte;
    }
}
