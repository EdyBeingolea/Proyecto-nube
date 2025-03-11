package pe.edu.vallegrande.proyecto.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.vallegrande.proyecto.model.Persona;


@Repository
public interface PersonaInterfaces extends JpaRepository<Persona,Long>{

}
