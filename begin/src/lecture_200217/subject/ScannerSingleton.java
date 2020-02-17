package lecture_200217.subject;

import java.util.Scanner;

public class ScannerSingleton {

	private static Scanner sc = null;
	
	private ScannerSingleton() {}

	public static Scanner getInctance() {
		
		if(sc == null) {
			sc = new Scanner(System.in);
		}
		
		return sc;
	}
}
