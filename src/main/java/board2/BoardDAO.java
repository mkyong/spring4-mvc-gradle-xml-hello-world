package board2;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface BoardDAO {
	// 전체 게시글 수
	public int boardCount(Map<String, Object> searchMap) throws DataAccessException;

	// 게시판 리스트
	public List<BoardDTO> boardList(Map<String, Object> searchMap) throws DataAccessException;
}