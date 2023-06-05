package kh.lclass;

public class TestFor {
	public static void main(String[] args) {
		int sum= 0;
		int start = 1;
		int end = 100;
		int step =1;
		int num3 = start;
		
		
		
		
		
		int total =0;
		String msg= (total >0) ? "홀수의 합계는 %d\n" : "합계는 음수일 수 없습니다. %d\n";
		if(total > 0) {
			msg = "홀수 합계는 %d\n";
		}else {
			msg = "합계는 음수일 수 없습니다. %d\n";
		}
		
		
		
		
		
		while (num3 <= end) {
			sum = sum+ num3;
			num3 +=step;
		} System.out.println(start+"부터 "+end+"까지의 합은 "+sum);
		sum = 0;
		start =2;
		end =200;
		step = 2;
		num3= start;
		while(num3<=end) {
			sum = sum+ num3;
			num3= num3+ step;
		}System.out.println(sum);	
			
		System.out.println("==========for");
		int evenSum = 0;
		int oddSum=0;
		sum = 0;
		start =1;
		end=100;
		step=1;
		for(sum =0 ,num3=start; 
				num3 <= end;
				num3 +=step
				) {
			sum += num3;
			if(num3 % 2==0) {
				evenSum+= num3;
			}else {
				oddSum += num3;
			}
		}
		System.out.println(start+"부터 "+end+"까지의 합은 "+sum);
		System.out.println(start+"부터 "+end+"까지의 홀수합은 "+oddSum);
		System.out.println(start+"부터 "+end+"까지의 짝수합은 "+evenSum);
		
		int class1= 0;
		int class2 = 0;
		int class3 = 0;
		sum =0;
		for(   num3=start;
				num3<=100;
				num3 += step) {
			sum += num3;
			if(num3%3==0) {
				class1 +=num3;
			}else if (num3%3==1){
				class2 += num3;
				
			}else {
				class3 +=num3;
			}
		}
		System.out.println(start+"부터 "+end+"까지의 나머지가 0인 수의 합은 "+class1);
		System.out.println(start+"부터 "+end+"까지의 나머지가 1인 수의 합은 "+class2);
		System.out.println(start+"부터 "+end+"까지의 나머지가 2인 수의 합은 "+class3);
	
		System.out.println("==========while");
		int num = 5;
		int num2 = 1;
		while (num >= 1) {
			System.out.println("(" + num + "," + num2 + ")");
			num = num - 1;
			num2 = num2 + 1;
		}
		for (num = 5, num2 = 1; num > 0; num--, num2 += 2) {
			System.out.println("(" + num + "," + num2 + ")");
		}
		int a;
		int sum1;
		for (a = 1, sum1 = 0; a <= 100 ; a++) {
			sum1 = sum1 + a;
		
		}
		a++;
		System.out.println(sum1);
		
		System.out.println("======지역범위 - 변수");
			int num8 = 10;
			for ( num8=1; num8<5; num8++) {
				System.out.println(num8);
			}
			System.out.println("===");
			System.out.println(num8);
			System.out.println("===");
			for(int num9=1; num9<5;num9++) {
				System.out.println(num9);
				System.out.println(num8);
			}
			
		System.out.println("=======구구단");
		int dan = 1;
		int su =1;
		int su2=1;
		for( dan=1; dan <=9; dan++) {
			for (su2=1; su2 <=9; su2++) {
				for (su=1; su <=9; su++) {

					System.out.printf("%d * %d * %d= %3d\t\t", dan, su, su2, dan*su*su2);
//					System.out.println(dan+" * "+su+" * "+su2+" = "+dan*su*su2);
				}System.out.println();
			}System.out.println();
		}
		System.out.println("======탭");
		
		for(su=1; su<=9;su++) {
			for(dan=2; dan<9; dan++) {
				System.out.printf("%d * %d= %2d\t", dan, su, dan*su);
			} 
			System.out.printf("%d * %d= %2d\n", dan, su, dan*su);
		}System.out.println();
			
		System.out.println("========continue");
		int total1= 0;
		for(int i =1; i<10;i++) {
//			if(i%2==0) {
//				continue;
//			}
//			total +=i;
//		}
//		System.out.printf("합계는 %d\n", total);
//		방법 2
		if(i%2 !=0) {
			total1 += i;
			System.out.printf("합계는 %d\n", total1);
		}
	
		
		}
		System.out.println("==========break");
		for(dan=2; dan<9; dan++) {
			for(su=1; su<=9;su++) {
				System.out.printf("%d * %d= %2d\n", dan, su, dan*su);
				
				}
				if(dan==5) {
					break;
			} System.out.println();
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
