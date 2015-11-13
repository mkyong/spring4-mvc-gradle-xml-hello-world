package board.board;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import sun.rmi.runtime.Log;

@Repository
public class BoardDao {

	//protected Log log = //LogFactory.getLog(this.getClass());
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final String nameSpace="board.board.";
	
	// @Autowired
	@Autowired(required = false) // 필수가 아닌경우 등록 안하게 설정
	@Qualifier("defultTemplate") // 는 타입으로(by type) 찿아줌. 똑같은 클래스가
	// 있을경우CommonService1 라는 구분값으로 찿음
	// @Resource(name="testDao") //는 이름으로(by name) 찿아줌
	private SqlSessionTemplate sql;

	public List<BoardVO> boardList(Map<String, String> map) {
		log.debug("boardList");
		// List<BoardVO> list = sql.selectList("defult.boardList", map);
		List<BoardVO> list = sql.selectList(nameSpace+"List", map);
		return list;
	}


	public int boardInsert(BoardVO vo) {
		int result = sql.insert(nameSpace+"Insert", vo);
		return result;
	}


	public int boardUpdate(BoardVO vo) {
		int result = sql.update(nameSpace+"Update", vo);
		return result;
	}

	/**
	 * 전체글수
	 * 
	 * @param map
	 * @return
	 */
	public int boardListCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		log.debug("boardListCount");

		int count = sql.selectOne(nameSpace+"ListCount", map);
		return count;
	}

	/**
	 * 목록에 출력할 페이지
	 * 
	 * @param map
	 * @return
	 */
	public List<BoardVO> boardListPage(Map<String, String> map) {
		// TODO Auto-generated method stub
		log.debug("boardListCount");

		List<BoardVO> list = sql.selectList(nameSpace+"ListPage", map);
		return list;
	}

	/**
	 * 살세글보기
	 * 
	 * @param b_no
	 * @return
	 */
	public BoardVO boardDetail(int b_no) {
		// TODO Auto-generated method stub
		BoardVO vo = sql.selectOne(nameSpace+"Detail", b_no);
		return vo;
	}

	/**
	 * 이전글 정보 반환
	 * 
	 * @param num
	 * @return
	 */
	public BoardVO getPrev(int num) {
		return sql.selectOne(nameSpace+"getPrev", num);
	}

	/**
	 * 다음글 정보 반환
	 * 
	 * @param num
	 * @return
	 */
	public BoardVO getNext(int num) {
		return sql.selectOne(nameSpace+"getNext", num);
	}
}
