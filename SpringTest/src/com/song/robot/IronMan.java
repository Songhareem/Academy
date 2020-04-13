package com.song.robot;

public class IronMan {

	private LeftArm leftArm;

	public IronMan() {
		leftArm = new LeftArm();
	}
	

	public LeftArm getLeftArm() {
		return leftArm;
	}

	public void setLeftArm(LeftArm leftArm) {
		this.leftArm = leftArm;
	}
	
	
}
