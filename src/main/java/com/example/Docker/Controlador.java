package com.example.Docker;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Persona buscar(@RequestParam(value="id") int id){
        return servicio.buscarPersona(id);
    }

    @GetMapping("/agregar")
    public ArrayList<Persona> agregar(@RequestParam(value="nombre") String nombre, @RequestParam(value="apellidos") String apellidos, @RequestParam(value="edad") int edad){
        Persona persona = new Persona(nombre,apellidos,edad);
        return servicio.listar();
    }

    @GetMapping("/editar")
    public ArrayList<Persona> buscar(@RequestParam(value="id") int id, @RequestParam(value="nombre") String nombre, @RequestParam(value="apellidos") String apellidos, @RequestParam(value="edad") int edad){
        Persona persona = servicio.buscarPersona(id);
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setEdad(edad);
        return servicio.listar();
    }

    @GetMapping("/eliminar")
    public ArrayList<Persona> eliminar(@RequestParam(value="id") int id){
        servicio.eliminarPersona(id);
        return servicio.listar();
    }
}