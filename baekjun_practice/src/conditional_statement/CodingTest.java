package conditional_statement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodingTest {
	 public String solution(String s) {
	        String answer = "";
	        
	        String[] numbers = s.split(" ");
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        
	        for(int i = 0; i < numbers.length; i++){
	            int number = Integer.parseInt(numbers[i]);
	            
	            min = Math.min(min, number);
	            max = Math.max(max, number);
	        }

	        answer = min+ " " +max;
	        return answer;
	    }
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); Long
		 * n= Long.parseLong(br.readLine()); System.out.println(n*n);
		 */
		for(int i =2;i<10;i++)
			for(int j=1; j<10; j++)
				System.out.println(i+"*"+j+"="+i*j);

	}
		
	}

