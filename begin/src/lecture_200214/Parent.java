package lecture_200214;

public class Parent {

	String name;
	
	// 디퐅트 생성자
	public Parent() {}
	
	// 매개변수를 받아서 멤버변수를 초기화하는 생성자 작성
	public Parent(String name) {
		this.name = name;
	}
	
	// 멤버변수 값을 출력하는 printName()
	// 반환 X 매개변수 X
	public void print() {
		
		System.out.println(name);
	}
}
