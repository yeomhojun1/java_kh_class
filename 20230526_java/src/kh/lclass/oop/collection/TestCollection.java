package kh.lclass.oop.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import kh.lclass.oop.sample.Car;

public class TestCollection {
	public <E, J>	String testGeneric(E a, J b) {
		
		System.out.println(a.getClass().getName());
		System.out.println(b.getClass().getName());
		return a.toString()	+"결과값";
		
	}
	
	
	
	
	
	public void testStack() {
		Stack<String> strStack = new Stack<String>();
		strStack.push("안녕");
		strStack.add("하");
		strStack.push("세요");
		System.out.println(strStack);
		System.out.println(strStack.get(0));
		System.out.println(strStack.pop());
		
		
		
		
		
		
		
		
	}
	
	public void testHashMap() {
		Map<String, Object> objMap= new HashMap<String, Object>();
		objMap.put("ej", 35);
		objMap.put("jy", "지영이네");
		objMap.put("hj", new Car(5000));
		System.out.println(objMap.toString());
		System.out.println(objMap.get("jy"));
		Set<String> keyset=objMap.keySet();
		System.out.println(keyset);
		System.out.println("=====map : enhanced for===");
		for( String item  :keyset) {
			Object value = objMap.get(item);
			System.out.println(item);
		}
		System.out.println("=====map : Iterator for===");
		for(String item : keyset) {
			System.out.println(item);//더이상 읽을수 없을때 까지 반복됨, 
//			null이들어갔으면 null이 출력됨, 처음부터 끝까지 한바퀴는 돌아감
		}
		Iterator<String> itr = keyset.iterator();
		while(itr.hasNext()) {
			String item= itr.next();
			Object value = objMap.get(item);
			System.out.println(value);
		}
		
		
		
		
	}
	
	public void testArrayList() {
		String strArr[] = new String[3];
		strArr[0] = "사과";
		strArr[1] = "바나나";
		strArr[2] = "수박";
		ArrayList<String>list1= new ArrayList<String>();
		ArrayList<Integer>list2= new ArrayList<Integer>();
		ArrayList<Car>list3= new ArrayList<Car>();
		
		list3.add(new Car(3000));
		list2.add(25);
		list2.add(26);
		list2.add(27);
		list2.add(2, 55);//끼워넣기 insert index 현재 크기size() 보다 클수없음
		System.out.println(list2);
		System.out.println(list2.get(3));//get은 자리를 꺼내옴
		System.out.println(list2.get(2));//get은 자리를 꺼내옴
		for(int i= 0;i<list2.size();i++ ) {
			Integer item = list2.get(i);
			System.out.println(list2.get(i));
		}
		
//		enhanced for
		for(Integer item : list2) {
			System.out.println(item);//더이상 읽을수 없을때 까지 반복됨, 
//			null이들어갔으면 null이 출력됨, 처음부터 끝까지 한바퀴는 돌아감
		}
		for(String item : strArr) {
			System.out.println(item);
		}
		
		
		
		
		
//		public class ArrayList implements List{
//		public boolean add(String e) {
//			
//		}
//		public boolean add(Integer e) {
//			
//		}
//		public boolean add(double e) {
//				
//		}
//		public boolean add(Car e) {
//		
//		}	
//		이건 오버라이딩으로 실행 불가,그래서 Object e로 바꿔줘야함
//				
//		
//		
		list1.add("1번");
		if(list1.add("2번")) {
			System.out.println("끼워넣기성공");
		}
		list1.add("3번");
		list1.add("4번");
		list1.add("5번");
		list1.add(1,"10번대신 끼워넣기");
		System.out.println(list1);
		Collection<String> collection1 = new ArrayList<String>();
		collection1.add("1번");
		collection1.add("2번");
		collection1.add("3번");
		collection1.add("4번");
		System.out.println(collection1);
//		collection1.add("3번");
		list1.removeAll(collection1);//2번이 사라짐 왜냐 2번의 주소값이 1이므로
//		그리고 지우면 아래있는걸 올려줌
//		list.clear();
		System.out.println(collection1);
		if(list1 instanceof ArrayList) {
		@SuppressWarnings("unchecked")
		ArrayList<String>copyList =  (ArrayList<String>)(((ArrayList<String>)list1).clone());
		}
	}
	public void testHashSet() {
		Set<Integer> integerSet = new HashSet<Integer>();
		integerSet.add(11);
		integerSet.add(22);
		integerSet.add(33);
		integerSet.add(11);
		System.out.println(integerSet);
		System.out.println("=====Set : enhanced for ===");
		for(Integer item : integerSet) {
			System.out.println(item);
		}
		System.out.println("=====Set : Interator 사용 ===");
		Iterator<Integer>itr= integerSet.iterator();
		System.out.println(itr);
		while(itr.hasNext()) {
			Integer item= itr.next();
			System.out.println(item);
			
		}
		
		
		
	}
}
