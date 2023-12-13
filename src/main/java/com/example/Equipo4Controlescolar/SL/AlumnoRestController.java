/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.SL;

import com.example.Equipo4Controlescolar.BL.AlumnoService;
import com.example.Equipo4Controlescolar.DL.Alumno;
import com.example.Equipo4Controlescolar.DL.AlumnoRepository;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/alumno")
public class AlumnoRestController {

    private AlumnoService alumnoService;

    @Autowired
    public AlumnoRestController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/GetAll")
    public List<Alumno> fetchDepartmentList() {

        return alumnoService.findall();
    }

    @PostMapping("/Add")
    public Alumno saveDepartment(@RequestBody Alumno alumno) {

        return alumnoService.saveAlumno(alumno);
    }

     @PutMapping("/Update/{alumnoid}")
    public Alumno updateAlumno(@RequestBody Alumno alumno, @PathVariable int alumnoId) {
        return alumnoService.updateAlumno(alumno, alumnoId);
    }
}
