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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Persona> listar() {
        
        return (ArrayList<Persona>)repositorio.findAll();
    }

    @Override
    public void agregarPersona(Persona persona) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void editarPersona(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void eliminarPersona(int id) {
        // TODO Auto-generated method stub
        
    }

    
    
}