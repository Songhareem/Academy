package lecture_200212.table;

public class Variable {

	// �������
	
	//�ν��Ͻ�(��ü/����) ����
	String memStr;
	
	// Ŭ����(static/����) ����
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
