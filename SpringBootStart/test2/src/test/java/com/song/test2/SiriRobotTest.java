package com.song.test2;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.song.test2.robot.SiriRobot;

@SpringBootTest
class SiriRobotTest {

	@Autowired
	private SiriRobot siri;
	
	@Resource
	private SiriRobot siriRobot;
	
	@Test
	void test() {
		siri.info();
		//siriRobot.info();
	}

}
