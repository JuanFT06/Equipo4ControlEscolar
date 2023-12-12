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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author digis
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class AlumnoMateria {
    @Id
    @Column(name = "idrelacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
   @OneToMany
   @JoinColumn(name = "idalumno")
   private Alumno alumno;
   
    @OneToMany
   @JoinColumn(name = "idmateria")
   private Materia materia;
}
