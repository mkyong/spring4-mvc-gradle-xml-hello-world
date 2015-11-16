package board2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BoardMultiController extends MultiActionController {
	
	private  final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private BoardService boardService;
	private PageHandler pageHandler;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	public void setPageHandler(PageHandler pageHandler) {
		this.pageHandler = pageHandler;
	}

	ModelAndView mav = null;

	// 게시판 리스트
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		log.debug("list");
		
		mav = new ModelAndView();

		List<BoardDTO> list = null;
		// 검색select , 검색Text
		String boardListSelect = request.getParameter("boardListSelect");
		String boardListSearchText = request.getParameter("boardListSearchText");

		Map<String, Object> searchMap = new HashMap<String, Object>();

		if (boardListSearchText != null) {
			searchMap.put("boardListSearchText", EncodingHandler.toKor(boardListSearchText));
			searchMap.put("boardListSelect", boardListSelect);

			mav.addObject("boardListSearchText", EncodingHandler.toKor(boardListSearchText));
			mav.addObject("boardListSelect", boardListSelect);
		}
		String pageNumber = request.getParameter("pageNumber");
		int pageNum = 1;
		if (pageNumber != null) {
			pageNum = Integer.parseInt(pageNumber);
		}

		// 게시글 수
		int totalCount = pageHandler.boardAllNumber(searchMap);

		// 페이지 갯수
		int totalPageCount = pageHandler.boardPageCount(searchMap);

		// startPage , endPage
		int startPage = pageHandler.boardStartPage(pageNum);
		int endPage = pageHandler.boardEndPage(pageNum, searchMap);

		// 처음, 마지막 rowNumber
		List<Object> rowNumberList = new ArrayList<Object>();
		rowNumberList = pageHandler.boardSetPageNumber(pageNum);
		searchMap.put("startRow", rowNumberList.get(0));
		searchMap.put("endRow", rowNumberList.get(1));

		// 글 전체 출력
		list = boardService.boardList(searchMap);

		mav.addObject("pageNumber", pageNum);
		mav.addObject("boardCount", totalCount);
		mav.addObject("totalPageCount", totalPageCount);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		mav.addObject("list", list);

		mav.setViewName("list");

		return mav;
	}
}