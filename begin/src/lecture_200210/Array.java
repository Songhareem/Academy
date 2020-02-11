package lecture_200210;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strArray = new String[] {"100","100","100","100","100"};
		
		for(int i=0; i<5; i++) {
			System.out.printf("%d : %s\n",i,strArray[i]);
		}
		
		strArray[3] = "99";
		System.out.println("=============================");
		
		for(int i=0; i<5; i++) {
			System.out.printf("%d : %s\n",i,strArray[i]);
		}
		
		char[] charArr = new char[] {'h','i','!'};
		System.out.println("char 배열의 길이  : " + charArr.length);
		
		System.out.println(charArr);
		
		String[] strArr = new String[] {null, null, "hello", null};
		
		for(int i=0; i<4; i++)
			System.out.println(strArr[i]);
		
		// init 때만 가능
		String[] bloodType = {"A", "B", "AB", "O"};
		// new String으로 재 초기화 가능 
		bloodType = new String[] {"이", "게", "킹", "능"};
		
		for(int i=0; i<4; i++)
			System.out.println(bloodType[i]);
	
		
	}

}
