package lecture_200206;

public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i=0;
		
		System.out.println(++i);
		System.out.println(--i);
		System.out.println(i++);
		System.out.println(i--);
		
		boolean result = 3>4;
		
		System.out.println(result);
		System.out.println(!result);
		
		i = 10;
		
		System.out.println(~i);
		float pi = 3.141592f;
		System.out.printf("%.2f\n",pi);
		System.out.println(Math.round(pi));
		
		System.out.println(5%2);
		System.out.println(-5%2);
		System.out.println(5%-2);
		System.out.println(-5%-2);
		
		i = 4;
		System.out.println(i<<1);
		System.out.println(i>>1);
		System.out.println(i>>>1);	// 밀리는 값으로 부호 비트 변경
		
		i = -4;
		System.out.println(i<<1);
		System.out.println(i>>1);
		System.out.println(i>>>1);	// 밀리는 값으로 부호 비트 변경
		
		i = 5;
		System.out.println("i는 짝수인가?" + (i%2 == 0));
		System.out.println("i는 홀수인가?" + (i%2 != 0));
		
		System.out.println(10&5);
		System.out.println(10|5);
		System.out.println(10^5);
		
		char ch = '@';
		System.out.println("ch는 대문자? :" + ('A'<=ch && ch<='Z'));									// 65 ~ 90 
		System.out.println("ch는 소문자? :" + ('a'<=ch && ch<='z'));									// 97 ~ 122
		System.out.println("ch는 영어가 맞음? :" + (('A'<=ch && ch<='Z') && ('a'<=ch && ch<='z')));		// 65 ~ 122 (66~96 무시)
		System.out.println("ch는 영어가 아님? :" + (!(('A'<=ch && ch<='Z') && ('a'<=ch && ch<='z'))));	// 65 ~ 122 (66~96 무시)
		
		float kor = 90;
		float eng = 80;
		float math = 75;
		
		System.out.println("========= 성적표 =========");
		System.out.println("국어 : " + (int)kor);
		System.out.println("영어 : " + (int)eng);
		System.out.println("수학 : " + (int)math);
		System.out.println("========================");
		System.out.println("총점 : " + (int)(kor+eng+math));
		System.out.printf("평균 : %.2f\n", (kor+eng+math)/3);
		System.out.println("합불 : " + ((int)((kor+eng+math)/3) >= 60 ? "합격" : "불합격"));
		
		i = 5;
		System.out.println(i);
		System.out.println(++i);
		System.out.println(i+=1);
		System.out.println(i=i+1);
		System.out.println(i=i-1);
		System.out.println(i-=1);
		System.out.println(--i);

		
	}
}
