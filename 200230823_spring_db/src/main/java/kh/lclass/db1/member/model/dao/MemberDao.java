package kh.lclass.db1.member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.lclass.db1.member.model.vo.MemberVo;

@Repository("memberDao")
public class MemberDao {
	// autowired쓸때 뒤에 null이나 = new Xxx()라고 설정하면 안됨,왜냐면 spring에서 이미 만들어진 빈객체를 가져다가 씀
	// root-context에 있는 bean객체를 가져다가 쓸거임, id인 sqlsession임
	@Autowired
	private SqlSession sqlSession;

	public List<MemberVo> selectList() {

		return sqlSession.selectList("member.selectList");
	}

	public int insert(MemberVo vo) {
		return sqlSession.insert("member.insert", vo);
	}

	public int delete(String pk) {
		return sqlSession.delete("member.delete", pk);
	}

	public int update(MemberVo vo) {
		return sqlSession.update("member.update", vo);
	}

	public MemberVo selectOne(String pk) {
		return sqlSession.selectOne("member.selectOne", pk);
	}
}
