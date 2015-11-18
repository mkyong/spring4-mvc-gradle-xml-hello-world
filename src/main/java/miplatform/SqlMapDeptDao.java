package miplatform;

import java.util.List;

import scott.DeptVO;

public class SqlMapDeptDao extends SqlMapClientDaoSupport {

	public List<DeptVO> getDeptList() {
		return getSqlMapClientTemplate().queryForList("");

	}

}
