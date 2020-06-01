package com.song.test2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.song.test2.phone.MobilePhone;

@SpringBootTest
class MobileTest {

	@Autowired
	private MobilePhone mobilePhone;
	
	@Test
	void test() {
		System.out.println(mobilePhone);
	}

	@Test
	void test2() {
		System.out.println(mobilePhone.getMobileCamera());
	}
}
