/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Equipo4Controlescolar.DL;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    Alumno findByNombre(String nombre);
}
