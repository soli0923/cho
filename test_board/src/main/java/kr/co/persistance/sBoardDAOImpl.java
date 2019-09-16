package kr.co.persistance;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.domain.BoardVO;
import kr.co.domain.pageTO;
import kr.co.domain.sPageTO;


@Repository /* 나중에 빈으로 사용할 것이라고 지정해 주는것! */
public class sBoardDAOImpl implements sBoardDAO{
	
	@Inject
	private SqlSession session;
	
	private final String NS = "kr.co.mapper.sboard";

	@Override
	public int amount(sPageTO sto) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".amount", sto);
	}

	@Override
	public List<BoardVO> list(sPageTO sto) {
		// TODO Auto-generated method stub
		return session.selectList(NS+".list", sto);
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".read", bno);
	}

	@Override
	public void increaseviewcnt(int bno) {
		session.update(NS+".increaseviewcnt", bno);
		
	}

	@Override
	public void del(int bno) {
		session.delete(NS+".del", bno);
		
	}

	@Override
	public BoardVO modifyUI(int bno) {
		// TODO Auto-generated method stub
		return session.selectOne(NS+".modifyUI", bno);
	}

	@Override
	public void modify(BoardVO vo) {
		session.update(NS+".modify", vo);
		
	}

}
