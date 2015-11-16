package scott;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller // 너는 C-M-V 중에 컨트롤러 계층이야.
@RequestMapping(value = "/dept/")
public class DeptController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	///hy_spring4/WebContent/WEB-INF/spring-service.xml
	@Autowired
	public DeptLogic	deptLogic	= null;
	
	@RequestMapping(value = "/")
	@ResponseBody
	public String test() {
		return "test";
	}

	@RequestMapping(value = "getDeptList.hy")
	public String getDeptList(ModelMap model, @ModelAttribute("deptVO") DeptVO dvo, HttpServletRequest req) {
		log.info("getDeptList 호출 성공");
		List<DeptVO> dList = null;
		dList = deptLogic.getDeptList(dvo);
		// logger.info("dList.size()"+dList.size());
		// req.setAttribute("dList", dList);//POJO F/W
		model.addAttribute("dList", dList);// spring
		return "getDeptList";
//		return "forward:getDeptList.jsp";
		// String을 반환타입으로 하면 forward와 sendRedirect를 사용.
		// forward를 사용하여 모델맵을 사용하면 모델을 넘길 수 있다.
	}

	// 리턴타입이 ModelAndView인 경우.
	/*
	 * 리턴타인이 String이냐, ModelAndView이냐에 따라
	 * 응답페이지의 위치가 달라진다.
	 * == 배치를 다르게 해야한다..
	 */
	@RequestMapping(value = "getDeptList2.hy")
	public ModelAndView getDeptList2(@ModelAttribute("deptVO") DeptVO dvo, HttpServletRequest req) {
		log.info("getDeptList 호출 성공");
		List<HashMap> dList = null;
		dList = deptLogic.getDeptList2(dvo);
		log.info("dList.size()" + dList.size());
		// req.setAttribute("dList", dList);
		ModelAndView mav = new ModelAndView();// 인스턴스화
		mav.setViewName("getDeptList2");// setViewName은 응답페이지를 따라가게 되어있다.
		// /WEB-INF/jsp/dept/xxxx.jsp 이라면
		// WEB-INF/jsp/dept/getDeptList2.jsp 를 가리키는 것이다.
		// spring-servlet.xml을 보면 prefix,suffix로 해당내용을 의미하게 URL을 완성할 수 있다.

		/* 배치하는 이유 */
		// WebContents 안에 jsp는 서버에서 직접접근 가능하지만,
		// WEB-INF는 보안상 직접접근 불가능(보안을 위해서라면 WEB-INF에 배치해야한다)->리턴타입을 모델 앤 뷰를
		// 사용해야한다.
		mav.addObject("dList", dList);// req.setAttribute("dList", dList); 대체
		return mav;
	}

	@RequestMapping(value = "deptInsert.hy")
	public void deptInsert(HttpServletRequest req, HttpServletResponse res) {
		log.info("deptInsert 호출 성공");
		String deptno = req.getParameter("deptno");
		String dname = req.getParameter("dname");
		String loc = req.getParameter("loc");
		DeptVO pdvo = new DeptVO();
		pdvo.setDeptno(Integer.parseInt(deptno));
		pdvo.setDname(dname);
		pdvo.setLoc(loc);
		int result = deptLogic.deptInsert(pdvo);
		if (result == 1) {// 입력성공
			try {
				res.sendRedirect("deptInsertOK.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				res.sendRedirect("deptInsertFail.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.info("result : " + result);
	}

	@RequestMapping(value = "deptInsert2.hy")
	public String deptInsert2(@ModelAttribute("deptVO") DeptVO dvo, HttpServletResponse res) throws IOException {
		log.info("deptInsert 호출 성공");
		int result = deptLogic.deptInsert(dvo);
		log.info("result : " + result);
		if (result == 1) {// 입력성공
			return "forward:getDeptList.hy";
		} else {
			return "forward:deptInsertFail.jsp";
		}
	}

	@RequestMapping(value = "deptUpdate.hy")
	public String deptUpdate(@ModelAttribute("deptVO") DeptVO dvo) throws IOException {
		log.info("deptUpdate 호출 성공");
		int result = deptLogic.deptUpdate(dvo);
		log.info("result : " + result);
		if (result == 1) {// 입력성공
			return "forward:getDeptList.hy";
		} else {
			return "forward:deptInsertFail.jsp";
		}
	}

	@RequestMapping(value = "deptDelete.hy")
	public String deptDelete(@ModelAttribute("deptVO") DeptVO dvo) throws IOException {
		log.info("deptDelete 호출 성공");
		int result = deptLogic.deptDelete(dvo);
		log.info("result : " + result);
		if (result == 1) {// 입력성공
			return "forward:getDeptList.hy";
		} else {
			return "forward:deptInsertFail.jsp";
		}
	}

	@RequestMapping(value = "cudDept.hy")
	public String cudDept(@ModelAttribute("deptVO") DeptVO dvo) throws IOException {
		log.info("cudDept 호출 성공");
		int result = 0;
		result = deptLogic.cudDept(dvo);
		return "redirect:getDeptList.hy";
	}
}
