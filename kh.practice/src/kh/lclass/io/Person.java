package kh.lclass.io;

import java.io.Serializable;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 3746068328283903974L;
	private String name;
	private int age;
	private String gender;
	
	public Person() {}
	public Person(String name, int age, String gender) {
		this.name=name;
		this.age=age;
		this.gender=gender;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	public String getName() {
		
		return name;
	}
	public void setName(String name) {
		this.name= name;
	}
	public int getAge() {
		
		return age;
	}
	public void setAge(int age) {
		this.age=age;
		
	}public String getGender() {
		return gender;
	
	}
	public void setGender(String gender) {
		this.gender= gender;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
