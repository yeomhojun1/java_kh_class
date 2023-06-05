package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice4 {
	public void method1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("단어를 입력하세요 : ");
		char a = sc.nextLine().charAt(0);
		System.out.print(a);
		char b = sc.nextLine().charAt(1);
		System.out.print(b);
		char c = sc.nextLine().charAt(2);
		System.out.print(c);
	}
}
