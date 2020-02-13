package lecture_200213.callby;

import lecture_200212.car.RedCar;

public class CallbyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RedCar redCar = new RedCar();
		
		System.out.println("===========================");
		System.out.println("before : " + redCar.door);
		CallbyVal.callByValTest(redCar.door);
		System.out.println("After : " + redCar.door);
		
		System.out.println("===========================");
		System.out.println("before : " + redCar.door);
		CallbyRef.callByRefTest(redCar);
		System.out.println("After : " + redCar.door);
	}

}
