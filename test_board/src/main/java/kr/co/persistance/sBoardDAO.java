package kr.co.persistance;

import java.util.List;

import kr.co.domain.BoardVO;
import kr.co.domain.sPageTO;

public interface sBoardDAO {

	int amount(sPageTO sto);

	List<BoardVO> list(sPageTO sto);

	BoardVO read(int bno);

	void increaseviewcnt(int bno);

	void del(int bno);

	BoardVO modifyUI(int bno);

	void modify(BoardVO vo);

}
