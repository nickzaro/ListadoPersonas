package com.nick.backend.controllers;

import com.nick.backend.entities.Persona;
import com.nick.backend.exceptions.PersonaNotFoundException;
import com.nick.backend.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/personas")
    public List<Persona> findAll(){
        return  personaService.findAll();
    }

    @GetMapping("/personas/{id}")
    public Persona findById(@PathVariable(value = "id") Long id){
        Persona persona= new Persona();
        try {
            persona= personaService.findById(id);
        } catch (PersonaNotFoundException e) {
            e.printStackTrace();
        }
        return persona;
    }

    @PostMapping("/personas")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona save(@RequestBody Persona persona){
        personaService.save(persona);
        return persona;
    }

    @PutMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Persona update(@RequestBody Persona persona, @PathVariable Long id){
        Persona personaRecuperada = new Persona();
        try {
            personaRecuperada = personaService.findById(id);
        } catch (PersonaNotFoundException e) {
            e.printStackTrace();
        }
        personaRecuperada.setNombre(persona.getNombre());
        personaService.save(personaRecuperada);
        return personaRecuperada;
    }

    @DeleteMapping("/personas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        Persona personaRecuperada = new Persona();
        try {
            personaRecuperada = personaService.findById(id);
        } catch (PersonaNotFoundException e) {
            e.printStackTrace();
        }
        personaService.delete(personaRecuperada);
    }


}
