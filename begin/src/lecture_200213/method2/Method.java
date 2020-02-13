package lecture_200213.method2;

public class Method {

	public int sum(int a, int b, int c) {
		
		System.out.println("=====================");
		return a+b+c;
	}

	public void printMyInfo(String[] info) {

		System.out.println("=====================");
		for(String iter : info)
			System.out.printf("%s\t", iter);
		System.out.println();
	}
	
	public void printAchievement(String name, int[] achievement) {
		
		System.out.println("=====================");
		System.out.printf("%s : ", name);
		int sum = 0;
		for(int iter : achievement) {
			System.out.printf("%d ", iter);
			sum += iter;
		}
		System.out.printf("총점 : %d\n", sum);
	}
	
	public void printSum(int ... nums) {
		
		System.out.println("=====================");
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		System.out.printf("%d개의 숫자들의 합 : %d\n", nums.length, sum);
	}
}
