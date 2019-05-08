package com.mucheniski.mongodbspringboot.configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mucheniski.mongodbspringboot.dto.AuthorDTO;
import com.mucheniski.mongodbspringboot.dto.CommentDTO;
import com.mucheniski.mongodbspringboot.model.Post;
import com.mucheniski.mongodbspringboot.model.User;
import com.mucheniski.mongodbspringboot.repository.PostRepository;
import com.mucheniski.mongodbspringboot.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User bruna = new User(null, "Bruna", "bruna@mucheniski.com");
		User diego = new User(null, "Diego", "diego@mucheniski.com");
		User miguel = new User(null, "Miguel", "miguel@mucheniski.com");
		User livia = new User(null, "Livia", "livia@mucheniski.com");		
		userRepository.saveAll(Arrays.asList(bruna, diego, miguel, livia));
		
		Post post1 = new Post(null, sdf.parse("21/03/2019"), "Partiu Viagem", "Vou viajar para Cuiaba, abraços", new AuthorDTO(bruna));
		Post post2 = new Post(null, sdf.parse("22/03/2019"), "Feliz", "Bom dia, acordei feliz hoje!", new AuthorDTO(bruna));
		
		CommentDTO comment1 = new CommentDTO("Boa viagem linda!", sdf.parse("21/03/2019"), new AuthorDTO(diego));
		CommentDTO comment2 = new CommentDTO("Volta logo!", sdf.parse("21/03/2019"), new AuthorDTO(livia));
		CommentDTO comment3 = new CommentDTO("Que bom!", sdf.parse("21/03/2019"), new AuthorDTO(miguel));
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		bruna.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(bruna);
		
	}

}
