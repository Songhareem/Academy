package lecture_200214;

public class Vehicle {

	// 멤버변수
	int		wheelNum;	// 바퀴 갯수
	String 	typeName;	// 차종
	
	// 메소드
	// 출발
	public void go() {
		System.out.println("바퀴 " + wheelNum + "개 " + typeName + " 출발");
	}
	// 정지
	public void stop() {
		System.out.println("바퀴 " + wheelNum + "개 " + typeName + " 정지");
	}
}
