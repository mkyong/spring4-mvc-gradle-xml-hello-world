package Member;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	Logger log = Logger.getLogger(this.getClass());
	
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
