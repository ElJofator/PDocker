package com.example.Docker;

import java.util.ArrayList;

public interface ServicioPersona{
    public void agregarPersona(Persona persona);
    public Persona buscarPersona(int id);
    public ArrayList<Persona> listar();
    public void editarPersona(int id);
    public void eliminarPersona(int id);
}