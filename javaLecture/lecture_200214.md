
# 추상클래스

# 과제 제출

# Chapter 07 객체지향 프로그래밍 I

- 클래스간 관계 설정
    - is a
        - 상속관계
    - has a
        - 포함관계

- 자바는 단일상속만 허용

- 최상위 클래스 Object

- super();
    - 부모의 디폴트 생성자를 호출
    - 만약 부모의 디폴트 생성자가 없다면 Error

- import static 문
    - import -> 클래스 패키지명 생략
    - import static -> static 멤버 호출시 클래스 이름 생략
    - import static java.lang.Math.random;
        - Math.random() -> random() 으로 사용 가능

- 제어자
    - static
        - 메서드에 선언, 공통으로 사용하는 메서드(body가 있는 메서드여야 함)
        - 변수에 선언, 공통으로 사용하는 변수
    - final
        - 클래스에 선언, 확장할 수 없는 클래스
        - 메서드에 선언, 오버라이딩 불가 메서드(private선언과 둘중 하나만)
        - 변수에 선언, 값 변경이 불가능한 변수
    - abstract
        - 클래스에 선언, 클래스 내에 추상 메서드 존재 의미
        - 메서드에 선언, 추상 메서드임을 의미
    - native
        - 자바가 아닌 언어(보통 C나 C++)로 구현한 후 자바에서 사용하려고 할 때 이용하는 키워드
    - transient
        - serializable 사용시, 보안 등의 문제로 보내고 싶지 않은 멤버 변수등에 사용
        - transient 선언시, null값 전송
    - synchronized
        - 멀티스레드 환경에서 data의 thread-safe를 위해 사용
        - 너무 남용하면, context switching 비용으로 인해 오히려 성능 저하를 가져옴
        - 메서드에 선언, 메서드에 접근시 rock, 메서드 종료시 unlock
        - 변수에 선언, 변수 접근시 rock, 변수 종료시 unlock
    - volatile
        - 변수에 선언, 변수 값 Read & Write시, cache가 아닌 메모리를 대상으로 한다는 의미
        - 왜 필요? 
            - 멀티스레드 환경에서 각 스레드별 캐시가 다르므로 변수 값 불일치 문제 발생
        - 언제 사용?
            - 하나의 스레드만 Read & Write를 하고 나머지 스레드는 Read만을 하는 경우
        - 사용하지 말아야할 경우?
            - 여러 스레드가 write를 하는 경우 -> synchronized 사용
        - ref : https://nesoy.github.io/articles/2018-06/Java-volatile
    - strictfp
        - 플랫폼 간 부동소수점 연산의 결과를 동일하게 해주는 키워드

- 접근제어자
    - public > protected > (default) > private
    - private : 같은 클래스 내에서 접근
    - default : 같은 패키지 내에서 접근
    - protected : 상속관계에 있는 자손클래스에서 접근 가능
    - public : 접근 제한이 전혀 없음

- 생성자의 접근 제어자
    - 싱글톤 패턴에 사용
    - ```
      class Singleton {
          private static Singleton s = new Singleton();
          
          private Singleton() {
              ...
          }

          // 인스턴스를 생성하지 않고 호출할 수 있어야 하므로 static 이어야 함
          public static Singleton getInstance() {
              return s;
          }
      }

      class SingletonTest {

          public static void main(String[] args) {

              Singleton s = Singleton.getInstance();
          }
      }
      ```
      
- 참조변수의 형변환
    - ```
      class Car {
          ...
      }

      class Bus extends Car {
          ...
      }

      class Main {
         public  static void main(String[] args) {

             // 업 캐스팅
             Car car = new Bus();

             // 다운 캐스팅
             Bus bus = (Bus)new Car();
         }
      }
      ```

- instanceof 연산자
    - 상속받은 객체들을 구분할 수 있게 도와주는 연산자
    - 결과가 true : 검사한 타입으로 형 변환이 가능하다는 의미

- 바인딩
    - 참조변수와 인스턴스간 바인딩에 따라 호출되는 메서드가 달라짐

- 매개변수의 다형성
    - 매개변수를 상위 클래스로 해줌으로써, 서로 다른 하위 클래스를 인자로 받을 수 있는 다형성이 생김

- 추상 클래스
    - 직접적인 인스턴스 생성 불가
    - 설령 추상 메서드를 지니지 않았더라도 직접적인 인스턴스 생성이 불가능

- 추상 메서드
    - 상속받아서 오버라이딩해서 사용하기 위해 미완으로 남겨놓는 메서드
    - Remote로 쓰임

```
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

```