package com.song.wrapper;

public class WrapperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Boolean b = new Boolean("true");
		Byte by = new Byte("10");
		Short s = new Short("100");
		Integer itg = new Integer("1000");
		Long l = new Long("10000");
		Float f = new Float("10.1");
		Double d = new Double("100.01");
		
		Object[] obj = new Object[7];
		obj[0] = b;
		obj[1] = by;
		obj[2] = s;
		obj[3] = itg;
		obj[4] = l;
		obj[5] = f;
		obj[6] = d;
		
		for(int i=0; i<obj.length; i++)
			System.out.println(obj[i].toString());
		
		int val = Integer.parseInt("20");
	}

}
