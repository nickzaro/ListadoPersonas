package com.nick.backend.services;

import com.nick.backend.entities.Persona;
import com.nick.backend.exceptions.PersonaNotFoundException;
import com.nick.backend.repositories.PersonaRepository;

import java.util.List;
import java.util.Optional;

public class PersonaServiceImpl implements PersonaService {

    private PersonaRepository personaRepository;
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> findAll() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public Persona findById(Long id) throws PersonaNotFoundException {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if(personaOptional.isEmpty())
            throw new PersonaNotFoundException("No exista la persona con id: " + id);
        return personaOptional.get();
    }

    @Override
    public void save(Persona persona) {
        personaRepository.save(persona);

    }

    @Override
    public void update(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void delete(Persona persona) {
        personaRepository.delete(persona);

    }
}
