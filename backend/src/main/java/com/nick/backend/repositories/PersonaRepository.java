package com.nick.backend.repositories;

import com.nick.backend.entities.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona,Long> {
}
