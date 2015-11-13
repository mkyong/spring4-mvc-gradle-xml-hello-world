package first;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Set;

public class CommandMap {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	Map<String, Object> map = new HashMap<String, Object>();

	public Object get(String key) {
		return map.get(key);
	}

	public void put(String key, Object value) {
		map.put(key, value);
	}

	public Object remove(String key) {
		return map.remove(key);
	}

	public boolean containsKey(String key) {
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	public void clear() {
		map.clear();
	}

	public Set<Entry<String, Object>> entrySet() {
		return map.entrySet();
	}

	public Set<String> keySet() {
		return map.keySet();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public void putAll(Map<? extends String, ? extends Object> m) {
		map.putAll(m);
	}

	public Map<String, Object> getMap() {
		return map;
	}

	/**
	 * 리다이랙트시 키갑을 그대로 넘겨줌
	 * 
	 * @param redirect
	 * @return
	 */
	public void redirect(RedirectAttributes redirect) {
		for (String key : map.keySet()) {
			redirect.addFlashAttribute(key, map.get(key));
		}
	}

	public void mapPrint() {
		if (log.isDebugEnabled()) {
			if (map.isEmpty()) {
				log.debug("Map is empty!");
			} else {
				for (String key : map.keySet()) {
					log.debug("key:{} \t value:{}", key, map.get(key));
				}
			}
		}
	}
}
