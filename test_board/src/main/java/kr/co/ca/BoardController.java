package kr.co.ca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.BoardVO;
import kr.co.domain.pageTO;
import kr.co.service.BoardService;
import kr.co.service.MemberService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void createUI() {
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(BoardVO vo) throws Exception {
		int reNum =  bService.create(vo);

		return "redirect:/board/list";
	}
	
	@RequestMapping("/listall")
	public void listall(Model model) throws Exception{
		List<BoardVO>list =  bService.listall();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("/read")
	public void read(int bno,pageTO to,Model model) throws Exception{
		BoardVO vo = bService.read(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("to", to);
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public String del(int bno , pageTO to, Model model) throws Exception {
		bService.del(bno);
		model.addAttribute("to", to);
		
		return "redirect:/board/list?curPage="+to.getCurPage()+"&perPage="+to.getPerPage();
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public void modifyUI(int bno , Model model , pageTO to) {
		BoardVO vo=bService.modifyUI(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("to", to);
	}
	
	@RequestMapping(value = "modify",method = RequestMethod.POST)
	public String modify(BoardVO vo, pageTO to) {
		bService.modify(vo);
		
		return "redirect:/board/read?bno="+vo.getBno()+"&curPage="+to.getCurPage()+"&perPage="+to.getPerPage();
	}
	
	@RequestMapping("/list")
	public void list(pageTO to, Model model) {
		pageTO dbTo = bService.list(to);
		model.addAttribute("to", dbTo);
		System.out.println(dbTo.getList());
	}
	
	@RequestMapping("/amount/{perPage}")
	@ResponseBody
	public int list(@PathVariable("perPage") int perPage) {
		int amount = bService.amount();
		return (amount-1)/perPage +1;
	}
}
