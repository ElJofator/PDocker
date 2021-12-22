package com.example.Docker;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controlador{
    @Autowired
    private ServicioPersona servicio;

    @GetMapping("/listar")
    public ArrayList<Persona> listar(){
        return servicio.listar();
    }

    @GetMapping("/buscar")
    public ArrayList<Persona> buscar(){
        return servicio.listar();
    }

    @GetMapping("/agregar")
    public ArrayList<Persona> agregar(){
        return servicio.agregarPersona();
    }
}