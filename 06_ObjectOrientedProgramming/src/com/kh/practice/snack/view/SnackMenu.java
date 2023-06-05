package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public void menu() {
		System.out.println("스낵류를 입력하세요.");
		System.out.println("종류 : ");
		String kind = sc.nextLine();
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("맛 : ");
		String flavor = sc.nextLine();
		System.out.println("개수 : ");
		int count = sc.nextInt();
		System.out.println("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.println(scr.saveData(kind, name, flavor, count, price));
		System.out.print("저장한 정보를 확인하시겠습니까? (y/n) : ");
		char answer = sc.nextLine().charAt(0);
		if(answer=='y') {
			System.out.print(scr.confirmData());
			
		}
		
	}

	}


		
	

	
	
	
	
	
	
	
	
	
	

