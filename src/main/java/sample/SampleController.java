package sample;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import common.security.LucyXss;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	// @Autowired(required=false)//필수가 아닌경우 빈으로 등록 안하게 설정
	// @Qualifier("CommonService1")//는 타입으로(by type) ?아줌. 똑같은 클래스가 있을경우
	// CommonService1 라는 구분값으로 ?음
	// @Resource(name="testDao") //는 이름으로(by name) ?아줌
	private SampleService svc;

	/**
	 * 기본 경로 테스트
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	// @ResponseBody
	public String sample(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "sample";
	}

	/**
	 * mvc 테스트
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sampleController", method = RequestMethod.GET)
	@ResponseBody
	public String sampleController(Locale locale, Model model) {

		logger.info("sampleController");

		return svc.sampleService(locale, model);
	}

	/**
	 * ResponseBody 테스트
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sampleResponseBody", method = RequestMethod.GET)
	@ResponseBody
	public String sampleResponseBody(Locale locale, Model model) {

		logger.info("sampleResponseBody");

		return "sampleResponseBody";
	}

	/**
	 * ResponseBody 테스트
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sampleResponseBodyList", method = RequestMethod.GET)
	@ResponseBody
	public List<String> sampleResponseBodyList(Locale locale, Model model) {

		logger.info("sampleResponseBodyList");

		return svc.sampleList(locale, model);
	}

	/**
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sampleResponseBodyMap", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> sampleResponseBodyMap(Locale locale, Model model) {

		logger.info("sampleResponseBodyMap");

		return svc.sampleMap(locale, model);
	}

	/**
	 * 예제는 아래 파일로
	 * /defult/src/main/webapp/test/xss_main.jsp
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/xss_test")
	public String xss_test(Locale locale, Model model, HttpServletRequest request) {

		logger.info("sampleResponseBodyMap");

		// StringBuffer sb=new StringBuffer();
		// sb.append(request.getParameter("data"));
		String data = request.getParameter("data");
		// log.debug(sb.toString());
		log.debug(data);

		data = LucyXss.doDefultFileSetNoComment1(data);

		log.debug(data);

		model.addAttribute("result", data);

		return "forward:/test/xss_result.jsp";
	}

	/**
	 * http://localhost:8080/defult/sample/xsstest
	 * 
	 * @param req
	 * @param md
	 * @return
	 */
	@RequestMapping(value = "/xsstest")
	public ModelAndView xsstest(HttpServletRequest req, Model md) {

		String data = req.getParameter("data");
		log.debug(data);

		// md.addAttribute("resultData", data);
		// return "xsstest";

		ModelAndView mv = new ModelAndView();
		mv.addObject("resultData", data);
		mv.setViewName("/xsstest");
		return mv;
	}
}
