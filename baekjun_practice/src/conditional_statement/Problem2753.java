package conditional_statement;

import java.util.Scanner;

public class Problem2753 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		if(a>0&&a<4001) {
			if(a%4==0 &&a%100!=0||a%400==0	) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
		}
		
	}

}
