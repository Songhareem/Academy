package lecture_200212.method;

public class MethodMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Method method = new Method();
		
		method.print();
		method.print("hello");
		System.out.println(method.print(9));
		System.out.println("이율은  : " + (int)(method.todayRate()*100) + "%");
	}

}

class Method {
	
	public void print() {
		System.out.println("====================");
		System.out.println("반환 X 매개변수 X");
	}
	
	public void print(String str) {
		System.out.println("====================");
		System.out.println("반환 X 매개변수 O");
		System.out.println("매개변수는 : " + str);
	}
	
	public int print(int i) {
		System.out.println("====================");
		System.out.println("반환 X 매개변수 O");
		System.out.println("매개변수는 : " + i);
			
		return i<<1;
	}
	
	public double todayRate() {
		System.out.println("====================");
		System.out.println("반환 O 매개변수 X");
			
		return 0.05;
	}
}
