package board.board;

import org.apache.ibatis.type.Alias;

@Alias("BoardVO")
public class BoardVO {

	private int b_no;
	private String b_title;
	private String b_content;
	private String b_indate;
	private String b_eddate;
	private int b_delete;
	private int u_no;
	private String u_id;
	private String u_pw;
	private String u_nick;
	private String u_indate;
	private String u_eddate;
	private int u_delete;
	

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_indate() {
		return b_indate;
	}

	public void setB_indate(String b_indate) {
		this.b_indate = b_indate;
	}

	public String getB_eddate() {
		return b_eddate;
	}

	public void setB_eddate(String b_eddate) {
		this.b_eddate = b_eddate;
	}

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public int getB_delete() {
		return b_delete;
	}

	public void setB_delete(int b_delete) {
		this.b_delete = b_delete;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_nick() {
		return u_nick;
	}

	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}

	public int getU_delete() {
		return u_delete;
	}

	public void setU_delete(int u_delete) {
		this.u_delete = u_delete;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_indate() {
		return u_indate;
	}

	public void setU_indate(String u_indate) {
		this.u_indate = u_indate;
	}

	public String getU_eddate() {
		return u_eddate;
	}

	public void setU_eddate(String u_eddate) {
		this.u_eddate = u_eddate;
	}
}
