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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
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
@Table(name = "alumnomateria")
@NamedStoredProcedureQuery(name = "AlumnoMateria.getmateriasnoagregadas",procedureName = "getmateriasnoagregadas",parameters = {
    @StoredProcedureParameter(name = "p_id",mode=ParameterMode.IN,type = Integer.class),
    @StoredProcedureParameter(name = "p_cursor",mode=ParameterMode.REF_CURSOR,type =Void.class)
})
public class AlumnoMateria {

    @Id
    @Column(name = "idrelacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idmateria")
    private Materia materia;
}
