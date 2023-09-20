package kh.lclass.db1.board.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.lclass.db1.board.model.service.BoardService;
import kh.lclass.db1.board.model.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("/list")
	public String list(Model model) throws Exception {
		model.addAttribute("boardList", boardService.selectList());
		return "board/list";
	}

//	자주사용하는 모델뷰가 있음
//	@GetMapping("/list")
//	public ModelAndView list(ModelAndView mv) {
//		mv.addObject("boardList",boardService.selectList());
//		mv.setViewName("board/list");
//		return mv;
//	}

	// 이건 불필요한 코드임 왜냐면 getflashattribue는 jsp에서만 값을 받음 controller에서는 소용없음
//	@GetMapping("/list")
//	public ModelAndView list(RedirectAttributes redirectAttr, ModelAndView mv) throws Exception{
//		Map<String, Object> map = (Map<String, Object>)redirectAttr.getFlashAttributes();
//		System.out.println(map);
//		mv.addObject("boardList",boardService.selectList());
//		mv.setViewName("board/list");
//		return mv;
//	}
//	@GetMapping("/board/get")
//	public String get(Model model, HttpServletRequest request) {
//		int bno = Integer.parseInt(request.getParameter("bno"));
//		model.addAttribute("boardvo",boardService.selectOne(bno));
//		return "board/get";
//	}
	@GetMapping("/get/{bno}")
	public String get(Model model, int bno) {

		try {
			model.addAttribute("boardvo", boardService.selectOne(bno));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/get";
	}
//	@GetMapping("/get")
//	public String get(Model model, int bno) {
//
//		try {
//			model.addAttribute("boardvo", boardService.selectOne(bno));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "board/get";
//	}

	@GetMapping("/insert")
	public String insert() {
		return "board/insert";
	}
//	@PostMapping("/insert")
//	public String insertDo(Model model, BoardVo vo) {
//		System.out.println(vo);
//		model.addAttribute("boardvo",boardService.insert(vo));
//		return "redirect:/board/list";
//	}

//	@PostMapping("/insert")
//	public String insertDo( BoardVo vo, String btitle) {
//		String viewPage ="";
//		int result= 1;
//		if(result<1) {
//			
//		}else {
//			viewPage= "redirect:/board/list";
//		}
//		
//		return viewPage;
//	}
	@PostMapping("/insert")
	public String insertDo(RedirectAttributes redirectAttr, BoardVo vo, String btitle) {
		String viewPage = "redirect:/";// url-->jsp에서 정보를 받아오려고 redirectAttrutes를 해놓은거임
		int result = 1;
		try {
			if (result < 1) {
				redirectAttr.addFlashAttribute("msg", "글등록 실패했습니다 \n 다시 입력해주세요");// flash라고 써있으니까 일회성임
				viewPage = "redirect:/board/insert";
			} else {
				redirectAttr.addFlashAttribute("msg", "글 등록 됐습니다");
				viewPage = "redirect:/board/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viewPage;
	}

//	개발과정에서는 ExceptionHandler를 잘쓰지는 않는다 오류를 봐야지 수정할수 잇기 때문
//	@ExceptionHandler
//	public void e(){
//		
//	}
}
