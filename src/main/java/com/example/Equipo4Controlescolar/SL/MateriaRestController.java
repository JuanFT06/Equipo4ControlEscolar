/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.SL;

import com.example.Equipo4Controlescolar.BL.MateriaService;
import com.example.Equipo4Controlescolar.DL.Materia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/api/materia")
public class MateriaRestController {
    
    @Autowired
    private MateriaService materiaService;
    
    @GetMapping("/listado")
    public ResponseEntity<List<Materia>> obtenerMateria(){
        List<Materia> materias = materiaService.obtenerTodasLasMaterias();
        return ResponseEntity.ok(materias);
    }
    
}
