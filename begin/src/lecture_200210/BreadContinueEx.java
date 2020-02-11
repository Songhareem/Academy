package lecture_200210;

public class BreadContinueEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1~100 사이의 정수 중에서
		// 가장 큰 7의 배수 하나만 출력
		
		
		for(int i=100; i>=1; i--) {
			if(i%7 == 0) {
				System.out.printf("1~100 사이의 정수 중 가장 큰 7의 배수 : %d\n", i);
				break;
			}
		}
		
		System.out.println("1~10 사이의 정수 중에서 3~6을 제외하고 출력");
		for(int i=1; i<=10; i++) {
			if(3<=i && i<=6)
				continue;
			System.out.print(i+" ");
		}
	}

}
