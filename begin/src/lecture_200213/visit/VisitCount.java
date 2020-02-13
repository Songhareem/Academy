package lecture_200213.visit;

public class VisitCount {

	static int count;
	
	VisitCount() {
		count++;
		System.out.println("현재 생성된 객체의 수 : " + count);
	}
}
