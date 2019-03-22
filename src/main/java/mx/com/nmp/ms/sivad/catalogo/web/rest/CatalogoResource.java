
package mx.com.nmp.ms.sivad.catalogo.web.rest;

import com.codahale.metrics.annotation.Timed;
import javax.inject.Inject;
import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.dto.Catalogo;
import mx.com.nmp.ms.sivad.catalogo.dto.CatalogoDTO;
import mx.com.nmp.ms.sivad.catalogo.service.CatalogoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author madelgadillo
 */
@RestController
@RequestMapping("/catalogo")
public class CatalogoResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogoResource.class);
    
    @Inject
    private CatalogoService catalogoService;
    
    @RequestMapping(value = "/{catalogo}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Catalogo> getAll(@PathVariable String catalogo, @RequestParam(value = "dependencias",required = false) boolean dependencias) {
        LOGGER.info(">> getAll catalogo: {}, dependecias: {}",catalogo,dependencias);
        CatalogoEnum catalogoEnum = null;
        try{
            catalogoEnum = CatalogoEnum.valueOf(catalogo.toUpperCase());
        }catch(IllegalArgumentException e){
            LOGGER.error(">> El catálogo que solicito no existe");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        Catalogo cat = catalogoService.getAll(catalogoEnum, dependencias);
        
        return new ResponseEntity<>(cat,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{catalogo}/{abreviatura}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Catalogo> get(@PathVariable String catalogo,@PathVariable String abreviatura, @RequestParam(name = "dependencias",required = false) boolean dependencias) {
        LOGGER.info(">> get catalogo: {},abreviatura:{}",catalogo,abreviatura);
        CatalogoEnum catalogoEnum = null;
        try{
            catalogoEnum = CatalogoEnum.valueOf(catalogo.toUpperCase());
        }catch(IllegalArgumentException e){
            LOGGER.error(">> El catálogo que solicito no existe");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        Catalogo cat = catalogoService.get(catalogoEnum,abreviatura, dependencias);
        
        return new ResponseEntity<>(cat,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{catalogo}/{abreviatura}",
            method = RequestMethod.DELETE)
    @Timed
    public ResponseEntity<Void> delete(@PathVariable String catalogo,@PathVariable String abreviatura) {
        LOGGER.info(">> delete catalogo:{}, abreviatura: {}",catalogo,abreviatura);
        CatalogoEnum catalogoEnum = null;
        try{
            catalogoEnum = CatalogoEnum.valueOf(catalogo.toUpperCase());
        }catch(IllegalArgumentException e){
            LOGGER.error(">> El catálogo que solicito no existe");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catalogoService.delete(catalogoEnum,abreviatura);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{catalogo}",
            method = RequestMethod.POST)
    @Timed
    public ResponseEntity<Void> create(@PathVariable String catalogo,@RequestBody CatalogoDTO catalogoDTO) {
        LOGGER.info(">> create catalogo:{}, catalogoDTO: {}",catalogo,catalogoDTO);
        CatalogoEnum catalogoEnum = null;
        try{
            catalogoEnum = CatalogoEnum.valueOf(catalogo.toUpperCase());
        }catch(IllegalArgumentException e){
            LOGGER.error(">> El catálogo que solicito no existe");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        catalogoService.save(catalogoEnum,catalogoDTO);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{catalogo}/{abreviatura}",
            method = RequestMethod.PUT)
    @Timed
    public ResponseEntity<Void> update(@PathVariable String catalogo,@PathVariable String abreviatura,@RequestBody CatalogoDTO catalogoDTO) {
        LOGGER.info(">> update catalogo:{}, catalogoDTO: {}",catalogo,catalogoDTO);
        
       CatalogoEnum catalogoEnum = null;
        try{
            catalogoEnum = CatalogoEnum.valueOf(catalogo.toUpperCase());
        }catch(IllegalArgumentException e){
            LOGGER.error(">> El catálogo que solicito no existe");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        catalogoService.update(catalogoEnum,abreviatura,catalogoDTO);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{catalogo}/id/{idElement}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Catalogo> getById(@PathVariable String catalogo,@PathVariable Long idElement, @RequestParam(name = "dependencias",required = false) boolean dependencias) {
        LOGGER.info(">> get catalogo: {},abreviatura:{}",catalogo,idElement);
        CatalogoEnum catalogoEnum = null;
        try{
            catalogoEnum = CatalogoEnum.valueOf(catalogo.toUpperCase());
        }catch(IllegalArgumentException e){
            LOGGER.error(">> El catálogo que solicito no existe");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        Catalogo cat = catalogoService.get(catalogoEnum,idElement);
        
        return new ResponseEntity<>(cat,HttpStatus.OK);
    }

}
