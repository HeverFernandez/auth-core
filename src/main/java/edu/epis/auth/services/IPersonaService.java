package edu.epis.sisga.services;

import edu.epis.sisga.dto.PersonaDto;
import edu.epis.sisga.entities.Administrativo;
import edu.epis.sisga.entities.Docente;
import edu.epis.sisga.entities.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonaService {

    Estudiante saveEstudiante(Estudiante estudiante);

    List<PersonaDto> getAllPerson(String nomape);

     /*
            CRUD DOCENTE
     */
     Docente saveDocente(Docente docente);
     Page<Docente> getAllDocente(Pageable pageable);
     void deleteDocente(Long iddocente);

     List<PersonaDto> getByApellidoOrDni(String apellido, String dni);

//    Personal saveOrUpdatePersonal(Personal personal);
//
//    List<Personal> getAllPersonal();
//
//    Profesor saveDocente(Profesor profesor);
//
//    List<Profesor> getAllDocente();

    List<Administrativo> getAllPersonalActivo();

    Boolean existsByDni(String dni);
}
