package org.example.onlinevotingsystem.repositories;

import org.example.onlinevotingsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
