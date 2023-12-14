/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.SL;

import com.example.Equipo4Controlescolar.BL.AlumnoMateriaService;
import com.example.Equipo4Controlescolar.BL.AlumnoService;
import com.example.Equipo4Controlescolar.DL.AlumnoMateria;
import com.example.Equipo4Controlescolar.DL.MateriasNoAgregadas;
import com.example.Equipo4Controlescolar.DL.TotalMaterias;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("/agregadas/{id}")
    public ResponseEntity<List<MateriasNoAgregadas>> getMateriasAgregadas(@PathVariable("id")int id){
        return ResponseEntity.ok(this.service.getMateriasAgregadas(id));
    }
     @GetMapping("/agregadas-sp/{id}")
    public ResponseEntity<List<MateriasNoAgregadas>> getMateriasAgregadasSP(@PathVariable("id")int id){
        return ResponseEntity.ok(this.service.materiasAgregadasSP(id));
    }
    
    @GetMapping("/no-agregadas/{id}")
    public ResponseEntity<List<MateriasNoAgregadas>> getMateriasNoAgregadas(@PathVariable("id")int id){
        return ResponseEntity.ok(this.service.getMateriasNoAgregadas(id));
    }
    @GetMapping("/no-agregadas-sp/{id}")
    public ResponseEntity<List<MateriasNoAgregadas>> getMateriasNoAgregadasSP(@PathVariable("id")int id){
        return ResponseEntity.ok(this.service.materiasNoAgregadasSP(id));
    }
    
      @GetMapping("/total/{id}")
    public ResponseEntity<TotalMaterias> getTotal(@PathVariable("id")int id){
        return ResponseEntity.ok(this.service.getTotal(id));
    }
    
    @PostMapping("")
    public ResponseEntity<AlumnoMateria> add(@RequestBody AlumnoMateria alumnoMateria){
        return ResponseEntity.status(201).body(this.service.add(alumnoMateria));
    }
    
    @PostMapping("/sp")
    public ResponseEntity<String> addSP(@RequestBody AlumnoMateria alumnoMateria){
        if (this.service.addSp(alumnoMateria)) {
            return ResponseEntity.status(201).body("Agregado");
        }
        
        return ResponseEntity.badRequest().build();
    }
    
}
