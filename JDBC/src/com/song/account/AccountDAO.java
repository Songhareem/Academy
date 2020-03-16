package com.song.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.song.jdbc.DBConnect;

public class AccountDAO {

	// Update
	public int updateBalance(AccountDTO AccountDTO) throws Exception {

		Connection conn = null;
		PreparedStatement pst = null;

		int result = 0;

		conn = DBConnect.getConnection();

		String sql = "UPDATE ACCOUNT SET ACCOUNTBALANCE = ? WHERE ACCOUNTNUM = ?";

		pst = conn.prepareStatement(sql);

		pst.setLong(1, AccountDTO.getAccountBalance());
		pst.setLong(2, AccountDTO.getAccountNum());
		result = pst.executeUpdate();
		System.out.println(result);

		pst.close();
		conn.close();

		return result;
	}

	// Delete
	public int delete(AccountDTO AccountDTO) throws Exception {

		Connection conn = null;
		PreparedStatement pst = null;

		int result = 0;

		conn = DBConnect.getConnection();

		String sql = "DELETE FROM Member WHERE PRONUM = ?";

		pst = conn.prepareStatement(sql);

		pst.setLong(1, AccountDTO.getMemNum());
		result = pst.executeUpdate();
		System.out.println(result);

		pst.close();
		conn.close();

		return result;
	}

	// Create
	public int insert(AccountDTO AccountDTO) throws Exception {

		Connection conn = null;
		PreparedStatement pst = null;

		int result = 0;

		conn = DBConnect.getConnection();

		String sql = "INSERT INTO ACCOUNT VALUES (?,?,?,?,SYSDAYE)";

		pst = conn.prepareStatement(sql);

		pst.setLong(1, AccountDTO.getAccountNum());
		pst.setLong(2, AccountDTO.getMemNum());
		pst.setString(3, AccountDTO.getProNum());
		pst.setLong(4, AccountDTO.getAccountBalance());

		result = pst.executeUpdate();

		pst.close();
		conn.close();

		return result;
	}

	// Read
	public ArrayList<AccountDTO> selectList() throws Exception {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<AccountDTO> adtoList = new ArrayList<AccountDTO>();

		conn = DBConnect.getConnection();

		String sql = "SELECT * FROM MEMBER ORDER BY PRONUM ASC";

		pst = conn.prepareStatement(sql);

		rs = pst.executeQuery();

		// rs.next -> 한 row씩 읽어옴
		// 데이터 있으면 true, 없으면 false return
		// 데이터 있으면 rs에 저장
		while (rs.next()) {

			AccountDTO adto = new AccountDTO();
			adto.setAccountNum(rs.getLong("ACCOUNTNUM"));
			adto.setMemNum(rs.getLong("MEMNUM"));
			adto.setProNum(rs.getString("PRONUM"));
			adto.setAccountBalance(rs.getLong("ACCOUNTBALANCE"));
			adto.setAccountDate(rs.getDate("ACCOUNTDATE"));

			adtoList.add(adto);
		}

		rs.close();
		pst.close();
		conn.close();

		return adtoList;
	}
}
