package lecture_200212.table;

public class Variable {

	// 멤버(인스턴스)변수
	String memStr;
	
	// 클래스(static/공유)변수
	static String classStr;
	
	// print all variable
	// 
	public void printMem() {
		String hello = "hello";
		System.out.println("memStr : " + memStr);
		
	}
	
	// print static variable
	public static void printStatic() {
		System.out.println("classStr : " + classStr);
	}
}
