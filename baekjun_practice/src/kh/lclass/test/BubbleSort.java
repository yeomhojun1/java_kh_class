package kh.lclass.test;

public class BubbleSort {
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void main(String[] args) {
		int[] arr = {3,5,2,10,3};
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < arr.length - i; j++) {
				if(arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
		// 출력
		int idx = 0;
		for(int a : arr) {
			System.out.print(a);
			idx++;
			if(idx<arr.length) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
}
