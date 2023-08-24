package kh.lclass.db1.board.model.vo;

import org.springframework.stereotype.Component;

import lombok.Data;



@Data
@Component
public class AttachFileVo {
	private int bno;
	private String filepath;
	private String fileno;
	@Override
	public String toString() {
		return "AttachFileVo [bno=" + bno + ", filepath=" + filepath + ", fileno=" + fileno + "]";
	}
	
	
}
