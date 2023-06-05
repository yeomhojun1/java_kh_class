package kh.lclass;

import java.util.Scanner;

public class TestIfLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("나이를 입력해주세요");
//		int age = sc.nextInt();
//	
//		if(8<=age&& age <=19 ){ 
//			System.out.println("학교에 다닙니다");
//		 if(age==8 ){ 
//			System.out.println("학교에 다닙니다");
//		} else if(age==19){ 
//			System.out.println("학교를 곧 졸업합니다");
//		}
//		}else {
//			System.out.println("학교에 다니지 않습니다");
//		}
//		System.out.println("==========");
//		System.out.println("공원입장료");
//		System.out.println("나이를 입력해주세요:");
//		System.out.println("==========");
//		
//		
//
//		int age1=sc.nextInt();
//		if(age1<8) {
//			int charge= 1000;
//			System.out.println("입장료는"+charge +"입니다");
//		}else if(age1<14){
//			int charge= 2000;
//			System.out.println("입장료는"+charge +"입니다");
//		}else if(age1<20){
//			int charge= 2500;
//			System.out.println("입장료는"+charge +"입니다");
//		}else {
//			int charge =3000;
//			System.out.println("입장료는"+charge +"입니다");
//		}
//		System.out.println("==========");
//		System.out.println("===학점===");
//		System.out.println("평균점수를 입력하세요:");
//		int totalScore = sc.nextInt();
//		int score = totalScore / 10;
//		switch(score) {//switch - case 문은 규칙성이 있을 때 쓰기 좋음
//		case 10: //if
//		case 9:
//			System.out.println("A학점입니다.");
//			break;
//		case 8:  //else if
//			System.out.println("B학점입니다.");
//			break;
//		case 7:  //else if
//			System.out.println("C학점입니다.");
//			break;
//		case 6:  //else if
//			System.out.println("D학점입니다.");
//			break;
//		default: //else
//			System.out.println("과락입니다.");
//		}
//		System.out.println("==========");
	
		
		//1~100 정수의 합을 구하시오
		int i;
		int sum = 0;
//		for(초기값 설정 ; 조건식    ; 증감식  )	{
		for(i=1 ; i<=100; i= i+1) {
			sum += i;
				 
				
		}
		int num;
		for(num =1; num<=5; ++num) {
			System.out.println(num);
		}
		
		
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
