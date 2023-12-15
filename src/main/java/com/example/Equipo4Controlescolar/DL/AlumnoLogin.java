/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.DL;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author digis
 */
@Data
public class AlumnoLogin {
    
    @NotEmpty(message = "ingresa un nombre")
    private String nombre;
    @NotEmpty(message = "ingresa un apellido")
    private String apellidoPaterno;
}
