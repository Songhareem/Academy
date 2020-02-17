package lecture_200217;

import lecture_200214.Child;
import lecture_200214.Parent;

public class PolyymorphismMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Parent p = new Parent("Kim");
		Child c = new Child("Lee", 10);
		
		p.print();
		c.print();
		
		System.out.println("==== up casting ====");
		p = new Child("Han", 9);
		p.print();
		
		System.out.println("==== downcasting ====");
		c = (Child)new Parent("Son");
		//c.print();
		
		System.out.println("==== When do we use downcasting? ====");
		
		
	}
}


