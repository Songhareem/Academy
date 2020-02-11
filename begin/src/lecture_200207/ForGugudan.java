package lecture_200207;

public class ForGugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		  for(int mul=1; mul<=18; mul++) {
		  
		  if(mul == 10) System.out.println();
		  
		  if(mul<=9) { for(int n=2; n<=5; n++) { 
			  	System.out.printf("%2d * %2d = %2d\t", n, mul, n*mul); } 
		  		System.out.println(); 
		  }
		  
		  else { int tmp = mul - 9; for(int n=6; n<=9; n++) {
			  	System.out.printf("%2d * %2d = %2d\t", n, tmp, n*tmp); }
		  		System.out.println(); } 
		  }
		 
	}

}
