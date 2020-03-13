package com.song.bankmain;

import com.song.product.ProductController;

public class BankMain {

	public static void main(String[] args) {
		
		ProductController pc = new ProductController();
		
		try {
			pc.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}

}
