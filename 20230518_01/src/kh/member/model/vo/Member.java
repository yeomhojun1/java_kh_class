package kh.member.model.vo;

import java.util.Date;

public class Member {
	private String name;
	private int age;
	private Date enrollDate;
	
	public Member() {}
	public Member(String name, int age) {
		this.name= name;
		this.age= age;
		
	}
	public String getName() {
		return name;
	}
}
