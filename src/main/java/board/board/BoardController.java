package board.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import common.utill.UtilsPage;

/**
 * http://localhost:8080/defult/board/
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	// @Autowired(required=false)//필수가 아닌경우 빈으로 등록 안하게 설정
	// @Qualifier("CommonService1")//는 타입으로(by type) ?아줌. 똑같은 클래스가 있을경우
	// CommonService1 라는 구분값으로 ?음
	// @Resource(name="testDao") //는 이름으로(by name) ?아줌
	private BoardService svc;

	/**
	 * http://localhost:8080/defult/board/
	 * 기본 경로 테스트
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// @ResponseBody
	public String board(Locale locale, Model model) {
		logger.info("Welcome board! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "board/boardMain";
	}

	/**
	 * 이 메소드 제거해야하는데.. boardListPage를 쓰삼
	 * http://localhost:8080/defult/board/boardList
	 * 
	 * @param model
	 * @param bvo
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value = "/boardList")
	public String boardList(
			Model model,
			@RequestParam(value = "BoardVO", required = false) BoardVO bvo,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {

		log.debug("boardList");

		Map<String, String> map = new HashMap<String, String>();

		int totalRowCount = svc.boardListCount(map);

		UtilsPage pu = new UtilsPage(pageNum, totalRowCount, 10, 10);

		map.put("startNum", String.valueOf(pu.getStartRow()));
		map.put("endNum", String.valueOf(pu.getEndRow()));

		List<BoardVO> list = svc.boardList(map);

		model.addAttribute("list", list);
		model.addAttribute("startPageNum", pu.getStartPageNum());
		model.addAttribute("endPageNum", pu.getEndPageNum());
		model.addAttribute("totalPageCount", pu.getTotalPageCount());
		model.addAttribute("pageNum", pageNum);

		return "board/boardList";
	}

	@RequestMapping(value = "/boardListPage")
	public String boardListPage(
			Model model,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
			@RequestParam(value = "shtype", required = false) String shtype,
			@RequestParam(value = "shvalue", required = false) String shvalue
			) {

		log.debug("boardList");

		Map<String, String> map = new HashMap<String, String>();

		map.put(shtype, shvalue);

		int totalRowCount = svc.boardListCount(map);
		
		UtilsPage pu = new UtilsPage(pageNum, totalRowCount, pageSize, 10);
		
		map.put("startNum", String.valueOf(pu.getStartRow()));
		map.put("endNum", String.valueOf(pu.getEndRow()));
		
		List<BoardVO> list = svc.boardListPage(map);

		model.addAttribute("list", list);
		
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalRowCount", totalRowCount);
//		model.addAttribute("startPageNum", pu.getStartPageNum());
//		model.addAttribute("endPageNum", pu.getEndPageNum());
//		model.addAttribute("totalPageCount", pu.getTotalPageCount());
		model.addAttribute("pageNum", pageNum);
		
		model.addAttribute("shtype", shtype);
		model.addAttribute("shvalue", shvalue);

		return "board/boardList";
	}

	@RequestMapping(value = "/boardDetail")
	public String boardDetail(
			Model model,
			@RequestParam(value = "BoardVO", required = false) BoardVO bvo,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "b_no") int b_no) {

		log.debug("boardDetail");

		HashMap<String, BoardVO> map = svc.boardDetail(b_no);

		// model객체에 값을 담으면 뷰페이지에서 출력가능(유효함)
		model.addAttribute("vo", map.get("vo"));
		model.addAttribute("prev", map.get("prev"));
		model.addAttribute("next", map.get("next"));

		// BoardVO vo = svc.boardDetail(b_no);
		// model.addAttribute("vo", vo);

		return "board/boardDetail";
	}

}
