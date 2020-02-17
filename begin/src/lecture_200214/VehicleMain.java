package lecture_200214;

public class VehicleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bicycle bc = new Bicycle();
		
		bc.go();
		for(int i=0; i<10; i++) bc.gearUp();
		for(int i=0; i<10; i++) bc.gearDown();
		bc.stop();
		System.out.println(bc.toString());
		
		System.out.println("==========================");
		
		Bus bus = new Bus("metal", 100, 200);
		
		bus.go();
		for(int i=0; i<4; i++) bus.switchController();	
		bus.stop();
	}
}
