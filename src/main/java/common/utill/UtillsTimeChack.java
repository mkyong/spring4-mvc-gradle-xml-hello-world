package common.utill;

/**
 * @author Administrator
 *
 * 소모시간 체크용
 */
public class UtillsTimeChack {
	long start;
	long end;

	public long getStart() {
		return start;
	}

	public void setStart() {
		this.start = System.currentTimeMillis();
	}

	public long getEnd() {
		return end;
	}

	public void setEnd() {
		this.end = System.currentTimeMillis(); // 종료시간
	}

	public long getTime() {
		return end - start;
	}
}
