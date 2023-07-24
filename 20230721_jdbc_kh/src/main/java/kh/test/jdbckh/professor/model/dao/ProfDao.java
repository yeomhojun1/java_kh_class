package kh.test.jdbckh.professor.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.professor.model.vo.ProfVo;

public class ProfDao {
	public List<ProfVo> selectListProf() {
		List<ProfVo> list = null;
		Connection conn = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
			String sql = "select * from tb_professor";
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			list = new ArrayList<ProfVo>();
			while (rset.next()) {
				ProfVo vo = new ProfVo();
				vo.setDepartmentNo(rset.getString("department_no"));
				vo.setProfessorNo(rset.getString("Professor_No"));
				vo.setProfessorName(rset.getString("Professor_Name"));
				vo.setProfessorSsn(rset.getString("Professor_Ssn"));
				vo.setProfessorAddress(rset.getString("Professor_Address"));
				
				list.add(vo);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				if(rset!= null)rset.close();
				if(pstmt!= null)pstmt.close();
				if(conn!= null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return list;
	}
	public ProfVo selectOneProf() {
		ProfVo result = null;
		Connection conn = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = "select * from tb_professor";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","kh");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			
		}
		
		
		
		
		
		
		
		
		return result;
	}
}
