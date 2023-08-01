package kh.test.jdbckh.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kh.test.jdbckh.student.model.vo.StudentVo;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;

public class StudentDao {
// PPT 내용구현
	public int insertStudent(Connection conn,StudentVo vo) {
		int result=0;
		String query = "insert into tb_student values("
				+ " (student_No,department_No, student_Name,student_Ssn,student_Address,entrance_Date,absence_Yn,coach_Professor_No,department_Name)"
				+ "values(?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?)"
				;
		PreparedStatement pstmt = null;
		try {
			 pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getStudentNo());
			pstmt.setString(2, vo.getDepartmentNo());
			pstmt.setString(3, vo.getStudentName());
			pstmt.setString(4, vo.getStudentSsn());
			pstmt.setString(5, vo.getStudentAddress());
			pstmt.setString(6, vo.getEntranceDate());
			pstmt.setString(7, vo.getAbsenceYn());
			pstmt.setString(8, vo.getDepartmentName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		
		
		
		
		
		
		return result;
	}
	
	// DB에서 tb_student 테이블의 전달받은 학번을 통해 학생1명의 상세정보를 읽어옴
	public StudentVo selectOneStudent(Connection conn, String studentNo) {
		System.out.println("DAO selectOneStudent() arg:"+ studentNo);

		StudentVo result = null;
//		String query = "select * from tb_student join tb_department using(department_no) where student_no = "+"'"+studentNo+"'";
//		String query = "select s.*, department_name from tb_student s join tb_department d on(s.department_no=d.department_no) where student_no ="+"'"+studentNo+"'";
//		String query = "select s.* "
//				+ " , (select department_name from tb_department where department_no=s.department_no) department_name "
//				+ " from "
//				+ " tb_student s where student_no ="+"'"+studentNo+"'";
		String query = "select s.* "
			+ " , (select department_name from tb_department where department_no=s.department_no) department_name "
			+ " from "
			+ " tb_student s where student_no = ?";  
		// ? 위치홀더
//		String query = "select * from tb_student join tb_department using(department_no) where student_no = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			// pstmt 생성된 후  ---- execute실행하기 전
			// 여기서 ? 위치홀더에 값넣기
			pstmt.setString(1, studentNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = new StudentVo();
				// while 동작시킬필요없음. query 결과가 단일행일 것이므로
				result.setAbsenceYn(rset.getString("Absence_Yn"));
				result.setCoachProfessorNo(rset.getString("Coach_Professor_No"));
				result.setDepartmentNo(rset.getString("Department_No"));
				result.setEntranceDate(rset.getString("Entrance_Date"));
				result.setStudentAddress(rset.getString("Student_Address"));
				result.setStudentName(rset.getString("student_Name"));
				result.setStudentNo(rset.getString("student_No"));
				result.setStudentSsn(rset.getString("Student_Ssn"));
				result.setDepartmentName(rset.getString("Department_Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		System.out.println(result);
		return result;
	}
	
	// DB에서 tb_student 테이블의 있는 모든 내용을 읽어서 꺼냄.
	public List<StudentVo> selectListStudent(Connection conn) {  // 전체 보기
		List<StudentVo> result = null;
		
		String query= "select * from tb_student order by Student_No desc";
		
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 3. Statement/PrepareStatement 객체 생성 -conn 객체로부터 - query 문을 실어보냄
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(query);
			// 4. query 문을 실행해달라고 함.- 그 결과값을 return 받음.
			// select query 문이면 ResultSet 모양
			// insert/update/delete 문이면 int 모양
			rs = pstmt.executeQuery();
			
			// 5. ResultSet 에서 row(record)=한줄 읽어오기 위해 cursor(포인트)를 이동함.
			if(rs.next() ) {
				result = new ArrayList<StudentVo>();
				do {
				//  한줄row/record 를 읽을 준비 완료
				// 확인용도. System.out.println( rs.getString("STUDENT_NAME") );
				StudentVo vo = new StudentVo();
				vo.setStudentNo(rs.getString("Student_No"));
				vo.setDepartmentNo( rs.getString("department_no"));
				vo.setStudentName( rs.getString("Student_Name"));
				vo.setAbsenceYn( rs.getString("Absence_Yn"));
				vo.setCoachProfessorNo( rs.getString("Coach_Professor_No"));
				vo.setStudentAddress( rs.getString("Student_Address"));
				vo.setEntranceDate( rs.getString("Entrance_Date") );
				
				result.add(vo);
				}while(rs.next() == true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		//  확인용 System.out.println(result);
		return result;
	}
	// DB에서 tb_student 테이블의 있는 모든 내용을 읽어서 꺼냄.
	public List<StudentVo> selectListStudent(Connection conn, String searchWord) {  // 검색
		List<StudentVo> result = null;
		// 오류String query= "select * from tb_student where student_name like '%?%' or student_address like '%?%'";
		String query= "select * from tb_student where student_name like ? or student_address like ?";
		// like 연산자인 경우 위치홀더? 대신 연결자
//		String query= "select * from tb_student where student_name like '%"+searchWord+"%' or student_address like '%"+searchWord+"%'";
		
		
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 3. Statement/PrepareStatement 객체 생성 -conn 객체로부터 - query 문을 실어보냄
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(query);
			// 3-4 사이 위치홀더 ? 에 값 설정
			searchWord = "%"+searchWord+"%";  //like 연산자인 경우 % 또는 _ 를 합쳐서 만듬
			pstmt.setString(1, searchWord);
			pstmt.setString(2, searchWord);
			// 4. query 문을 실행해달라고 함.- 그 결과값을 return 받음.
			// select query 문이면 ResultSet 모양
			// insert/update/delete 문이면 int 모양
			rs = pstmt.executeQuery();
			
			// 5. ResultSet 에서 row(record)=한줄 읽어오기 위해 cursor(포인트)를 이동함.
			result = new ArrayList<StudentVo>();
			while(rs.next() == true) {
				//  한줄row/record 를 읽을 준비 완료
				// 확인용도. System.out.println( rs.getString("STUDENT_NAME") );
				StudentVo vo = new StudentVo();
				vo.setStudentNo(rs.getString("Student_No"));
				vo.setDepartmentNo( rs.getString("department_no"));
				vo.setStudentName( rs.getString("Student_Name"));
				vo.setAbsenceYn( rs.getString("Absence_Yn"));
				vo.setCoachProfessorNo( rs.getString("Coach_Professor_No"));
				vo.setStudentAddress( rs.getString("Student_Address"));
				vo.setEntranceDate( rs.getString("Entrance_Date") );
				
				result.add(vo);
			}
		} catch (SQLException e) {
			// 2. dbms에 연결 실패
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		//  확인용 System.out.println(result);
		return result;
	}

		
	public int getTotalCount(Connection conn) {
		int result = 0;// 총글개수
		String queryTotalCnt= "select count(*) cnt from tb_student";  
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
	
	public List<StudentVo> selectListStudent(Connection conn, int currentPage, int pageSize, int totalCnt) {  // 페이징처리
		List<StudentVo> result = new ArrayList<StudentVo>();
		String query= " select * from "
				+ " (\r\n"
				+ " select tb1.*, rownum rn from"
				+ "    (select * from tb_student order by student_no ) tb1"
				+ " ) tb2"
				+ " where rn between ? and ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startRownum = 0;
		int endRownum = 0;
		System.out.println("총글개수:"+totalCnt);
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
		System.out.println("startRownum:"+startRownum);
		System.out.println("endRownum:"+endRownum);
		
		try {
			// 페이지당 글 읽어오기 위한 query 실행
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRownum);
			pstmt.setInt(2, endRownum);
			rs = pstmt.executeQuery();
			
			// 5. ResultSet 에서 row(record)=한줄 읽어오기 위해 cursor(포인트)를 이동함.
			while(rs.next() == true) {
				//  한줄row/record 를 읽을 준비 완료
				// 확인용도. System.out.println( rs.getString("STUDENT_NAME") );
				StudentVo vo = new StudentVo();
				vo.setStudentNo(rs.getString("Student_No"));
				vo.setDepartmentNo( rs.getString("department_no"));
				vo.setStudentName( rs.getString("Student_Name"));
				vo.setAbsenceYn( rs.getString("Absence_Yn"));
				vo.setCoachProfessorNo( rs.getString("Coach_Professor_No"));
				vo.setStudentAddress( rs.getString("Student_Address"));
				vo.setEntranceDate( rs.getString("Entrance_Date") );
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		//  확인용 System.out.println(result);
		return result;
	}
	
	public int getSearchTotalCount(Connection conn, String searchWord) {// 검색용 total Count
		int result = 0;// 총글개수
		String queryTotalCnt= "select count(*) cnt from tb_student"
				+ " where student_name like ? or student_address like ?";  
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
	
	public List<StudentVo> selectListStudent(Connection conn, int currentPage, int pageSize, int totalCnt , String searchWord) {  // 페이징처리+검색
		List<StudentVo> result = new ArrayList<StudentVo>();
		String query= " select * from "
				+ " (\r\n"
				+ " select tb1.*, rownum rn from"
				+ "    (select * from tb_student"
				+ " 			where student_name like ? or student_address like ?"
				+ " 			order by student_no desc) tb1"
				+ " ) tb2"
				+ " where rn between ? and ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startRownum = 0;
		int endRownum = 0;
		System.out.println("총글개수:"+totalCnt);
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
		System.out.println("startRownum:"+startRownum);
		System.out.println("endRownum:"+endRownum);
		
		searchWord = "%"+searchWord+"%";
		
		try {
			// 페이지당 글 읽어오기 위한 query 실행
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, searchWord);
			pstmt.setString(2, searchWord);
			pstmt.setInt(3, startRownum);
			pstmt.setInt(4, endRownum);
			rs = pstmt.executeQuery();
			
			// 5. ResultSet 에서 row(record)=한줄 읽어오기 위해 cursor(포인트)를 이동함.
			while(rs.next() == true) {
				//  한줄row/record 를 읽을 준비 완료
				// 확인용도. System.out.println( rs.getString("STUDENT_NAME") );
				StudentVo vo = new StudentVo();
				vo.setStudentNo(rs.getString("Student_No"));
				vo.setDepartmentNo( rs.getString("department_no"));
				vo.setStudentName( rs.getString("Student_Name"));
				vo.setAbsenceYn( rs.getString("Absence_Yn"));
				vo.setCoachProfessorNo( rs.getString("Coach_Professor_No"));
				vo.setStudentAddress( rs.getString("Student_Address"));
				vo.setEntranceDate( rs.getString("Entrance_Date") );
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		//  확인용 System.out.println(result);
		return result;
	}
	
	
}
