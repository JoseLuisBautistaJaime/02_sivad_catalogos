
package mx.com.nmp.ms.sivad.catalogo.service;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoWithoutDependenciesProjection;
import mx.com.nmp.ms.sivad.catalogo.domain.Metal;
import mx.com.nmp.ms.sivad.catalogo.domain.OperacionCaja;
import mx.com.nmp.ms.sivad.catalogo.domain.Perfil;
import mx.com.nmp.ms.sivad.catalogo.domain.QuilatajeOro;
import mx.com.nmp.ms.sivad.catalogo.domain.Ramo;
import mx.com.nmp.ms.sivad.catalogo.domain.Subramo;
import mx.com.nmp.ms.sivad.catalogo.domain.Sucursal;
import mx.com.nmp.ms.sivad.catalogo.domain.TipoContrato;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.dto.CatalogoDTO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.terracotta.modules.ehcache.store.TerracottaClusteredInstanceFactory.LOGGER;

/**
 *
 * @author Quarksoft
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
public class CatalogoServiceTest {
    
    @Inject
    private CatalogoService catalogoService;

    @Before
    public void setUp() {

    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerTodosElementosPerfil() {
        LOGGER.info(">> testObtenerTodosElementosPerfil");

        Catalogo result = catalogoService.getAll(CatalogoEnum.PERFIL,  false);
        assertNotNull(result);
        assertTrue(result.getElementos().size() > 0);
        LOGGER.debug("--> {}",result.getElementos().get(0).getClass());
        for (int x = 0; x < result.getElementos().size(); x++) {
            CatalogoWithoutDependenciesProjection perfil = (CatalogoWithoutDependenciesProjection)result.getElementos().get(x);
            LOGGER.debug("Abreviatura: [{}]", perfil.getAbreviatura());
            LOGGER.debug("Etiqueta: [{}]", perfil.getEtiqueta());
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerTodosElementosRamo() {
        LOGGER.info(">> testObtenerTodosElementosRamo");

        Catalogo result = catalogoService.getAll(CatalogoEnum.RAMO,  false);
        assertNotNull(result);
        assertTrue(result.getElementos().size() > 0);

        for (int x = 0; x < result.getElementos().size(); x++) {
            CatalogoWithoutDependenciesProjection ramo = (CatalogoWithoutDependenciesProjection)result.getElementos().get(x);
            LOGGER.debug("Abreviatura: [{}]", ramo.getAbreviatura());
            LOGGER.debug("Etiqueta: [{}]", ramo.getEtiqueta());
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerTodosElementosSubramo() {
        LOGGER.info(">> testObtenerTodosElementosSubramo");

        Catalogo result = catalogoService.getAll(CatalogoEnum.SUBRAMO,  false);
        assertNotNull(result);
        assertTrue(result.getElementos().size() > 0);

        for (int x = 0; x < result.getElementos().size(); x++) {
            CatalogoWithoutDependenciesProjection subramo = (CatalogoWithoutDependenciesProjection)result.getElementos().get(x);
            LOGGER.debug("Abreviatura: [{}]", subramo.getAbreviatura());
            LOGGER.debug("Etiqueta: [{}]", subramo.getEtiqueta());
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerTodosElementosSucursal() {
        LOGGER.info(">> testObtenerTodosElementosSucursal");

        Catalogo result = catalogoService.getAll(CatalogoEnum.SUCURSAL,  false);
        assertNotNull(result);
        assertTrue(result.getElementos().size() > 0);

        for (int x = 0; x < result.getElementos().size(); x++) {
            CatalogoWithoutDependenciesProjection sucursal = (CatalogoWithoutDependenciesProjection)result.getElementos().get(x);
            LOGGER.debug("Abreviatura: [{}]", sucursal.getAbreviatura());
            LOGGER.debug("Etiqueta: [{}]", sucursal.getEtiqueta());
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerTodosElementosTipoContrato() {
        LOGGER.info(">> testObtenerTodosElementosTipoContrato");

        Catalogo result = catalogoService.getAll(CatalogoEnum.TIPOCONTRATO,  false);
        assertNotNull(result);
        assertTrue(result.getElementos().size() > 0);

        for (int x = 0; x < result.getElementos().size(); x++) {
            CatalogoWithoutDependenciesProjection tipoContrato = (CatalogoWithoutDependenciesProjection)result.getElementos().get(x);
            LOGGER.debug("Abreviatura: [{}]", tipoContrato.getAbreviatura());
            LOGGER.debug("Etiqueta: [{}]", tipoContrato.getEtiqueta());
        }
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerTodosElementosOperacionCaja() {
        LOGGER.info(">> testObtenerTodosElementosOperacionCaja");

        Catalogo result = catalogoService.getAll(CatalogoEnum.OPERACIONCAJA,  false);
        assertNotNull(result);
        assertTrue(result.getElementos().size() > 0);

        for (int x = 0; x < result.getElementos().size(); x++) {
            CatalogoWithoutDependenciesProjection operacionCaja = (CatalogoWithoutDependenciesProjection)result.getElementos().get(x);
            LOGGER.debug("Abreviatura: [{}]", operacionCaja.getAbreviatura());
            LOGGER.debug("Etiqueta: [{}]", operacionCaja.getEtiqueta());
        }
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerTodosElementosMetal() {
        LOGGER.info(">> testObtenerTodosElementosMetal");

        Catalogo result = catalogoService.getAll(CatalogoEnum.METAL,  false);
        assertNotNull(result);
        assertTrue(result.getElementos().size() > 0);

        for (int x = 0; x < result.getElementos().size(); x++) {
            CatalogoWithoutDependenciesProjection operacionCaja = (CatalogoWithoutDependenciesProjection)result.getElementos().get(x);
            LOGGER.debug("Abreviatura: [{}]", operacionCaja.getAbreviatura());
            LOGGER.debug("Etiqueta: [{}]", operacionCaja.getEtiqueta());
        }
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerTodosElementosQuilates() {
        LOGGER.info(">> testObtenerTodosElementosQuilates");

        Catalogo result = catalogoService.getAll(CatalogoEnum.QUILATES,  false);
        assertNotNull(result);
        assertTrue(result.getElementos().size() > 0);

        for (int x = 0; x < result.getElementos().size(); x++) {
            CatalogoWithoutDependenciesProjection quilatajeOro = (CatalogoWithoutDependenciesProjection)result.getElementos().get(x);
            LOGGER.debug("Abreviatura: [{}]", quilatajeOro.getAbreviatura());
            LOGGER.debug("Etiqueta: [{}]", quilatajeOro.getEtiqueta());
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerElementoPerfil() {
        LOGGER.info(">> testObtenerElementoPerfil");

        try {
            Catalogo result = catalogoService.get(CatalogoEnum.PERFIL,"V",false);
            CatalogoWithoutDependenciesProjection perfil = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(perfil);
            assertEquals("V", perfil.getAbreviatura());
            assertEquals("Valuador", perfil.getEtiqueta());
            assertNotNull(perfil.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerElementoRamo() {
        LOGGER.info(">> testObtenerElementoRamo");

        try {
            Catalogo result = catalogoService.get(CatalogoEnum.RAMO,"AL",false);
            CatalogoWithoutDependenciesProjection ramo = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(ramo);
            assertEquals("AL", ramo.getAbreviatura());
            assertEquals("Alhajas", ramo.getEtiqueta());
            assertNotNull(ramo.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerElementoSubRamo() {
        LOGGER.info(">> testObtenerElementoSubRamo");

        try {
            Catalogo result = catalogoService.get(CatalogoEnum.SUBRAMO,"RJ",false);
            CatalogoWithoutDependenciesProjection subramo = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(subramo);
            assertEquals("RJ", subramo.getAbreviatura());
            assertEquals("Relojes", subramo.getEtiqueta());
            assertNotNull(subramo.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerElementoSucursal() {
        LOGGER.info(">> testObtenerElementoSucursal");

        try {
            Catalogo result = catalogoService.get(CatalogoEnum.SUCURSAL,"suc0",false);
            CatalogoWithoutDependenciesProjection sucursal = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(sucursal);
            assertEquals("suc0", sucursal.getAbreviatura());
            assertEquals("Casa Matriz-Centro Histórico, Cuauhtémoc, CDMX", sucursal.getEtiqueta());
            assertNotNull(sucursal.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerElementoTipoContrato() {
        LOGGER.info(">> testObtenerElementoTipoContrato");

        try {
            Catalogo result = catalogoService.get(CatalogoEnum.TIPOCONTRATO,"CL",false);
            CatalogoWithoutDependenciesProjection tipoContrato = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(tipoContrato);
            assertEquals("CL", tipoContrato.getAbreviatura());
            assertEquals("CLASICO", tipoContrato.getEtiqueta());
            assertNotNull(tipoContrato.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerElementoOperacionCaja() {
        LOGGER.info(">> testObtenerElementoOperacionCaja");

        try {
            Catalogo result = catalogoService.get(CatalogoEnum.OPERACIONCAJA,"PP",false);
            CatalogoWithoutDependenciesProjection operacionCaja = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(operacionCaja);
            assertEquals("PP", operacionCaja.getAbreviatura());
            assertEquals("Pagar Prestamo", operacionCaja.getEtiqueta());
            assertNotNull(operacionCaja.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerElementoMetal() {
        LOGGER.info(">> testObtenerElementoMetal");

        try {
            Catalogo result = catalogoService.get(CatalogoEnum.METAL,"AU",false);
            CatalogoWithoutDependenciesProjection metal = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(metal);
            assertEquals("AU", metal.getAbreviatura());
            assertEquals("Oro", metal.getEtiqueta());
            assertNotNull(metal.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testObtenerElementoQuilates() {
        LOGGER.info(">> testObtenerElementoQuilates");

        try {
            Catalogo result = catalogoService.get(CatalogoEnum.QUILATES,"8_Q",false);
            CatalogoWithoutDependenciesProjection quilatajeOro = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(quilatajeOro);
            assertEquals("8_Q", quilatajeOro.getAbreviatura());
            assertEquals("8", quilatajeOro.getEtiqueta());
            assertNotNull(quilatajeOro.getConfiguracion());
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testAgregarElementoPerfil() {
        LOGGER.info(">> testAgregarElementoPerfil");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("CC");
            catalogoDTO.setEtiqueta("Cajero Prueba");
            catalogoService.save(CatalogoEnum.PERFIL,catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.PERFIL,"CC",false);
            CatalogoWithoutDependenciesProjection perfil = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(perfil);
            assertEquals("CC", perfil.getAbreviatura());
            assertEquals("Cajero Prueba", perfil.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testAgregarElementoRamo() {
        LOGGER.info(">> testAgregarElementoRamo");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("PP");
            catalogoDTO.setEtiqueta("Ramo Prueba");
            List<String> subramos = new ArrayList<>();
            subramos.add("DI");
            catalogoDTO.setAbreviaturasHijas(subramos);
            catalogoService.save(CatalogoEnum.RAMO,catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.RAMO,"PP",false);
            CatalogoWithoutDependenciesProjection ramo = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(ramo);
            assertEquals("PP", ramo.getAbreviatura());
            assertEquals("Ramo Prueba", ramo.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testAgregarElementoSubramo() {
        LOGGER.info(">> testAgregarElementoSubRamo");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("PP-1");
            catalogoDTO.setEtiqueta("SubRamo Prueba");
 
            catalogoService.save(CatalogoEnum.SUBRAMO,catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.SUBRAMO,"PP-1",false);
            CatalogoWithoutDependenciesProjection subramo = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(subramo);
            assertEquals("PP-1", subramo.getAbreviatura());
            assertEquals("SubRamo Prueba", subramo.getEtiqueta());
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testAgregarElementoSucursal() {
        LOGGER.info(">> testAgregarElementoSucursal");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("suc20000");
            catalogoDTO.setEtiqueta("Sucursal 2000");
 
            catalogoService.save(CatalogoEnum.SUCURSAL,catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.SUCURSAL,"suc20000",false);
            CatalogoWithoutDependenciesProjection sucursal = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(sucursal);
            assertEquals("suc20000", sucursal.getAbreviatura());
            assertEquals("Sucursal 2000", sucursal.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testAgregarElementoTipoContrato() {
        LOGGER.info(">> testAgregarElementoTipoContrato");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("TC");
            catalogoDTO.setEtiqueta("Tipo contrato prueba");
 
            catalogoService.save(CatalogoEnum.TIPOCONTRATO,catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.TIPOCONTRATO,"TC",false);
            CatalogoWithoutDependenciesProjection tipoContrato = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(tipoContrato);
            assertEquals("TC", tipoContrato.getAbreviatura());
            assertEquals("Tipo contrato prueba", tipoContrato.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testAgregarElementoOperacionCaja() {
        LOGGER.info(">> testAgregarElementoOperacionCaja");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("OC");
            catalogoDTO.setEtiqueta("Operacion caja prueba");
 
            catalogoService.save(CatalogoEnum.OPERACIONCAJA,catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.OPERACIONCAJA,"OC",false);
            CatalogoWithoutDependenciesProjection operacionCaja = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(operacionCaja);
            assertEquals("OC", operacionCaja.getAbreviatura());
            assertEquals("Operacion caja prueba", operacionCaja.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testAgregarElementoMetal() {
        LOGGER.info(">> testAgregarElementoMetal");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("MT-1");
            catalogoDTO.setEtiqueta("Metal prueba");
 
            catalogoService.save(CatalogoEnum.METAL,catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.METAL,"MT-1",false);
            CatalogoWithoutDependenciesProjection metal = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(metal);
            assertEquals("MT-1", metal.getAbreviatura());
            assertEquals("Metal prueba", metal.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testAgregarElementoQuilates() {
        LOGGER.info(">> testAgregarElementoQuilates");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("Q-1");
            catalogoDTO.setEtiqueta("Quilates prueba");
 
            catalogoService.save(CatalogoEnum.QUILATES,catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.QUILATES,"Q-1",false);
            CatalogoWithoutDependenciesProjection quilatajeOro = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(quilatajeOro);
            assertEquals("Q-1", quilatajeOro.getAbreviatura());
            assertEquals("Quilates prueba", quilatajeOro.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testActualizarElementoPerfil() {
        LOGGER.info(">> testAgregarElementoPerfil");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("MCO");
            catalogoDTO.setEtiqueta("Perfil prueba update");
 
            catalogoService.update(CatalogoEnum.PERFIL,"MCO",catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.PERFIL,"MCO",false);
            CatalogoWithoutDependenciesProjection perfil = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(perfil);
            assertEquals("MCO", perfil.getAbreviatura());
            assertEquals("Perfil prueba update", perfil.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testActualizarElementoRamo() {
        LOGGER.info(">> testAgregarElementoRamo");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("SR");
            catalogoDTO.setEtiqueta("Sin Resguardo update");
 
            catalogoService.update(CatalogoEnum.RAMO,"SR",catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.RAMO,"SR",false);
            CatalogoWithoutDependenciesProjection ramo = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(ramo);
            assertEquals("SR", ramo.getAbreviatura());
            assertEquals("Sin Resguardo update", ramo.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testActualizarElementoSubRamo() {
        LOGGER.info(">> testAgregarElementoSubRamo");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("MC");
            catalogoDTO.setEtiqueta("Motocicletas update");
 
            catalogoService.update(CatalogoEnum.SUBRAMO,"MC",catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.SUBRAMO,"MC",false);
            CatalogoWithoutDependenciesProjection subramo = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(subramo);
            assertEquals("MC", subramo.getAbreviatura());
            assertEquals("Motocicletas update", subramo.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testActualizarElementoSucursal() {
        LOGGER.info(">> testAgregarElementoSucursal");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("suc0");
            catalogoDTO.setEtiqueta("Casa Matriz-Centro Histórico, Cuauhtémoc, CDMX update");
 
            catalogoService.update(CatalogoEnum.SUCURSAL,"suc0",catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.SUCURSAL,"suc0",false);
            CatalogoWithoutDependenciesProjection sucursal = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(sucursal);
            assertEquals("suc0", sucursal.getAbreviatura());
            assertEquals("Casa Matriz-Centro Histórico, Cuauhtémoc, CDMX update", sucursal.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testActualizarElementoTipoContrato() {
        LOGGER.info(">> testAgregarElementoTipoContrato");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("CL");
            catalogoDTO.setEtiqueta("CLASICO update");
 
            catalogoService.update(CatalogoEnum.TIPOCONTRATO,"CL",catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.TIPOCONTRATO,"CL",false);
            CatalogoWithoutDependenciesProjection tipoContrato = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(tipoContrato);
            assertEquals("CL", tipoContrato.getAbreviatura());
            assertEquals("CLASICO update", tipoContrato.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testActualizarElementoOperacionCaja() {
        LOGGER.info(">> testAgregarElementoOperacionCaja");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("RFE");
            catalogoDTO.setEtiqueta("Cobro Refrendo Extemporaneo update");
 
            catalogoService.update(CatalogoEnum.OPERACIONCAJA,"RFE",catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.OPERACIONCAJA,"RFE",false);
            CatalogoWithoutDependenciesProjection operacionCaja = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(operacionCaja);
            assertEquals("RFE", operacionCaja.getAbreviatura());
            assertEquals("Cobro Refrendo Extemporaneo update", operacionCaja.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testActualizarElementoMetal() {
        LOGGER.info(">> testAgregarElementoMetal");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("AU");
            catalogoDTO.setEtiqueta("Oro update");
 
            catalogoService.update(CatalogoEnum.METAL,"AU",catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.METAL,"AU",false);
            CatalogoWithoutDependenciesProjection metal = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(metal);
            assertEquals("AU", metal.getAbreviatura());
            assertEquals("Oro update", metal.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testActualizarElementoQuilates() {
        LOGGER.info(">> testAgregarElementoQuilates");
        try {
            CatalogoDTO catalogoDTO = new CatalogoDTO();
            catalogoDTO.setAbreviatura("8_Q");
            catalogoDTO.setEtiqueta("8 update");
 
            catalogoService.update(CatalogoEnum.QUILATES,"8_Q",catalogoDTO);
            
            Catalogo result = catalogoService.get(CatalogoEnum.QUILATES,"8_Q",false);
            CatalogoWithoutDependenciesProjection quilatajeOro = (CatalogoWithoutDependenciesProjection) result.getElementos().get(0);
            assertNotNull(result);
            assertNotNull(quilatajeOro);
            assertEquals("8_Q", quilatajeOro.getAbreviatura());
            assertEquals("8 update", quilatajeOro.getEtiqueta());
            
        } catch (DataIntegrityViolationException e) {
            assertNotNull(e);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testEliminarElementoPerfil() {
        LOGGER.info(">> testEliminarElementoPerfil");

        try {
            catalogoService.delete(CatalogoEnum.PERFIL,"V");
            assertTrue(true);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testEliminarElementoRamo() {
        LOGGER.info(">> testEliminarElementoRamo");

        try {
            catalogoService.delete(CatalogoEnum.RAMO,"AL");
            assertTrue(true);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testEliminarElementoSubRamo() {
        LOGGER.info(">> testEliminarElementoSubRamo");

        try {
            catalogoService.delete(CatalogoEnum.SUBRAMO,"AL");
            assertTrue(true);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testEliminarElementoSucursal() {
        LOGGER.info(">> testEliminarElementoSucursal");

        try {
            catalogoService.delete(CatalogoEnum.SUCURSAL,"suc0");
            assertTrue(true);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testEliminarElementoTipoContrato() {
        LOGGER.info(">> testEliminarElementoTipoContrato");

        try {
            catalogoService.delete(CatalogoEnum.TIPOCONTRATO,"CL");
            assertTrue(true);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testEliminarElementoOperacionCaja() {
        LOGGER.info(">> testEliminarElementoOperacionCaja");

        try {
            catalogoService.delete(CatalogoEnum.OPERACIONCAJA,"PP");
            assertTrue(true);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }

    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testEliminarElementoMetal() {
        LOGGER.info(">> testEliminarElementoMetal");

        try {
            catalogoService.delete(CatalogoEnum.METAL,"AU");
            assertTrue(true);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void testEliminarElementoQuilataje() {
        LOGGER.info(">> testEliminarElementoQuilataje");

        try {
            catalogoService.delete(CatalogoEnum.QUILATES,"8_Q");
            assertTrue(true);
        } catch (Exception e) {
            LOGGER.error("Ocurrio una excepcion inesperada realizar la operacion. {}", e.getMessage());
            fail();
        }
    }
    
    
    
    
    
}
