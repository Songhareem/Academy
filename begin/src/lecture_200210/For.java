package lecture_200210;

public class For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1; i<=9; i++) {
			System.out.printf("%d : ", i);
			for(int j=1; j<=i; j++) {
				System.out.printf("%d",j);
			}
			System.out.println();
		}
	}

}
