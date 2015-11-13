package Member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/")
	@ResponseBody
	public String Member(Model md) {
		md.addAttribute("test", "test");
		return "join";
	}
	
	@RequestMapping(value = "/join")
	public String join(Model md) {
		md.addAttribute("test", "test");
		return "join";
	}
}
