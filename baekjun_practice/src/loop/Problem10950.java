package loop;

import java.util.Scanner;

public class Problem10950 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a= sc.nextInt();
		int[] result = new int[a];
		for(int i = 0; i<a;i++) {
			int b = sc.nextInt();
			int c = sc.nextInt();
			result[i] =b+c;
		}
		for(int num: result) {
			System.out.println(num);
		}

	}
}