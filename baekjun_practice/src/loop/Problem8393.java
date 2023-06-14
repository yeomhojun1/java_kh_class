package loop;

import java.util.Scanner;

public class Problem8393 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a= sc.nextInt();
		int sum=0;
		if(a>0&&a<10001) {
			for(int i=0;i<a+1;i++) {
				sum= i+sum;
		}
		}System.out.println(sum);
	}

}
