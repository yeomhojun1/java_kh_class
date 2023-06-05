package com.kh.practice1.func;

import java.util.Scanner;

import com.kh.practice1.run.Run;

public class VariablePractice1 {

	Scanner sc = new Scanner(System.in);
	public void method1() {
		System.out.println("여기실행됨");
		
		
		System.out.println("키를 입력하세요 : ");
		String height = sc.nextLine();
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("성별을 입력하세요(남/여) : ");
		char gender = sc.nextLine().charAt(0);
			System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
	
		System.out.println("키 "+height+"cm인 "+age+"살 "+gender+"성인 "+name+"님 반갑습니다.");
		
		
		
//		System.out.print("단어를 입력하세요 : ");
//		char word = sc.nextLine().charAt(4);
//		System.out.print(word);
	sc.close();
	}			
		
}



