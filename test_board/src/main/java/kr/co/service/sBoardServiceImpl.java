package kr.co.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.domain.BoardVO;
import kr.co.domain.MemberVO;
import kr.co.domain.pageTO;
import kr.co.domain.sPageTO;
import kr.co.persistance.BoardDAO;
import kr.co.persistance.MemberDAO;
import kr.co.persistance.sBoardDAO;

@Service
@Transactional
public class sBoardServiceImpl implements sBoardService{
	
	@Inject
	private sBoardDAO sbDao;

	@Override
	public sPageTO slist(sPageTO sto) {
		// TODO Auto-generated method stub
		int amount=sbDao.amount(sto);
		sto.setAmount(amount);
		
		List<BoardVO> list = sbDao.list(sto);
		sto.setList(list);
		
		return sto;
	}

	@Override
	public int amount(sPageTO sto) {
		// TODO Auto-generated method stub
		return sbDao.amount(sto);
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		sbDao.increaseviewcnt(bno);
		return sbDao.read(bno);
	}

	@Override
	public void del(int bno) {
		sbDao.del(bno);
		
	}

	@Override
	public BoardVO modifyUI(int bno) {
		// TODO Auto-generated method stub
		return sbDao.modifyUI(bno);
	}

	@Override
	public void modify(BoardVO vo) {
		sbDao.modify(vo);
		
	}
	
	

	

}
