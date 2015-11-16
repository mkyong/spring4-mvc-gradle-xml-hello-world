package common.security;

import java.util.regex.Pattern;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import com.nhncorp.lucy.security.xss.XssFilter;

import common.logger.LoggerInterceptor;

public class LucyXss {
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);

	/**
	 * XssFilter를 쓰기 쉽게하기위해서 제작. 기본형.
	 * 앞의 주석은 제거되게끔 설정
	 * 
	 * @param str
	 * @param xmlFile
	 * @return
	 */
	public static String doFileSetNoComment(String str, String xmlFile) {
		return XssFilter.getInstance(xmlFile, true).doFilter(str);
		// XssFilter filter = XssFilter.getInstance(xmlFile);
		// return filter.doFilter(str);
	}

	/**
	 * 기본값 lucy-xss-superset.xml
	 * 
	 * @param str
	 * @return
	 */
	public static String doDefultFileSetNoComment(String str) {
		return XssFilter.getInstance(true).doFilter(str);
		// XssFilter filter = XssFilter.getInstance(xmlFile);
		// return filter.doFilter(str);
	}

	/**
	 * XssFilter를 lucy-xss.xml 파일로 처리
	 * 
	 * @param str
	 * @return
	 */
	public static String doDefultFileSetNoComment1(String str) {
		return doFileSetNoComment(str, "lucy-xss.xml");
	}

	// /**
	// * XssFilter를 lucy-xss-superset.xml 파일로 처리
	// *
	// * @param str
	// * @return
	// */
	// public static String doSuperset(String str) {
	// return doFileSet(str, "lucy-xss-superset.xml");
	// }

	// /**
	// * 주석 제거용 메서드
	// *
	// * @param str
	// * @return
	// */
	// public static String doSubstring(String str) {
	// return str.substring(str.indexOf("-->") + 3);
	// }

	
}
