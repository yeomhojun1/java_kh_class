package kh.test.jdbckh.member.model.service;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.getConnectionKhl;

import java.sql.Connection;
import java.util.List;

import kh.test.jdbckh.member.model.dao.MemberDao;
import kh.test.jdbckh.member.model.dto.Member;

public class MemberService {
	private MemberDao dao = new MemberDao();

	public List<Member> selectList() {
		List<Member> result = null;
		Connection conn = getConnectionKhl();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}

	// 한 행 읽기 - PK로where조건
	public Member selectOne(String mid) {
		Member result = null;
		Connection conn = getConnectionKhl();
		result = dao.selectOne(conn, mid);
		close(conn);
		return result;
	}

	public String login(String mid) {
		String result = null;

		Connection conn = getConnectionKhl();
		result = dao.login(conn, mid);
		close(conn);
		return result;
	}
	
}
