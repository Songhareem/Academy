package lecture_200214;

public class ParentChildMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Parent p = new Parent("Parent");
		Child c = new Child("Child", 20);
		
		p.print();
		c.print();
	}
}
