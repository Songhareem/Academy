package lecture_200214;

import java.io.PrintStream;

public class Bus extends Vehicle{
	
	// 멤버변수
	private boolean exitController = false;
	private int doorNum = 2;
	private Door[] door = new Door[doorNum];
	
	// 메소드
	Bus(String material,int width, int height) {
		wheelNum = 4;
		typeName = "Bus";
		for(int i=0; i<2; i++)
			door[0] = new Door(material, width, height);
		
		System.out.println("===== 버스 생성 =====");
		System.out.println("이름 : " + typeName);
		System.out.println("바퀴 수 : " + wheelNum);
		System.out.println("문의 수 : " + doorNum);
		System.out.println("문의 재질 : " + door[0].material);
		System.out.println("문의 가로 : " + door[0].width);
		System.out.println("문의 세로 : " + door[0].heigth);
	}
	
	public void switchController() {
		
		exitController = exitController ? false:true;
		PrintStream ps = exitController ? System.out.printf("문이 열립니다\n"):System.out.printf("문이 닫힙니다\n");
	}
}
