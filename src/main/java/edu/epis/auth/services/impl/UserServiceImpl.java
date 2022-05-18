package edu.epis.sisga.services.impl;

import edu.epis.sisga.dao.IUsuarioDao;
import edu.epis.sisga.entities.User;
import edu.epis.sisga.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public User getPersonaByUsuario(String username) {
        System.out.println("ESTOY EN EL METODO SERVICE USER >>> ");
        User user = this.usuarioDao.findPersonaByUsername(username);

        System.out.println("ID EXTRAIDO DEL USUARIO >>>> " + user.getPersona());

        return user;
    }
}
