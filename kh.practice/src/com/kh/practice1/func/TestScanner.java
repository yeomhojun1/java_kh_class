package com.kh.practice1.func;

import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //스캐너 전원 켜줌
		
		
//		엔터키 칠때까지의 데이터를 스캔해줘
//		1 2 가 나 다 enter
//		scan은 데이터 "11 22 33.3 가가가 나나 다\n\0"
		String str1 =scan.next();//next는 한덩어리만 줄래라는 뜻인데 한 덩어리는 띄어쓰기 전까지. 그러므로 1이 나옴
		System.out.println(str1);//11
		int num1 =scan.nextInt();//nextInt는 띄어쓰기 전까지 한덩어리를 정수로 바꾸서 리턴, 형변환을 못하면 죽음
		//22
		System.out.println(num1);//11
		double num2 = scan.nextDouble();//nextDouble은 띄어쓰기 전까지 한 덩어리를 실수로 바꿔서 리턴
		//33.3
		System.out.println(num2);//11
		String str2 = scan.nextLine();//nextLine은 줄바꿈까지의 덩어리를 문자형태로 바꿔서 리턴
		//가가가 나나 다
		System.out.println(str2);//11
		
		System.out.println("입력1");
		
		int num3 = scan.nextInt();
		scan.nextLine();//flush
		System.out.println(num3);
		
		System.out.println("입력2");
		String str3 = scan.nextLine();
		System.out.println(str3);
		
		System.out.println("끝");
		
		
		
		
		
		
		
		scan.close();//스캐너 전원 끔
	}

}
