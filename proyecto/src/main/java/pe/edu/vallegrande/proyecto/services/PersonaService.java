package pe.edu.vallegrande.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.edu.vallegrande.proyecto.interfaces.PersonaInterfaces;
import pe.edu.vallegrande.proyecto.model.Persona;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaInterfaces faces;

    // Listar todas las personas
    public List<Persona> getAllPersona(){
        return faces.findAll();
    }

    // Listar persona por id
    public Optional<Persona> getPersonaId(Long id){
        return faces.findById(id);
    }

    // Guardar persona
    public Persona savPersona(Persona persona){
        persona.setEstado("A");
        return faces.save(persona);
    }

    // Actualizar persona
    public Optional<Persona> updatePersona(Persona persona,Long id){
        return faces.findById(id).map(per -> {
            per.setNombre(persona.getNombre());
            per.setApellido(persona.getApellido());
            per.setEdad(persona.getEdad());
            per.setEdad(persona.getEdad());
            return faces.save(per);
        });
    }

    // Eliminar persona
    public Optional<Persona> deletePersona(Long id){
        return faces.findById(id).map(per -> {
            per.setEstado("I");
            return faces.save(per);
        });
    }

    
}
