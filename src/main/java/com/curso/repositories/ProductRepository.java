package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
