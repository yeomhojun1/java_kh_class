package com.kh.practice.comp.function;

import java.util.Scanner;

public class CompExample {
	Scanner sc = new Scanner(System.in);
	public void recursive() {
		recursive();
	}
	public void practice4() {
		while(true) {
		System.out.println("문자열 : ");
		String str = sc.nextLine();
		System.out.println("문자 :");
		char c = sc.nextLine().charAt(0);
		int count = 0;
		
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i)==c) {
				count++;
			}
		}
		System.out.println("포함된 개수"+count);
		
		boolean exit = false;//문자열:을 끝내고 나갈수 있도록 하기 위한 변수
		while(true) {
		System.out.println("더하시겠습니가?");
		String answer = sc.nextLine().toLowerCase();
		if(answer.equals("y")) {
			break;
		}else if(answer.equals("n")){
			exit = true;
			break;
		}else {
			System.out.println("잘못된 대답입니다. 다시입력해주세요");
				}
			}//while(true) 더하시겠습니까?(y/n)
		if(exit) {
			break;
		}
		}//while(true) 문자열;
	}
}
