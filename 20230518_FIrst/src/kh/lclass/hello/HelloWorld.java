package kh.lclass.hello;

import java.util.Date;

public class HelloWorld {
	private String name;
	private int age;
	private Date enrollDate;
	
	public HelloWorld() {}
	public HelloWorld(String name, int age) {
		this.name= name;
		this.age= age;
		
	}
	public String getName() {
		return name;
	}
}
