package com.in.irise.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.in.irise.service.WebClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebClientController {
	
	private WebClientService webClientService;
	
	public WebClientController(WebClientService webClientService) {
		this.webClientService = webClientService;
	}
	
	// get all data for client side
	@GetMapping
	public Flux<Map> getAllPosts() {
		return webClientService.getAllPosts();
	}
		
	//get data by id
	@GetMapping("/{id}")
	public Mono<Map> getPostById(@PathVariable Long id) {
		return webClientService.getPostById(id);	
	}
}
