package com.desafio.desafioWeb.Responsavel;

import java.util.HashSet;
import java.util.Set;

import com.desafio.desafioWeb.Obra.Obra;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/*
 * Classe responsável por criar responsaveis, cada responsavel poderá ou não estar em uma Obra
 */
@Entity
@Table
public class Responsavel {
    @Id
    @SequenceGenerator(
        name = "responsavel_sequencia",
        sequenceName = "responsavel_sequencia",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "responsavel_sequencia"
    )
    private Long codigo;
    private String cpf;
    private String nome;

    @JsonIgnore
    @ManyToMany(mappedBy = "responsaveis", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Obra> obras = new HashSet<>();

    public Responsavel(Long codigo, String cpf, String nome) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Responsavel(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Responsavel(){
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Responsavel [codigo=" + codigo + ", cpf=" + cpf + ", nome=" + nome + "]";
    }

    public Set<Obra> getObras() {
        return obras;
    }

    public void setObras(Set<Obra> obras) {
        this.obras = obras;
    }
}
