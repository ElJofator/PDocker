package com.example.Docker;

import java.util.ArrayList;

public interface ServicioPersona{
    public Persona guardarPersona(Persona persona);
    public Persona buscarPersona(int id);
    public ArrayList<Persona> listar();
    public void eliminarPersona(int id);
}