package lecture_200212.car;

public class CarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// SuperCar[] cars = new SuperCar[3]
		// 은 아래와 같은 코드 n개 메모리 잡고 null 넣어둠
		// SuperCar *cars = new SuperCar[3]
		// for(int i=0; i<3; i++)
		// 		SuperCar cars[i] = null;
		SuperCar[] cars = new SuperCar[3];
		
		for(int i=0; i<3; i++)
			System.out.printf("[%d]%d\n",i,cars[i]);
		
		cars[0] = new BlueCar(); 
		cars[1] = new RedCar(); 
		cars[2] = new GreenCar();
		 
		for(int i=0; i<3; i++)
			System.out.printf("[%d]%s\n",i,cars[i]);
		
		cars[0].color = "BlueBlack";
		cars[1].color = "RedBlack";
		cars[2].color = "GreenBlack";
		
		for(SuperCar iter : cars) {
		  
			System.out.println("==============================");
			System.out.println("This Car's color is "+iter.color+"\nThere are "+iter.door+" doors");
			iter.start(); 
			iter.stop(); 
		}
		
		System.out.println(cars[0] instanceof BlueCar);
	}
}
