/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.BL;

import com.example.Equipo4Controlescolar.DL.Alumno;
import com.example.Equipo4Controlescolar.DL.AlumnoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
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
    private EntityManager entityManager;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository, EntityManager entityManager) {
        this.alumnoRepository = alumnoRepository;
        this.entityManager = entityManager;
    }

    public List<Alumno> findall() {
        return alumnoRepository.findAll();
    }

    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void deleteAlumnoById(int alumnoId) {
        alumnoRepository.deleteById(alumnoId);
    }
    
     public List<Alumno> getAllAlumnosSP() {
        StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("AlumnoGetAll");
        storedProcedure.execute();
        return storedProcedure.getResultList();
    }

    public String saveAlumnoSP(Alumno alumno) {

        return alumnoRepository.procedureAdd(alumno.getNombre(),
                alumno.getApellidopaterno(),
                alumno.getApellidomaterno());
    }

    public String updateAlumnoSP(Alumno alumno) {

        return alumnoRepository.procedureUpdate(
                alumno.getIdalumno(),
                alumno.getNombre(),
                alumno.getApellidopaterno(),
                alumno.getApellidomaterno());
    }

    public String deleteAlumnoSP(int alumnoId) {

        return alumnoRepository.procedureDelete(alumnoId);
    }

   
}
