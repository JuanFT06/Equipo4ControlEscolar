/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.DL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author digis
 */
@Entity
@Table(name = "Materia")
public class Materia {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idmateria")
    private int idmateria;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column (name = "precio")
    private double precio;

    public int getIdmateria() {
        return idmateria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Materia() {
    }

    public Materia(int idmateria, String nombre, double precio) {
        this.idmateria = idmateria;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    
    
    
    
}
