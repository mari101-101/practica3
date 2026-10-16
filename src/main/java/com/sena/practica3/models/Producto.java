package com.sena.practica3.models;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

    @Entity
    public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String cat;
    private Integer valor;
    private Integer stock;

    public Producto() {
    }

    public Producto(Integer id, String nom, String cat, Integer valor, Integer stock) {
        this.id = id;
        this.nom = nom;
        this.cat = cat;
        this.valor = valor;
        this.stock = stock;
    }

    // Getters and setters

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCat() {
        return this.cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Integer getValor() {
        return this.valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
