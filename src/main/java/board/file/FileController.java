package board.file;

//FileController.java
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sample.board.BoardController;

/**
 * http://gangzzang.tistory.com/125
 * 
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/file/")
public class FileController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/")
	// @ResponseBody
	public String File(Model model) {
		
		log.info("File:" );
		
		model.addAttribute("test", "test");
		
		return "file/fileMain";
	}	
	
	@RequestMapping(value = "/{jsp}")
	// @ResponseBody
	public String FileJsp(Model model, @PathVariable String jsp) {

		log.info("FileJsp:" + jsp);

		return "file/"+jsp;
	}	
	
	@RequestMapping(value = "/fileForm", method = RequestMethod.GET)
//	public ModelAndView fileForm() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("fileForm");
//		return mv;
//	}
	public String fileForm() {
		return "file/fileForm";
	}

	@RequestMapping(value = "/fileForm", method = RequestMethod.POST)
	public String fileSubmit(FileDTO dto) {
		MultipartFile uploadfile = dto.getUploadfile();
		if (uploadfile != null) {
			String fileName = uploadfile.getOriginalFilename();
			dto.setF_onm(fileName);
			try {
				// 1. FileOutputStream 사용
				// byte[] fileData = file.getBytes();
				// FileOutputStream output = new FileOutputStream("C:/images/" +
				// fileName);
				// output.write(fileData);

				// 2. File 사용
				File file = new File("C:/images/" + fileName);
				uploadfile.transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			} // try - catch
		} // if
			// 데이터 베이스 처리를 현재 위치에서 처리
		return "redirect:getBoardList.do"; // 리스트 요청으로 보내야하는데 일단 제외하고 구현
	}
}
