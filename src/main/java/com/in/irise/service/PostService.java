package com.in.irise.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService {
	
	private RestTemplate restTemplate;
	private final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

	public PostService(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}	

	/*
	 * This declares a public method that returns a List of Maps. Each element in
	 * the list will represent one JSON object (for example, one post). Each post is
	 * stored as a Map<String, Object> → a key-value representation of the JSON
	 * fields.
	 */
	public List<Map<String, Object>> getAllPosts() {
		ResponseEntity<List> response = restTemplate.getForEntity(BASE_URL, List.class);
		return response.getBody();
	}
	
	/*
	 * Declares a method that returns one post, represented as a Map. id is passed
	 * from the caller to tell which post to fetch (e.g., /posts/1).
	
	 * RestTemplate is blocking → waits for the response before returning.
	 * getForEntity() → gives full HTTP response (ResponseEntity = status + body)
	 * getForObject() → gives just the body (shortcut)
	 * Using Map is flexible, but not type-safe (you can replace it later with a
	 * Java DTO class).
	 */	
	
	public Map<String, Object> getPostbyId(Long id) {
		String url = BASE_URL + "/" +id;
		return restTemplate.getForObject(url, Map.class);	
	}
}
