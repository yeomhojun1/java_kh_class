package com.kh.practice.file.view;

import java.util.Scanner;

public class Number7 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int z=0;
		int a= sc.nextInt();
		int b= sc.nextInt();
		int c= sc.nextInt();
		int d= sc.nextInt();
		int e= sc.nextInt();
		int[] intArr= {a,b,c,d,e};
		for(int i=0;i<intArr.length;i++) {
			if(intArr[i]>intArr[i+1]) {
				z=intArr[i];
			}else {
				z=intArr[i+1];
			}
		}
		System.out.println(z);
	}
}
