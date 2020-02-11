package lecture_200210;

public class WhileEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1 ~ 10까지 홀수의 합 출력
		int n=1;
		int sum = 0;
		while(n<=10) {
			
			sum += n;
			n+=2;			
		}
		
		System.out.println(sum);
	}

}
