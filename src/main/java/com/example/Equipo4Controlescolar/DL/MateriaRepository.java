/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Equipo4Controlescolar.DL;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author digis
 */
public interface MateriaRepository extends CrudRepository<Materia, Integer> {

    @Query(value = "SELECT m FROM Materia m")
    List<Materia> findAllMaterias();

}
