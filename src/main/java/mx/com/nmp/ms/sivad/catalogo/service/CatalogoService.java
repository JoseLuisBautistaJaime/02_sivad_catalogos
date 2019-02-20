
package mx.com.nmp.ms.sivad.catalogo.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import mx.com.nmp.ms.arquetipo.annotation.validation.HasText;
import mx.com.nmp.ms.sivad.catalogo.domain.BaseCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoConfigurable;
import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.CatalogoWithoutDependenciesProjection;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo;
import mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogoEnum;
import mx.com.nmp.ms.sivad.catalogo.domain.Contrato;
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
import mx.com.nmp.ms.sivad.catalogo.exception.CatalogoNotFoundException;
import mx.com.nmp.ms.sivad.catalogo.factory.CatalogoFactory;
import mx.com.nmp.ms.sivad.catalogo.repository.CatalogoRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 *
 * @author madelgadillo
 */
@Service
@Transactional
public class CatalogoService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogoService.class);
    
    @Autowired
    private ListableBeanFactory listableBeanFactory;
    
    @Inject
    private ConfiguracionCatalogoService configuracionCatalogoService;
    
    private Repositories repositories;

    public CatalogoService() {
        
    }
    
    @PostConstruct
    public void init(){
        this.repositories = new Repositories(listableBeanFactory);
        
    }
    
    @Transactional(readOnly = true)
    public Catalogo getAll(@NotNull CatalogoEnum catalogoEnum,boolean dependencias){
        
        Class domain = getDomainClass(catalogoEnum);
        CatalogoRepository repository = null;
        List lista = null;
        if(!dependencias){
            repository =  getRepository(domain);
            List<CatalogoWithoutDependenciesProjection> catalogo = repository.findAllWithoutDependenciesBy();
            if(!ObjectUtils.isEmpty(catalogo)){
                return CatalogoFactory.build(catalogo.get(0).getConfiguracion(), catalogo);
            }
            
        }else{
            repository = getRepository(domain);
            lista = repository.findAll();
            if(!ObjectUtils.isEmpty(lista)){
                    return CatalogoFactory.build(lista);
            }
        }
        
        return null;
        
        
    }
    
    @Transactional(readOnly = true)
    public Catalogo get(@NotNull CatalogoEnum catalogoEnum,@HasText String abreviatura,boolean dependencias){
        Class domain = getDomainClass(catalogoEnum);
        CatalogoRepository repository = null;
        CatalogoConfigurable obj = null;
        
         if(!dependencias){
             repository =   getRepository(domain);
            CatalogoWithoutDependenciesProjection catalogo = repository.findWithoutDependenciesByAbreviatura(abreviatura);
            validarElementoExistente(catalogo,catalogoEnum,abreviatura,domain);
            List<CatalogoWithoutDependenciesProjection> lista = new ArrayList<>();
            lista.add(catalogo);
            return CatalogoFactory.build(lista.get(0).getConfiguracion(),lista);
         }else{
             repository =  getRepository(domain);
             obj = (CatalogoConfigurable) repository.findByAbreviatura(abreviatura);
             validarElementoExistente(obj,catalogoEnum,abreviatura,domain);
         }
        
        return CatalogoFactory.build(obj);
    }
    
    
     @Transactional(readOnly = true)
     public Catalogo get(@NotNull CatalogoEnum catalogoEnum,@NotNull Long idElemento){
        Class domain = getDomainClass(catalogoEnum);
        CatalogoRepository repository = null;
        CatalogoConfigurable obj = null;
        
        repository =  getRepository(domain);
        obj = (CatalogoConfigurable) repository.findOne(idElemento);
        validarElementoExistenteId(obj,catalogoEnum,idElemento,domain);
        
        
        return CatalogoFactory.build(obj);
     }
    
    
    public void delete(@NotNull CatalogoEnum catalogoEnum,@HasText String abreviatura){
        
        Class domain = getDomainClass(catalogoEnum);
        CatalogoRepository repository = getRepository(domain);
        
        Object instanciaRepo = repository.findByAbreviatura(abreviatura);
        validarElementoExistente((Serializable) domain.cast(instanciaRepo),catalogoEnum,abreviatura,domain);
        actualizarConfiguracion(catalogoEnum);
        repository.delete(instanciaRepo);
        
    }
    
    
    public void save(@NotNull CatalogoEnum catalogoEnum,@NotNull CatalogoDTO catalogoDTO){
        LOGGER.info(">> save catalogo: {},catalogoDTO", catalogoEnum,catalogoDTO);
        try {
            Class domain = getDomainClass(catalogoEnum);
            CatalogoRepository repository = getRepository(domain);
            
            ConfiguracionCatalogo config = actualizarConfiguracion(catalogoEnum);
            Object instancia = domain.newInstance();
            if(instancia instanceof BaseCatalogo){
                ((BaseCatalogo)instancia).setAbreviatura(catalogoDTO.getAbreviatura());
                ((BaseCatalogo)instancia).setEtiqueta(catalogoDTO.getEtiqueta());
                ((BaseCatalogo)instancia).setConfiguracion(config);
            }else if(instancia instanceof Metal){
                ((Metal)instancia).setAbreviatura(catalogoDTO.getAbreviatura());
                ((Metal)instancia).setEtiqueta(catalogoDTO.getEtiqueta());
                ((Metal)instancia).setConfiguracion(config);
            }else if(instancia instanceof QuilatajeOro){
                ((QuilatajeOro)instancia).setAbreviatura(catalogoDTO.getAbreviatura());
                ((QuilatajeOro)instancia).setEtiqueta(catalogoDTO.getEtiqueta());
                ((QuilatajeOro)instancia).setConfiguracion(config);
            }
            
           
            if(instancia instanceof Ramo){
                if(!ObjectUtils.isEmpty(catalogoDTO.getAbreviaturasHijas())){
                    CatalogoRepository repositorioSubramo = getRepository(Subramo.class);
                    List<Subramo> subramos = repositorioSubramo.findAllByAbreviaturaIn(catalogoDTO.getAbreviaturasHijas());
                    if(!ObjectUtils.isEmpty(subramos)){
                        ((Ramo) instancia).setSubramos(subramos);
                    }
                }
            }else if(instancia instanceof Contrato){
                if(!ObjectUtils.isEmpty(catalogoDTO.getAbreviaturasHijas())){
                    CatalogoRepository repositorioTipoContrato = getRepository(TipoContrato.class);
                    List<TipoContrato> contrato = repositorioTipoContrato.findAllByAbreviaturaIn(catalogoDTO.getAbreviaturasHijas());
                    if(!ObjectUtils.isEmpty(contrato)){
                        ((Contrato) instancia).setTipoContrato(contrato);
                    }
                }
            }
            
            repository.save(instancia);
            
        } catch (InstantiationException ex) {
            LOGGER.warn(" Excepcion: [{}]", ex);
        } catch (IllegalAccessException ex) {
            LOGGER.warn(" Excepcion: [{}]", ex);
        }catch(DataIntegrityViolationException e){
            String mensaje = "No fue posible realizar el guardado de la entidad. El catalogo "+catalogoEnum.getCatalogo()+" ya " +
                    "contiene un elemento con la abreviatura: [" + catalogoDTO.getAbreviatura() + "].";
            LOGGER.warn(mensaje + " Excepcion: [{}]", e);
            throw e;
        }
        
    }
    
    
    public void update(@NotNull CatalogoEnum catalogoEnum,@HasText String abreviatura,@NotNull CatalogoDTO catalogoDTO){
        
        Class<?> domain = getDomainClass(catalogoEnum);
        CatalogoRepository repository = getRepository(domain);
        Object instancia =  repository.findByAbreviatura(abreviatura);
        validarElementoExistente((Serializable) domain.cast(instancia),catalogoEnum,abreviatura,domain);
        
        if(instancia instanceof BaseCatalogo){
            if (!ObjectUtils.isEmpty(catalogoDTO.getAbreviatura())){
                ((BaseCatalogo)instancia).setAbreviatura(catalogoDTO.getAbreviatura());
            }
            
            if(!ObjectUtils.isEmpty(catalogoDTO.getEtiqueta())){
                ((BaseCatalogo)instancia).setEtiqueta(catalogoDTO.getEtiqueta());
            }
            ((BaseCatalogo)instancia).getConfiguracion().setUltimaActualizacion(new DateTime());
        }else if(instancia instanceof Metal){
            if (!ObjectUtils.isEmpty(catalogoDTO.getAbreviatura())){
                ((Metal)instancia).setAbreviatura(catalogoDTO.getAbreviatura());
            }
            
            if(!ObjectUtils.isEmpty(catalogoDTO.getEtiqueta())){
                ((Metal)instancia).setEtiqueta(catalogoDTO.getEtiqueta());
            }
            ((Metal)instancia).getConfiguracion().setUltimaActualizacion(new DateTime());
        }else if(instancia instanceof QuilatajeOro){
            if (!ObjectUtils.isEmpty(catalogoDTO.getAbreviatura())){
                ((QuilatajeOro)instancia).setAbreviatura(catalogoDTO.getAbreviatura());
            }
            
            if(!ObjectUtils.isEmpty(catalogoDTO.getEtiqueta())){
                ((QuilatajeOro)instancia).setEtiqueta(catalogoDTO.getEtiqueta());
            }
            ((QuilatajeOro)instancia).getConfiguracion().setUltimaActualizacion(new DateTime());
        }
        
        if(instancia instanceof Ramo){
            if(!ObjectUtils.isEmpty(catalogoDTO.getAbreviaturasHijas())){
                CatalogoRepository repositorioSubramo = getRepository(Subramo.class);
                List<Subramo> subramos = repositorioSubramo.findAllByAbreviaturaIn(catalogoDTO.getAbreviaturasHijas());
                if(!ObjectUtils.isEmpty(subramos)){
                    ((Ramo) instancia).getSubramos().clear();
                    ((Ramo) instancia).setSubramos(subramos);
                }
            }
        }else if(instancia instanceof Contrato){
            if(!ObjectUtils.isEmpty(catalogoDTO.getAbreviaturasHijas())){
                CatalogoRepository repositorioTipoContrato = getRepository(TipoContrato.class);
                List<TipoContrato> contrato = repositorioTipoContrato.findAllByAbreviaturaIn(catalogoDTO.getAbreviaturasHijas());
                if(!ObjectUtils.isEmpty(contrato)){
                    ((Contrato) instancia).setTipoContrato(contrato);
                }
            }
        }
        
        try {
            repository.saveAndFlush(instancia);
        } catch (DataIntegrityViolationException e) {
            String mensaje = "No fue posible realizar la actualizacion de la entidad. El catalogo "+catalogoEnum.getCatalogo()+" ya " +
                    "contiene un elemento con la abreviatura: [" + catalogoDTO.getAbreviatura() + "].";
            LOGGER.warn(mensaje + " Excepcion: [{}]", e);
            throw e;
        }

    }
        
    
    private CatalogoRepository  getRepository(Class<?> domainClass){
        return (CatalogoRepository)this.repositories.getRepositoryFor(domainClass);
    }
    
    private Class<?> getDomainClass(CatalogoEnum catalogoEnum){
        Class<?> domain = null;
        switch(catalogoEnum){
            case PERFIL: domain = Perfil.class; break;
            case RAMO: domain = Ramo.class;break;
            case SUBRAMO: domain = Subramo.class;break;
            case SUCURSAL: domain = Sucursal.class; break;
            case TIPOCONTRATO: domain = TipoContrato.class;break;
            case OPERACIONCAJA: domain = OperacionCaja.class; break;
            case METAL: domain = Metal.class; break;
            case QUILATES: domain = QuilatajeOro.class; break;
            case CONTRATO: domain = Contrato.class; break;
            default:break;
        }
        
        
        return domain;
        
    }
    
    private ConfiguracionCatalogo actualizarConfiguracion(CatalogoEnum catalogoEnum) {
        ConfiguracionCatalogoEnum config = getConfiguracionCatalogo(catalogoEnum);

        return configuracionCatalogoService.getAndUpdateOperationDate(config.getDominioUnwrap(), config.getTipo());
    }
    
    protected ConfiguracionCatalogoEnum getConfiguracionCatalogo(CatalogoEnum catalogoEnum) {
        ConfiguracionCatalogoEnum config = null;
        switch(catalogoEnum){
            case PERFIL: config = ConfiguracionCatalogoEnum.PERFILES; break;
            case RAMO: config = ConfiguracionCatalogoEnum.RAMOS;break;
            case SUBRAMO: config = ConfiguracionCatalogoEnum.SUBRAMOS;break;
            case SUCURSAL: config = ConfiguracionCatalogoEnum.SUCURSALES; break;
            case TIPOCONTRATO: config = ConfiguracionCatalogoEnum.TIPO_CONTRATOS;break;
            case OPERACIONCAJA: config = ConfiguracionCatalogoEnum.OPERACIONES_CAJA; break;
            case METAL: config = ConfiguracionCatalogoEnum.METAL; break;
            case QUILATES: config = ConfiguracionCatalogoEnum.QUILATAJE_ORO; break;
            case CONTRATO: config = ConfiguracionCatalogoEnum.CONTRATOS; break;
            default:break;
        }
        return config;
    }
    
    
    private void validarElementoExistente(Serializable serial,CatalogoEnum catalogoEnum,String abreviatura,Class<?> domain){
        if (ObjectUtils.isEmpty(serial)) {
                String mensaje =
                    "El catalogo"+ catalogoEnum.getCatalogo() +" no contiene un elemento con la abreviatura: [" + abreviatura + "].";
                LOGGER.warn(mensaje);
                throw new CatalogoNotFoundException(mensaje, domain);
        }
    }
    
    private void validarElementoExistenteId(Serializable serial,CatalogoEnum catalogoEnum,Long IdElement,Class<?> domain){
        if (ObjectUtils.isEmpty(serial)) {
                String mensaje =
                    "El catalogo"+ catalogoEnum.getCatalogo() +" no contiene un elemento con la abreviatura: [" + IdElement + "].";
                LOGGER.warn(mensaje);
                throw new CatalogoNotFoundException(mensaje, domain);
        }
    }
    
}
