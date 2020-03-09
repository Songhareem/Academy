package com.song.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptDAO {

	// 매서드
	public void delete(int deptno) {
		// 1. 접속시 필요한 정보
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			// 2. driver를 객체를 생성해서 메모리에 로드
			Class.forName(driver);
	
			// 3. 로그인 후 Connection 반환
			con = DriverManager.getConnection(url, user, pw);
			//if(con != null)
			//	System.out.println("로그인");
			
			// 4. Query문 작성
			String query = "DELETE FROM DEPT WHERE DEPTNO = ?";
			//System.out.println(query);
			
			// 5. PreparedStatement 쿼리문 미리 전송
			st = con.prepareStatement(query);
			
			// 6. ? 값을 세팅
			st.setInt(1, deptno);
			
			// 7. 필드값 전송 후 결과 처리
			int result = st.executeUpdate();
			if(result > 0) {
				System.out.printf("%d 개의 컬럼 삭제\n", result);
			} else {
				System.out.println("삭제 실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void insert(DeptDTO ddto) {
		// 1. 접속시 필요한 정보
		// ip, port, id, pw, sid
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";

		String user = "scott";
		String pw = "tiger";
		
		
		// JDBC 드라이버 클래스
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		// data
		int deptno = ddto.getDeptno();
		String dname = ddto.getDname();
		String loc = ddto.getLoc();
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			// 2. driver를 객체를 생성해서 메모리에 로드
			Class.forName(driver);

			// 3. 로그인 후 Connection 반환
			con = DriverManager.getConnection(url, user, pw);
			
			// auto commit 해체
			//con.setAutoCommit(false);
			
			//if(con != null)
			//	System.out.println("로그인");
			
			// 4. Query문 작성
			String query = "INSERT INTO DEPT VALUES(?,?,?)";
			//System.out.println(query);
			
			// 5. PreparedStatement 쿼리문 미리 전송
			st = con.prepareStatement(query);
			
			// 6. ? 값을 세팅
			st.setInt(1, deptno);
			st.setString(2, dname);
			st.setString(3, loc);
			
			// 7. 필드값 전송 후 결과 처리
			int result = st.executeUpdate();
			
			if(result > 0) {
				System.out.printf("%d 개의 컬럼 업데이트\n", result);
			} else {
				System.out.println("업데이트 실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
