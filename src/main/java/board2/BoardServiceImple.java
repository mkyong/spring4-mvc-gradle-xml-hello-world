package board2;

import java.util.List;
import java.util.Map;

public class BoardServiceImple implements BoardService {
	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	// 게시글 수
	public int boardCount(Map<String, Object> searchMap) throws Exception {
		return boardDAO.boardCount(searchMap);
	}

	// 게시판 리스트
	public List<BoardDTO> boardList(Map<String, Object> searchMap) throws Exception {
		return boardDAO.boardList(searchMap);
	}
}