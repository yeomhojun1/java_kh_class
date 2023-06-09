package com.kh.practice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BubbleSort {

	public static void main(String[] args) {
		//버블정렬
		int a = 10;
		int b= 20;
		//swap a 방에 b값으로 바꾸고, b방에 a값으로 바꾸기
		int c = a;
		a=b;
		b=c;
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println(a);
		System.out.println(b);
		
		
		String arr[] = new String[] {"손범규","천영준,","유청하","김민성"};
		System.out.print("[");
		for(String ar: arr) {
			System.out.print(ar);
			System.out.print(",");
		}
		System.out.print("]");
		for(int i = 0; i<arr.length-1;i++) {
			for(int j = 0; j<arr.length-1-i;j++) {
				if(arr[j].compareTo(arr[j+1])>0) {//오름차순
//					if(arr[j].compareTo(arr[j+1])<0) {//내림차순
				String temp = arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
			System.out.print("[");
			for(String ar: arr) {
				System.out.print(ar);
				System.out.print(",");
			}
			System.out.print("]");
			
			
			
		System.out.println("이름을 ,로 구분하여 입력해주세요.");
		String names= sc.nextLine();
		StringTokenizer strToken = new StringTokenizer(names,",");
		List<String> nameList = new ArrayList<String>();
		while(strToken.hasMoreTokens()) {
			nameList.add(strToken.nextToken());
		}//버블 정렬하기
		System.out.println();
		
		
		
		
//		int[] arr = new int[] {1,2,3,4,5}	;
//		
//		for(int i= 0; i<arr.length-1; i++) {
//			
//			for(int j = 0; j<arr.length-1-i; j++) {
//				if(arr[j]>arr[j+1]) {//오름차순
////				if(arr[j]<arr[j+1]) {//내림차순
//					//swap
//					int temp = arr[j];
//					arr[j]=arr[j+1];
//					arr[j+1]=temp;
//					
//				}
//				
//				
//			}
//		}
//		
//		
//		
//		
//		
		
		
		
		
	}

}
}
