package kh.practice;

import java.util.Date;

public class Member {
	private String name;
	private int age;
	private Date enrollDate;
	public Member () {}
	public Member (String name, int age, Date enrollDate) {
		this.name= name;
		this.age= age;
		this.enrollDate= enrollDate;
	} public String getName (//ex. String 회원에게 받은 이름 염호준
			){
		return name;
	}
	public int age (//ex. int 회원의 나이 29
			){
		return age;
	}
}
