package kh.lclass.api;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;
import static kh.lclass.api.KhCommonApi.*;
public class TestApi {
	public void testDate() {
		Date now = new Date();
		System.out.println(now);
		Calendar c = new GregorianCalendar();//cannot instantiate the type calendar
		System.out.println(c.getTime());
		TestSingleton ts = TestSingleton.getInstance();
		System.out.println(ts.getA());
		ts.setA(50);
		System.out.println(ts.getA());
		TestSingleton ts2 = TestSingleton.getInstance();
		System.out.println(ts2.getA());
		ts2.setA(100);
		System.out.println(ts2.getA());
	}
	
	
	public void testWrapperWhile() {
		Scanner sc = new Scanner(System.in);
		//입력값을 5a라고 쓰면 InputMIsmatchException이 뜸
		while(true) {
			int menu =0;
			System.out.println("메뉴 1-5 사이 선택해주세요.");
			try {
				String menuStr = sc.nextLine();
				menu = Integer.parseInt(menuStr);
				//String menuStr은 오직 try 안에서만 쓰임
			}catch(NumberFormatException e) {
//				NumberFormatException 뜸
			}
			if(!checkMenu(1, 5, menu)) {
			//지금 menu는 0임 
//	왜냐면 menu = Integer.parseInt(menuStr);여기서 오류가났기때문에 catch를 갔다가 넘어와서 0임
			//정상케이스
			System.out.println("정상적으로 입력되어서..다른함수 호출함");
			testString();
			System.out.println("동작마침!");
			break;	
			}else {
			//비정상케이스
			System.out.println("1-5사이의 수를 입력해주세요");
			
		}
	}
	System.out.println("testWrapperDowhile 끝");
//	while(true) {
//		int menu =0;
//		System.out.println("메뉴 1-5 사이 선택해주세요.");
//		try {
//			menu = sc.nextInt();
//		}catch(InputMismatchException e) {
//			sc.nextLine();
//		}
//		if(menu>0 &&menu <6) {
//		//정상케이스
//		System.out.println("정상적으로 입력되어서..다른함수 호출함");
//		testString();
//		System.out.println("동작마침!");
//		break;	
//		}else {
//		//비정상케이스
//		System.out.println("1-5사이의 수를 입력해주세요");
//		
//	}
//}
//System.out.println("testWrapperDowhile 끝");	
	
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public void testString() {
		StringBuffer str1 = new StringBuffer("aaa");
		StringBuffer str2 = new StringBuffer();
		str2.append("12345");
		str2.insert(2, "abc");
		System.out.println(str2);
		System.out.println(str2.indexOf("bc"));
		StringBuilder str3 = new StringBuilder();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("구분자를 입력해주세요");
//		String token = sc.nextLine();
//		System.out.println("내용을 입력해주세요");
//		String content = sc.nextLine();
		String str = "AA|BB|CC";
		StringTokenizer st = new StringTokenizer(str,"|");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		//기본자료형-->String
		int i = 30;
		
		String s1 = String.valueOf(35);
		String s2 = String.valueOf(i);
		System.out.println(35);
		String s3 = Integer.valueOf(35).toString();
		//String -->기본자료형
		String s = "35";
		i = Integer.parseInt(s);
		System.out.println(i);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		
		
		
	}
}
