package kh.practice.bank;

import java.util.Scanner;

public class Member {
	public static void main(String[] args) {
		//스캐너 마련
		java.util.Scanner sc= new Scanner(System.in); 
		System.out.println("통장개설을 원하십니까?");
		String answer = sc.nextLine();
		if(answer.equals("네")) {
			System.out.println("주민등록번호 확인");
			int strNo= sc.nextInt();
//			String strNo = sc.nextLine();
//			int sno = Integer.parseInt(strNo);
			sc.nextLine();
			System.out.println("이름 확인");
			String strName= sc.nextLine();
			BankAccount ej = new BankAccount(strNo, strName);
			BankAccount hj = new BankAccount(123123, "호준", 01033);
			BankAccount jh = new BankAccount();
			System.out.println(jh.getsNo());//0
			System.out.println(jh.getName());//0
			System.out.println(jh.getBalance());//0
			System.out.println(jh.getAccountName());//0
			jh.sumArgs(2,5,3);
			String str1 = "문자";
			String str2 = "문자";
			String str3	=	new String(); //""
			String str4	=	new String("문자");			
			boolean b = str1.equals(str4);
			System.out.println(hj);
			System.out.println(hj.toString());
			System.out.println(hj.hashCode());
			System.out.println(str3);	
			System.out.println(hj.getsNo().MAX_VALUE);
			System.out.println(hj.getsNo().MIN_VALUE);
			
			System.out.println("한줄\n한탭\t탭한슬래쉬\\\\따옴표는 어떻게\"?");
			System.out.printf("한줄\n한탭\t탭한슬래쉬\\\\따옴표는 어떻게\"?");
			System.out.println(2);
			System.out.println("안"+2+4);//안24
			System.out.println(2+4+"안");//6안
			System.out.println(2*4+"안");//8안
			System.out.println("안"+2*4);//안8
			System.out.println("안"+2*4+7);//안87
			System.out.println(2+4+"안"+2*4+7);//6안87
			System.out.println(2+4+"안"+(2*4+7));//6안15
			
			String str = "Hello Java";
			System.out.println(str.charAt(0));
			System.out.println(str.charAt(1));
			System.out.println(str.charAt(2));
			System.out.println(str.length());
			System.out.println(str.toLowerCase());//전부 소문자
			System.out.println(str.toUpperCase());//전부 대문자
			String strReplace = str.replace('J', 'L');
			String strSubString = str.substring(5,8);
			int idx = str.indexOf(' ');
			String strSubString1 = str.substring(idx+1,idx+2);
//			String strSubString2 = str.substring(indexOf(' ')+1,indexOf(' ')+2);
			System.out.println(strReplace);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}else {
		System.out.println("다른 청구를 이용해주세요.");
		}
		
	}
}
