package pe.edu.vallegrande.proyecto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.edu.vallegrande.proyecto.model.Persona;
import pe.edu.vallegrande.proyecto.services.PersonaService;

@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService serviice;

    @GetMapping("/listar")
    public List<Persona> getAllPersona(){
        return serviice.listarPersona();
    }

    @PostMapping("/guardar")
    public Persona save(@RequestBody Persona persona){
        return serviice.savPersona(persona);
    }

}
