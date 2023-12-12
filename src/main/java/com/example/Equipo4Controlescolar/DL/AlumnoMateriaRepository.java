/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Equipo4Controlescolar.DL;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author digis
 */
public interface AlumnoMateriaRepository extends ListCrudRepository<AlumnoMateria, Integer> {

    @Query(value = "SELECT "
            + " materia.idmateria, "
            + " materia.nombre, "
            + " materia.costo  "
            + " from materia where idmateria not in( "
            + " select idmateria from  alumnomateria where idalumno=:id "
            + " )", nativeQuery = true)
    List<MateriasNoAgregadas> getMateriasNoAgregadas(@Param("id") int id);

}
