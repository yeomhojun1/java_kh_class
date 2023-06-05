package kh.lclass.oop.sample;

import java.util.Collection;

public interface TestInterFace {
	public final int MAXCNT= 10;
	public void method1();//능력단위별 평가보기
	public String method2();//평가안내
	public int method3(int a, int b);//평가리뷰
	
	Car[] selectlist();
	Car[] selectlist(String searchWord);
	
	
	
}
