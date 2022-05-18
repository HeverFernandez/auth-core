package edu.epis.sisga.services.impl;


import edu.epis.sisga.dao.IRoleDao;
import edu.epis.sisga.entities.Role;
import edu.epis.sisga.services.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    protected IRoleDao roleDao;

    @Override
    public Role save(Role rol) {
        return this.roleDao.save(rol);
    }

    @Override
    public List<Role> findAll() {
        return this.roleDao.findAll();
    }

    @Override
    public void deleteRol(Long id) {
        this.roleDao.deleteById(id);
    }
}
