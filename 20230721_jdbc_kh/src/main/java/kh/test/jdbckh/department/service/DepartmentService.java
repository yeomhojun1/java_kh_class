package kh.test.jdbckh.department.service;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import kh.test.jdbckh.common.jdbc.JdbcTemplate;
import kh.test.jdbckh.department.model.dao.DeptDao;
import kh.test.jdbckh.department.model.vo.DeptVo;



public class DepartmentService {
		private DeptDao dao = new DeptDao();
		
		
		public DeptVo selectOneDept( String deptNo) {
			DeptVo result =null;
			Connection conn = getConnection();
			result = dao.selectOneDept(conn, deptNo);
			close(conn);
			return result;
		}
		public List<DeptVo> selectListDepartment() {  // 전체 보기
			List<DeptVo> result = null;
			Connection conn = JdbcTemplate.getConnection();
			result = dao.selectListDept(conn);
			close(conn);
			return result;
		}
		
		public List<DeptVo> selectListDepartment( String searchWord) {  // 검색
			List<DeptVo> result= null;
			Connection conn = JdbcTemplate.getConnection();
			result = dao.selectListDept(conn, searchWord);
			close(conn);
			return result;
		}
		public int getTotalCount(String searchWord) {
			int result = 0;
			Connection conn = getConnection();
			result = dao.getTotalCount(conn, searchWord);
			close(conn);
			return result;
		}
		public List<DeptVo> selectListDepartment( int currentPage, int pageSize, int totalCnt) {  // 페이징처리
			List<DeptVo> result= null;
			Connection conn = JdbcTemplate.getConnection();
			result = dao.selectListDept(conn, currentPage,pageSize,totalCnt);
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
		public List<DeptVo> selectListDepartment( int currentPage, int pageSize, String searchWord) {  // 페이징처리+검색
			List<DeptVo> result= null;
			Connection conn = JdbcTemplate.getConnection();
			int totalCount = getTotalCount(searchWord);
			result = dao.selectListDept(conn, currentPage,pageSize,totalCount,searchWord);
			close(conn);
			return result;
		}
	}

