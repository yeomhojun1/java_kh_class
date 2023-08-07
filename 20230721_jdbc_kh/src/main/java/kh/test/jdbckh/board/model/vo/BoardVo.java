package kh.test.jdbckh.board.model.vo;

import java.util.List;

public class BoardVo {
//	BNO         NOT NULL NUMBER         
//	BTITLE      NOT NULL VARCHAR2(300)  
//	BCONTENT             VARCHAR2(4000) 
//	BWRITE_DATE NOT NULL TIMESTAMP(6)   
//	MID         NOT NULL VARCHAR2(20)   
//	BREF        NOT NULL NUMBER         
//	BRE_LEVEL   NOT NULL NUMBER         
//	BRE_STEP    NOT NULL NUMBER
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriteDate;
	private String mid;
	private int bref;
	private int breLevel;
	private int breStep;
	//1대 n관계일때 작성하는 방법
	//private List<String>  filepath;
	private List<AttachFileVo> attachFileList;
//	public BoardDto() {
//	}
	// selectOne dao --> controll --> view
	public BoardVo(int bno, String btitle, String bcontent, String bwriteDate, String mid, int bref, int breLevel,
			int breStep) {
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriteDate = bwriteDate;
		this.mid = mid;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}
	// selectList(content없음) dao --> controll --> view
	public BoardVo(int bno, String btitle, String bwriteDate, String mid, int bref, int breLevel, int breStep) {
		this.bno = bno;
		this.btitle = btitle;
		// content 없음
		this.bwriteDate = bwriteDate;
		this.mid = mid;
		this.bref = bref;
		this.breLevel = breLevel;
		this.breStep = breStep;
	}
	// 원본글 등록 view --> controller --> dao
	public BoardVo(String btitle, String bcontent, String mid) {
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mid = mid;
	}
	// 답글 등록 view --> controller --> dao
	public BoardVo(int bno, String btitle, String bcontent, String mid) {
		this.bno = bno;  // bno는 답글 달려는 글번호
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.mid = mid;
	}

	
	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriteDate=" + bwriteDate
				+ ", mid=" + mid + ", bref=" + bref + ", breLevel=" + breLevel + ", breStep=" + breStep
				+ ", attachFileList=" + attachFileList + "]";
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBwriteDate() {
		return bwriteDate;
	}
	public void setBwriteDate(String bwriteDate) {
		this.bwriteDate = bwriteDate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getBref() {
		return bref;
	}
	public void setBref(int bref) {
		this.bref = bref;
	}
	public int getBreLevel() {
		return breLevel;
	}
	public void setBreLevel(int breLevel) {
		this.breLevel = breLevel;
	}
	public int getBreStep() {
		return breStep;
	}
	public void setBreStep(int breStep) {
		this.breStep = breStep;
	}
	public List<AttachFileVo> getAttachFileList() {
		return attachFileList;
	}
	public void setAttachFileList(List<AttachFileVo> attachFileList) {
		this.attachFileList = attachFileList;
	}
	
}
