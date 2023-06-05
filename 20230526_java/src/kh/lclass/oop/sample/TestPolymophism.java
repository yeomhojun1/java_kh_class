package kh.lclass.oop.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TestPolymophism {

	public static void main(String[] args) {
		List<Car> carList = new ArrayList<Car>();//업캐스팅한거 가장많이 선언하는 방식
		List<Car> carList2 = new LinkedList<Car>();//선언되는 메소드들은 대부분 리스트안에 들어있음
		ArrayList<Car> carArrayList;//업캐스팅 안한거
		Collection<Car> carCollection = new ArrayList<Car>();
		
		
		
		
		
		
		
		
		
		
		TestInterFace kh = new Kh() {
			
			@Override
			public Car[] selectlist(String searchWord) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Car[] selectlist() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		((Kh)kh).khSpecial();
		TestInterFace bit;
		TestInterFace bit2;
		Kh kh2 = new Kh() {
			
			@Override
			public Car[] selectlist(String searchWord) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Car[] selectlist() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		kh2.khSpecial();
		kh2.method1();
		
		Driver ej = new DriverSub() {};
	
	ej.buy(new Avante());
	ej.buy(new Sonata());
	
		
		
		
		
		
	}

}
