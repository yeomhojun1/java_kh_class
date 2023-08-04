package kh.test.jdbckh.professor.model.service;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import kh.test.jdbckh.professor.model.dao.ProfDao;
import kh.test.jdbckh.professor.model.vo.ProfVo;

public class ProfessorService {
	private ProfDao dao = new ProfDao();
	
	// 학생등록시 필요한 학과정보 리스트 읽기
	public List<ProfVo> selectList(){
		List<ProfVo> result = null;
		Connection conn = getConnection();
		result = dao.selectListProf(conn);
		close(conn);
		return result;
	}

}