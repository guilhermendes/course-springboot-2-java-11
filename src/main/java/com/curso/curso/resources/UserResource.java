package com.curso.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.curso.entities.User;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAl(){
		User u = new User(1L, "Maria", "maria@gmail.com", "999999", "123456789");
		return ResponseEntity.ok().body(u);
	}
}
