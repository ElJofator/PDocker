package com.example.Docker;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRedis{
    Map<String, Persona> listar();
    Persona buscarPersona(String id);
    void guardarPersona(Persona persona);
    void eliminarPersona(String id);
}