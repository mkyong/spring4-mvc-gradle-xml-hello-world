package sample.board;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/Board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	// @Autowired(required=false)//필수가 아닌경우 빈으로 등록 안하게 설정
	// @Qualifier("CommonService1")//는 타입으로(by type) ?아줌. 똑같은 클래스가 있을경우
	// CommonService1 라는 구분값으로 ?음
	// @Resource(name="testDao") //는 이름으로(by name) ?아줌
	private BoardService svc;

	@RequestMapping(value = "/{jsp}")
	// @ResponseBody
	public String Board(Model model, @PathVariable String jsp) {

		logger.info("Board:" + jsp);

		return jsp;
	}

	/**
	 * http://localhost:8080/defult/sample/Board/BoardList
	 * mvc 테스트
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/BoardList")
	// @ResponseBody
	public String BoardList(Model model) {

		logger.info("BoardList");

		List<BoardVO> list = svc.boardList();

		model.addAttribute("BoardList", list);

		return "BoardList";
	}

	@RequestMapping(value = "/BoardInsert", method = RequestMethod.POST)
	// @ResponseBody
	public String BoardInsert(Model model, @ModelAttribute("BoardVO") BoardVO vo) {

		logger.info("BoardInsert");

		int result = svc.BoardInsert(vo);

		model.addAttribute("result", result);

		BoardList(model);

		return "BoardList";
		// return "redirect:BoardList";
		// return "forward:BoardList";
	}

}
