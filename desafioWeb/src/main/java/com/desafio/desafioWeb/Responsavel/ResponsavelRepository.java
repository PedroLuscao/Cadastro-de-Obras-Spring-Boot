package com.desafio.desafioWeb.Responsavel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>{

    @Query("SELECT r FROM Responsavel r WHERE r.codigo = ?1")
    Optional<Responsavel> findResponsavelByCodigo(Long codigo);

    @Query("SELECT r FROM Responsavel r WHERE r.cpf = ?1")
    Optional<Responsavel> findResponsavelByCpf(String cpf);
    
}