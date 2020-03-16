package com.song.trade;

import java.util.ArrayList;

public class TradeView {

	public void viewResult(int result) {

		String msg = "반영 실패";

		if (result > 0) {
			msg = result + "개 행 반영 성공";
		}

		System.out.println(msg + "\n");
	}

	public void viewSelect(ArrayList<TradeDTO> tdtoList) {

		System.out.println("AccountNum\tAccountDate\tTradeAmount\tAccountBalance\tTradeIO");

		if (tdtoList.size() == 0)
			return;

		for (TradeDTO tradeDTO : tdtoList) {

			StringBuffer sb = new StringBuffer();

			sb.append(tradeDTO.getAccountNum() + "\t");
			sb.append(tradeDTO.getAccountDate() + "\t");
			sb.append(tradeDTO.getTradeAmount() + "\t\t");
			sb.append(tradeDTO.getAccountBalance() + "\t\t");
			sb.append(tradeDTO.getTradeIO() + "\t");

			System.out.println(sb);
		}
		System.out.println();
	}
}
