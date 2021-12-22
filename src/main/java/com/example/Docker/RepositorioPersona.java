package com.example.Docker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPersona extends CrudRepository<Persona, Integer>{
}