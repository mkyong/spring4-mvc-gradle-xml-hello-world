package sample;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
// @Service("CommonService1")
public class SampleService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	// @Qualifier("CommonDao1")
	private SampleDao dao;

	public String sampleService(Locale locale, Model model) {

		log.debug("sampleService");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return dao.sampleDAO();
	}

	public List<String> sampleList(Locale locale, Model model) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			list.add("list" + i);
		}
		return list;
	}

	public Map<String, String> sampleMap(Locale locale, Model model) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		for (int i = 0; i < 9; i++) {
			map.put("key"+i, "value"+i);
		}
		return map;
	}

}
