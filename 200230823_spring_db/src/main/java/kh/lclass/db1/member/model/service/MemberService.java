package kh.lclass.db1.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.lclass.db1.member.model.dao.MemberDao;
import kh.lclass.db1.member.model.vo.MemberVo;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;

	public List<MemberVo> selectList() {
		return memberDao.selectList();
	}

	public int insert(MemberVo vo) {
		memberDao.update(vo);
		return memberDao.insert(vo);
	}

	public int delete(String pk) {
		return memberDao.delete(pk);
	}

	public int update(MemberVo vo) {
		return memberDao.update(vo);
	}

	public MemberVo selectOne(String pk) {
		return memberDao.selectOne(pk);
	}

	@Transactional
	public int insertReply(MemberVo vo) {
		memberDao.update(vo);
		return memberDao.insert(vo);
	}

}
