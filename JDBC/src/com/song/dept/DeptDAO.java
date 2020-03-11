package com.song.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDAO {

	// 매서드
	public DeptDTO selectOne(int deptno) {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		DeptDTO ddto = null;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, pw);
			
			String query = "SELECT * FROM DEPT WHERE DEPTNO = ?";

			pst = con.prepareStatement(query);
			
			pst.setInt(1, deptno);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				ddto = new DeptDTO();
				ddto.setDeptno(rs.getInt("DEPTNO"));
				ddto.setDname(rs.getString("DNAME"));
				ddto.setLoc(rs.getString("LOC"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ddto;
	}
	
	public ArrayList<DeptDTO> select() {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		ArrayList<DeptDTO> ddtoList = new ArrayList<DeptDTO>();
		
		try {
			Class.forName(driver);
		
			con = DriverManager.getConnection(url, user, pw);
			
			String query = "SELECT * FROM DEPT ORDER BY DEPTNO ASC";
			
			pst = con.prepareStatement(query);
			
			rs = pst.executeQuery();
			
			// rs.next -> 한 row씩 읽어옴 
			// 데이터 있으면 true, 없으면 false return
			// 데이터 있으면 rs에 저장
			while(rs.next()) {
				
				DeptDTO ddto = new DeptDTO();
				ddto.setDeptno(rs.getInt("DEPTNO")); 
				ddto.setDname(rs.getString("DNAME"));
				ddto.setLoc(rs.getString("LOC"));
				
				ddtoList.add(ddto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ddtoList;
	}
	
	public int delete(int deptno) {
		// 1. 접속시 필요한 정보
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection con = null;
		PreparedStatement st = null;
		
		int result = 0;
		
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
			result = st.executeUpdate();
			
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
		
		return result;
	}
	
	public int insert(DeptDTO ddto) {
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
		
		int result = 0;
		
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
			result = st.executeUpdate();
			
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
	
		return result;
	}
}
