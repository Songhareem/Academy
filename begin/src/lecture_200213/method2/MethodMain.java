package lecture_200213.method2;

public class MethodMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int 매개변수 3개 받아서 sum 반환
		Method mm = new Method();
		System.out.println(mm.sum(1, 2, 3));
	
		// 이름, 혈액형, 별자리를 매개변수 1개 받아서 화면에 출력하는 메서드
		String[] info = new String[] {"림", "A", "물병"};
		mm.printMyInfo(info);
		
		// 이름, 성적(국/영/수/과) 매개변수 2개 받아서 화면에 출력하는 메서드
		mm.printAchievement("림", new int[] { 90, 80, 70, 60 });
		
		// 임의의 정수들을 매개변수 1개 받아서 합산해서 출력하는 메서드
		mm.printSum(1,1,1,1,1);
		
		// 재귀를 이용한 factorial
		System.out.println("=====================");
		System.out.printf("%d! = %d",3, Factorial.recursionFactorial(3));
	}
}
