package mx.com.nmp.ms.sivad.catalogo.repository;

import mx.com.nmp.ms.sivad.catalogo.domain.TipoPrenda;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoPrendaRepository extends JpaRepository<TipoPrenda, Long> {
    /**
     * Recupera un elemento del catálogo.
     *
     * @param abreviatura Abreviatura del elemento a recuperar.
     *
     * @return Elemento del catálogo o {@literal null} si no existe.
     */
    TipoPrenda findByAbreviatura(String abreviatura);
}