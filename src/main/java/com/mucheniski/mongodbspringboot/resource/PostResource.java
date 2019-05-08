package com.mucheniski.mongodbspringboot.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mucheniski.mongodbspringboot.model.Post;
import com.mucheniski.mongodbspringboot.service.PostService;
import com.mucheniski.mongodbspringboot.util.URL;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	 
	@Autowired
	private PostService postService;

	@GetMapping
	public ResponseEntity<List<Post>> findAll() {	
		List<Post> list = postService.findAll();		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {	
		Post post = postService.findById(id);		
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value="/findbytitle")
	public ResponseEntity <List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {			
		text = URL.decoreParam(text);		
		List<Post> list = postService.findByTitle(text);		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/findbytitleQuery")
	public ResponseEntity <List<Post>> findByTitleWhitQuery(@RequestParam(value="text", defaultValue="") String text) {			
		text = URL.decoreParam(text);		
		List<Post> list = postService.findByTitle(text);		
		return ResponseEntity.ok().body(list);
	}
	
}
