package com.in.irise.service;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PostScheduler {

	private PostSyncService postSyncService;
	
	public PostScheduler(PostSyncService postSyncService) {
		this.postSyncService=postSyncService;
	}
	
	//Run every hour
	@Scheduled(cron = "0 0 * * * * ")
	public void runPostSyncJob() {
		System.out.println("Starting API sync job at: " + LocalTime.now());
		postSyncService.syncPostsFromApi();
	}
	
	//Run every minute
	@Scheduled(cron = "0 * * * * *")
	public void everyMinuteJob() {
		System.out.println("Running ecery minute: " + LocalTime.now());
		postSyncService.syncPostsFromApi();
	}
}
