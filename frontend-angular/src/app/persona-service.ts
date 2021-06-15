import {Injectable} from "@angular/core";
import {Persona} from "./persona.model";
import {DataService} from "./data-service";

@Injectable()
export class PersonaService {
  personas: Persona[] =[];

  constructor(private dataService: DataService) {
  }

  // Se usa para modificar el valor del arreglo debido a la llamada asincrona
  setPersonas(personas: Persona[]){
    this.personas = personas;
  }

  obtenerPersonas(){
    return this.dataService.cargarPersonas();
  }
  agregarPersona(persona: Persona){
    console.log("persona a agregar: "+persona.nombre);
    
    this.dataService.agregarPersona(persona)
      .subscribe(
        (persona:Persona) =>{

          // Recuperamos el objeto persona con el id persona
          console.log("Se agrega al arreglo la persona recien insetada suscriber:"+persona.idPersona);
          this.personas.push(persona);
        }
      );
  }

  encontrarPersona(id: number){
    // @ts-ignore
    const persona: Persona = this.personas.find(persona => persona.idPersona == id);
    console.log("persona encontrada: "+ persona.idPersona + " " + persona.nombre);
    return persona;
  }

  modificarPersona(id: number,persona: Persona){
    console.log("persona a modificar: "+ persona.idPersona);
    this.dataService.modificarPersona(id,persona);
    const personaMod:Persona = this.encontrarPersona(id);
    personaMod.nombre = persona.nombre; // modifico el nombre en la vista


  }

  eliminarPersona(id:number){
    console.log("eliminar persona con id: "+ id);
    const  index = this.personas.findIndex(persona => persona.idPersona==id);
    this.personas.splice(index,1); // eliminar de la vista
    this.dataService.eliminarPersona(id); // eliminar del servidor
  }

}
