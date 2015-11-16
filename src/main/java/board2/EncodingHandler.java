package board2;

import java.io.UnsupportedEncodingException;

public class EncodingHandler {
	public static String toKor(String str) {
		String s = null;
		try {
			s = new String(str.getBytes("8859_1"), "euc-kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}
}