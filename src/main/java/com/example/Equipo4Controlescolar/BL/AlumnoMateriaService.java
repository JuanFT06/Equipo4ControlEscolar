/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.BL;

import com.example.Equipo4Controlescolar.DL.AlumnoMateria;
import com.example.Equipo4Controlescolar.DL.AlumnoMateriaRepository;
import com.example.Equipo4Controlescolar.DL.MateriasNoAgregadas;
import com.example.Equipo4Controlescolar.DL.TotalMaterias;
import java.util.List;
import java.util.Map;
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
    
    public Map<String,Object> materiasNoAgregadasSP(int id){
        return this.repository.materiasNoAgregadasSP(id);
    }
    
    public List<MateriasNoAgregadas> getMateriasAgregadas(int id){
        return this.repository.getMateriasAgregadas(id);
    }
    
    public AlumnoMateria add(AlumnoMateria alumnoMateria){
        return this.repository.save(alumnoMateria);
    }
    
    public TotalMaterias getTotal(int id){
        return this.repository.getTotal(id);
    }
}
