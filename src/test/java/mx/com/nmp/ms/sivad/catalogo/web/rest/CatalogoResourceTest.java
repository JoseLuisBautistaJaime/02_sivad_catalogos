
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import mx.com.nmp.ms.sivad.catalogo.CatalogosApplication;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.dto.CatalogoDTO;
import mx.com.nmp.ms.sivad.catalogo.service.CatalogoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author Quarksoft
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogosApplication.class)
@SuppressWarnings("SpringAutowiredFieldsWarningInspection")
public class CatalogoResourceTest {
    
    @Inject
    CatalogoService catalogoService;
    
    private MockMvc test;
    
    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        CatalogoResource catalogoResource = new CatalogoResource();
        ReflectionTestUtils.setField(catalogoResource, "catalogoService", catalogoService);
        test = MockMvcBuilders.standaloneSetup(catalogoResource).build();
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getAllPerfil() throws Exception {
        test.perform(get("/catalogo/perfil"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.PERFILES.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.PERFILES.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("V"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Valuador"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].abreviatura").value("A"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].etiqueta").value("Amarrador"));
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getAllRamo() throws Exception {
        test.perform(get("/catalogo/ramo"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.RAMOS.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.RAMOS.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("AL"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Alhajas"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].abreviatura").value("VE"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].etiqueta").value("Vehículos"));
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getAllSubramo() throws Exception {
        test.perform(get("/catalogo/subramo"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.SUBRAMOS.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.SUBRAMOS.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("RJ"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Relojes"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].abreviatura").value("AL"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].etiqueta").value("Alhajas"));
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getAllSucursal() throws Exception {
        test.perform(get("/catalogo/sucursal"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.SUCURSALES.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.SUCURSALES.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("suc0"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Casa Matriz-Centro Histórico, Cuauhtémoc, CDMX"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].abreviatura").value("suc1"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].etiqueta").value("Victoria-Centro Histórico, Cuauhtémoc, CDMX"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getAllTipoContrato() throws Exception {
        test.perform(get("/catalogo/tipocontrato"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.TIPO_CONTRATOS.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.TIPO_CONTRATOS.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("CL"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("CLASICO"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].abreviatura").value("PL"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].etiqueta").value("PAGOS LIBRES"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getAllOperacionesCaja() throws Exception {
        test.perform(get("/catalogo/operacioncaja"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.OPERACIONES_CAJA.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.OPERACIONES_CAJA.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("PP"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Pagar Prestamo"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].abreviatura").value("VB"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].etiqueta").value("Venta con Billete"));
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getAllMetal() throws Exception {
        test.perform(get("/catalogo/metal"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.METAL.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.METAL.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("AU"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Oro"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].abreviatura").value("PT"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].etiqueta").value("Platino"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getAllQuilatesOro() throws Exception {
        test.perform(get("/catalogo/quilates"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.QUILATAJE_ORO.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.QUILATAJE_ORO.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("8_Q"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("8"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].abreviatura").value("10_Q"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].etiqueta").value("10"));
    }
    
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getAllRamoConDependencias() throws Exception {
        test.perform(get("/catalogo/ramo?dependencias=true"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.RAMOS.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.RAMOS.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("AL"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Alhajas"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].subramos[0].abreviatura").value("RJ"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].subramos[0].etiqueta").value("Relojes"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getAllRamoSinDependencias() throws Exception {
        test.perform(get("/catalogo/ramo?dependencias=false"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.RAMOS.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.RAMOS.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("AL"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Alhajas"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].abreviatura").value("VE"))
                .andExpect(jsonPath("$.Catalogo.listaValores[1].etiqueta").value("Vehículos"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getOnePerfilTest() throws Exception {
        test.perform(get("/catalogo/perfil/V"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.PERFILES.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.PERFILES.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("V"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Valuador"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getOneRamoTest() throws Exception {
        test.perform(get("/catalogo/ramo/AL"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.RAMOS.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.RAMOS.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("AL"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Alhajas"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getOneSubramoTest() throws Exception {
        test.perform(get("/catalogo/subramo/AU"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.SUBRAMOS.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.SUBRAMOS.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("AU"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Automoviles"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getOneSucursalTest() throws Exception {
        test.perform(get("/catalogo/sucursal/suc0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.SUCURSALES.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.SUCURSALES.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("suc0"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Casa Matriz-Centro Histórico, Cuauhtémoc, CDMX"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getOneTipoContratoTest() throws Exception {
        test.perform(get("/catalogo/tipocontrato/CL"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.TIPO_CONTRATOS.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.TIPO_CONTRATOS.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("CL"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("CLASICO"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getOneOperacionCajaTest() throws Exception {
        test.perform(get("/catalogo/operacioncaja/PP"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.OPERACIONES_CAJA.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.OPERACIONES_CAJA.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("PP"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Pagar Prestamo"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getOneMetalTest() throws Exception {
        test.perform(get("/catalogo/metal/AU"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.METAL.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.METAL.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("AU"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("Oro"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void getOneQuilatesOroTest() throws Exception {
        test.perform(get("/catalogo/quilates/12_Q"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.Catalogo.dominio").value(ConfiguracionCatalogoEnum.QUILATAJE_ORO.getDominioUnwrap()))
                .andExpect(jsonPath("$.Catalogo.tipo").value(ConfiguracionCatalogoEnum.QUILATAJE_ORO.getTipo()))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].abreviatura").value("12_Q"))
                .andExpect(jsonPath("$.Catalogo.listaValores[0].etiqueta").value("12"));
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void deletePerfilTest() throws Exception {
        test.perform(delete("/catalogo/perfil/V").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void deleteRamoTest() throws Exception {
        test.perform(delete("/catalogo/ramo/AL"))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void deleteSubRamoTest() throws Exception {
        test.perform(delete("/catalogo/subramo/RJ"))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void deleteSucursalTest() throws Exception {
        test.perform(delete("/catalogo/sucursal/suc0"))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void deleteTipoContratoTest() throws Exception {
        test.perform(delete("/catalogo/tipocontrato/PL"))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void deleteOperacionCajaTest() throws Exception {
        test.perform(delete("/catalogo/operacioncaja/PP"))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void deleteMetalTest() throws Exception {
        test.perform(delete("/catalogo/metal/AU"))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void deleteQuilatajeTest() throws Exception {
        test.perform(delete("/catalogo/quilates/8_Q"))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void createPerfilTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("CC");
        catalogoDTO.setEtiqueta("Cajero Prueba");
        
        test.perform(post("/catalogo/perfil")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void createRamoTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("PP");
        catalogoDTO.setEtiqueta("Ramo Prueba");
        List<String> subramos = new ArrayList<>();
        subramos.add("DI");
        catalogoDTO.setAbreviaturasHijas(subramos);
        
        
        test.perform(post("/catalogo/ramo")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void createSubRamoTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("PP-1");
        catalogoDTO.setEtiqueta("SubRamo Prueba");
 
        test.perform(post("/catalogo/subramo")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void createSucursalTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("suc20000");
        catalogoDTO.setEtiqueta("Sucursal 2000");
 
        test.perform(post("/catalogo/sucursal")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void createTipoContratoTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("TC");
        catalogoDTO.setEtiqueta("Tipo contrato prueba");
 
        test.perform(post("/catalogo/tipocontrato")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void createOperacionCajaTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("OC");
        catalogoDTO.setEtiqueta("Operacion caja prueba");
 
        test.perform(post("/catalogo/operacioncaja")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void createMetalTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("MT-1");
        catalogoDTO.setEtiqueta("Metal prueba");
 
        test.perform(post("/catalogo/metal")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void createQuilatesTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("Q-1");
        catalogoDTO.setEtiqueta("Quilates prueba");
 
        test.perform(post("/catalogo/quilates")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void updatePerfilTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("MCO");
        catalogoDTO.setEtiqueta("Perfil prueba update");
 
        test.perform(put("/catalogo/perfil/MCO")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void updateRamoTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("SR");
        catalogoDTO.setEtiqueta("Sin Resguardo update");
 
        test.perform(put("/catalogo/ramo/SR")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void updateSubRamoTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("MC");
        catalogoDTO.setEtiqueta("Motocicletas update");
 
        test.perform(put("/catalogo/subramo/MC")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void updateSucursalTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("suc0");
        catalogoDTO.setEtiqueta("Casa Matriz-Centro Histórico, Cuauhtémoc, CDMX update");
 
        test.perform(put("/catalogo/sucursal/suc0")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void updateTipoContratoTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("CL");
        catalogoDTO.setEtiqueta("CLASICO update");
 
        test.perform(put("/catalogo/tipocontrato/CL")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void updateOperacionCajaTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("RFE");
        catalogoDTO.setEtiqueta("Cobro Refrendo Extemporaneo update");
 
        test.perform(put("/catalogo/operacioncaja/RFE")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void updateMetalTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("AU");
        catalogoDTO.setEtiqueta("Oro update");
 
        test.perform(put("/catalogo/metal/AU")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
    @Test
    @Transactional
    @Sql("/bd/test-data-catalogo-h2.sql")
    public void updateQuilatajeTest() throws Exception {
        
        CatalogoDTO catalogoDTO = new CatalogoDTO();
        catalogoDTO.setAbreviatura("8_Q");
        catalogoDTO.setEtiqueta("8 update");
 
        test.perform(put("/catalogo/quilates/8_Q")
            .content(asJsonString(catalogoDTO))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    
    
    
    public static String asJsonString(final Object obj) {
    try {
        final ObjectMapper mapper = new ObjectMapper();
        final String jsonContent = mapper.writeValueAsString(obj);
        return jsonContent;
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}  
    
    
    
    
}
