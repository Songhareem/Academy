package lecture_200214;

public class Singleton {
	
	private static Singleton s;
	public String good = "good";
	
	private Singleton() {}
	
	public static Singleton GetInstance() {
		
		if(s == null)
			s = new Singleton();
		
		return s;
	}
}
