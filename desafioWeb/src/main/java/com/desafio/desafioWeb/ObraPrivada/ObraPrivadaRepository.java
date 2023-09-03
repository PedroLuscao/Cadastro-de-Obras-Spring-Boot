package com.desafio.desafioWeb.ObraPrivada;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ObraPrivadaRepository extends JpaRepository<ObraPrivada, Long> {

    @Query("SELECT o FROM Obra o WHERE o.numero = ?1")
    Optional<ObraPrivada> findObraPrivadaByNumero(Long numero);

}
