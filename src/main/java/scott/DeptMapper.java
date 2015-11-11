package scott;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository(value="deptMapper")
public interface DeptMapper {
	public List<DeptVO> getDeptList(DeptVO dvo);
	public List<HashMap> getDeptList2(DeptVO dvo);
	public int deptInsert(DeptVO dvo);
	public int deptUpdate(DeptVO dvo);
	public int deptDelete(DeptVO dvo);
}
