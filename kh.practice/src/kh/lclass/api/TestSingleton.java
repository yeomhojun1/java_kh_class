package kh.lclass.api;

public class TestSingleton {
	private int a = 10;
	private static TestSingleton instance = new TestSingleton();
	//딱 하나만 만들고싶을 때 스태틱으로 초깃값을 꼭 생성해줘야함
	//그리고 생성자를 private로 만들어야함
	//그 다음 메소드도 static으로 만들어줘야지 class가 실행되기전에 만들어져서 쓸수있음
	private TestSingleton() {
	}	
	public static TestSingleton getInstance() {
		return instance;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	
}

