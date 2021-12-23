package com.example.Docker;

import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ServicioPersonaRedis implements RepositorioRedis{
    private static final String KEY = "Persona";
    private RedisTemplate<String, Persona> redisTemplate;
    private HashOperations hashOperations;

    public ServicioPersonaRedis(RedisTemplate<String, Persona> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Persona buscarPersona(String id) {
        return (Persona)hashOperations.get(KEY, id);
    }

    @Override
    public Map<String, Persona> listar() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void eliminarPersona(String id) {
        hashOperations.delete(KEY, id);
    }

    @Override
    public void guardarPersona(Persona persona) {
        hashOperations.put(KEY, UUID.randomUUID().toString(), persona);
    }
}