package com.nick.backend.controllers;

import com.nick.backend.entities.Persona;
import com.nick.backend.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/")
    public List<Persona> findAll(){
        return  personaService.findAll();
    }

}
