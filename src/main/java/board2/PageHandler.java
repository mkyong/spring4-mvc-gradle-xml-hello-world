package board2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageHandler {

	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	// 페이지 사이즈, 페이지 그룹
	private final int PAGESIZE = 3;
	private final int PAGEGROUP = 5;

	// 전체 게시글 수
	public int boardAllNumber(Map<String, Object> searchMap) throws Exception {
		int count = boardDAO.boardCount(searchMap);
		return count;
	}

	// 페이지 갯수
	public int boardPageCount(Map<String, Object> searchMap) throws Exception {
		int pageCount = boardAllNumber(searchMap) / PAGESIZE;
		if (boardAllNumber(searchMap) % PAGESIZE != 0) {
			pageCount++;
		}
		return pageCount;
	}

	// startPage
	public int boardStartPage(int pageNum) throws Exception {
		int startPage = (pageNum - 1) / PAGEGROUP * PAGEGROUP + 1;
		return startPage;
	}

	// endPage
	public int boardEndPage(int pageNum, Map<String, Object> searchMap) throws Exception {
		int endPage = boardStartPage(pageNum) + (PAGEGROUP - 1);
		if (endPage > boardPageCount(searchMap)) {
			endPage = boardPageCount(searchMap);
		}
		return endPage;
	}

	// 처음, 마지막 rowNumber
	public List<Object> boardSetPageNumber(int pageNum) throws Exception {
		List<Object> list = new ArrayList<Object>();
		int endRow = PAGESIZE * pageNum;
		int startRow = endRow - PAGESIZE + 1;
		list.add(startRow);
		list.add(endRow);
		return list;
	}
}