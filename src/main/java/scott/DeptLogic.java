package scott;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptLogic {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
									
	// @Resource(name="deptMapper")
	// public DeptMapper deptMapper = null;
	
	@Autowired
	private SqlDeptDao	sqlDeptDao	= null;
									
	public List<DeptVO> getDeptList(DeptVO dvo) {
		log.info("getDeptList 호출 성공");
		List<DeptVO> dList = null;
		dList = sqlDeptDao.getDeptList(dvo);
		return dList;
	}
	
	public List<HashMap> getDeptList2(DeptVO dvo) {
		log.info("getDeptList2 호출 성공");
		List<HashMap> dList = null;
		dList = sqlDeptDao.getDeptList2(dvo);
		return dList;
	}
	
	public int deptInsert(DeptVO pdvo) {
		log.info("deptInsert 호출 성공");
		int result = 0;
		result = sqlDeptDao.deptInsert(pdvo);
		return result;
	}
	
	public int deptUpdate(DeptVO pdvo) {
		log.info("deptUpdate 호출 성공");
		int result = 0;
		result = sqlDeptDao.deptUpdate(pdvo);
		return result;
	}
	
	public int deptDelete(DeptVO pdvo) {
		log.info("deptDelete 호출 성공");
		int result = 0;
		result = sqlDeptDao.deptDelete(pdvo);
		return result;
	}
	
	public int cudDept(DeptVO dvo) {
		int result = 0;
		log.info("cudDept 호출 성공");
		result = sqlDeptDao.deptInsert(dvo);
		log.info("result : " + result);
		return result;
	}
	
}
