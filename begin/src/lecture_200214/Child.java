package lecture_200214;

public class Child extends Parent {

	int age;

	public Child(String name, int age) {

		super(name);
		this.age = age;
	}

	public void print() {

		System.out.printf(name);
		System.out.println(age);
	}

	public void Child() {
		
		System.out.printf(name);
	}
}
