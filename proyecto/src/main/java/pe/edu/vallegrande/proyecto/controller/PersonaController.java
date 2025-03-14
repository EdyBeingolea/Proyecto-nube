package pe.edu.vallegrande.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.edu.vallegrande.proyecto.model.Persona;
import pe.edu.vallegrande.proyecto.services.PersonaService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin()

public class PersonaController {

    private final PersonaService serviice;

    @GetMapping("/Personas")
    public List<Persona> getAllPersona(){
        return serviice.getAllPersona();
    }

    @GetMapping("/Personas/{id}")
    public ResponseEntity<?> getPersonaId(@PathVariable Long id){
        return serviice.getPersonaId(id);
    }

    @PostMapping("/Personas")
    public Persona save(@RequestBody Persona persona){
        return serviice.savPersona(persona);
    }

    @PutMapping("/Personas/{id}")
    public Optional<Persona> update(@RequestBody Persona persona, @PathVariable Long id){
        return serviice.updatePersona(persona, id);
    }

    @DeleteMapping("/Personas/{id}")
    public ResponseEntity<?> delete( @PathVariable Long id){
        return serviice.deletePersona(id);
    }
   



}
