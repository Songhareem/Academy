package com.song.test2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodayTest {

	@BeforeAll
	public static void BeforeAllTest() {
		System.out.println("Before All");
	}
	
	@AfterAll
	public static void AfterAllTest() {
		System.out.println("After All");
	}
	
	@BeforeEach
	public void beforeTest() {
		System.out.println("before test");
	}
	
	@Test
	public void test() {
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}

	@AfterEach
	public void afterTest() {
		System.out.println("after test");
	}
}
