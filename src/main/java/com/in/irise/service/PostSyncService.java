package com.in.irise.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.in.irise.entity.User;
import com.in.irise.repository.UserRepository;
import java.util.stream.Collectors;

@Service
public class PostSyncService {
	
	private UserRepository userRepository;
	private RestTemplate restTemplate = new RestTemplate();
	
	public void syncPostsFromApi() {
		String apiUrl = "https://jsonplaceholder.typicode.com/posts";
		
		System.out.println("Fetching posts from API..");
		User[] response = restTemplate.getForObject(apiUrl, User[].class);
		
		if(response == null || response.length == 0) {
			System.out.println("No data received from API.");
			return;
		}
		
		List<User> allPosts = Arrays.asList(response);
		System.out.println("Total posts received: " + allPosts.size());
		
		int batchSize = 10;
		for(int i =0; i<allPosts.size(); i += batchSize) {
			int end = Math.min(i + batchSize, allPosts.size());
			
			List<User> batch = allPosts.subList(i, end)
					.stream()
					.map(this::mapToEntity)
					.collect(Collectors.toList());
			
			userRepository.saveAll(batch);
			System.out.println("Save batch " + (i / batchSize + 1) + "("+ batch.size() + 
					" records)");
			
			try {
				Thread.sleep(1000);
				
			} catch(InterruptedException ignored) {
				
			}
		}
		System.out.println("All posts synced successfully!");	
	}
	
	private User mapToEntity(User user) {
		User userId = new User();
		userId.setUserId(user.getUserId());
		userId.setId(user.getId());
		userId.setTitle(user.getTitle());
		userId.setBody(user.getBody());
		
		return user;
	}
}
