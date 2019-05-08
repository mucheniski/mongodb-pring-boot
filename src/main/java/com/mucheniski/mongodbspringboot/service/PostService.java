package com.mucheniski.mongodbspringboot.service;

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
	
}
