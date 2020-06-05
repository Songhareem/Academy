package com.song.mysql.schedule;

import java.util.Calendar;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestSchedule {

	@Scheduled(fixedRate = 1000)
	public void rateSchedule() throws Exception {
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("rate : "+Calendar.getInstance().getTime());
		Random random = new Random();
		int d = random.nextInt(3000) + 1000;
		Thread.sleep(d);
	}
	
	@Scheduled(fixedDelay=1000)
	public void delay() throws Exception{
		System.out.println(Thread.currentThread().getName());
		System.out.println("delay : "+Calendar.getInstance().getTime());
		Random random = new Random();
		int d = random.nextInt(3000) + 1000;
		Thread.sleep(d);
	}

	@Scheduled(cron = "10 * * * * *")
	public void cronSchedule() throws Exception {
		
		System.out.println("cron : "+Calendar.getInstance().getTime());
	}	
	
}
