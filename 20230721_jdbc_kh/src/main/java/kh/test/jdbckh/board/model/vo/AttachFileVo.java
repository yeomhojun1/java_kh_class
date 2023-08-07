package kh.test.jdbckh.board.model.vo;

public class AttachFileVo {
	private int bno;
	private String filepath;
	private String fileno;
	@Override
	public String toString() {
		return "AttachFileVo [bno=" + bno + ", filepath=" + filepath + ", fileno=" + fileno + "]";
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFileno() {
		return fileno;
	}
	public void setFileno(String fileno) {
		this.fileno = fileno;
	}
	public AttachFileVo(String filepath) {
		super();
		this.filepath = filepath;
	}
	public AttachFileVo() {
		super();
	}
	
	
}
