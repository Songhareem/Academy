package lecture_200210;

public class ArrayEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 국어 성적을 저장하는 korArr 선언,
		// 99, 88, 77, 66, 33으로 초기화
		
		int korArr[] = new int[] {99, 88, 77, 66, 33};
		int sum = 0;
		float avg = 0.0f;
		System.out.println("===== 국어점수 =====");
		for(int i=0; i<korArr.length; i++) {
			sum += korArr[i];
			System.out.printf("%d번 : %d\n", i+1, korArr[i]);
		}
		System.out.println("================");
		System.out.printf("전체 인원 수 : %d\n", korArr.length);
		System.out.printf("총점            : %d\n", sum);
		System.out.printf("평균            : %.2f\n", sum/(float)korArr.length);
		
		
	}

}
