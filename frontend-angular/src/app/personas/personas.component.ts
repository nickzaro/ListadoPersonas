import { Component, OnInit } from '@angular/core';
import { PersonaService } from '../persona-service';
import { Router, ActivatedRoute } from '@angular/router';
import { Persona } from '../persona.model';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
})
export class PersonasComponent implements OnInit {


  personas: Persona[]=[];

  constructor(private personaService: PersonaService,
              private router: Router,
              private route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    this.personaService.obtenerPersonas().subscribe(
      (personas: Persona[]) => {
        this.personas = personas;
        this.personaService.setPersonas(personas);
        console.log("personas obtenidad del subscriber"+ this.personas)
      }
    )
  }

  irAgregar(){
    this.router.navigate(['./personas/agregar']);
  }

}
