package kh.lclass;

public class TestOperater {
	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 3;
		double num3 = 3;
	
		System.out.println(num1/num2);
		System.out.println(num1/num3);
		System.out.println(num1);
		System.out.println(-num1);
		System.out.println(-(-num1-10));
		
		num1=-num1;
		System.out.println(num1);
		
		int a = 10000;
		int b = 0;//처리완료 인원수
		a += 1;
		a -=1;
		a*=2;
		a /=4 ;
		System.out.println(a);
		
		a++;
		++a;
		a--;
		--a;
		
		a=10;
		System.out.println(++a);
		System.out.println(a);
		System.out.println(--a);
		System.out.println(a);
	
		a=10;
		System.out.println(a++);
		System.out.println(a);
		System.out.println(a--);
		System.out.println(a);
		
		System.out.println("비교연산자결과는 ture/false");
		System.out.println(3<7);
		boolean c = 3<7;
		System.out.println(c);
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
