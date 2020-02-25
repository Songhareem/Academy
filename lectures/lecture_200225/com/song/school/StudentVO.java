package com.song.school;

public class StudentVO {

	private final double SUBJECT = 3;
	
	private String name;
	private String num;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTotal() {
		return this.total;
	}
	public void setTotal() {
		this.total = this.kor + this.eng + this.math;
	}
	public double getAvg() {
		return this.avg;
	}
	public void setAvg() {
		this.avg = this.total/SUBJECT;
	}
	
	
}
