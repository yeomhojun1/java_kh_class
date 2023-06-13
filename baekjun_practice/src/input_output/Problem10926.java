package input_output;

import java.util.Scanner;

public class Problem10926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id= sc.nextLine();
		String ids= id.toLowerCase();
		
		if(ids.length()<50) {
			boolean chechTrue = true;
			char[] arr= ids.toCharArray();
			for(int i = 0; i<ids.length();i++) {
				int a = arr[i];
				if(a>=97&& a<=122) {
					
				}else {
					chechTrue= false;
				}
			}
			if(chechTrue) {
				System.out.println(ids+"??!");
			}
		}
		
	}

}
