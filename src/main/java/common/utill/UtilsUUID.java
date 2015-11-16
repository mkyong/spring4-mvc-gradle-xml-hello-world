package common.utill;

import java.util.UUID;

public class UtilsUUID {

	public static String getRandomString() {
		return UUID.randomUUID().toString();//.replaceAll("-", "")
	}

	/**
	 * UUID 형식의 문자열을 UUID으로 변환시켜줌..
	 * 
	 * @param name
	 * @return
	 */
	public static UUID getFromString(String name) {
		return UUID.fromString(name);
	}

	public static void main(String[] args) {
		System.out.println(UtilsUUID.getRandomString());
		System.out.println(UtilsUUID.getRandomString());
		System.out.println(UtilsUUID.getRandomString());

	}
}
