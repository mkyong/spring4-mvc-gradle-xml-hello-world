package board.user;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import common.utill.UtilsPage;

/**
 * http://localhost:8080/defult/board/
 * Handles requests for the application home page.
 */
@RequestMapping(value = "/user/") // , method = RequestMethod.POST
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	// @Autowired(required=false)//필수가 아닌경우 빈으로 등록 안하게 설정
	// @Qualifier("CommonService1")//는 타입으로(by type) ?아줌. 똑같은 클래스가 있을경우
	// CommonService1 라는 구분값으로 ?음
	// @Resource(name="testDao") //는 이름으로(by name) ?아줌
	private UserService svc;

	/**
	 * http://localhost:8080/defult/board/
	 * 기본 경로 테스트
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	// @ResponseBody
	public String user(Locale locale, Model model) {
		logger.info("Welcome board! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "user/userMain";
	}

	@RequestMapping(value = "/{jsp}")
	// @ResponseBody
	public String userAll(@PathVariable String jsp) {
		log.debug("userAll:" + jsp);
		return "user/" + jsp;
	}

	@RequestMapping(value = "/userList")
	public String userList(
			Model model,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
			@RequestParam(value = "shtype", required = false) String shtype,
			@RequestParam(value = "shvalue", required = false) String shvalue) {

		log.debug("userList");

		Map<String, String> map = new HashMap<String, String>();

		map.put(shtype, shvalue);

		int totalRowCount = svc.userListCount(map);

		UtilsPage pu = new UtilsPage(pageNum, totalRowCount, pageSize, 10);

		map.put("startNum", String.valueOf(pu.getStartRow()));
		map.put("endNum", String.valueOf(pu.getEndRow()));

		List<UserVO> list = svc.userListPage(map);

		model.addAttribute("list", list);

		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalRowCount", totalRowCount);
		// model.addAttribute("startPageNum", pu.getStartPageNum());
		// model.addAttribute("endPageNum", pu.getEndPageNum());
		// model.addAttribute("totalPageCount", pu.getTotalPageCount());
		model.addAttribute("pageNum", pageNum);

		model.addAttribute("shtype", shtype);
		model.addAttribute("shvalue", shvalue);

		return "user/userList";
	}

	@RequestMapping(value = "/userInsert")
	// @ResponseBody
	public String userInsert(
			Model model,
			@RequestParam(value = "p1", required = false) String p1,
			@RequestParam(value = "p2", required = false) String p2,
			@RequestParam(value = "id") String id,
			@RequestParam(value = "pwd") String pwd,
			@RequestParam(value = "rpwd") String rpwd,
			@RequestParam(value = "nick") String nick) {

		log.debug(p1);
		log.debug(p2);
		log.debug(id);
		log.debug(pwd);
		log.debug(rpwd);
		log.debug(nick);

		if (id == null
				|| pwd == null
				|| rpwd == null
				|| !(pwd.equals(rpwd))
				|| nick == null
				|| id.equals("")
				|| pwd.equals("")
				|| rpwd.equals("")
				|| nick.equals("")) {
			model.addAttribute("msg", "userInsert False");
			return "user/userInsertForm";
			// return "userInsert False";
		}

		model.addAttribute("msg", "userInsert ok");
		return "user/userInsertForm";
		// return "userInsert ok";
	}
}
