package lecture_200214;

public class AbstractMain { // extends { AbstractModifier{

	public static void main(String[] args) {

		AbstractSub as = new AbstractSub();
		
		as.printDate();
		
		//AbstractMain am = new AbstractMain();
		//System.out.println(am.age);
		
		AbstractModifier am = new AbstractModifier();
		System.out.println(am.level);
		
		am.setPhone("010-1111-1111");
		System.out.println(am.getPhone());
	
		Singleton s = Singleton.GetInstance();
		
		System.out.println(s.good);
	}
}
