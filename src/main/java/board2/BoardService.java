package board2;

import java.util.List;
import java.util.Map;

public interface BoardService {
	// 게시글 수
	public int boardCount(Map<String, Object> searchMap) throws Exception;

	// 게시판 리스트
	public List<BoardDTO> boardList(Map<String, Object> searchMap) throws Exception;
}