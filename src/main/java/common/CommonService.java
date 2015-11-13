package common;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("commonService")
public class CommonService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
     
    @Resource(name="commonDAO")
    private CommonDAO commonDAO;
    
    public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
        return commonDAO.selectFileInfo(map);
    }
}