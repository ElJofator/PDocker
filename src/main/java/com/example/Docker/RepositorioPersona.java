package com.example.Docker;

import java.util.ArrayList;

import org.springframework.data.repository.Repository;

public interface RepositorioPersona extends Repository<Persona, Integer>{
    public Persona save(Persona persona);
    public Persona findOne(int id);
    public ArrayList<Persona> findAll();
    public void delete(int id);
}