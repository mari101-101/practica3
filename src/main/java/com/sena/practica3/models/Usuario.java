package com.sena.practica3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    private Integer numDoc;
    private String nombre;
    private String apellido;
    private java.time.LocalDate fechaNacimiento;

    // Getters and setters
}
