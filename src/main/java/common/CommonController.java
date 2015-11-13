package common;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import common.utill.UtilsFile;
import first.CommandMap;

@Controller
@RequestMapping(value = "/common/")
public class CommonController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "commonService")
	private CommonService commonService;

	@Resource(name = "fileUtils")
	private UtilsFile fileUtils;

	/**
	 * 다운로드를 파라메터값으로 받을경우
	 * 
	 * @param commandMap
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "downloadFile")
	public void downloadFile(CommandMap commandMap, HttpServletResponse response) throws Exception {
		Map<String, Object> map = commonService.selectFileInfo(commandMap.getMap());
		String storedFileName = (String) map.get("STORED_FILE_NAME");
		String originalFileName = (String) map.get("ORIGINAL_FILE_NAME");

		fileUtils.readFile(response, storedFileName, originalFileName);
	}

	/**
	 * 주소창에 파일명을 쳤을경우
	 * 
	 * @param commandMap
	 * @param response
	 * @param file
	 * @throws Exception
	 */
	@RequestMapping(value = "downloadFile/{file:.+}")
	public void downloadFile(CommandMap commandMap, HttpServletResponse response, @PathVariable String file)
			throws Exception {
		// Map<String, Object> map =
		// commonService.selectFileInfo(commandMap.getMap());
		// String storedFileName = (String) map.get("STORED_FILE_NAME");
		// String originalFileName = (String) map.get("ORIGINAL_FILE_NAME");

		fileUtils.readFile(response, file, file);
	}

}
