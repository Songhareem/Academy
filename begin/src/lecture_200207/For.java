package lecture_200207;

public class For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// A ~ Z 출력
		for(int i=1; i<=26; i++) {
			System.out.print((char)(i+64));
			if(i%6 == 0)
				System.out.print("\n");
		}
		
		System.out.println();
		for(int i=0; i<5; i++) {
			for(int j=0; j<6; j++) {
				char ch = (char)((j+65)+(i*6));
				System.out.print(ch<='Z'?ch:' ');
			}
			System.out.println();
		}
	}

}
