package input_output;

import java.util.Scanner;

public class Problem1001 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a>0&&b<10) {
			System.out.println(a-b);
		}else {
			System.out.println("범위에맞는 수를 입력해주세요");
		}
	}

}
