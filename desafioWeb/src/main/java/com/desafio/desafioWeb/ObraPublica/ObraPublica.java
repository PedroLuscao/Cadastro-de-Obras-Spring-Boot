package com.desafio.desafioWeb.ObraPublica;

import java.time.LocalDate;

import com.desafio.desafioWeb.Obra.Obra;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/*
 * Classe responsável por criar Obras públicas
 */
@Entity
@Table
public class ObraPublica extends Obra {
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public ObraPublica(Long numero, String descricao, LocalDate dataInicio, LocalDate dataFim) {
        super(numero, descricao);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public ObraPublica(String descricao, LocalDate dataInicio, LocalDate dataFim) {
        super(descricao);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public ObraPublica(){
    }

    // Getters e setters para os atributos específicos de ObraPublica
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}