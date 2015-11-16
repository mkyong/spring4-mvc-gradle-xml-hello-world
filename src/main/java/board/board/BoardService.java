package board.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	// @Qualifier("CommonDao1")
	private BoardDao dao;

	public List<BoardVO> boardList(Map<String, String> map) {
		// TODO Auto-generated method stub
		log.debug("boardList");
		List<BoardVO> list = dao.boardList(map);
		return list;
	}

	public List<BoardVO> boardListPage(Map<String, String> map) {
		// TODO Auto-generated method stub
		log.debug("boardListPage");
		List<BoardVO> list = dao.boardListPage(map);
		return list;
	}

	public int boardListCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		log.debug("boardListCount");
		int count = dao.boardListCount(map);
		return count;
	}

	public HashMap<String, BoardVO> boardDetail(int b_no) {
		// TODO Auto-generated method stub
		log.debug("boardDetail");

		HashMap<String, BoardVO> map = new HashMap<String, BoardVO>();
		// BoardVO vo = dao.boardDetail(b_no);
		map.put("vo", dao.boardDetail(b_no)); // 현재글에 대한 정보
		map.put("prev", dao.getPrev(b_no)); // 이전글에 대한 정보
		map.put("next", dao.getNext(b_no)); // 다음글에 대한 정보

		// dao.addHit(num);// 조회수 증가

		return map;
	}
}
