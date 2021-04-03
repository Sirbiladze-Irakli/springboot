package com.spring.springboot.repository;

import com.spring.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

    List<User> findAllByEnabled(int enabled);

    void deleteByUsername(String username);

    User save(String username);
}
