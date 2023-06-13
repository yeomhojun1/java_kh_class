package input_output;

import java.util.Scanner;

public class Problem10430 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if(a>=2&&a<=10000&&b>=2&&b<=10000&&c>=2&&c<=10000) {
			System.out.println((a+b)%c);
			System.out.println(((a%c)+(b%c))%c);
			System.out.println((a*b)%c);
			System.out.println(((a%c)*(b%c))%c);
	}else {
		System.out.println("잘못된 범위입니다");
	}

}
}