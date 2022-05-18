package edu.epis.sisga.services;

import edu.epis.sisga.entities.Role;

import java.util.List;

public interface IRolService {
    /**
     * Guarda un Rol
     *
     * @param rol
     * @return el rol guardado
     */
    Role save(Role rol);

    /**
     * Recupera la lista de roles
     *
     * @return lista de roles
     */
    List<Role> findAll();

    /**
     * Elimina un rol con el id recibido
     *
     * @param id
     */
    void deleteRol(Long id);
}
