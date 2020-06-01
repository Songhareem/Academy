package com.song.test2.robot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("left")
//@Qualifier("left")
public class LeftArm implements RobotArm {

	@Override
	public void punch() {
		// TODO Auto-generated method stub
		System.out.println("left punch");
	}
}
