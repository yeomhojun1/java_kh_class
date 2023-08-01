package kh.test.jdbckh.professor.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.common.jdbc.JdbcTemplate;
import kh.test.jdbckh.professor.model.vo.ProfVo;

public class ProfDao {
	public List<ProfVo> selectListProf() {
		List<ProfVo> list = null;
		Connection conn = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//드라이버 확인
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");//SQL디벨로퍼에서의 주소,아이디, 비번을 입력해줘서 서버에 들어감
			String sql = "select * from tb_professor";//내가 뽑고자 하는 테이블
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			list = new ArrayList<ProfVo>();
			while (rset.next()) {
				ProfVo vo = new ProfVo();//VO객체를 생성했는데 텅 비어있음, 그리고 WHILE안에 있어서 계속 반복함 언제까지? 다음께 없을때까지
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
				JdbcTemplate.close(rset);
				if(pstmt!= null)pstmt.close();
				if(conn!= null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return list;
	}
	public List<ProfVo> selectListProf(String a) {
		List<ProfVo> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from tb_professor where professor_name like ? or professor_address like ?";//내가 뽑고자 하는 테이블
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//드라이버 확인
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");//SQL디벨로퍼에서의 주소,아이디, 비번을 입력해줘서 서버에 들어감
			pstmt = conn.prepareStatement(sql);
			a = "%"+a+"%";
			pstmt.setString(1, a);
			pstmt.setString(2, a);
			rset = pstmt.executeQuery();
			if(rset.next()) {
			list = new ArrayList<ProfVo>();
			
			do {
				ProfVo vo = new ProfVo();//VO객체를 생성했는데 텅 비어있음, 그리고 WHILE안에 있어서 계속 반복함 언제까지? 다음께 없을때까지
				vo.setDepartmentNo(rset.getString("department_no"));
				vo.setProfessorNo(rset.getString("Professor_No"));
				vo.setProfessorName(rset.getString("Professor_Name"));
				vo.setProfessorSsn(rset.getString("Professor_Ssn"));
				vo.setProfessorAddress(rset.getString("Professor_Address"));
				
				list.add(vo);
			}while (rset.next()) ;
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
	public ProfVo selectOneProf(String professorNo) {
		ProfVo result = null;
		Connection conn = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String query = "select * from tb_professor where professor_no = ?"; //이번엔 하나를 뽑는거라서 테이블에 WHERE조건이 붙음,꼭 작은 따옴표신경써주기
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//드라이버 확인
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","kh");//SQL디벨로퍼에서의 주소,아이디, 비번을 입력해줘서 서버에 들어감
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, professorNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = new ProfVo();
				result.setDepartmentNo(rset.getString("department_no"));
				result.setProfessorNo(rset.getString("Professor_No"));
				result.setProfessorName(rset.getString("Professor_Name"));
				result.setProfessorSsn(rset.getString("Professor_Ssn"));
				result.setProfessorAddress(rset.getString("Professor_Address"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rset != null)
					rset.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	return result;
	}
}
