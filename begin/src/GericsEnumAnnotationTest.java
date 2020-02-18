import java.lang.reflect.Array;
import java.util.ArrayList;

public class GericsEnumAnnotationTest {

	public void run() {
		
		//this.genericsTest();
		this.genericsTest2();
	}
	
	public void genericsTest() {
		
		// 클래스 선언
		class Fruit					{ public String toString() { return "Fruit"; } }
		class Apple extends Fruit 	{ public String toString() { return "Apple"; } }
		class Grape extends Fruit 	{ public String toString() { return "Grape"; } }
		class Toy					{ public String toString() { return "Toy"; } }
		
		// 기본적인 제네릭 클래스 선언
		/*
		 * class Box<T> { ArrayList<T> list = new ArrayList<T>(); void add(T item) {
		 * list.add(item); } T get(int i) { return list.get(i); } int size() { return
		 * list.size(); } public String toString() { return list.toString(); } }
		 */
		
		// 타입에 제한을 둔 제네릭 클래스 선언 (Fruit 이하의 클래스만 들어올 수 있음)
		class Box<T extends Fruit> {
			ArrayList<T> list = new ArrayList<T>();
			void add(T item) 			{ list.add(item); }
			T get(int i)				{ return list.get(i); }
			int size()					{ return list.size(); }
			public String toString() 	{ return list.toString(); }
		}
		
		// testLogic
	
		Box<Fruit> 	fruitBox = new Box<Fruit>();
		Box<Apple> 	appleBox = new Box<Apple>();
		Box<Grape> 	grapeBox = new Box<Grape>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
	
		// appleBox.add(new Fruit()); 불가
		appleBox.add(new Apple());
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
	}
	
	interface Eatable {}
	public void genericsTest2() {
		
		class Fruit implements Eatable {
			public String toString() { return "Fruit"; }
		}
		
		class Apple extends Fruit { public String toString() { return "Apple"; } }
		class Grape extends Fruit { public String toString() { return "Grape"; } }
		class Toy				  { public String toString() { return "Toy"; } }
		
		class Box<T> {
			ArrayList<T> list = new ArrayList<T>();
			void add(T item) 			{ list.add(item); }
			T get(int i)				{ return list.get(i); }
			int size()					{ return list.size(); }
			public String toString() 	{ return list.toString(); }
		}
		
		// 클래스 Fruit의 자손이면서 Eatable을 구현한 클래스 타입만 T에 대입될 수 있다
		class FruitBox<T extends Fruit & Eatable> extends Box<T> {}
		
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();

		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		grapeBox.add(new Grape());
		
		System.out.println("fruitBox-" + fruitBox);
		System.out.println("appleBox-" + appleBox);
		System.out.println("grapeBox-" + grapeBox);	
	}
	
	public void wildCardTest() {
		
		// 일단 패스
	}
}


