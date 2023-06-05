package kh.lclass.oop.run;

import kh.lclass.oop.sample.Person;
import kh.lclass.oop.sample.Student;

public class TestArray {
	public static void main(String[] args) {
		Person[] personArray = new Person[22];
		Person p1 = new Student();
		Object obj2 = new Person();

//		obj2.
		
		
		
		
		
		
		
		
		for(int i=0; i<personArray.length;i++	) {
			personArray[i] = new Person();
		}
		personArray[0]= new Person();
		personArray[0].setAge(25);
		personArray[0].setName("염호준");
		personArray[0].setGender("남");
		//이렇게 하나씩 쓸바에 매개인자해놔서 오버로딩해놓는게 더편함
		personArray[1]= new Person("염지연",27,"여");
		personArray[2]= new Person("서상민",29,"남");
		System.out.println(personArray[0].getName());
		System.out.println(personArray[1].getAge());
		
		Student [] stdArray = new Student[3];
		for(int i = 0; i<stdArray.length;i++) {
			stdArray[i] = new Student();
		}
		stdArray[0].setAge(15);
		stdArray[0].setName("김영희");
		stdArray[0].setGender("여자");
		stdArray[0].setScore(85);
		stdArray[0].setGrade(3);
		System.out.println(stdArray[0].getName());//김영희
		System.out.println(stdArray[0].getAge());//김영희
		System.out.println(stdArray[0].getGender());//김영희
		System.out.println(stdArray[0].toString());//김영희
		
		Student yh = new Student("홍길동", "여자", 21, 1);
		
		
		
		
//		NullPointerException 
//		원인: . 점 앞에있는 변수(객체=인스턴스)가 null상태
//		personArray[0]이 null 주소값을 가지고있었음
//		해결방법 : 변수(객체 = 인스턴스)에 new 생성자();를 해줌
	}
}
