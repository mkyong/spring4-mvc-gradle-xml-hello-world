package common.utill;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author Administrator
 *         파일 저장및 읽기 구현
 *         http://addio3305.tistory.com/84 참고자료
 *         참고로 커먼에 있던 기능을 여기로 옮김.
 */
@Component("fileUtils")
public class UtilsFile {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private String filePath = "d:\\file\\";

	/**
	 * 파일 업로드 기능,크기 제한 없음, 다중 파일 처리
	 * 
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public Map<String, List<Map<String, Object>>> parseInsertFileInfo(
			Map<String, Object> map,
			HttpServletRequest request)
					throws Exception {
		return parseInsertFileInfo(map, request, 0);
	}

	/**
	 * 파일 업로드 기능, 업로드 크기 제한 가능, 다중 파일 처리
	 * 
	 * @param map
	 * @param request
	 * @param fileMaxSize
	 *            최대 크기 사이즈. 단위: 바이트. 기본값 :0=무한대
	 * @return
	 * @throws Exception
	 */
	public Map<String, List<Map<String, Object>>> parseInsertFileInfo(
			Map<String, Object> map,
			HttpServletRequest request,
			long fileMaxSize)
					throws Exception {
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> listFail = new ArrayList<Map<String, Object>>();
		Map<String, Object> listMap = null;

		String boardIdx = (String) map.get("IDX");

		File file = new File(filePath);
		if (file.exists() == false) {
			file.mkdirs();
		}

		while (iterator.hasNext()) {

			multipartFile = multipartHttpServletRequest.getFile(iterator.next());

			if (multipartFile.isEmpty() == false) {

				log.debug("FILE_SIZE:" + multipartFile.getSize());
				originalFileName = multipartFile.getOriginalFilename();

				// 파일 크기 확이
				if (fileMaxSize == 0 || multipartFile.getSize() < fileMaxSize) {

					originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
					storedFileName = UtilsUUID.getRandomString() + originalFileExtension;

					file = new File(filePath + storedFileName);
					multipartFile.transferTo(file);

					// 업로드 성공 리스트 작성
					listMap = new HashMap<String, Object>();
					listMap.put("BOARD_IDX", boardIdx);
					listMap.put("ORIGINAL_FILE_NAME", originalFileName);
					listMap.put("STORED_FILE_NAME", storedFileName);
					listMap.put("FILE_SIZE", multipartFile.getSize());
					list.add(listMap);
				} else {
					// 업로드 실패 리스트 작성
					listMap = new HashMap<String, Object>();
					listMap.put("ORIGINAL_FILE_NAME", originalFileName);
					listMap.put("FILE_SIZE", multipartFile.getSize());
					listFail.add(listMap);
				}
			}
		}
		Map<String, List<Map<String, Object>>> mapReturn = new HashMap<String, List<Map<String, Object>>>();
		mapReturn.put("list", list);
		mapReturn.put("listFail", listFail);
		return mapReturn;
	}

	/**
	 * 파일 다운로드 기능
	 * 
	 * @param response
	 * @param storedFileName
	 * @param originalFileName
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public void readFile(HttpServletResponse response, String storedFileName, String originalFileName)
			throws IOException, UnsupportedEncodingException {
		byte fileByte[] = FileUtils.readFileToByteArray(new File(filePath + storedFileName));

		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",
				"attachment; fileName=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);

		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

	/**
	 * 현재 업로드된 파일 내용 확인
	 * 
	 * @param request
	 */
	public void fileChack(HttpServletRequest request) {
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		while (iterator.hasNext()) {
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if (multipartFile.isEmpty() == false) {
				log.debug("------------- file start -------------");
				log.debug("name : " + multipartFile.getName());
				log.debug("filename : " + multipartFile.getOriginalFilename());
				log.debug("size : " + multipartFile.getSize());
				log.debug("-------------- file end --------------");
			}
		}
	}

	/**
	 * 단일 파일 업로드 예제
	 * 
	 * @param file
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String fileUpload(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {

		String real_name = null;
		String org_name = file.getOriginalFilename();

		if (org_name != null && (!org_name.equals(""))) {
			real_name = "board_" + System.currentTimeMillis() + "_" + org_name;
			// String docRoot =
			// request.getSession().getServletContext().getRealPath("/uploadStorage");
			String docRoot = "d:/file";
			File fileDir = new File(docRoot);
			if (!fileDir.exists()) {
				fileDir.mkdir();
			}
			File fileAdd = new File(docRoot + "/" + real_name);
			log.info("---------------------***docRoot : " + docRoot);
			file.transferTo(fileAdd);
		}
		return real_name;
	}

	public List<Map<String, Object>> parseUpdateFileInfo(Map<String, Object> map, HttpServletRequest request)
			throws Exception {
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> listMap = null;

		String boardIdx = (String) map.get("IDX");
		String requestName = null;
		String idx = null;

		while (iterator.hasNext()) {
			
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			
			if (multipartFile.isEmpty() == false) {
				// 첨부된 파일명에 내용이 있을경우. 새로 첨부된 파일
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = UtilsUUID.getRandomString() + originalFileExtension;

				multipartFile.transferTo(new File(filePath + storedFileName));

				listMap = new HashMap<String, Object>();
				listMap.put("IS_NEW", "Y");
				listMap.put("BOARD_IDX", boardIdx);
				listMap.put("ORIGINAL_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
				list.add(listMap);
				
			} else {
				// 첨부된 파일명에 내용이 없을경우. 기존 게시판에 있던 파일
				requestName = multipartFile.getName();
				idx = "IDX_" + requestName.substring(requestName.indexOf("_") + 1);
				
				if (map.containsKey(idx) == true && map.get(idx) != null) {
					listMap = new HashMap<String, Object>();
					listMap.put("IS_NEW", "N");
					listMap.put("FILE_IDX", map.get(idx));
					list.add(listMap);
				}
			}
		}
		return list;
	}
}
