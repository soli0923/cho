package kr.co.ca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.BoardVO;
import kr.co.domain.pageTO;
import kr.co.domain.sPageTO;
import kr.co.service.BoardService;
import kr.co.service.sBoardService;

@Controller
@RequestMapping("/sboard")
public class SearchBoardController {
	
	@Autowired
	private sBoardService sbService;
	
	@RequestMapping("/list")
	public void list(Model model , sPageTO sto) {
		System.out.println(sto.getKeyword());
		System.out.println(sto.getSearchType());
		sPageTO dbsto = sbService.slist(sto);
		model.addAttribute("to", dbsto);
	}
	
	@RequestMapping("/amount/{perPage}")
	@ResponseBody
	public int list(@PathVariable("perPage") int perPage,sPageTO sto) {
		int amount = sbService.amount(sto);
		int totalPage = (amount-1)/perPage +1; 
		return totalPage;
	}
	
	@RequestMapping("/read")
	public void read(int bno,sPageTO sto, Model model) {
		BoardVO svo = sbService.read(bno);
		model.addAttribute("to", sto);
		model.addAttribute("vo", svo);
	}
	
	@RequestMapping(value = "/del", method=RequestMethod.POST)
	public String del(int bno, sPageTO sto) throws Exception{
		sbService.del(bno);
		
		StringBuffer sb = new StringBuffer();
		sb.append("redirect:/sboard/list?curPage=");
		sb.append(sto.getCurPage());
		sb.append("&perPage=");
		sb.append(sto.getPerPage());
		sb.append("&searchType=");
		sb.append(sto.getSearchType());
		sb.append("&keyword=");
		sb.append(sto.getKeyword());
		
		return sb.toString();
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyUI(int bno, sPageTO sto, Model model) {
		BoardVO vo = sbService.modifyUI(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("to", sto);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVO vo , sPageTO sto) {
		sbService.modify(vo);
		
		StringBuffer sb = new StringBuffer();
		sb.append("redirect:/sboard/read?bno=");
		sb.append(vo.getBno());
		sb.append("&curPage=");
		sb.append(sto.getCurPage());
		sb.append("&perPage=");
		sb.append(sto.getPerPage());
		sb.append("&searchType=");
		sb.append(sto.getSearchType());
		sb.append("&keyword=");
		sb.append(sto.getKeyword());
		
		return sb.toString();
	}
}
