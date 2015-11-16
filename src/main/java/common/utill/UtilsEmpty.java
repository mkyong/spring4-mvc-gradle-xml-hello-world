package common.utill;

import java.util.List;
import java.util.Map;

/**
 * 오브젝트 내용의 존재 확인을 위해서 만듬
 * 
 * @author Administrator
 *
 */
public class UtilsEmpty {
	/**
	 * 내용이 없을경우 트루 반환
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(Object s) {
		if (s == null) {
			return true;
		}
		if ((s instanceof String) && (((String) s).trim().length() == 0)) {
			return true;
		}
		if (s instanceof Map) {
			return ((Map<?, ?>) s).isEmpty();
		}
		if (s instanceof List) {
			return ((List<?>) s).isEmpty();
		}
		if (s instanceof Object[]) {
			return (((Object[]) s).length == 0);
		}
		return false;
	}

}
