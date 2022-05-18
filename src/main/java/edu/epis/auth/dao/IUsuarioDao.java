package edu.epis.sisga.dao;


import edu.epis.sisga.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by AITAMH on 18/11/2019.
 */
public interface IUsuarioDao extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    List<User> findByIdIn(List<Long> userIds);

    Boolean existsByUsername(String username);

    Boolean existsById(User id);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findPersonaByUsername(@Param("username") String username);


}
