package kh.test.jdbckh.department.model.service;


	import java.sql.Connection;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;
	import kh.test.jdbckh.department.model.dao.DeptDao;
	import kh.test.jdbckh.department.model.vo.DeptVo;
	public class DeptService {


		// transaction 트랜잭션 
		// Connection 관리
		// 일처리 단위별로 넣어줌. - for DAO
		// commit/rollback/연결해제
		private DeptDao dao = new DeptDao();
		
		public DeptVo selectOneDept(String DeptNo) {
			Connection conn = getConnection();
			DeptVo result = dao.selectOneDept(conn,DeptNo);
			close(conn);
			return result;
		}
		public List<DeptVo> selectListDept() { 
			Connection conn = getConnection();
			List<DeptVo> result = dao.selectListDept(conn);
			close(conn);
			return result;
		}
		public List<DeptVo> selectListDept(String searchWord) {  // 검색
			Connection conn = getConnection();
			List<DeptVo> result =  dao.selectListDept(conn,searchWord);
			close(conn);
			return result;
		}
	
		
		// 페이징처리 + 검색
		public Map<String, Object> selectListDept(int currentPage, int pageSize, String searchWord ) {  // 페이징처리 + 검색
			Connection conn = getConnection();
			// 검색용 total Count
			int totalCnt = dao.getSearchTotalCount(conn, searchWord);
			List<DeptVo> result =  dao.selectListDept(conn,currentPage, pageSize, totalCnt, searchWord);
			close(conn);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("totalCnt", totalCnt);
			map.put("DeptList", result);
			return map;
		}
		public int getTotalCount(String searchWord) {
			Connection conn = getConnection();
			int result = dao.getTotalCount(conn,searchWord);
			close(conn);
			return result;
		}
	}


