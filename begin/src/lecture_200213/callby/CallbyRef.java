package lecture_200213.callby;

import lecture_200212.car.RedCar;

public class CallbyRef {

	public static void callByRefTest(RedCar car) {
		
		car.door = 4; 
		System.out.println("callbyRef method");
		System.out.println("door : " + car.door);
	}
}
