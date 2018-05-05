package com.ghosh.jaagteyRaho.service.quartzServices;

import org.springframework.scheduling.annotation.Scheduled;

public class CronScheduler {

	@Scheduled(cron = "0 0/1 * 1/1 * ? *")
	public void run() throws InterruptedException {
		System.out.println("asdfadsfasdfasfasdfasfd");
	}

}
