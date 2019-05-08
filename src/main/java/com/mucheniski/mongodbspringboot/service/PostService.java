package com.mucheniski.mongodbspringboot.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mucheniski.mongodbspringboot.exception.ObjectNotFoundException;
import com.mucheniski.mongodbspringboot.model.Post;
import com.mucheniski.mongodbspringboot.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public List<Post> findAll() { 
		return postRepository.findAll();
	}	
		
	public Post findById(String id) {
		Optional<Post> user = postRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado com o ID: " + id));
	}
	
	// Exemplo com consulta simples
	public List<Post> findByTitle(String text) {
		return postRepository.findByTitleContainingIgnoreCase(text);
	}	
	
	// Exemplo com @Query
	public List<Post> findByTitleWhitQuery(String text) {
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + (24 * (60 * 60 * 1000)));
		return postRepository.fullSearch(text, minDate, maxDate);
	}
	
}
