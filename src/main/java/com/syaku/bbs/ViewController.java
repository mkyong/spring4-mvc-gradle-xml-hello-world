package com.syaku.bbs;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.syaku.bbs.dao.BbsDao;
import com.syaku.bbs.dao.BbsVo;

@Controller(value = "viewController")
// @Controller
// 해당 클래스가 Controller 임을 나타내기 위한 어노테이션.
// appServlet/servlet-context.xml 의 <context:component-scan
// base-package=“com.syaku.bbs” /> 의해 스캔된다.
// 컨트롤러 명을 정의하고 싶을 때는 @Controller(value = “컨트롤러명”) 하면된다. 정의하지 않으면 자동적으로 지정되며,
// 첫글자는 소문자로 치횐된다. 그래서 viewController 가 된다.
public class ViewController {

	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

	// Resource 어노테이션을 이용하여 BbsDao 선언.
	@Resource(name = "bbsDao")
	private BbsDao bbsDao;

	// 게시판 목록
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String dispBbsList(Model model) {
		logger.info("display view BBS list");

		List<BbsVo> list = this.bbsDao.getSelect();
		model.addAttribute("list", list);

		logger.info("totcal count" + list.size());

		return "bbs.list";
	}

	// 게시판 상세보기
	// PathVariable 어노테이션을 이용하여 RESTful 방식 적용
	// bbs/1 -> id = 1; id = 게시물 번호로 인식함.
	// 일반 적으로 (@ReuqstParam(value = "bbsVo", required = false, defaultValue =
	// "0"), int idx, Model model)
	@RequestMapping("/{idx}")
	public String dispBbsView(@PathVariable int idx, Model model) {
		logger.info("display view BBS view idx = {}", idx);

		BbsVo object = this.bbsDao.getSelectOne(idx);

		model.addAttribute("object", object);

		return "bbs.view";
	}

	// 게시판 쓰기
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String dispBbsWrite(@RequestParam(value = "idx", defaultValue = "0") int idx, Model model) {
		logger.info("display view BBS write");

		if (idx > 0) {
			BbsVo object = this.bbsDao.getSelectOne(idx);
			model.addAttribute("object", object);
		}

		return "bbs.write";
	}

	@RequestMapping(value = "/write_ok", method = RequestMethod.POST)
	public String procBbsWrite(@ModelAttribute("bbsVo") BbsVo bbsVo, RedirectAttributes redirectAttributes) {
		logger.info("bbsVo.getContent:{}",bbsVo.getUser_name());
		logger.info("bbsVo.getContent:{}",bbsVo.getSubject());
		logger.info("bbsVo.getContent:{}",bbsVo.getContent());
		logger.info("bbsVo.getContent:{}",bbsVo.getIdx());
		Integer idx = bbsVo.getIdx();

		if (idx == null || idx == 0) {
			this.bbsDao.insert(bbsVo);
			redirectAttributes.addFlashAttribute("message", "추가되었습니다.");
			return "redirect:./";
		} else {
			this.bbsDao.update(bbsVo);
			redirectAttributes.addFlashAttribute("message", "수정되었습니다.");
			//return "redirect:./write?idx=" + idx;
			return "redirect:./" + idx;
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String procBbsDelete(@RequestParam(value = "idx", required = false) int idx) {
        this.bbsDao.delete(idx);
        return "redirect:./";
    }
}
