package com.mucheniski.mongodbspringboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mucheniski.mongodbspringboot.model.User;
import com.mucheniski.mongodbspringboot.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User bruna = new User(null, "Bruna", "bruna@mucheniski.com");
		User diego = new User(null, "Diego", "diego@mucheniski.com");
		User miguel = new User(null, "Miguel", "miguel@mucheniski.com");
		User livia = new User(null, "Livia", "livia@mucheniski.com");
		
		userRepository.saveAll(Arrays.asList(bruna, diego, miguel, livia));
		
	}

}
