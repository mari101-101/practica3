package com.sena.practica3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    public Integer numDoc;
    public String nombre;
    private String apellido;
    private java.time.LocalDate fechaNacimiento;


    public Usuario() {
    }

    public Usuario(Integer numDoc, String nombre, String apellido, java.time.LocalDate fechaNacimiento) {
        this.numDoc = numDoc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }


    // Getters and setters

    public Integer getNumDoc() {
        return this.numDoc;
    }

    public void setNumDoc(Integer numDoc) {
        this.numDoc = numDoc;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public java.time.LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(java.time.LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
