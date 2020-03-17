package com.song.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.song.dbconnect.DBConnect;

public class BankBookDAO {
	
	public String seqSelect() throws Exception{
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String result = null;
		
		String sql = "select LPAD(bankBook_seq.nextval,10,'0') as bookNum from dual";
		
		conn = DBConnect.getConnection();
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		rs.next();
				
		result = rs.getString("bookNum");
		
		rs.close();
		pst.close();
		conn.close();
		
		return result;
	}
	
	public ArrayList<BankBookDTO> selectList() throws Exception {
		
		Connection con = DBConnect.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		
		
		
		String sql="SELECT LPAD(bookNumber, 10, '0') as booknumber, bookname, bookcontents, bookrate, booksale FROM BANKBOOK";
		
		st = con.prepareStatement(sql);
		
		rs = st.executeQuery();
		
		while(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookContents(rs.getString("bookcontents"));
			bankBookDTO.setBookName(rs.getString("bookname"));
			bankBookDTO.setBookNumber(rs.getString("booknumber"));
			bankBookDTO.setBookRate(rs.getDouble("bookrate"));
			bankBookDTO.setBookSale(rs.getInt("booksale"));
			ar.add(bankBookDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
		
	}

	public int insert(BankBookDTO bankBookDTO)throws Exception{
		
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = null;
		
		String sql = "insert into bankbook values(?,?,?,?,?)";
		
		st = conn.prepareStatement(sql);
		
		st.setString(1, bankBookDTO.getBookNumber());
		st.setString(2, bankBookDTO.getBookName());
		st.setString(3, bankBookDTO.getBookContents());
		st.setDouble(4, bankBookDTO.getBookRate());
		st.setInt(5, bankBookDTO.getBookSale());
		
		int result = st.executeUpdate();
		
		st.close();
		conn.close();
		
		return result;
	}
	
	public int updateBookSale(BankBookDTO bankBookDTO) throws Exception {
		
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = null;
		int result = 0;
		
		String sql = "update bankbook set booksale = ? where booknumber = ?";
		
		st = conn.prepareStatement(sql);
		
		st.setInt(1, bankBookDTO.getBookSale());
		st.setString(2, bankBookDTO.getBookNumber());
		
		result = st.executeUpdate();
		
		st.close();
		conn.close();
		
		return result;
	}
}
