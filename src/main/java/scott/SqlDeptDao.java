package scott;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class SqlDeptDao implements DeptMapper {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("scottTemplate")
	public SqlSessionTemplate	sqlSession	= null;

	@Override
	public List<DeptVO> getDeptList(DeptVO dvo) {
		log.info("getDeptList ȣ�� ����");
		List<DeptVO> deptList = null;
		deptList = sqlSession.selectList("getDeptList", dvo);
		return deptList;
	}

	public List<HashMap> getDeptList2(DeptVO dvo) {// �ӵ��� ���� ��뷮 �����ͺ��̽����� ��ȣ.
		log.info("getDeptList2 ȣ�� ����");
		List<HashMap> deptList = null;
		deptList = sqlSession.selectList("getDeptList2", dvo);
		log.info("getDeptList2 ȣ�� ����");
		return deptList;
	}

	@Override
	public int deptInsert(DeptVO dvo) {
		log.info("deptInsert ȣ�� ����");
		int result = 0;
		result = sqlSession.insert("deptInsert", dvo);
		return result;
	}

	@Override
	public int deptUpdate(DeptVO dvo) {
		log.info("deptUpdate ȣ�� ����");
		int result = 0;
		result = sqlSession.update("deptUpdate", dvo);
		return result;
	}

	@Override
	public int deptDelete(DeptVO dvo) {
		log.info("deptDelete ȣ�� ����");
		int result = 0;
		result = sqlSession.delete("deptDelete", dvo);
		return result;
	}

}
