package com.example.Docker;

import java.util.ArrayList;

public interface ServicioPersona{
    ArrayList<Persona> listar();
    Persona buscarPersona(int id);
}