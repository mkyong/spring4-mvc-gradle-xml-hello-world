package board.user;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final String nameSpace="board.user.";
	
	// @Autowired
	@Autowired(required = false) // 필수가 아닌경우 등록 안하게 설정
	@Qualifier("defultTemplate") // 는 타입으로(by type) 찿아줌. 똑같은 클래스가
	// 있을경우CommonService1 라는 구분값으로 찿음
	// @Resource(name="testDao") //는 이름으로(by name) 찿아줌
	private SqlSessionTemplate sql;

	public int userListCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		log.debug("userListCount");
		int count = sql.selectOne(nameSpace+"ListCount", map);
		return count;
	}

	public List<UserVO> userListPage(Map<String, String> map) {
		// TODO Auto-generated method stub
		log.debug("userListPage");
		// List<BoardVO> list = sql.selectList("defult.boardList", map);
		List<UserVO> list = sql.selectList(nameSpace+"List", map);
		return list;
	}
}
