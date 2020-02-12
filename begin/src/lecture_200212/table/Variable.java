package lecture_200212.table;

public class Variable {

	// 멤버변수
	
	//인스턴스(객체/참조) 변수
	String memStr;
	
	// 클래스(static/전역) 변수
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
