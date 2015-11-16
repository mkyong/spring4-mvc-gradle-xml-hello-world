package board.reply;

import org.apache.ibatis.type.Alias;

@Alias("ReplyVO")
public class ReplyVO {

	private int r_no;
	private String r_content;
	private int b_no;
	private int u_no;
	private String r_indate;
	private String r_eddate;
	private int r_delete;

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public String getR_indate() {
		return r_indate;
	}

	public void setR_indate(String r_indate) {
		this.r_indate = r_indate;
	}

	public String getR_eddate() {
		return r_eddate;
	}

	public void setR_eddate(String r_eddate) {
		this.r_eddate = r_eddate;
	}

	public int getR_delete() {
		return r_delete;
	}

	public void setR_delete(int r_delete) {
		this.r_delete = r_delete;
	}

}
