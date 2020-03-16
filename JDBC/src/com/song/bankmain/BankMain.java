package com.song.bankmain;

import com.song.product.ProductController;
import com.song.trade.TradeDAO;
import com.song.trade.TradeView;

public class BankMain {

	public static void main(String[] args) {
		
		ProductController pc = new ProductController();
		
		try {
			//pc.start();
			
			new TradeView().viewSelect(new TradeDAO().selectList());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}

}
