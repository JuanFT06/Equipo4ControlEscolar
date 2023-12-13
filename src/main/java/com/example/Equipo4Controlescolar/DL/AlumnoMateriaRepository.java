/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Equipo4Controlescolar.DL;

import ch.qos.logback.core.model.ParamModel;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author digis
 */
public interface AlumnoMateriaRepository extends JpaRepository<AlumnoMateria, Integer> {

    @Query(value = "select "
            + " idmateria as id, "
            + " nombre as nombre, "
            + " costo as costo"
            + " from materia where idmateria not in( "
            + " select idmateria from  alumnomateria where idalumno=:alumno"
            + " )", nativeQuery = true)
    List<MateriasNoAgregadas> getMateriasNoAgregadas(@Param("alumno") int id);

    @Query(value = "select "
            + " idmateria as id, "
            + " nombre as nombre, "
            + " costo as costo"
            + " from materia where idmateria in( "
            + " select idmateria from  alumnomateria where idalumno=:alumno"
            + " )", nativeQuery = true)
    List<MateriasNoAgregadas> getMateriasAgregadas(@Param("alumno") int id);

    @Query(value = "select sum(materia.costo) as total from materia\n"
            + "where idmateria in( select idmateria from  alumnomateria where idalumno=:alumno)", nativeQuery = true)
    TotalMaterias getTotal(@Param("alumno") int id);
    
    @Procedure(name = "AlumnoMateria.getmateriasnoagregadas")
    Map<String,Object> materiasNoAgregadasSP(@Param("p_id")int id);

}
