package exceoption;

public class ArrayExecptionHandling {

	public static void main(String[] args) {
		int[] arr =new int[5];
		try {
			for(int i =0; i<=arr.length;i++) {
				arr[i]=i;
				System.out.println(arr[i]);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
				System.out.println("예외처리부분");
			}System.out.println("프로그램 종료");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


