package com.mucheniski.mongodbspringboot.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mucheniski.mongodbspringboot.model.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {		
		User bruna = new User("1", "Bruna", "bruna@teste.com");
		User diego = new User("2", "Diego", "diego@teste.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(bruna, diego));
		return ResponseEntity.ok().body(list);
	}
	
}
