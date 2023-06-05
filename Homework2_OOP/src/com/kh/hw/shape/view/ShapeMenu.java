package com.kh.hw.shape.view;

import java.util.Scanner;


import com.kh.hw.shape.controller.SquareController;
import com.kh.hw.shape.controller.TraingleController;

public class ShapeMenu {
	Scanner sc = new Scanner(System.in);
	SquareController scr = new SquareController();
	TraingleController tc = new TraingleController();
	public void intputMenu() {
		while(true) {
		System.out.println("====도형 프로그램");
		System.out.println("3. 삼각형");
		System.out.println("4. 사각형");
		System.out.println("9. 프로그램 종료");
		System.out.println("메뉴 번호 :");
		int a = sc.nextInt();
		if(a==3) {
			//ShapeMenu triangleMenu= new ShapeMenu();
			this.triangleMenu();
		}else if (a==4) {
			this.squareMenu();			
		}else if(a==9) {
			//ShapeMenu iDontKnow = new ShapeMenu();
			break;
		}else {
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			
		}
		
		}
		
		
		
		
	}
	public void triangleMenu () {
		while(true) {
		System.out.println("1.삼각형 면적");
		System.out.println("2.삼각형 색칠");
		System.out.println("3.삼각형 정보");
		System.out.println("9.메인으로 돌아갑니다.");
		System.out.println("메뉴 번호 : ");
		int a = sc.nextInt();
		if(a==1) {
			System.out.println("높이 :");
			int b = sc.nextInt();
			System.out.println("너비 :");
			int c = sc.nextInt();
			this.inputSize(b,c);
			tc.calcArea(b, c);
			
		}else if(a==2) {
			
		}else if(a==3) {
			
		}else if(a==9) {
			
		}else {
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
		}
		
		
		}
		}
	public void squareMenu() {
		System.out.println("1.사각형 둘레");
		System.out.println("2.사각형 면적");
		System.out.println("3.사각형 색칠");
		System.out.println("4.사각형 정보");
		System.out.println("9.메인으로 돌아갑니다.");
		int a = sc.nextInt();
		if(a==1) {
			
		}else if(a==2) {
			
		}else if(a==3) {
			
		}else if(a==9) {
			
		}else {
			System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
		}
	}
	
	public int inputSize(int type, int menuNum) {
		int result = 0;
		return result;
	}
	public int printformation(int type) {
		int result = 0;
		return result;
	}
	
}
