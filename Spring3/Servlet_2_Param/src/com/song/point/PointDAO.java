package com.song.point;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.song.util.DBConnect;

public class PointDAO {

	/*
	 * // test public static void main(String[] args) {
	 * 
	 * PointDTO pointDTO = new PointDTO(); pointDTO.setName("Song");
	 * pointDTO.setNum(2); pointDTO.setKor(90); pointDTO.setEng(85);
	 * pointDTO.setMath(80); pointDTO.setTotal(); pointDTO.setAvg();
	 * 
	 * try { int result = new PointDAO().pointAdd(pointDTO);
	 * System.out.println(result);
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	
	// insert
	public int pointAdd(PointDTO pointDTO) throws Exception {
		
		Connection conn = null;
		PreparedStatement pst = null;
		String sql = null;
		int result=0;

		// 1. DB 연결
		conn = DBConnect.getConnection();
		
		// 2. 쿼리문 작성
		sql="insert into point values (?,?,?,?,?,?,?)";
		
		// 3. 미리 전송 
		pst = conn.prepareStatement(sql);
		
		// 4. 값 넣기
		pst.setString(1, pointDTO.getName());
		pst.setInt(2, pointDTO.getNum());
		pst.setInt(3, pointDTO.getKor());
		pst.setInt(4, pointDTO.getEng());
		pst.setInt(5, pointDTO.getMath());
		pst.setInt(6, pointDTO.getTotal());
		pst.setDouble(7, pointDTO.getAvg());
		
		
		System.out.println("save");
		// 5. 최종 전송 후 처리
		result = pst.executeUpdate();
		System.out.println("pointAdd result : " + result);
		
		// 6. 자원해제
		pst.close();
		conn.close();
		
		// 7. 반환
		//return 0;
		return result;
	}
}
