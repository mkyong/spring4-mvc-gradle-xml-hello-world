package com.study;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.security.sample.LoginController;

@Controller
public class StudyController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping({
			"/", "/index"
	})
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/{jsp}")
	// @ResponseBody
	public String defultJsp(Model model, @PathVariable String jsp) {
		log.info("defultJsp:" + jsp);
		return jsp;
	}

	/**
	 * http://hellogk.tistory.com/75
	 * 
	 * @return
	 */
//	@RequestMapping("/hello")
//	public String hello() {
//		return "hello";
//	}

	/**
	 * http://hellogk.tistory.com/76
	 * 
	 * @return
	 */
//	@RequestMapping("/form")
//	public String form() {
//		return "form";
//	}

	/**
	 * http://hellogk.tistory.com/76
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/submit")
	public String submit(HttpServletRequest request, Model model) {
		model.addAttribute("text", request.getParameter("text"));
		return "submit";
	}

	/**
	 * form submit 파일결과 받기
	 * @param file
	 */
	@RequestMapping("/getFile")
	public void getFile(FileVo file){
	    System.out.println(file.getFile().getOriginalFilename());
	}
	
	/**
	 * 가상의 로그인체크 컨트롤러
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		log.debug("login");
		String returnURL = "";
		// 웹페이지에서받은 아이디,패스워드 일치시 admin 세션key 생성
		if (request.getParameter("id").equals("admin") && request.getParameter("password").equals("1234")) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("admin_id", "admin");
			map.put("admin_name", "관리자");
			request.getSession().setAttribute("admin", map);
			returnURL = "redirect:admin_main";
			// 일치하지 않으면 로그인페이지 재이동
		} else {
			returnURL = "redirect:./";
		}
		return returnURL;
	}

	/**
	 * 관리자메인 컨트롤러
	 * 
	 * @return
	 */
	// @RequestMapping("/admin_main")
	// public String admin_main() {
	// return "admin_main";
	// }
}
