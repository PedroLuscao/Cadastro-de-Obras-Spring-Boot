package com.desafio.desafioWeb.ObraPublica;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ObraPublicaRepository extends JpaRepository<ObraPublica, Long> {
    @Query("SELECT o FROM Obra o WHERE o.numero = ?1")
    Optional<ObraPublica> findObraPublicaByNumero(Long numero);
}
