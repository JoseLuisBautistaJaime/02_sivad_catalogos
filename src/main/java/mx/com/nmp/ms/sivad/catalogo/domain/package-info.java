/**
 * La definición de catálogo está basada en configuraciones
 * {@link mx.com.nmp.ms.sivad.catalogo.domain.ConfiguracionCatalogo}; estas configuraciones permitirán
 * identificar el dominio y el tipo de catálogo al cual se está accediendo.
 * <p>
 * Cada catálogo tendrá un conjunto de 1 o más entradas, para efectos de catálogos con descendencia se define
 * dicha relación en una entidad; esta entidad debe ser empleada únicamente para el caso de catálogos anidados.
 * <p>
 * Cada entrada definida en un catálogo, tendrá un identificador de configuración asociado
 * al tipo particular del catálogo usado, ejemplo de un tipo válido será “Claridad”, el cual pertenecerá
 * al dominio “Diamante”.
 * <p>
 * Para los casos de creación de nuevos catálogos, es necesario clasificarlos por dominio y tipo,
 * esto con el fin de hacer configurable el procedimiento de agregación de nuevos catálogos.
 * <p>
 * La nomenclatura de nombre de las entidades debe ser: cat_<dominio>_<tipo_catalogo>.
 *
 * @author osanchez
 */
package mx.com.nmp.ms.sivad.catalogo.domain;
