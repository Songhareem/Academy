package lecture_200213.callby;

public class CallbyVal {

	public static void callByValTest(int door) {
		
		door = 10;
		System.out.println("callbyVal method");
		System.out.println("door : " + door);
	}
}
