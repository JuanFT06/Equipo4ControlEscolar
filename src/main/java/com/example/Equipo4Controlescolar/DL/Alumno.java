/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.DL;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

/**
 *
 * @author digis
 */
@Entity

@NamedStoredProcedureQuery(
        name = "AlumnoGetAll",
        procedureName = "AlumnoGetAll",
        resultClasses = Alumno.class,
        parameters = {
            @StoredProcedureParameter(
                    mode = ParameterMode.REF_CURSOR,
                    type = void.class,
                    name = "resultado"
            )
        }
)
@NamedStoredProcedureQuery(
        name = "AlumnoAdd",
        procedureName = "AlumnoAdd",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "NombreU", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ApellidoPaternoU", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ApellidoMaternoU", type = String.class)

        })

@NamedStoredProcedureQuery(
        name = "AlumnoUpdate",
        procedureName = "AlumnoUpdate",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "IdAlumnoU", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "NombreU", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ApellidoPaternoU", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "ApellidoMaternoU", type = String.class)

        })
@NamedStoredProcedureQuery(
        name = "AlumnoDelete",
        procedureName = "AlumnoDelete",
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "IdAlumnoU", type = Integer.class),})

public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idalumno;
    @Basic
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;

    public Alumno() {
    }

    public Alumno(int idalumno, String nombre, String apellidopaterno, String apellidomaterno) {
        this.idalumno = idalumno;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
    }

    public Alumno(String nombre, String apellidopaterno, String apellidomaterno) {
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

}