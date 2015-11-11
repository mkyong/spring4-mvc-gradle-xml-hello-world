package scott;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptLogic {
	
	Logger				logger		= Logger.getLogger(DeptLogic.class);
									
	// @Resource(name="deptMapper")
	// public DeptMapper deptMapper = null;
	
	@Autowired
	private SqlDeptDao	sqlDeptDao	= null;
									
	public List<DeptVO> getDeptList(DeptVO dvo) {
		logger.info("getDeptList 호출 성공");
		List<DeptVO> dList = null;
		dList = sqlDeptDao.getDeptList(dvo);
		return dList;
	}
	
	public List<HashMap> getDeptList2(DeptVO dvo) {
		logger.info("getDeptList2 호출 성공");
		List<HashMap> dList = null;
		dList = sqlDeptDao.getDeptList2(dvo);
		return dList;
	}
	
	public int deptInsert(DeptVO pdvo) {
		logger.info("deptInsert 호출 성공");
		int result = 0;
		result = sqlDeptDao.deptInsert(pdvo);
		return result;
	}
	
	public int deptUpdate(DeptVO pdvo) {
		logger.info("deptUpdate 호출 성공");
		int result = 0;
		result = sqlDeptDao.deptUpdate(pdvo);
		return result;
	}
	
	public int deptDelete(DeptVO pdvo) {
		logger.info("deptDelete 호출 성공");
		int result = 0;
		result = sqlDeptDao.deptDelete(pdvo);
		return result;
	}
	
	public int cudDept(DeptVO dvo) {
		int result = 0;
		logger.info("cudDept 호출 성공");
		result = sqlDeptDao.deptInsert(dvo);
		logger.info("result : " + result);
		return result;
	}
	
}
