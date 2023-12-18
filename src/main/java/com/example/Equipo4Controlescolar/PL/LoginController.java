/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Equipo4Controlescolar.PL;

import com.example.Equipo4Controlescolar.BL.AlumnoService;
import com.example.Equipo4Controlescolar.DL.Alumno;
import com.example.Equipo4Controlescolar.DL.AlumnoLogin;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("")
public class LoginController {

    public LoginController(com.example.Equipo4Controlescolar.BL.AlumnoService service) {
        this.service = service;
    }
    
    private final AlumnoService service;
    
    @GetMapping("/")
    public String Login(Model model){
        model.addAttribute("alumnoLogin",new AlumnoLogin());
        return "Login";
    }
    
    
      @PostMapping("/")
    public String Login(@Valid @ModelAttribute("alumnoLogin") AlumnoLogin alumnoLogin, BindingResult bindingResult, HttpSession session, Model model) {
        
        //hay un error
        if (bindingResult.hasErrors()) {
            model.addAttribute("alumnoLogin", alumnoLogin);
            return "Login";
        }
        
        //Buscar el alumno
        Alumno alumno = this.service.getByNombre(alumnoLogin.getNombre());
        
          if (alumno.getApellidopaterno().equals(alumnoLogin.getApellidoPaterno())) {
              return "redirect:/alumno/ListaAlumnos";
          }else{
               model.addAttribute("error", true);
                return "Login";
          }
        
    }
}
