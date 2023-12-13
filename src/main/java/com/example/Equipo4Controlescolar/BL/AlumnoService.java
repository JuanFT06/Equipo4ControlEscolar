/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.BL;

import com.example.Equipo4Controlescolar.DL.Alumno;
import com.example.Equipo4Controlescolar.DL.AlumnoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digis
 */
@Service
public class AlumnoService {

    private AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> findall() {
        return alumnoRepository.findAll();
    }

    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Alumno updateAlumno(Alumno alumno, int alumnoId) {
        Optional<Alumno> optionalAlumno = alumnoRepository.findById(alumnoId);

        if (optionalAlumno.isPresent()) {
            Alumno alumnoDB = optionalAlumno.get();
            alumnoDB.setNombre(alumno.getNombre());
            alumnoDB.setApellidopaterno(alumno.getApellidopaterno());
            alumnoDB.setApellidomaterno(alumno.getApellidomaterno());
            return alumnoRepository.save(alumnoDB);
        } else {

            return null;
        }

}
    public void deleteDepartmentById(int alumnoId) {
        alumnoRepository.deleteById(alumnoId);
    }
}