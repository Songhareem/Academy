package lecture_200213.method2;

public class Factorial {

	public static int recursionFactorial(int n) {
		
		// f(n) = n * f(n-1), 단 f(1) = 1
		if(n<1 || n >12)
			return -1;
		
		if(n == 1) return 1;
		
		return n * recursionFactorial(n-1);
	}
	
	public static int loopFactorial(int n) {
		
		// f(n) = n * f(n-1), 단 f(1) = 1
		int result = 1;
		
		while(n!=0) {
			result *= n--;
		}
		
		return result;
	}
}
