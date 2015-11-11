package board.user;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	protected Log log = LogFactory.getLog(this.getClass());

	@Autowired
	// @Qualifier("CommonDao1")
	private UserDao dao;

	public int userListCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		log.debug("boardListCount");
		int count = dao.userListCount(map);
		return count;
	}

	public List<UserVO> userListPage(Map<String, String> map) {
		// TODO Auto-generated method stub
		log.debug("boardListPage");
		List<UserVO> list = dao.userListPage(map);
		return list;
	}

}
