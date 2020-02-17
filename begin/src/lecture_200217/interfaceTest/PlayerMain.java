package lecture_200217.interfaceTest;

public class PlayerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("==== RPG GAME ====\n");
		
		SwordMan sm = new SwordMan("소드맨"); 
		sm.attack();
		sm.move(1, 1);
		
		Merchant mc = new Merchant("상인");
		mc.attack();
		mc.move(1, 1);
		
		System.out.println("\n==== Game End ====");
	}
}
