package kh.lclass.oop.sample;

public class Student extends Person {

	private String name;
	private int score;
	private int grade;
	private static int age;
	public Student() {
		super();//person(); 같은말
	}
	
	public Student(String name, String gender, int aget, int grade ) {
		super(name, age, gender);
		this.name = name;
		this.grade= grade;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", grade=" + grade + ", age=" + age + ", toString()="
				+ super.toString() + "]";
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public int getAge() {
		return this.age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade){ 
		this.grade = grade; 
	}
									 
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
