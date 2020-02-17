package lecture_200217;

public class InterfaceMain {

	public static void main(String[] args) {

	}
}

interface InterfaceClass {
	
	public abstract void method();
	
	public abstract void method2();
}

class ImplementClassA implements InterfaceClass {

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("A method");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("A method2");
	}
}
