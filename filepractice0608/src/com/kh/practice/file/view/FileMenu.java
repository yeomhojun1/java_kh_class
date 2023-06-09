package com.kh.practice.file.view;

import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	public void mainMenu() {
		System.out.println("****My note***");
		System.out.println("1. 노트 새로 만들기");
		System.out.println("2. 노트 열기");
		System.out.println("3. 노트 열어서 수정하기");
		System.out.println("9.끝내기");
		System.out.print("메뉴번호 : ");
		int answer = sc.nextInt();
		switch(answer) {
		case 1: fileSave();
			break;
		case 2: fileOpen();
			break;
			
		case 3:fileEdit();
			break;
		case 9:
		default:
			System.out.println("잘못된 숫자입니다. 다시 입력해주세요");
			break;
		}
	}
	public void fileSave(){
		do {
		System.out.println("파일에 저장할 내용을 입력하세요. \n ex끝it라고 입력하면 종료됩니다.");
		System.out.println("내용 : ");
		String answer = sc.nextLine();
		fc.checkName(answer);
		}while(true);
}		
	public void fileOpen(){}
	public void fileEdit(){}
	
}
