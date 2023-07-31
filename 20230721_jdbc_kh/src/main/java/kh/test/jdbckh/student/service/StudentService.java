package kh.test.jdbckh.student.service;

import java.sql.Connection;
import java.util.List;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;

import kh.test.jdbckh.common.jdbc.JdbcTemplate;
import kh.test.jdbckh.student.model.dao.StudentDao;
import kh.test.jdbckh.student.model.vo.StudentVo;


public class StudentService {
	private StudentDao dao = new StudentDao();
	
	public int insertStudent(StudentVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.insertStudent(conn, vo);
		close(conn);
		return result;
	}
	public StudentVo selectOneStudent( String studentNo) {
		StudentVo result =null;
		Connection conn = getConnection();
		result = dao.selectOneStudent(conn, studentNo);
		close(conn);
		return result;
	}
	public List<StudentVo> selectListStudent() {  // 전체 보기
		List<StudentVo> result = null;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.selectListStudent(conn);
		close(conn);
		return result;
	}
	
	public List<StudentVo> selectListStudent( String searchWord) {  // 검색
		List<StudentVo> result= null;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.selectListStudent(conn, searchWord);
		close(conn);
		return result;
	}
	public int getTotalCount() {
		int result= 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.getTotalCount(conn);
		close(conn);
		return result;
	}
	public List<StudentVo> selectListStudent( int currentPage, int pageSize, int totalCnt) {  // 페이징처리
		List<StudentVo> result= null;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.selectListStudent(conn, currentPage,pageSize,totalCnt);
		close(conn);
		return result;
	}
	public int getSearchTotalCount( String searchWord) {// 검색용 total Count
		int result= 0;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.getSearchTotalCount(conn, searchWord);
		close(conn);
		return result;
	}
	public List<StudentVo> selectListStudent( int currentPage, int pageSize, int totalCnt , String searchWord) {  // 페이징처리+검색
		List<StudentVo> result= null;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.selectListStudent(conn, currentPage,pageSize,totalCnt,searchWord);
		close(conn);
		return result;
	}
}
