package com.song.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO {
	
	public int update(EmpDTO empDTO) {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		int result = 0;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,user,password);
			
			String sql = "UPDATE EMP SET SAL = ?, COMM = ? WHERE EMPNO = ?";
			
			pst = con.prepareStatement(sql);
			
			pst.setDouble(1, empDTO.getSal());
			pst.setDouble(2, empDTO.getComm());
			pst.setInt(3, empDTO.getEmpno());
			
			result = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 사번으로 삭제
	public int delete(EmpDTO empDTO) {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		int result = 0;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,user,password);
			
			String sql = "DELETE FROM EMP WHERE EMPNO = ?";
			
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, empDTO.getEmpno());
			
			result = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 고용날짜 현재시간, dept는 현재 있는걸로 제한
	public int insert(EmpDTO empDTO) {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		int result = 0;
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,user,password);
			
			String sql = "INSERT INTO EMP VALUES(?,?,?,?,?,?,?,?)";
			
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, empDTO.getEmpno());
			pst.setString(2, empDTO.getEname());
			pst.setString(3, empDTO.getJob());
			pst.setString(4, empDTO.getMgr());
			pst.setDate(5, empDTO.getHiredate());
			pst.setDouble(6, empDTO.getSal());
			pst.setDouble(7, empDTO.getComm());
			pst.setInt(8, empDTO.getDeptno());
			
			result = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int countSal() {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		int totalSal = 0;
		
		try {
			Class.forName(driver);
		
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT SUM(SAL+NVL(COMM,0)) FROM EMP";
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				totalSal = rs.getInt(1);
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
		
		return totalSal;
	}

	public EmpDTO selectOne(EmpDTO empDTO) {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		EmpDTO edto = new EmpDTO();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT * FROM EMP WHERE ENAME LIKE '%' || ? || '%' ORDER BY EMPNO";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, empDTO.getEname());
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				
				edto.setEmpno(rs.getInt("EMPNO"));
				edto.setEname(rs.getString("ENAME"));
				edto.setJob(rs.getString("JOB"));
				edto.setMgr(rs.getString("mgr"));
				edto.setHiredate(rs.getDate("HIREDATE"));
				edto.setSal(rs.getDouble("SAL"));
				edto.setComm(rs.getDouble("COMM"));
				edto.setDeptno(rs.getInt("DEPTNO"));
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
		
		return edto;
	}
	
	public ArrayList<EmpDTO> selectAll() {
		
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String user = "scott";
		String password = "tiger";
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		ArrayList<EmpDTO> edtoList = new ArrayList<EmpDTO>();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT * FROM EMP ORDER BY EMPNO";
			
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				EmpDTO edto = new EmpDTO();
				edto.setEmpno(rs.getInt("EMPNO"));
				edto.setEname(rs.getString("ENAME"));
				edto.setJob(rs.getString("JOB"));
				edto.setMgr(rs.getString("mgr"));
				edto.setHiredate(rs.getDate("HIREDATE"));
				edto.setSal(rs.getDouble("SAL"));
				edto.setComm(rs.getDouble("COMM"));
				edto.setDeptno(rs.getInt("DEPTNO"));
				
				edtoList.add(edto);
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
		
		return edtoList;
	}
}
