package kr.co.ca;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardVO;
import kr.co.domain.PageTO;
import kr.co.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService bservice;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void createUI() {
		
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(BoardVO vo) throws Exception {
		bservice.create(vo);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/listall")
	public String listall(Model model) throws Exception{
		List<BoardVO> list = bservice.listall();
		model.addAttribute("list", list);
		return "/board/listall";
	}
	
	@RequestMapping("/read")
	public void read(Model model, int bno) throws Exception{
		BoardVO vo = bservice.read(bno);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping(value="/del", method=RequestMethod.POST)
	public String del(int bno) throws Exception {
		
		bservice.del(bno);
		
		return "redirect:/board/listall";
	}
	
	@RequestMapping("/modify")
	public void modifyui(int bno, Model model) throws Exception{
		
		BoardVO vo = bservice.modifyui(bno);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(BoardVO vo) throws Exception{
		
		bservice.modify(vo);
		
		return "redirect:/board/read?bno="+vo.getBno();
	}
	
	@RequestMapping("/list")
	public void list(PageTO to, Model model) {
		PageTO dbto = bservice.list(to);
		model.addAttribute("to", dbto);
	}
	
}
