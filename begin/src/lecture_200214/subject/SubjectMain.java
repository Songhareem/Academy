package lecture_200214.subject;

import java.io.PrintStream;

public class SubjectMain {

	public static void main(String[] args) {

		// Cat
		Cat cat = new Cat();
		
		cat.bark();
		cat.showHideNail();
		if(cat.isHideNail())
			cat.setHideNail(!cat.isHideNail());
		cat.showHideNail();
		
		// Dog
		Dog dog = new Dog();
		
		dog.bark();
		dog.showHowling();
		if(dog.isHowling())
			dog.setHowling(!dog.isHowling());
		dog.showHowling();
		
		// Bird
		Bird bird = new Bird();
		
		bird.bark();
		bird.showFlying();
		if(bird.isFlying())
			bird.setFlying(!bird.isFlying());
		bird.showFlying();
		
		// call Animal static method
		System.out.println("=================================");
		System.out.println("나타난 야생 동물은 총 " + Animal.getAnimalNum() + "마리!!");
	}
}

abstract class Animal {
	
	//====================
	// Variable
	//====================
	private String type;
	private String sound;
	private static int animalNum = 0;
	
	//====================
	// Method
	//====================
	
	// constructor
	Animal() {
		animalNum++;
	}
	
	// functions
	abstract void bark();
	
	public String toString() {	
		return "야생의 " + type + "가 나타났다!!";
	}
	
	public static int getAnimalNum() {
		return animalNum;
	}
	
	// Getter Setter
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}
}

class Cat extends Animal{
	
	// ====================
	// Variable
	// ====================
	private boolean hideNail;

	// ====================
	// Method
	// ====================
	
	// constructor
	Cat() {
		System.out.println("=================================");
		super.setType("고양이");
		super.setSound("야옹");
		this.hideNail = true;
		System.out.println(super.toString());
	}
	
	// functions
	public void bark() {
		System.out.println(super.getType()+"가 내는 소리는 "+super.getSound());
	}
	
	public void showHideNail() {
		PrintStream ps = hideNail?System.out.printf("발톱을 숨기고 있다\n"):System.out.printf("발톱을 드러내고 있다\n");	
	}

	// Getter Setter
	public boolean isHideNail() {
		return hideNail;
	}

	public void setHideNail(boolean hideNail) {
		this.hideNail = hideNail;
	}
}

class Dog extends Animal{
	
	// ====================
	// Variable
	// ====================
	private boolean howling;

	// ====================
	// Method
	// ====================
	
	// constructor
	Dog() {
		System.out.println("=================================");
		super.setType("개");
		super.setSound("멍멍");
		this.howling = true;
		System.out.println(super.toString());
	}
	
	// functions
	public void bark() {
		System.out.println(super.getType()+"가 내는 소리는 "+super.getSound());
	}
	
	public void showHowling() {
		PrintStream ps = howling?System.out.printf("울부짖고 있다\n"):System.out.printf("조용히 있다\n");	
	}

	// Getter Setter
	public boolean isHowling() {
		return howling;
	}

	public void setHowling(boolean howling) {
		this.howling = howling;
	}
}

class Bird extends Animal{
	
	// ====================
	// Variable
	// ====================
	private boolean flying;

	// ====================
	// Method
	// ====================
	
	// constructor
	Bird() {
		System.out.println("=================================");
		super.setType("새");
		super.setSound("짹짹");
		this.flying = true;
		System.out.println(super.toString());
	}
	
	// functions
	public void bark() {
		System.out.println(super.getType()+"가 내는 소리는 "+super.getSound());
	}
	
	public void showFlying() {
		PrintStream ps = flying?System.out.printf("날고 있다\n"):System.out.printf("가만히 있다\n");	
	}

	// Getter Setter
	public boolean isFlying() {
		return flying;
	}

	public void setFlying(boolean flying) {
		this.flying = flying;
	}
}
