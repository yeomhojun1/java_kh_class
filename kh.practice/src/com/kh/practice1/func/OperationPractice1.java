package com.kh.practice1.func;

import java.util.Scanner;

public class OperationPractice1 {
	public void method1() {
		Scanner sc= new Scanner(System.in); 
		System.out.println("정수는 : ");
		int a = sc.nextInt();
		if(a>0) {
			System.out.println("양수다");
		}else {
			System.out.println("양수가 아니다");
		
		}
		
		sc.close();
		}
		
		
		
		
		
	
	public void method2() {
		Scanner sc= new Scanner(System.in); 
		System.out.println("정수는 :");
		int b = sc.nextInt();
		if(b==0) {
			System.out.println("0이다");
		} else if (b>0){
			System.out.println("양수다");
		}else {
			System.out.println("음수다");
		}
		sc.close();
	}
	
	public void method3() {
		Scanner sc= new Scanner(System.in);
		System.out.println("정수는 :");
		int c= sc.nextInt();
		if(c%2==0) {
			System.out.println("짝수다");
		}else {
			System.out.println("홀수다");
		}
		sc.close();
		
		
		
	}
	
	public void method4() {
		Scanner sc= new Scanner(System.in);
		System.out.println("인원 수 :");
		int d= sc.nextInt();
		System.out.println("사탕 개수 :");
		int e= sc.nextInt()	;
		System.out.println("1인당 사탕개수 :"+e/d);
		System.out.println("남는 사탕개수 :"+e%d);
		
		sc.close();
		
	}
	public void method5() {
		Scanner sc= new Scanner(System.in);
		System.out.println("이름 :");
		String name= sc.nextLine();
		System.out.println("학년(숫자만) :");
		int grade= sc.nextInt();
		System.out.println("반(숫자만) :");
		int class1= sc.nextInt();
		System.out.println("번호(숫자만) :");
		int num= sc.nextInt();
		sc.nextLine(); 
		System.out.println("성별 M/F :");
		String gender = sc.nextLine();
	
		if(gender.equals('m')) {
			gender="남";
		}else {
			gender="여";
		}
		
		System.out.println("성적(소수점 아래 둘째자리까지) :");
		double sungjuk = sc.nextDouble();
		
		System.out.println(grade+"학년 "+class1+"반 "+num+"번 "+name+" "+gender+"학생의 성적은 "+sungjuk+"이다.");
		
		sc.close();
	}
	public void method6() {
		Scanner sc =new Scanner(System.in);
		System.out.println("나이 :");
		int age = sc.nextInt();
		if(age<13) {
			System.out.println("어린이");
		} else if(age<=19) {
			System.out.println("청소년");
		}else {
			System.out.println("성인");
		}
		sc.close();
	}
	public void method7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 :");
		int kor = sc.nextInt();
		System.out.print("영어 :");
		int eng = sc.nextInt();
		System.out.print("수학 :");
		int math = sc.nextInt();
		
		System.out.println("합계 :"+(kor+eng+math));
		System.out.println("합계 :"+(kor+eng+(double)math)/3);
		sc.close();
	}
	public void method8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요(- 포함) : ");
		char a= sc.nextLine().charAt(8);
		if(a=='1') {
			System.out.println("남자");
		}else {
			System.out.println("여자");
		}
		sc.close();
	}
	public void method9 ()	{
		Scanner sc= new Scanner(System.in);
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		System.out.print("입력 : ");
		int num3 = sc.nextInt();
		if(num1<num2) {
			if(num3>num2||num3<num1) {
				System.out.println(true);
			}else {
				System.out.println(false);
		}
		System.out.println();	
	}
		sc.close();
	}
	public void method10 () {
		Scanner sc= new Scanner(System.in);
		System.out.print("입력1 : ");
		int a = sc.nextInt();
		System.out.print("입력2 : ");
		int b = sc.nextInt();
		System.out.print("입력3 : ");
		int c = sc.nextInt();
		if(a==b) {
			if(b==c){
				System.out.println(true);
			}else {
				System.out.println(false);
			}
		}else {
			System.out.println("false1");
		}
		sc.close();
	}
	public void method11() {
		Scanner sc= new Scanner(System.in);
		System.out.print("중간 고사 점수 : ");
		int num1 = sc.nextInt()	;
		System.out.print("기말 고사 점수 : ");
		int num2 = sc.nextInt()	;
		System.out.print("과제 점수 : ");
		int num3 = sc.nextInt()	;
		System.out.print("출석 회수 : ");
		int num4 = sc.nextInt()	;
		System.out.println("========결과");
		double a = num1*0.2;
		double b = num2*0.3;
		double c = num3*0.3;
		double d = num4;
		System.out.println("중간 고사 점수(20) : "+a);
		System.out.println("기말 고사 점수(30) : "+b);
		System.out.println("과제 점수(30) : "+c);
		System.out.println("출석 점수(20) : "+d);
		System.out.println("총점 : "+(a+b+c+d));
		if(d>15) {
			if((a+b+c+c)>70) {
				System.out.println("PASS");
			}else {
				System.out.println("Fail [점수 미달]");
			}
		}else {
			System.out.println("Fail [출석 회수 부족 ("+num4+"/20)]");
		}
		
		sc.close();
		
	}
//	public void method
}
