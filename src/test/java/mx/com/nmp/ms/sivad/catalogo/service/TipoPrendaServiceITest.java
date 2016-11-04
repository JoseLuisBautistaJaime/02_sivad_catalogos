/*
 *
 * Microservicios - Catálogos
 *
 * <p><b>Quarksoft Copyrigth © 2016</b></p>
 *
 */
package mx.com.nmp.ms.sivad.catalogo.service;

import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.TipoPrenda;
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
 * Clase de prueba para el Controlador REST que nos permite consultar el catálogo {@link TipoPrenda}
 * @see TipoPrendaService
 *
 * @author <a href="https://wiki.quarksoft.net/display/~cachavez">Carlos Chávez Melena</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class TipoPrendaServiceITest {
    private static final String ABREVIATURA_ANILLO = "ANILLO";
    private static final String ETIQUETA_ANILLO = "Anillo";

    private static final String ABREVIATURA_PULSERA = "PULSERA";

    private static final String ABREVIATURA_XXX = "xXx";

    private static final String ABREVIATURA_TEST = "TEST";
    private static final String ETIQUETA_TEST = "Test";

    @Inject
    private TipoPrendaService test;

    @Test(expected = CatalogoNotFoundException.class)
    public void saveSinConfiguracionTest() {
        test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveSinDatosTest() {
        test.save(creatEntidad(null, null));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    @Test(expected = ConstraintViolationException.class)
    public void saveDatosVaciosTest() {
        test.save(creatEntidad("", ""));
    }

    @Transactional
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void saveDuplicadoTest() {
        test.save(creatEntidad(ABREVIATURA_ANILLO, ETIQUETA_ANILLO));
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    public void saveTest() {
        TipoPrenda result = test.save(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST));
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
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateSinDatosNoElementoTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void updateNoElementoTest() {
        test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    @Test(expected = DataIntegrityViolationException.class)
    public void updateDuplicadoTest() {
        test.update(creatEntidad(ABREVIATURA_PULSERA, ETIQUETA_TEST), ABREVIATURA_ANILLO);
        test.getAll();
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    public void updateAbrNullTest() {
        TipoPrenda result = test.update(creatEntidad(null, ETIQUETA_TEST), ABREVIATURA_ANILLO);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_ANILLO);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    public void updateEtqNullTest() {
        TipoPrenda result = test.update(creatEntidad(ABREVIATURA_TEST, null), ABREVIATURA_ANILLO);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_ANILLO);
        Assert.assertNotEquals(result.getAbreviatura(), ABREVIATURA_ANILLO);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    public void updateAmbNullTest() {
        TipoPrenda result = test.update(creatEntidad(null, null), ABREVIATURA_ANILLO);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_ANILLO);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_ANILLO);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    public void updateTest() {
        TipoPrenda result = test.update(creatEntidad(ABREVIATURA_TEST, ETIQUETA_TEST), ABREVIATURA_ANILLO);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_TEST);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_TEST);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosTest() {
        test.delete(ABREVIATURA_ANILLO);
    }

    @Test(expected = CatalogoNotFoundException.class)
    public void deleteSinDatosNoElementoTest() {
        test.delete(ABREVIATURA_XXX);
    }

    @Transactional
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    @Test(expected = CatalogoNotFoundException.class)
    public void deleteNoElementoTest() {
        test.delete(ABREVIATURA_XXX);
    }

    @Test
    @Transactional
    @Sql("/bd/test-data-diamante_tipo_prenda-h2.sql")
    public void deleteTest() {
        TipoPrenda result = test.delete(ABREVIATURA_ANILLO);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAbreviatura(), ABREVIATURA_ANILLO);
        Assert.assertEquals(result.getEtiqueta(), ETIQUETA_ANILLO);
    }

    private static TipoPrenda creatEntidad(String abr, String etq) {
        TipoPrenda tp = new TipoPrenda();

        tp.setAbreviatura(abr);
        tp.setEtiqueta(etq);

        return tp;
    }
}
