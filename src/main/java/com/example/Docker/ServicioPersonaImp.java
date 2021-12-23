package com.example.Docker;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPersonaImp implements ServicioPersona{
    @Autowired
    private RepositorioPersona repositorio;

    @Override
    public Persona buscarPersona(int id) {
        if(repositorio.existsById(id)){
            return repositorio.findById(id).get();
        }
        return null;
    }

    @Override
    public ArrayList<Persona> listar() {
        
        return (ArrayList<Persona>)repositorio.findAll();
    }

    @Override
    public void eliminarPersona(int id) {
        if(repositorio.existsById(id)){
            repositorio.deleteById(id);
        }
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return repositorio.save(persona);
    }
}