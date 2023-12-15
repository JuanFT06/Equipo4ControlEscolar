/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.SL;

import com.example.Equipo4Controlescolar.BL.MateriaService;
import com.example.Equipo4Controlescolar.DL.Materia;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/api/materia")
public class MateriaRestController {

    private final MateriaService materiaService;

    @Autowired
    public MateriaRestController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping("/listado")
    public ResponseEntity<List<Materia>> obtenerMateria() {
        List<Materia> materias = materiaService.obtenerTodasLasMaterias();
        return ResponseEntity.ok(materias);
    }

    @PostMapping("/agregar")
    public ResponseEntity<List<Materia>> agregarMateria(@RequestBody Materia nuevaMateria) {
        try {
            materiaService.registrarMateria(nuevaMateria.getNombre(), nuevaMateria.getPrecio());
            List<Materia> materiasActualizadas = materiaService.obtenerTodasLasMaterias();
            return ResponseEntity.ok(materiasActualizadas);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al agregar la materia", e);
        }
    }

    @GetMapping("/GetById/{idmateria}")
    public ResponseEntity<Materia> getById(@PathVariable int idmateria) {
        try {
            Optional<Materia> materia = materiaService.obtenerMateriaPorId(idmateria);
            if (materia.isPresent()) {
                return ResponseEntity.ok(materia.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al recuperar la materia", e);
        }
    }

    @DeleteMapping("/borrar/{idmateria}")
    public ResponseEntity<Materia> Delete(@PathVariable int idmateria) {
        try {
            Optional<Materia> materia = materiaService.obtenerMateriaPorId(idmateria);
            if (materia.isPresent()) {
                materiaService.eliminarMateria(idmateria);
                return ResponseEntity.ok(materia.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar la materia", e);
        }
    }

    @PutMapping("/update/{idmateria}")
    public ResponseEntity<Materia> updateMateria(@PathVariable int idmateria, @RequestBody Materia materiaActualizada) {
        try {
            Optional<Materia> optionalMateria = materiaService.obtenerMateriaPorId(idmateria);

            if (optionalMateria.isPresent()) {
                Materia materiaExistente = optionalMateria.get();

                materiaExistente.setNombre(materiaActualizada.getNombre());
                materiaExistente.setPrecio(materiaActualizada.getPrecio());

                Materia materiaActualizadaEnRepo = materiaService.actualizarMateria(materiaExistente);

                return ResponseEntity.ok(materiaActualizadaEnRepo);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al actualizar la materia", e);
        }
    }

}
