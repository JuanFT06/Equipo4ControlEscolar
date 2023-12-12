/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.SL;

import com.example.Equipo4Controlescolar.BL.AlumnoMateriaService;
import com.example.Equipo4Controlescolar.BL.AlumnoService;
import com.example.Equipo4Controlescolar.DL.MateriasNoAgregadas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("api/alumno-materia")
public class AlumnoMateriaRestController {
    private final AlumnoMateriaService service;

    @Autowired
    public AlumnoMateriaRestController(AlumnoMateriaService service) {
        this.service = service;
    }
    
    @GetMapping("/no-agregadas/{id}")
    public ResponseEntity<List<MateriasNoAgregadas>> getMateriasNoAgregadas(@PathVariable("id")int id){
        return ResponseEntity.ok(this.service.getMateriasNoAgregadas(id));
    }
    
}
