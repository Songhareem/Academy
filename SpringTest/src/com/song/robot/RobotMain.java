package com.song.robot;

public class RobotMain {

	public static void main(String[] args) {
		
		IronMan ironman = new IronMan();
		System.out.println((ironman.getLeftArm()).getName());
	}
}
