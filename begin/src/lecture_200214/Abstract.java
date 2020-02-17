package lecture_200214;

import java.util.Date;

public abstract class Abstract {

	public void printTime() {
		
		Date now = new Date();
		
		System.out.println("실행 시간 : "+now);
		System.out.println("실행시간 : "+now.toLocaleString());
	}
	
	public abstract void printDate();
}
