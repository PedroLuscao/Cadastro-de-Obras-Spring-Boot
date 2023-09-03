package com.desafio.desafioWeb.Obra;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.desafio.desafioWeb.Responsavel.Responsavel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/*
 * Classe responsável por criar obras
 */
@Entity
@Table
public class Obra {
    @Id
    @SequenceGenerator(
        name = "obra_sequencia",
        sequenceName = "obra_sequencia",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "obra_sequencia"
    )
    private Long numero;
    private LocalDate dataCadastro;
    private String descricao;

    @ManyToMany
    @JoinTable(
        name="responsaveis_obras",
        joinColumns = @JoinColumn(name = "obra_id"),
        inverseJoinColumns = @JoinColumn(name = "responsavel_id")
    )
    private Set<Responsavel> responsaveis = new HashSet<>();

    public Obra(Long numero, String descricao) {
        dataCadastro = LocalDate.now();
        this.numero = numero;
        this.descricao = descricao;
    }

    public Obra(String descricao) {
        dataCadastro = LocalDate.now();
        this.descricao = descricao;
    }

    public Obra() {
        dataCadastro = LocalDate.now();
    }

    // Getters e setters para os atributos
    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    public void addResponsavel(Responsavel responsavel){
        responsaveis.add(responsavel);
        System.out.println(getResponsaveis());
    }

    @Override
    public String toString() {
        return "Obra [numero=" + numero + ", dataCadastro=" + dataCadastro + ", descricao=" + descricao + "]";
    }

    public void setResponsaveis(Set<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }
}
