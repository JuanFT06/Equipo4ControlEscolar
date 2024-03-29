/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.SL;

import com.example.Equipo4Controlescolar.BL.AlumnoService;
import com.example.Equipo4Controlescolar.DL.Alumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/alumno")
public class AlumnoRestController {

    private AlumnoService alumnoService;

    @Autowired
    public AlumnoRestController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/GetAll")
    public List<Alumno> AlumnoList() {

        return alumnoService.findall();
    }

    @PostMapping("/Add")
    public Alumno saveAlumno(@RequestBody Alumno alumno) {

        return alumnoService.saveAlumno(alumno);
    }

    @PostMapping("/Update/{IdAlumno}")
    public Alumno updateAlumno(@PathVariable int IdAlumno, @RequestBody Alumno alumno) {
        alumno.setIdalumno(IdAlumno);
        return alumnoService.saveAlumno(alumno);
    }

    @DeleteMapping("/Delete/{IdAlumno}")
    public void deleteAlumno(@PathVariable int IdAlumno) {
        alumnoService.deleteAlumnoById(IdAlumno);
    }

    @GetMapping("/GetAllSP")
    public List<Alumno> getAllAlumnosSP() {
        return alumnoService.getAllAlumnosSP();
    }

    @PostMapping("/AddSP")
    public String saveAlumnoSP(@RequestBody Alumno alumno) {

        return alumnoService.saveAlumnoSP(alumno);
    }

    @PostMapping("/UpdateSP/{IdAlumno}")
    public String updateAlumnoSP(@PathVariable int IdAlumno, @RequestBody Alumno alumno) {
        alumno.setIdalumno(IdAlumno);
        return alumnoService.updateAlumnoSP(alumno);
    }

    @DeleteMapping("/DeleteSP/{IdAlumno}")
    public String deleteAlumnoSP(@PathVariable int IdAlumno) {

        return alumnoService.deleteAlumnoSP(IdAlumno);
    }
}
