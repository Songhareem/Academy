package com.song.Product;

public class ProductMain {

	public static void main(String[] args) {

		Product[] p = new Product[3];

		p[0] = new Tv();
		p[1] = new Computer();
		p[2] = new Phone();

		for (int i = 0; i < 3; i++)
			System.out.println(p[i].toString());
	}

}
