package lecture_200207;

public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String type = "a";
		String result = null;
		
		switch(type) {
			case "a":
			case "A": result = "A형"; break;
			case "b":
			case "B": result = "B형"; break;
			case "o":
			case "O": result = "O형"; break;
			case "ab":
			case "AB": result = "AB형"; break;
			default: result = "혈액형이 아닙니다"; break;
		}
		
		System.out.println(result);
	}

}
