package conditional_statement;

import java.util.Scanner;

public class Problem2525 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a= sc.nextInt();
		int b= sc.nextInt();
		int c= sc.nextInt();
		int d= c/60;
		int e= c%60;
		if(b+e>=60&&a+d+1>=24) {
				System.out.println((a+d-23)+" "+(b+e-60));
			}else if(b+e>=60&&a+d+1<24) {
				System.out.println((a+d+1)+" "+(b+e-60));
			}else if(b+e<60 && a+d>=24) {
				System.out.println((a+d-24)+" "+(b+e));
			}else {
				System.out.println((a+d)+" "+(b+e));
			}
	}

}
