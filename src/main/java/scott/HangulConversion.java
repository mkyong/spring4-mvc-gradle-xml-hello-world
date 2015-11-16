package scott;

public class HangulConversion {
	 
	//�ѱ� ���ڵ� Ÿ������ �о ���� ���ڵ� Ÿ������ ��ȯ
	public static String toEng(String ko){
		if(ko == null) return null;
		try {
			return new String(ko.getBytes("KSC5601"),"8859_1");
		} catch (Exception e) {
			return ko;
		}
	}
	//���� ���ڵ� Ÿ������ �о �ѱ� ���ڵ� Ÿ������ ��ȯ
	public static String toKor(String en){
		if(en == null) return null;
		try {
			return new String(en.getBytes("8859_1"),"KSC5601");
		} catch (Exception e) {
			return en;
		}
	}
	public static String toUTF(String en){
		if(en == null) return null;
		try {
			return new String(en.getBytes("8859_1"),"utf-8");
		} catch (Exception e) {
			return en;
		}
	}
}
