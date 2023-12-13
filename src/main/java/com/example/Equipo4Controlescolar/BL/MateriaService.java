/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.BL;

import com.example.Equipo4Controlescolar.DL.Materia;
import com.example.Equipo4Controlescolar.DL.MateriaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digis
 */
@Service
public class MateriaService {

    private final MateriaRepository repository;

    @Autowired
    public MateriaService(MateriaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void registrarMateria(String nombre, double precio) {
        Materia materia = new Materia();

        materia.setNombre(nombre);
        materia.setPrecio(precio);

        repository.save(materia);
    }

    public Optional<Materia> obtenerMateriaPorId(int id) {
        return repository.findById(id);
    }

    public List<Materia> obtenerTodasLasMaterias() {
        return (List<Materia>) repository.findAll();
    }

    @Transactional
    public void eliminarMateria(int id) {
        repository.deleteById(id);
    }

    @Transactional
    public void actualizarMateria(int id, String nuevoNombre, double nuevoPrecio) {
        Optional<Materia> optionalMateria = repository.findById(id);

        if (optionalMateria.isPresent()) {
            Materia materia = optionalMateria.get();
            materia.setNombre(nuevoNombre);
            materia.setPrecio(nuevoPrecio);
            repository.save(materia);
        } else {
            throw new IllegalArgumentException("Materia no encontrada con ID: " + id);
        }
    }

}
