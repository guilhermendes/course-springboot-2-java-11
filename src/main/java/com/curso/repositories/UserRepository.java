package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
