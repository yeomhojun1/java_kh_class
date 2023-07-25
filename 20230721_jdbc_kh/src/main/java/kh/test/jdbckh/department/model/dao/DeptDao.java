package kh.test.jdbckh.department.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.department.model.vo.DeptVo;
import kh.test.jdbckh.student.model.vo.StudentVo;

public class DeptDao {
	public List<DeptVo> selectListDept() {
		List<DeptVo> list = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			// 1. driver 있다면 로딩함.//없다면 ClassNotFoundException 뜸
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 객체 생성.. dbms와 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kh", "kh");
			if (conn != null) {
				System.out.println("db연결 성공!!!!!!!!!!!!!");
			} else {
				System.out.println("------------db연결실패-------");
			}
			// 3. statement/preparestatement 객체 생성 - conn객체로부터 받아서 생성 -query문을 실어 보냄
//			 stmt = conn.createStatement();
			String sql = "select * from tb_department";
			pstmt = conn.prepareStatement(sql);
			// 4.query 문을 실행해달라고함. 그 결과값을 return 받음
			// insert/update/delete 문이면 int 모양
			ResultSet rs = pstmt.executeQuery();
			// 5. resultset에서 row(record) = 한줄 읽어오기 위해 cursor(포인트)를 이동함
			list = new ArrayList<DeptVo>();
			while (rs.next() == true) {
				DeptVo vo = new DeptVo();
				vo.setDepartmentName(rs.getString("department_Name"));
				vo.setDepartmentNo(rs.getString("department_No"));
				vo.setCategory(rs.getString("category"));
				vo.setOpenYn(rs.getString("open_Yn"));
				vo.setCapacity(rs.getString("capacity"));

				list.add(vo);

			}

		} catch (ClassNotFoundException e) {
			// 1.driver (ojdbc.jar) 없음
			e.printStackTrace();
		} catch (SQLException e) {
			// 2. dbms에 연결 실패
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
//		if(stmt!=null)  {stmt.close();}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//System.out.println(list);
		return list;
	}
	public List<DeptVo> selectListDept(String searchword) {
		List<DeptVo> list = null;
		Connection conn = null;
	
		PreparedStatement pstmt = null;
		String sql = "select * from tb_department where department_name like ? or category like ?";
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kh", "kh");
			
			pstmt = conn.prepareStatement(sql);
			searchword = "%"+searchword+"%";
			pstmt.setString(1, searchword);
			pstmt.setString(2, searchword);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<DeptVo>();
			
			do {
				DeptVo vo = new DeptVo();
				vo.setDepartmentName(rs.getString("department_Name"));
				vo.setDepartmentNo(rs.getString("department_No"));
				vo.setCategory(rs.getString("category"));
				vo.setOpenYn(rs.getString("open_Yn"));
				vo.setCapacity(rs.getString("capacity"));

				list.add(vo);

			}while (rs.next() == true);
			
			}
		} catch (ClassNotFoundException e) {
			// 1.driver (ojdbc.jar) 없음
			e.printStackTrace();
		} catch (SQLException e) {
			// 2. dbms에 연결 실패
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
//		if(stmt!=null)  {stmt.close();}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//System.out.println(list);
		return list;
	}

	public DeptVo selectOneDept(String deptNo) {
		DeptVo result = null;
		System.out.println("dao selectOneStudent() arg:" + deptNo);
		String query = "select * from tb_department where department_no = "+"'"+deptNo+"'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
			if (conn == null) {
				System.out.println("연결실패");
			}
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = new DeptVo();
				// while은 동작안함 왜냐면 위에 쿼리문의 결과가 단일행으로 나오니까, list일때만 와일이나 for돌림
				result.setDepartmentNo(rset.getString("Department_no"));
				result.setDepartmentName(rset.getString("department_name"));
				result.setCategory(rset.getString("category"));
				result.setOpenYn(rset.getString("open_yn"));
				result.setCapacity(rset.getString("capacity"));

			}
		} catch (Exception e) {

		} finally {
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