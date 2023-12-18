/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Equipo4Controlescolar.DL;

import java.util.Optional;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author digis
 */
public interface MateriaRepository extends CrudRepository<Materia, Integer> {
    
    @Procedure(name = "ADDMATERIA")
    String ADDMATERIA(@Param("NombreM")String nombre,
            @Param("PrecioM") double precio);
    
    @Procedure(name = "UPDATEMATERIA")
    String UPDATEMATERIA(@Param("IdMateriaM")int idmateria, @Param("NombreM")String nombre,
            @Param("PrecioM")double precio);
    
    @Procedure(name = "deleteemateria")
    String deleteemateria(@Param("IdMateriaM")int idmateria);
    
    @Procedure(name = "GETMATERIABYID")
    Optional<Materia> getMateriaById(@Param("IdMateriaM") int idmateria);
}
