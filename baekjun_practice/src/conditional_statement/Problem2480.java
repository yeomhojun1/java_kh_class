package conditional_statement;

import java.util.Scanner;

public class Problem2480 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a= sc.nextInt();
		int b= sc.nextInt();
		int c= sc.nextInt();
		if(a>0&&a<7&&b>0&&b<7&&c>0&&c<7) {
			if(a==b) {
				if(b==c) {
					System.out.println(a*1000+10000);
				}else {
					System.out.println(1000+a*100);
				}
			}else if(b==c||a==c) {
				System.out.println(1000+c*100);
			}else  {
				if(a>b){
					if(a>c) {
						System.out.println(a*100);
					}else {
						System.out.println(c*100);
					}
				}else if(a<b) {
					if(b>c) {
						System.out.println(b*100);
					}else {
						System.out.println(c*100);
					}
				}
			}
		}
	}

}
