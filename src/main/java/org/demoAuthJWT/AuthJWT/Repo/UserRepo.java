package org.demoAuthJWT.AuthJWT.Repo;

import org.demoAuthJWT.AuthJWT.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
