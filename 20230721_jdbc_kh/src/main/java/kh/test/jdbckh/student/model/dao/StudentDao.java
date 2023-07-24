package kh.test.jdbckh.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.student.model.vo.StudentVo;

public class StudentDao {
	// ppt 내용 구현

	// DB에서 TB_STUDENT 테이블의 전달받은 학번을 통해 학생1의 정보를 가져옴

	public StudentVo selectOneStudent(String studentNo) {
		StudentVo result = null;
		System.out.println("dao selectOneStudent() arg:"+studentNo);
		//위치홀더 ? 나옴
		String query = "select s.*, (select department_name from tb_department d where d.department_no = s.department_no) department_name from tb_student s where student_no= ? " ;
		
//		String query = "select s.*, (select department_name from tb_department d where d.department_no = s.department_no) department_name from tb_student s where student_no=" + "'"+studentNo+"'";

		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","kh");
			if(conn ==null) {
				System.out.println("연결실패");
			}
			pstmt = conn.prepareStatement(query);
//			pstmt가 생성되고 executeQuery가 실행되기전에 
//			위치홀더에다가 값을 넣어줌
			pstmt.setString(0, studentNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = new StudentVo();
				//while은 동작안함 왜냐면 위에 쿼리문의 결과가 단일행으로 나오니까, list일때만 와일이나 for돌림
				result.setAbsenceYn(rset.getString("Absence_Yn"));
				result.setCoachProfessorNo(rset.getString("Coach_Professor_No"));
				result.setDepartmentNo(rset.getString("Department_No"));
				result.setEntranceDate(rset.getDate("Entrance_Date"));
				result.setStudentAddress(rset.getString("Student_Address"));
				result.setStudentName(rset.getString("Student_Name"));
				result.setStudentNo(rset.getString("Student_No"));
				result.setStudentSsn(rset.getString("Student_Ssn"));
				result.setDepartmentName(rset.getString("Department_Name"));
			}
		}catch (Exception e) {
			
		
		
		}finally {
				try {
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
		
		
		
		
		
		System.out.println(result);
		return result;
	}

	// DBdptj tb_student 테이블의 있는 모든 내용을 읽어서 꺼냄.
	public List<StudentVo> selectListStudent() {
		List<StudentVo> list = null;
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
			String sql = "select * from tb_student s join tb_department d on d.department_no=s.department_no";
			pstmt = conn.prepareStatement(sql);
			// 4.query 문을 실행해달라고함. 그 결과값을 return 받음
			// insert/update/delete 문이면 int 모양
			ResultSet rs = pstmt.executeQuery();
			// 5. resultset에서 row(record) = 한줄 읽어오기 위해 cursor(포인트)를 이동함
			list = new ArrayList<StudentVo>();
			while (rs.next() == true) {
				// 한줄(row,record) 읽을 준비가 됨
//				System.out.println( rs.getString("STUDENT_NAME"));
				StudentVo vo = new StudentVo();
				vo.setStudentName(rs.getString("STUDENT_NAME"));
				vo.setStudentSsn(rs.getString("Student_Ssn"));
				vo.setStudentNo(rs.getString("STUDENT_NO"));
				vo.setStudentAddress(rs.getString("STUDENT_ADDRESS"));
				vo.setDepartmentNo(rs.getString("DEPARTMENT_NO"));
				vo.setEntranceDate(rs.getDate("Entrance_Date"));
				vo.setCoachProfessorNo(rs.getString("Coach_professor_no"));
				vo.setAbsenceYn(rs.getString("ABSENCE_YN"));
				vo.setDepartmentName(rs.getString("Department_Name"));

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
//				if(pstmt!=null) {pstmt.close();}
//				if(stmt!=null)  {stmt.close();}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//		System.out.println(list);
		return list;
	}

}
