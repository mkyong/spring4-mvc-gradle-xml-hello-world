package sample;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
// @Repository("CommonDao1")
public class SampleDao {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	// @Autowired
	@Autowired(required = false) // 필수가 아닌경우 등록 안하게 설정
	@Qualifier("Template") // 는 타입으로(by type) 찿아줌. 똑같은 클래스가
									// 있을경우CommonService1 라는 구분값으로 찿음
	// @Resource(name="testDao") //는 이름으로(by name) 찿아줌
	private SqlSessionTemplate sql;

	public String sampleDAO() {
		// TODO Auto-generated method stub
		log.debug("sampleDAO");
		
		return "sample MVC test";
	}

}
