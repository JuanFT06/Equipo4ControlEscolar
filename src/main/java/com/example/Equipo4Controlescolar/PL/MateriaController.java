/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.PL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/clase")
public class MateriaController {
    
   @GetMapping("/dashboard")
   public String Dashboard(){
       return "Materias";
   }
   
   @GetMapping("/dashboardSP")
   public String DashboardSP(){
       return "MateriasSP";
   }
    
}
