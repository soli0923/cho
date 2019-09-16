package kr.co.service;

import kr.co.domain.BoardVO;
import kr.co.domain.sPageTO;

public interface sBoardService {

	sPageTO slist(sPageTO sto);

	int amount(sPageTO sto);

	BoardVO read(int bno);

	void del(int bno);

	BoardVO modifyUI(int bno);

	void modify(BoardVO vo);

}
