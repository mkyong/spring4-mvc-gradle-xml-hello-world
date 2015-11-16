package miplatform;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import scott.DeptVO;

public class SqlMapDeptDao extends SqlMapClientDaoSupport {

	public List<DeptVO> getDeptList() {
		return getSqlMapClientTemplate().queryForList("");

	}

}
