package input_output;

import java.util.Scanner;

public class Problem2588 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a= sc.nextInt();
		int b= sc.nextInt();
		if(a>99&&a<1000&&b>99&&b<1000) {
			int c= a*(b%10);
			int d= ((a*((b%100)-(b%10))/10));
			int e= a*((b-(b%100))/100);
			System.out.println(c);
			System.out.println(d);
			System.out.println(e);
			System.out.println(c+d*10+e*100);
		}
	}

}
