package com.example.demo.repository;

import com.example.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer > {

    List<UserEntity> findAll();

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
