package com.example.Docker;

import java.util.ArrayList;
import java.util.Map;

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
    @Autowired
    private ServicioPersonaRedis servicioRedis;

    public Controlador(ServicioPersonaRedis servicioRedis){
        this.servicioRedis = servicioRedis;
    }

    @GetMapping("/listar")
    public ArrayList<Persona> listar(){
        return servicio.listar();
    }

    @GetMapping("/listarRedis")
    public Map<String, Persona> listarRedis(){
        return servicioRedis.listar();
    }

    @GetMapping("/buscar")
    public Persona buscar(@RequestParam(value="id") int id){
        return servicio.buscarPersona(id);
    }

    @GetMapping("/buscarRedis")
    public Persona buscarRedis(@RequestParam(value="id") String id){
        return servicioRedis.buscarPersona(id);
    }

    @GetMapping("/agregar")
    public ArrayList<Persona> agregar(@RequestParam(value="nombre") String nombre, @RequestParam(value="apellidos") String apellidos, @RequestParam(value="edad") int edad){
        Persona persona = new Persona(nombre, apellidos, edad);
        servicio.guardarPersona(persona);
        return servicio.listar();
    }

    @GetMapping("/agregarRedis")
    public Map<String, Persona> agregarRedis(@RequestParam(value="nombre") String nombre, @RequestParam(value="apellidos") String apellidos, @RequestParam(value="edad") int edad){
        Persona persona = new Persona(nombre, apellidos, edad);
        servicioRedis.guardarPersona(persona);
        return servicioRedis.listar();
    }

    @GetMapping("/editar")
    public ArrayList<Persona> editar(@RequestParam(value="id") int id, @RequestParam(value="nombre") String nombre, @RequestParam(value="apellidos") String apellidos, @RequestParam(value="edad") int edad){
        Persona persona = servicio.buscarPersona(id);
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setEdad(edad);
        servicio.guardarPersona(persona);
        return servicio.listar();
    }

    @GetMapping("/editarRedis")
    public Map<String, Persona> editarRedis(@RequestParam(value="id") int id, @RequestParam(value="nombre") String nombre, @RequestParam(value="apellidos") String apellidos, @RequestParam(value="edad") int edad){
        Persona persona = servicioRedis.buscarPersona(id+"");
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setEdad(edad);
        servicio.guardarPersona(persona);
        return servicioRedis.listar();
    }

    @GetMapping("/eliminar")
    public ArrayList<Persona> eliminar(@RequestParam(value="id") int id){
        servicio.eliminarPersona(id);
        return servicio.listar();
    }

    @GetMapping("/eliminarRedis")
    public Map<String, Persona> eliminarRedis(@RequestParam(value="id") int id){
        servicioRedis.eliminarPersona(id+"");
        return servicioRedis.listar();
    }
}