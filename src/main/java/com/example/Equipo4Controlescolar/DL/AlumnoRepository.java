
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Equipo4Controlescolar.DL;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    @Procedure(name = "AlumnoAdd")
    String procedureAdd(@Param("NombreU") String Nombre,
            @Param("ApellidoPaternoU") String ApellidoPaterno,
            @Param("ApellidoMaternoU") String ApellidoMaterno);

    @Procedure(name = "AlumnoUpdate")
    String procedureUpdate(@Param("IdAlumnoU") int idalumno, @Param("NombreU") String Nombre,
            @Param("ApellidoPaternoU") String ApellidoPaterno,
            @Param("ApellidoMaternoU") String ApellidoMaterno);

    @Procedure(name = "AlumnoDelete")
    String procedureDelete(@Param("IdAlumnoU") int alumnoId);

    Alumno findByNombre(String nombre);
}

