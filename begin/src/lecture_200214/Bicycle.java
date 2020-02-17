package lecture_200214;

import java.io.PrintStream;

public class Bicycle extends Vehicle {

	// 멤버변수
	private int gear = 0;

	// 메소드
	Bicycle(){
		super.wheelNum = 2;
		super.typeName = "Bicycle";
	}
	
	public void gearUp() {
		
		PrintStream ps = gear<7?System.out.printf("자전거 기어를  올린다 [현재 기어 : %d]\n", ++gear):System.out.printf("더 이상 기어를 올릴 수 없습니다\n");
	}

	public void gearDown() {
		
		PrintStream ps = gear>1?System.out.printf("자전거 기어를 내린다 [현재 기어 : %d]\n", --gear):System.out.printf("더 이상 기어를 내릴 수 없습니다\n");
	}
	
	public String toString() {
		
		return "typeName : "+typeName+" wheelNum : "+wheelNum+" gear : "+gear+"\n";
	}
}
