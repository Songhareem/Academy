package com.song.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.song.dbconnect.DBConnect;

public class AccountDAO {

	// SELECT
	public long selectBalance(AccountDTO accountDTO) throws Exception {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		long balance = 0L;

		con = DBConnect.getConnection();

		String sql = "select accountBalance from account where accountNum=?";
		st = con.prepareStatement(sql);

		st.setLong(1, accountDTO.getAccountNum());

		rs = st.executeQuery();

		if (rs.next()) {
			balance = rs.getLong("accountBalance");
		}

		rs.close();
		st.close();
		con.close();

		return balance;
	}
	
	public ArrayList<AccountDTO> selectList(String memberID)throws Exception{
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<AccountDTO> ar = new ArrayList<AccountDTO>();
		
		con = DBConnect.getConnection();
		
		String sql="select * from account where memberId=?";
		
		st = con.prepareStatement(sql);
		
		st.setString(1, memberID);
		
		rs = st.executeQuery();
		
		while(rs.next()) {
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setAccountNum(rs.getLong("accountNum"));
			accountDTO.setMemberID(rs.getString("memberID"));
			accountDTO.setBookNumber(rs.getString("bookNumber"));
			accountDTO.setAccountBalance(rs.getLong("accountBalance"));
			accountDTO.setAccountDate(rs.getDate("accountDate"));
			ar.add(accountDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}

	// update
	public int update(AccountDTO accountDTO, Connection con) throws Exception {
		PreparedStatement st = null;
		int result = 0;

		String sql = "update account set accountBalance=? where accountNum=?";

		st = con.prepareStatement(sql);
		st.setLong(1, accountDTO.getAccountBalance());
		st.setLong(2, accountDTO.getAccountNum());

		result = st.executeUpdate();

		st.close();

		return result;
	}

	// insert
	public int insert(AccountDTO accountDTO) throws Exception {

		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		con = DBConnect.getConnection();

		String sql = "insert into account values(?,?,?,0,sysdate)";

		st = con.prepareStatement(sql);

		st.setLong(1, accountDTO.getAccountNum());
		st.setString(2, accountDTO.getMemberID());
		st.setString(3, accountDTO.getBookNumber());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	public ArrayList<AccountDTO> selectList() throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<AccountDTO> ar = new ArrayList<AccountDTO>();

		con = DBConnect.getConnection();

		String sql = "select * from account";

		st = con.prepareStatement(sql);

		rs = st.executeQuery();

		while (rs.next()) {
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setAccountNum(rs.getLong("accountNum"));
			accountDTO.setMemberID(rs.getString("memberID"));
			accountDTO.setBookNumber(rs.getString("bookNumber"));
			accountDTO.setAccountBalance(rs.getLong("accountBalance"));
			accountDTO.setAccountDate(rs.getDate("accountDate"));
			ar.add(accountDTO);
		}

		rs.close();
		st.close();
		con.close();

		return ar;
	}
	
	
}
