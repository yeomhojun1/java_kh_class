package kh.lclass;

import java.util.Arrays;

public class TestArray {

	public static void main(String[] args) {
		String[] strArr = new String[3];
		strArr[0] = "apple";
		strArr[1] = "banana";
		strArr[2] = new String("mango");
//		strArr을 복사할 strCopyArr
		String[] strCopyArr = new String[strArr.length];		
		for(int i=0;i < strArr.length;i++) {
			strCopyArr[i]= strArr[i];
			
		}
		for(int i=0; i <strArr.length; i++) {
			System.out.println(strArr[i]+" : "+strCopyArr[i]);
		
		}
		System.out.println("==========");
		
		int a = 10;
		int[] arrA = new int[3];
		int[] arrB = arrA.clone();
		System.out.println(arrB.length);
		System.out.println(arrB[2]);
		
		System.out.println("======Arrays.copyOf===");
		
		String[] strCopyArr2= Arrays.copyOf(strArr, 3);
		for(int i =0; i <strCopyArr2.length;i++) {
			System.out.println(strCopyArr2[i]);
		}
		
		System.out.println("====System.===");
		String[] strCopyArr3= new String[5];
		System.arraycopy(strArr, 1, strCopyArr3, 0, 2);
		for(int i =0; i <strCopyArr3.length;i++) {
			System.out.println(strCopyArr3[i]);
		}
		
		int [][] arr = {{1,2,3,4},{5,6,7,8}};
		
		System.out.println(strArr[0]);
		
		String[] strArr2 = {"apple","banana", new String("mango")};
		String[] strArr3 = {new String("apple"),new String("banana"), new String("mango")};
		String[] strArr4 = new String[] {"apple","banana", new String("mango")};
		String[] strArr5 = new String[] {new String("apple"),new String("banana"), new String("mango")};
		System.out.println("strArr의 1번째 과일은 "+strArr[0]);
		System.out.println("strArr의 2번째 과일은 "+strArr[1]);
		System.out.println("strArr의 3번째 과일은 "+strArr[2]);
		
		for(int i =0; i<strArr.length; i++)	{
			System.out.println("strArr의 "+i+"번째 과일은 "+strArr[i]);
			System.out.printf("strArr의 %d번째 과일은 %s\n",i,strArr[i]);
		}
		
		
		int[] intArr= new int[3];
		System.out.println(intArr[1]);
		
		int[] innArr2 = new int[] {1,2,3};
		int[] innArr3 = {1,2,3};
		
	}

}
