package input_output;

import java.util.Scanner;

public class Problem18108 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int y = sc.nextInt();
		if(y<999||y>3000) {
			System.out.println("잘못입력했습니다");
		}else {
		System.out.println(y-543);
	}
	}
}
