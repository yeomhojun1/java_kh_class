package kh.test.jdbckh.member.model.dao;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.member.model.dto.Member;


public class MemberDao {
	public List<Member> selectList(Connection conn) {
		System.out.println("[Board Dao selectList]");
		List<Member> result = new ArrayList<Member>();

		String subquery = "select * from member ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(subquery);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				Member dto = new Member(
						
						);
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[Board Dao selectList] return:" + result);
		return result;
	}

	// 한 행 읽기 - PK로where조건
	public Member selectOne(Connection conn, String  mid) {
		System.out.println("[Board Dao selectOne] bno:" + mid);
		Member result = null;
		// TODO
		System.out.println("[Board Dao selectOne] return:" + result);
		return result;
	}

	// 한 행 삽입 - Member 자료형을 받아와야 함.
	public int insert(Connection conn, Member dto) {
		System.out.println("[Board Dao insert] dto:" + dto);
		int result = 0;
		String query = "";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
			close(pstmt);
		}
		System.out.println("[Board Dao insert] return:" + result);
		return result;
	}
	public int insertReply(Connection conn, Member dto) {
		System.out.println("[Board Dao insertReply] dto:" + dto);
		int result = 0;
		String query = "insert into BOARD values (SEQ_BOARD_BNO.nextval, ?, ?, default, ?    , (select bref from board where bno=?)    , (select bre_level+1 from board where bno=?)    , (select bre_step+1 from board where bno=?)    )";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
		
			pstmt.setString(3, dto.getMid());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[Board Dao insertReply] return:" + result);
		return result;
	}
	// 한 행 수정 - Member 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
	public int update(Connection conn, Member dto) {
		System.out.println("[Board Dao update] dto:" + dto);
		int result = -1;  // update 경우 0도 정상 결과값일 수 있으므로 -1을 초기값
		String query = "update board set BRE_STEP = BRE_STEP + 1 where BRE_STEP > (select bre_step from board where bno=?)  and BREF = (select bref from board where bno=?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[Board Dao update] return:" + result);
		return result;
	}

	// 한 행 삭제 - 주로 PK로 where조건
	public int delete(Connection conn, int bno) {
		System.out.println("[Board Dao delete] bno:" + bno);
		int result = 0;
		// TODO
		System.out.println("[Board Dao delete] return:" + result);
		return result;
	}

	//// 추가
	// 페이징 처리(pageSize!=0아닐때) + 검색(있다면 where처리)
	
	//추가 로그인 성공시 1, 실패시 0
	//
	public int login(Connection conn, Member vo ) {
		String query = "select count(*) cnt from member where mid=? and mpwd=?";
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rs= null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpwd());
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
		
	}
	//login시 mpwd를 return함 id가 존재하지 않으면 return null이 됨
	public String login(Connection conn, String mid ) {
		String result = null;
		String query = "select mpwd from member where mid=? ";
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mid);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("mpwd");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
		
	}
}
