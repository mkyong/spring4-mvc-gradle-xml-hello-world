package board2;

public class BoardDTO {
	private String seq;
	private String name;
	private String passwd;
	private String title;
	private String content;
	private String filename;
	private String regdate;
	private int readcount;
	private String reply;
	private int reply_step;
	private int reply_level;

	public BoardDTO() {
	};

	public BoardDTO(String seq, String name, String title, String regdate, int readcount, int reply_step,
			int reply_level) {
		super();
		this.seq = seq;
		this.name = name;
		this.title = title;
		this.regdate = regdate;
		this.readcount = readcount;
		this.reply_step = reply_step;
		this.reply_level = reply_level;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public int getReply_step() {
		return reply_step;
	}

	public void setReply_step(int reply_step) {
		this.reply_step = reply_step;
	}

	public int getReply_level() {
		return reply_level;
	}

	public void setReply_level(int reply_level) {
		this.reply_level = reply_level;
	}
}