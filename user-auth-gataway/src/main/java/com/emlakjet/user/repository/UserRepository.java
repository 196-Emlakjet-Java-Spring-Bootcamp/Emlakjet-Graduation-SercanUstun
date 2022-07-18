package com.emlakjet.user.repository;

import com.emlakjet.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // we created a new query here because we using it on register endpoint for
    // checking is there any user with this username if there is we send
    // HHTP status error code
    Optional<User> findByUsername(String username);

}
