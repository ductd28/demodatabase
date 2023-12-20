package com.example.demodatabase.DAO;

import com.example.demodatabase.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    Boolean existsByUsername(String username);
    User findByUsername(String username);

    User getUserByUsername(String username);

}
