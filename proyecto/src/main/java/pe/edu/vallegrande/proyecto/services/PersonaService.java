package pe.edu.vallegrande.proyecto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.vallegrande.proyecto.interfaces.PersonaInterfaces;
import pe.edu.vallegrande.proyecto.model.Persona;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonaService {

    private final PersonaInterfaces faces;

    // Listar todas las personas
    public List<Persona> getAllPersona() {
        return faces.findAll();
    }

    // Listar persona por id
    public ResponseEntity<?> getPersonaId(Long id) {
        Optional<Persona> persona = faces.findById(id);
        if (persona.isPresent()) {
            log.info("Persona encontrada: " + persona.get());
            return ResponseEntity.ok(faces.findById(id));
        } else {
            log.warn("Persona no encontrada con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona no encontrada con ID: " + id);
        }
    }

    // Guardar persona
    public Persona savPersona(Persona persona) {
        persona.setEstado("A");
        return faces.save(persona);
    }

    // Actualizar persona
    public Optional<Persona> updatePersona(Persona persona, Long id) {
        return faces.findById(id).map(per -> {
            per.setNombre(persona.getNombre());
            per.setApellido(persona.getApellido());
            per.setDni(persona.getDni());
            per.setEdad(persona.getEdad());
            per.setEdad(persona.getEdad());
            per.setEstado("A");
            return faces.save(per);
        });
    }

    // Eliminar persona
    public ResponseEntity<?> deletePersona( Long id) {
    Optional<Persona> personaOpt = faces.findById(id);

    if (personaOpt.isEmpty()) {
        log.warn("Persona no encontrada con ID: " + id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Persona no encontrada con ID: " + id);
    }

    Persona persona = personaOpt.get();

    if ("I".equals(persona.getEstado())) {
        log.warn("Persona ya está inactiva con ID: " + id);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Persona ya está inactiva con ID: " + id);
    }

    // Cambiar estado a inactivo
    persona.setEstado("I");
    Persona updatedPersona = faces.save(persona);
    
    log.info("Persona con ID " + id + " ha sido marcada como inactiva.");
    return ResponseEntity.ok(updatedPersona);
}

}
