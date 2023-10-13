package kh.lclass.test;

public class DrawStar {
	public static void main(String[] args) {

		int maxCnt = 10 * 2; // 2배
		int maxCnt_1 = maxCnt - 1;
		for (int i = 0; i < maxCnt; i += 2) {// 2씩 증가
			for (int j = maxCnt_1; j > i + 1; j -= 2) { // 2씩 감소
				System.out.print(" ");// 공백
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();

		}
	}
}
