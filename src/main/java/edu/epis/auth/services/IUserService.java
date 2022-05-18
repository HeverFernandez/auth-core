package edu.epis.sisga.services;


import edu.epis.sisga.entities.User;

public interface IUserService {

    User getPersonaByUsuario(String username);
}
