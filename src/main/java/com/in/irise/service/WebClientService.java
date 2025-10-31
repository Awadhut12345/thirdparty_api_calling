package com.in.irise.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {

	private final WebClient webClient;
	
	public WebClientService(WebClient webClient) {
		this.webClient = webClient;
	}
	
	/*This Method
	 * Calls an external REST API (GET /posts) Returns a reactive stream of many
	 * results (Flux = many items) Each item is a Map (key-value pairs representing
	 * JSON)
	 * Mono<T> → one result (or none) 
	 * Flux<T> → multiple results (stream) WebClient
	 * → modern, non-blocking HTTP client 
	 * Map.class → tells WebClient to parse JSON into key-value pairs
	 */
	public Flux<Map> getAllPosts() {
		return webClient.get()
		       .uri("/posts")
		       .retrieve()
		       .bodyToFlux(Map.class);
	}
	
	/*
	 * This method: Calls GET /posts/{id} Returns a single item (Mono<Map>) Each Map
	 * represents one JSON object
	 */
	public Mono<Map> getPostById(Long id) {
		return webClient.get()
				.uri("/posts/{id}", id)
				.retrieve()
				.bodyToMono(Map.class);	
	}
}
