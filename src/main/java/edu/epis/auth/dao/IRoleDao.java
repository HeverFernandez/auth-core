package edu.epis.sisga.dao;


import edu.epis.sisga.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by AITAMH on 18/11/2019.
 */
public interface IRoleDao extends JpaRepository<Role, Long> {

    Role findByDescripcionrol(String roleName);

    @Query("SELECT r FROM Role r WHERE r.idrol = :idrol")
    Role findByIdrol(@Param("idrol") Long idrol);

    //Role findByIdrol(Long idrol);
}
