package com.desafio.desafioWeb.Obra;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ObraRepository extends JpaRepository<Obra, Long>{

    @Query("SELECT o FROM Obra o WHERE o.numero = ?1")
    Optional<Obra> findObraByNumero(Long numero);

    @Query("SELECT o FROM Obra o JOIN o.responsaveis r WHERE r.id = :responsavelId")
    List<Obra> getObrasOfResponsavel(@Param("responsavelId") Long responsavelId);
    
}
