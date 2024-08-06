package com.quinnox.training.clowns.userspef;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, Long>{
    Optional<Users> findByUsername(String username);

    Boolean existsByUsername(String username);
}
