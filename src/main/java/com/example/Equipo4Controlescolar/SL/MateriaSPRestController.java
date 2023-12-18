/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.SL;

import com.example.Equipo4Controlescolar.BL.MateriaService;
import com.example.Equipo4Controlescolar.DL.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/sp/materia")
public class MateriaSPRestController {

    public MateriaSPRestController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @Autowired
    private MateriaService materiaService;

    @PostMapping("/AddSP")
    public String saveMateriasSP(@RequestBody Materia materia){
        return materiaService.saveMateriasP(materia);
    }
    
    @PutMapping("/updatesp/{idmateria}")
    public String updateMateriaSP(@PathVariable int idmateria, @RequestBody Materia materia){
        materia.setIdmateria(idmateria);
        return materiaService.updateMateriaSP(materia);
    }
    
    @DeleteMapping("/deleteSP/{idmateria}")
    public String deleteMateriaSP(@PathVariable int idmateria){
        return materiaService.deleteMateriaSP(idmateria);
    }
    
    

}
