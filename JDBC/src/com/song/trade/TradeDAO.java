package com.song.trade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.song.jdbc.DBConnect;

public class TradeDAO {

	// 입금
	public int insert(TradeDTO tradeDTO) throws Exception {
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		int result = 0;
		
		conn = DBConnect.getConnection();
		
		String sql = "INSERT INTO TRADE VALUES (?, SYSDATE,?,?,?)";
		
		pst = conn.prepareStatement(sql);
		
		pst.setLong(1, tradeDTO.getAccountNum());
		pst.setLong(2, Math.abs(tradeDTO.getTradeAmount()));	// 보이는건 항상 양수
		pst.setLong(3, tradeDTO.getAccountBalance());
		pst.setBoolean(4, tradeDTO.getTradeIO());
		
		result = pst.executeUpdate();
		
		pst.close();
		conn.close();
		
		return result;
	}
	
	// 출금
	public int insertOutput(TradeDTO tradeDTO) throws Exception {
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		int result = 0;
		
		conn = DBConnect.getConnection();
		
		String sql = "INSERT INTO TRADE VALUES (?,?,?,?,?)";
		
		pst = conn.prepareStatement(sql);
		
		pst.setLong(1, tradeDTO.getAccountNum());
		pst.setDate(2, tradeDTO.getAccountDate());
		pst.setLong(3, tradeDTO.getTradeAmount());
		pst.setLong(4, tradeDTO.getAccountBalance());
		pst.setBoolean(5, tradeDTO.getTradeIO());
		
		result = pst.executeUpdate();
		
		pst.close();
		conn.close();
		
		return result;
	}
	
	// Read
	public ArrayList<TradeDTO> selectList() throws Exception {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<TradeDTO> tdtoList = new ArrayList<TradeDTO>();

		conn = DBConnect.getConnection();

		String sql = "SELECT * FROM TRADE ORDER BY ACCOUNTDATE DESC";

		pst = conn.prepareStatement(sql);

		rs = pst.executeQuery();

		// rs.next -> 한 row씩 읽어옴
		// 데이터 있으면 true, 없으면 false return
		// 데이터 있으면 rs에 저장
		while (rs.next()) {

			TradeDTO tdto = new TradeDTO();
			tdto.setAccountNum(rs.getLong("ACCOUNTNUM"));
			tdto.setAccountDate(rs.getDate("ACCOUNTDATE"));
			tdto.setTradeAmount(rs.getLong("TRADEAMOUNT"));
			tdto.setAccountBalance(rs.getLong("ACCOUNTBALANCE"));
			tdto.setTradeIO(rs.getBoolean("TRADEIO"));

			tdtoList.add(tdto);
		}

		rs.close();
		pst.close();
		conn.close();

		return tdtoList;
	}
}
