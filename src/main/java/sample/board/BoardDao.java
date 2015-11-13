package sample.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
// @Repository("CommonDao1")
public class BoardDao {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	// @Autowired
	@Autowired(required = false) // 필수가 아닌경우 등록 안하게 설정
	@Qualifier("defultTemplate")
	// 는 타입으로(by type) 찿아줌. 똑같은 클래스가 있을경우boardTemplate 라는 구분값으로 찿음
	// @Resource(name="testDao") //는 이름으로(by name) 찿아줌
	private SqlSessionTemplate sql;

	public List<BoardVO> boardList() {
		// TODO Auto-generated method stub

		// 조회 테스트용
		// List<BoardVO> list=sql.selectList("board.testboardSelect");

		List<BoardVO> list = sql.selectList("board.boardList");

		return list;
	}

	public int BoardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		int result=sql.insert("board.boardInsert",vo);
		
		return result;
	}

}
