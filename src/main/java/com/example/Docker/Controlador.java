package com.example.Docker;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Controlador{
    @Autowired
    private ServicioPersona servicio;

    @GetMapping("/listar")
    public String listar(Model model){
        ArrayList<Persona> personas = servicio.listar();
        model.addAttribute("Personas", personas);
        return "index";
    }
}