package com.nick.backend.services;

import com.nick.backend.entities.Persona;
import com.nick.backend.exceptions.PersonaNotFoundException;
import com.nick.backend.repositories.PersonaRepository;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.List;

public interface PersonaService {

    public List<Persona> findAll();

    public  Persona findById(Long id) throws PersonaNotFoundException;

    public  void save(Persona persona);

    public void update(Persona persona);

    public void delete(Persona persona);

}
