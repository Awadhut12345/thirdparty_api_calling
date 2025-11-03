package com.in.irise.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.irise.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	// get all data for client side
	@GetMapping
	public List<Map<String, Object>> getAllPosts() {
		return postService.getAllPosts();	
	}
	
	//get data by id
	@GetMapping("/{id}")
	public Map<String, Object> getPostById(@PathVariable Long id) {
		return postService.getPostbyId(id);
	}
}
