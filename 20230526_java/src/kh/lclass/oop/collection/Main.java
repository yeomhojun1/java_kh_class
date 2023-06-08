package kh.lclass.oop.collection;

public class Main {
	public static void main(String[] args) {
//		new TestCollection().testHashSet();
//		new TestCollection().testArrayList();
//		new TestCollection().testHashMap();
//		new TestCollection().testStack();
		new TestCollection().testGeneric(35.5, 2);
		TestCollection tc = new TestCollection();
		String str = tc.testGeneric(35.5,2 );
		System.out.println(str);
		
		str = tc.testGeneric("안녕",2);
		System.out.println(str);
		new TestCollection().testGeneric(35.5,2);
	}
}
