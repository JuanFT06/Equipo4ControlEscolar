/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.BL;

import com.example.Equipo4Controlescolar.DL.AlumnoMateriaRepository;
import com.example.Equipo4Controlescolar.DL.MateriasNoAgregadas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digis
 */
@Service
public class AlumnoMateriaService {

    @Autowired
    public AlumnoMateriaService(AlumnoMateriaRepository repository) {
        this.repository = repository;
    }
    private final AlumnoMateriaRepository repository;
    
    
    public List<MateriasNoAgregadas> getMateriasNoAgregadas(int id){
        return this.repository.getMateriasNoAgregadas(id);
    }
}
