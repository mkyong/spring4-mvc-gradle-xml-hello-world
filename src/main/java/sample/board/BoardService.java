package sample.board;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
// @Service("CommonService1")
public class BoardService {

	protected Log log = LogFactory.getLog(this.getClass());

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
