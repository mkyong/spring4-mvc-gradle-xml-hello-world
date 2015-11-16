package sample.board;

public class BoardVO {

	/*
	 * SELECT
	 * b_no,
	 * b_nick,
	 * b_pw,
	 * b_text,
	 * b_date
	 * FROM SAMPLE_BOARD
	 */

	private int b_no;
	private String b_nick;
	private String b_pw;
	private String b_text;
	private String b_date;

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_nick() {
		return b_nick;
	}

	public void setB_nick(String b_nick) {
		this.b_nick = b_nick;
	}

	public String getB_pw() {
		return b_pw;
	}

	public void setB_pw(String b_pw) {
		this.b_pw = b_pw;
	}

	public String getB_text() {
		return b_text;
	}

	public void setB_text(String b_text) {
		this.b_text = b_text;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

}
