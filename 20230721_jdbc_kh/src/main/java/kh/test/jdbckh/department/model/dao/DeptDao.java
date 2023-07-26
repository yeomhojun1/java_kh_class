package kh.test.jdbckh.department.model.dao;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.getConnection;

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
	public List<DeptVo> selectListDept(Connection conn) {
		List<DeptVo> list = null;
		conn = null;
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
	public List<DeptVo> selectListDept(Connection conn,String searchword) {
		List<DeptVo> list = null;
		 conn = null;
	
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
	public List<DeptVo> selectListDept(Connection conn,int currentPage, int pageSize, int totalCnt,String searchword) {
		List<DeptVo> list = null;
		 conn = null;
	
		PreparedStatement pstmt = null;
		String sql =" select * from "
				+ " (\r\n"
				+ " select tb1.*, rownum rn from"
				+ "    (select * from tb_department"
				+ " 			where department_name like ? or category like ?"
				+ " 			order by department_name asc) tb1"
				+ " ) tb2"
				+ " where rn between ? and ?";
		ResultSet rs = null;
		int startRownum = 0;
		int endRownum = 0;
		System.out.println("총글개수:"+totalCnt);
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
		try {
			
			pstmt = conn.prepareStatement(sql);
			searchword = "%"+searchword+"%";
			pstmt.setString(1, searchword);
			pstmt.setString(2, searchword);
			pstmt.setInt(3, startRownum);
			pstmt.setInt(4, endRownum);
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
	public List<DeptVo> selectListDept(Connection conn,int currentPage, int pageSize, int totalCnt) {
		List<DeptVo> list = null;
		 conn = null;
	
		PreparedStatement pstmt = null;
		String sql =" select * from "
				+ " (\r\n"
				+ " select tb1.*, rownum rn from"
				+ "    (select * from tb_department"
				+ " 			order by department_name asc) tb1"
				+ " ) tb2"
				+ " where rn between ? and ?";
		ResultSet rs = null;
		int startRownum = 0;
		int endRownum = 0;
		System.out.println("총글개수:"+totalCnt);
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRownum);
			pstmt.setInt(2, endRownum);
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

	public DeptVo selectOneDept(Connection conn,String deptNo) {
		DeptVo result = null;
		System.out.println("dao selectOneStudent() arg:" + deptNo);
		String query = "select * from tb_department where department_no = "+"'"+deptNo+"'";
	conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
		
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
	public int getSearchTotalCount(Connection conn, String searchWord) {// 검색용 total Count
		int result = 0;// 총글개수
		String queryTotalCnt= "select count(*) cnt from tb_department"
			+"	where department_name like ? or category like ?"
				+ " 			order by department_name asc";
		searchWord = "%"+searchWord+"%";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(queryTotalCnt);
			pstmt.setString(1, searchWord);
			pstmt.setString(2, searchWord);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//오류 함수는 컬럼명이 될수 없음 -  totalCnt = rs.getInt("count(*)");
				result = rs.getInt("cnt");
				//totalCnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("검색총글개수:"+result);
		return result;
	}
	public int getTotalCount(Connection conn) {
		int result = 0;// 총글개수
		String queryTotalCnt= "select count(*) cnt from tb_department";  
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(queryTotalCnt);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//오류 함수는 컬럼명이 될수 없음 -  totalCnt = rs.getInt("count(*)");
				result = rs.getInt("cnt");
				//totalCnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("총글개수:"+result);
		return result;
	}
}