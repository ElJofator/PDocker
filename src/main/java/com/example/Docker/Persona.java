package com.example.Docker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Persona")
public class Persona{

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Column
    private int edad;

	public Persona(String nombre, String apellidos, int edad){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Persona(int id, String nombre, String apellidos, int edad){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public Persona(){

    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellidos(){
        return apellidos;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public int getId(){
        return id;
    }
}