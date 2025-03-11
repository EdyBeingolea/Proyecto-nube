package pe.edu.vallegrande.proyecto.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.edu.vallegrande.proyecto.interfaces.PersonaInterfaces;
import pe.edu.vallegrande.proyecto.model.Persona;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaInterfaces faces;

    public List<Persona> listarPersona(){
        return faces.findAll();
    }

    public Persona savPersona(Persona persona){
        return faces.save(persona);
    }

    
}
