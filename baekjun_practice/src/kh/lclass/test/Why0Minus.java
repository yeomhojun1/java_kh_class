package kh.lclass.test;

import java.util.Scanner;

public class Why0Minus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.nextLine(); // 1S2D3T, 7D2S9S
		char[] input = inputStr.toCharArray();
		int result = 0;
		for (int i = 1; i < 6; i += 2) {
			switch (input[i]) {
			case 'S':
				result += input[i - 1] -'0';
				
				break;
			case 'D':
				result += (input[i - 1] - '0') * 2;
				break;
			case 'T':
				result += (input[i - 1] - '0') * 3;
				break;
			default:
				break;
			}
		}
		sc.close();
		System.out.println(result); // 14, 25
	}

}
