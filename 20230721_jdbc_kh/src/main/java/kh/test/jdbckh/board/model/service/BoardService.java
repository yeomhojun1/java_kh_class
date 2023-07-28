package kh.test.jdbckh.board.model.service;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.getConnectionKhl;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.setAutoCommit;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.commit;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import kh.test.jdbckh.board.model.dao.BoardDao;
import kh.test.jdbckh.board.model.vo.BoardVo;

public class BoardService {
	private BoardDao dao = new BoardDao();
	
	public List<BoardVo> selectList(){
		List<BoardVo> result = null;
		Connection conn = getConnectionKhl();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	// 한 행 읽기 - PK로where조건
	public BoardVo selectOne(int bno){
		BoardVo result = null;
		Connection conn = getConnectionKhl();
		result = dao.selectOne(conn, bno);
		close(conn);
		return result;
	}
	// 한 행 삽입 - BoardVo 자료형을 받아와야 함.
	public int insert(BoardVo dto){
		int result = 0;
		Connection conn = getConnectionKhl();
		setAutoCommit(conn, false);
		if(dto.getBno() == 0) { // 원본글작성
			result = dao.insert(conn, dto);
		}else {   // 답글작성
			result = dao.update(conn, dto);
			if(result > -1) {
				result = dao.insert(conn, dto);
			}
		}
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	// 한 행 수정 - BoardVo 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
	public int update(BoardVo dto){
		int result = 0;
		Connection conn = getConnectionKhl();
		result = dao.update(conn, dto);
		close(conn);
		return result;
	}
	// 한 행 삭제 - 주로 PK로 where조건
	public int delete(int bno){
		int result = 0;
		Connection conn = getConnectionKhl();
		result = dao.delete(conn, bno);
		close(conn);
		return result;
	}
	
	//// 추가 
	// 페이징 처리 + 검색
	public int getTotalCount(String searchWord) {
		int result = 0;
		Connection conn = getConnectionKhl();
		result = dao.getTotalCount(conn, searchWord);
		close(conn);
		return result;
	}
	public List<BoardVo> selectList(int currentPage, int pageSize, String searchWord){
		List<BoardVo> result = null;
		Connection conn = getConnectionKhl();
		int totalCount = getTotalCount(searchWord);
		result = dao.selectList(conn, currentPage, pageSize, totalCount, searchWord);
		close(conn);
		return result;
	}
}
