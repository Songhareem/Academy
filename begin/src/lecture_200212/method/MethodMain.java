package lecture_200212.method;

public class MethodMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Method method = new Method();
		
		method.print();
		method.print("hello");
		System.out.println(method.print(9));
		System.out.println("������ ���� : " + (int)(method.todayRate()*100) + "%");
	}

}

class Method {
	
	public void print() {
		System.out.println("====================");
		System.out.println("��ȯ X �Ű����� X");
	}
	
	public void print(String str) {
		System.out.println("====================");
		System.out.println("��ȯ X �Ű����� O");
		System.out.println("�Ű������� �� : " + str);
	}
	
	public int print(int i) {
		System.out.println("====================");
		System.out.println("��ȯ X �Ű����� O");
		System.out.println("�Ű������� �� : " + i);
			
		return i<<1;
	}
	
	public double todayRate() {
		System.out.println("====================");
		System.out.println("��ȯ O �Ű����� X");
			
		return 0.05;
	}
}
