package conditional_statement;

import java.util.Scanner;

public class Problem2884 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a= sc.nextInt();
		int b= sc.nextInt();
		if(a>=0&&a<=23&&b>=0&&b<=59) {
			if(b<45) {
				if(a==0) {
					System.out.print("0 "+((60+b)-45));
				}else {
				System.out.print(a-1);
				System.out.print(" ");
				System.out.print((60+b)-45);
				}
			}else {
				System.out.print(a);
				System.out.print(" ");
				System.out.print(b-45);
			}
		}
	}

}
