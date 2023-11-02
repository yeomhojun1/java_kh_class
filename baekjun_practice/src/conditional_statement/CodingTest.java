package conditional_statement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingTest {
	 static int[] min_arr(int[] A) {
		 int min=A[0];
		for(int i=0;i<A.length;i++) {
			for(int j=i+1;j<A.length;j++) {
			if(A[i]<A[j]) {
				min=A[i];
				A[i]=A[j];
				A[j]=min;
				
			}}
		}
		return A;
	 }
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Long n= Long.parseLong(br.readLine());
		System.out.println(n*n);
		System.out.println('2');
		System.out.println('3');
	}
		
	}

