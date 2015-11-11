package scott;

import java.text.DateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ScottController {
	
	private static final Logger logger = LoggerFactory.getLogger(ScottController.class);
	private  final Logger log = LoggerFactory.getLogger(this.getClass());
	
	//@Autowired
	// @Autowired(required=false)//필수가 아닌경우 빈으로 등록 안하게 설정
	// @Qualifier("CommonService1")//는 타입으로(by type) ?아줌. 똑같은 클래스가 있을경우
	// CommonService1 라는 구분값으로 ?음
	// @Resource(name="testDao") //는 이름으로(by name) ?아줌
	//private ScottService svc;
	
	/**
	 * 기본 경로 테스트
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//@ResponseBody
	public String sample(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "scott";
	}
	
	/**
	 * mvc 테스트
	 * @param locale
	 * @param model
	 * @return
	 */
/*	@RequestMapping(value = "/sampleController", method = RequestMethod.GET)
	@ResponseBody
	public String sampleController(Locale locale, Model model) {
		
		logger.info("sampleController");		
		
		return svc.sampleService(locale,model);
	}
	*/
	/**
	 * ResponseBody 테스트
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
	 * @param locale
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value = "/sampleResponseBodyList", method = RequestMethod.GET)
	@ResponseBody
	public List<String> sampleResponseBodyList(Locale locale, Model model) {
		
		logger.info("sampleResponseBodyList");		
		
		return svc.sampleList(locale,model);
	}*/
	
	/**
	 * @param locale
	 * @param model
	 * @return
	 */
	/*@RequestMapping(value = "/sampleResponseBodyMap", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> sampleResponseBodyMap(Locale locale, Model model) {
		
		logger.info("sampleResponseBodyMap");		
		
		return svc.sampleMap(locale,model);
	}*/
}
