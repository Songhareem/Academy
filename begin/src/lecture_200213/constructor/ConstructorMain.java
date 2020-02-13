package lecture_200213.constructor;

public class ConstructorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Constructor con = new Constructor();
		Constructor con2 = new Constructor("hello");
		
		System.out.println(con.msg);
		System.out.println(con2.msg);
	}
}

class Constructor {
	
	String msg;

	public Constructor() {
		//this("기본 생성자에서 호출");
		System.out.println("기본 생성자 호출");
	}
	
	Constructor(String msg) {
		System.out.println("오버로딩 생성자 호출");
		this.msg = msg;
	}
	
	
}
