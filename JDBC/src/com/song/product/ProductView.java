package com.song.product;

import java.util.ArrayList;

public class ProductView {

	public void viewResult(int result) {
		
		String msg = "반영 실패";
		
		if(result > 0) {
			msg = result + "개 행 반영 성공";
		}
		
		System.out.println(msg+"\n");
	}
	
	public void viewSelect(ArrayList<ProductDTO> pdtoList) {
		
		System.out.println("ProNum\t\tProName\tProComment\tProRate\tProSale");
		
		if(pdtoList.size() == 0)
			return;
		
		for (ProductDTO productDTO : pdtoList) {

			StringBuffer sb = new StringBuffer();
			
			sb.append(productDTO.getProNum() + "\t");
			sb.append(productDTO.getProName() + "\t");
			sb.append(productDTO.getProComment() + "\t\t");
			sb.append(productDTO.getProRate() + "%\t");
			if(productDTO.getProSale() == 0)
				sb.append("Non Sale");
			else
				sb.append("Sale");
			
			System.out.println(sb);
		}
		System.out.println();
	}
}
