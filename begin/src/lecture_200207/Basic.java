package lecture_200207;

public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int total = 100;
		
		System.out.println(total>99?"통과":(total>49?"재검토":"실패"));
		
		if(total > 99)
			System.out.println("통과");
		else if(total > 49)
			System.out.println("재검토");
		else
			System.out.println("실패");
		
		
	}
}
