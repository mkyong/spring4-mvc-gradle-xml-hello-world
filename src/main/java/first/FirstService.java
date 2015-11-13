package first;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import common.utill.UtilsEmpty;
import common.utill.UtilsFile;

@Service("FirstService")
public class FirstService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "fileUtils")
	private UtilsFile fileUtils;

	@Resource(name = "FirstDAO")
	private FirstDAO dao;

	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return dao.selectBoardList(map);
	}

	public List<Map<String, Object>> insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		dao.insertBoard(map);

		// 파일 들어온거 확인용
		fileUtils.fileChack(request);

		//파일 저장 처리
		Map<String, List<Map<String, Object>>> listReturn = fileUtils.parseInsertFileInfo(map, request,1024*50);
		List<Map<String, Object>> list=listReturn.get("list");
		//파일저장된 정보를 db로 저장
		for (int i = 0, size = list.size(); i < size; i++) {
			dao.insertFile(list.get(i));
		}
		//실패한 리스트 반환
		return listReturn.get("listFail");
	}



	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		dao.updateHitCnt(map);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 기존 상세글
		Map<String, Object> tempMap = dao.selectBoardDetail(map);
		resultMap.put("map", tempMap);

		// 파일 리스트
		List<Map<String, Object>> list = dao.selectFileList(map);
		// log.debug(list);
		// log.debug(list==null);
		// log.debug(list.equals(""));
		if (!UtilsEmpty.isEmpty(list))
			resultMap.put("list", list);

		return resultMap;
	}

	public void updateBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		
		dao.updateBoard(map);//게시판 내용 업데이트
		
		dao.deleteFileList(map);//현재 등록됬던 파일들 DEL_GB = 'Y' 처리 
		
		//기존파일,새파일 분류 작업. 새파일은 저장.
	    List<Map<String,Object>> list = fileUtils.parseUpdateFileInfo(map, request);
	    
	    Map<String,Object> tempMap = null;
	    
	    for(int i=0, size=list.size(); i<size; i++){
	        tempMap = list.get(i);
	        if(tempMap.get("IS_NEW").equals("Y")){
	            dao.insertFile(tempMap);
	        }
	        else{
	            dao.updateFile(tempMap);
	        }
	    }
	}

	public void deleteBoard(Map<String, Object> map) throws Exception {
		dao.deleteBoard(map);
	}

	public Map<String, Object> selectBoardListPaging(Map<String, Object> map) throws Exception{
		// TODO Auto-generated method stub
		return dao.selectBoardListPaging(map);
	}
}
