package common.utill;

import org.springframework.ui.Model;

public class UtilsPage {
	
	private int totalRowCount; // 전체글의 갯수
	private int pageNum; // 현재 페이지 번호
	private int startRow; // 시작행번호
	private int endRow; // 끝 행번호
	private int totalPageCount; // 전체페이지갯수
	private int startPageNum; // 시작페이지번호
	private int endPageNum; // 끝페이지번호
	private int rowBlockCount; // 보여줄 글의 행갯수
	private int pageBlockCount; // 한페이지에 보여줄 페이지 갯수

	public UtilsPage() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * tlwkrgod
	 * @param pageNum
	 *            현재페이지번호
	 * @param totalRowCount
	 *            전체글의 갯수
	 * @param rowBlockCount
	 *            한페이지에 보여줄 글의 갯수
	 * @param pageBlockCount
	 *            한페이지에 보여줄 페이지의 갯수
	 * @param model
	 */
	public UtilsPage(int pageNum, int totalRowCount, int rowBlockCount, int pageBlockCount,Model model) {
		// TODO Auto-generated constructor stub
		this(pageNum, totalRowCount, rowBlockCount, pageBlockCount);
		model.addAttribute("totalRowCount", totalRowCount);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("rowBlockCount", rowBlockCount);
		model.addAttribute("pageBlockCount", pageBlockCount);
	}

	/**
	 * 
	 * @param pageNum
	 *            현재페이지번호
	 * @param totalRowCount
	 *            전체글의 갯수
	 * @param rowBlockCount
	 *            한페이지에 보여줄 글의 갯수
	 * @param pageBlockCount
	 *            한페이지에 보여줄 페이지의 갯수
	 */
	public UtilsPage(int pageNum, int totalRowCount, int rowBlockCount, int pageBlockCount) {
		this.pageNum = pageNum;
		this.totalRowCount = totalRowCount;
		this.rowBlockCount = rowBlockCount;
		this.pageBlockCount = pageBlockCount;
		// 시작행번호 구하기
		startRow = (pageNum - 1) * rowBlockCount + 1;
		// 끝행번호 구하기
		endRow = startRow + rowBlockCount - 1;
		// 전체 페이지 갯수 구하기
		totalPageCount = (int) Math.ceil(totalRowCount / (double) rowBlockCount);
		// 시작페이지번호 구하기
		startPageNum = (pageNum - 1) / pageBlockCount * pageBlockCount + 1;
		// 끝페이지번호 구하기
		endPageNum = startPageNum + pageBlockCount - 1;
		if (totalPageCount < endPageNum) {
			endPageNum = totalPageCount;
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}

	public int getRowBlockCount() {
		return rowBlockCount;
	}

	public void setRowBlockCount(int rowBlockCount) {
		this.rowBlockCount = rowBlockCount;
	}

	public int getPageBlockCount() {
		return pageBlockCount;
	}

	public void setPageBlockCount(int pageBlockCount) {
		this.pageBlockCount = pageBlockCount;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}
}
