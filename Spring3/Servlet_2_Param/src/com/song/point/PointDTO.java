package com.song.point;

public class PointDTO {

	private String name;
	private String num;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avg;
	
	PointDTO() {
		
	}
	
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
		return total;
	}
	public void setTotal() {
		this.total = this.kor + this.eng + this.math;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg() {
		this.avg = this.total/3.0;
	}
}
