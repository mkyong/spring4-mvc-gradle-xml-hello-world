package board.file;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {
	private int b_no;
	private int f_no;
	private String f_onm;
	private String f_rnm;
	private int f_sz;
	private String f_indate;
	private int f_delete;
	private MultipartFile uploadfile;

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public int getF_no() {
		return f_no;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public String getF_onm() {
		return f_onm;
	}

	public void setF_onm(String f_onm) {
		this.f_onm = f_onm;
	}

	public String getF_rnm() {
		return f_rnm;
	}

	public void setF_rnm(String f_rnm) {
		this.f_rnm = f_rnm;
	}

	public int getF_sz() {
		return f_sz;
	}

	public void setF_sz(int f_sz) {
		this.f_sz = f_sz;
	}

	public String getF_indate() {
		return f_indate;
	}

	public void setF_indate(String f_indate) {
		this.f_indate = f_indate;
	}

	public int getF_delete() {
		return f_delete;
	}

	public void setF_delete(int f_delete) {
		this.f_delete = f_delete;
	}

	public MultipartFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
}
