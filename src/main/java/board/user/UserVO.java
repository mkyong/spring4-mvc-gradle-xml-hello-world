package board.user;

import org.apache.ibatis.type.Alias;

@Alias("UserVO")
public class UserVO {
	
	private int u_no;
	private String u_id;
	private String u_pw;
	private String u_nick;
	private String u_indate;
	private int u_delete;

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_nick() {
		return u_nick;
	}

	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}

	public String getU_indate() {
		return u_indate;
	}

	public void setU_indate(String u_indate) {
		this.u_indate = u_indate;
	}

	public int getU_delete() {
		return u_delete;
	}

	public void setU_delete(int u_delete) {
		this.u_delete = u_delete;
	}
}
