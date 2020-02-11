package lecture_200205;

import java.util.Date;

public class VariableRefType {

	static char ch;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "init";
		System.out.println(name);
		
		name = "changed";
		System.out.println(name);
		
		Date date = new Date();
		
		System.out.println(date);
		System.out.println(date.toLocaleString());
		
		char first = 'a';
		char second = 65;
		char third = '\u0041';
		
		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
	
		System.out.println("|"+ch+"|");
		System.out.println("|\t|");		// tab
		System.out.println("|\f|");		// form feed
		System.out.println("|\r|");		// carriage return
		System.out.println("|\n|");		// new line
		System.out.println("\"hello\"");
		
		byte unsignedChar = 127;
		short binary = 0x7fff;	//0b1010;
		int oct = 017;
		int hex = 0x7fffffff;
		long lg = 0x7fffffffffffffffL;
		
		System.out.println("unsignedChar\tbinary\toct\thex\t\tlg");
		System.out.println(unsignedChar + "\t\t" + binary + "\t" + oct + "\t" + hex + "\t" + lg + "\n");

		float f = 0.1234567f;	// 소수점 아래 7자리
		double d = 0.123456789123456;	// 소수점 아래 15자리
		
		System.out.println("f\t\td\n" + f + "\t" + d + "\n");
		
		System.out.printf("%07.3f\n",123456.123f);
		System.out.println(3E6);
		System.out.println(2e-3);
	
		System.out.printf("|%10s|\n", "우측정렬");
		System.out.printf("|%-10s|\n", "좌측정렬");
	}
}
