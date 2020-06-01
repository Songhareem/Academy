package com.song.test2.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SiriRobot {
	
	@Autowired
	@Qualifier("left")
	//@Resource(name="left")
	private RobotArm left;
	@Autowired
	private RobotArm rightArm;
	
	public void info() {
		System.out.println("Siri Robot");
	
		left.punch();
		rightArm.punch();
	}
}
