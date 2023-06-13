package input_output;

import java.util.Scanner;

public class Problem10869 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a>=1&&b<=10000) {
			System.out.println(a+b);
			System.out.println(a-b);
			System.out.println(a*b);
			System.out.println((double)a/b);
		}else {
			System.out.println("범위에 맞는 수를 입력해주세요");

	}

	}
}