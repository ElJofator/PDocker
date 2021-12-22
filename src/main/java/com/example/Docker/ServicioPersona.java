package com.example.Docker;

import java.util.ArrayList;

public interface ServicioPersona{
    public Persona agregarPersona(Persona persona);
    public Persona buscarPersona(int id);
    public ArrayList<Persona> listar();
    public Persona editarPersona(int id);
    public Persona eliminarPersona(int id);
}