package kh.lclass.db1.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.lclass.db1.board.model.dao.BoardDao;
import kh.lclass.db1.board.model.vo.BoardVo;
@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;

	public List<BoardVo> selectList() {
		return boardDao.selectList();
	}

	public int insert(BoardVo vo) {
		return boardDao.insert(vo);
	}

	public int delete(int bno) {
		return boardDao.delete(bno);
	}

	public int update(BoardVo vo) {
		return boardDao.update(vo);
	}

	public BoardVo selectOne(int bno) {
		return boardDao.selectOne(bno);
	}

}
