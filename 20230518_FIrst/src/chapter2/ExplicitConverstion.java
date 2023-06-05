package chapter2;

public class ExplicitConverstion {

	public static void main(String[] args) {
		double dNum1 = 1.2;
		float fNum2 = 0.9F;
		
		int iNum3 = (int)dNum1 + (int)fNum2;
		int iNum4 = (int)(dNum1 + fNum2);
		System.out.println(iNum3);
		System.out.println(iNum4);
		
		int a1 = 10;
		byte b1= 3;
		int c1 = a1/ b1;
		int d1 = a1 /b1;
		System.out.println(d1);
		
		
		
		
		
		 
	}

}
