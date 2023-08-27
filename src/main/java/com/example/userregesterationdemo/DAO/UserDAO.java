package com.example.userregesterationdemo.DAO;

import com.example.userregesterationdemo.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
