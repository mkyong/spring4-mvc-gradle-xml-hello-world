package sample.board;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// @Service("CommonService1")
public class BoardService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	// @Qualifier("CommonDao1")
	private BoardDao dao;

	public List<BoardVO> boardList() {
		// TODO Auto-generated method stub
		log.debug("boardList");
		
		List<BoardVO> list=dao.boardList();
		
		return list;
	}

	public int BoardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		int result=dao.BoardInsert(vo);
		
		return result;
	}

}
