package com.desafio.desafioWeb.ObraPrivada;

import com.desafio.desafioWeb.Obra.Obra;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/*
 * Classe responsável por criar obras privadas
 */
@Entity
@Table
public class ObraPrivada extends Obra {
    private ZonaEnum zona;
    private double areaTotal;

    public ObraPrivada(Long numero, String descricao, ZonaEnum zona, double areaTotal) {
        super(numero, descricao);
        this.zona = zona;
        this.areaTotal = areaTotal;
    }

    public ObraPrivada(String descricao, ZonaEnum zona, double areaTotal) {
        super(descricao);
        this.zona = zona;
        this.areaTotal = areaTotal;
    }

    public ObraPrivada(){
    }

    // Getters e setters para os atributos específicos de ObraPrivada
    public ZonaEnum getZona() {
        return zona;
    }

    public void setZona(ZonaEnum zona) {
        this.zona = zona;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(double areaTotal) {
        this.areaTotal = areaTotal;
    }
}
