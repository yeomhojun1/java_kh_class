package kh.practice.bank;

public class BankAccount {
	//static 클래스 변수
	private static int count;//현재 가입한 사람들
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		BankAccount.count = count;
	}
	
	
	private int accountNo;// 계좌번호
	private String name;// 예금주 이름
	private Integer sNo;// 주민번호
	//위에 3개는 절대 바뀌면 안됨
	
	private String accountName="내일배움";
	private Information info;
	private int balcane;
	private int password;
	private int balance;
	private int source;
	{
		accountName= "내일배움=블럭초기화";
		balance = 5000000;
	}
	
	public int sumArgs(int ... args)	{
		int result = 0;
		for (int a : args) {
			System.out.println(a);
			result +=a;
		}
		System.out.println("합은 "+result);
		System.out.printf("printf는 가변인자 사용 %d %f %d %c %s", 1, 3.5,200000000L,'c',"문자열");
		return result;
	}
	
	
	
	
	
	
	
	
	
	

	public BankAccount() {}
	public BankAccount(Integer sno, String name, int phonenumber) {
		this.sNo =sno;
		this.accountNo= phonenumber;
		this.name = name;
	}
//	생성자는 클래스명과 동일, 리턴타입이 없음, 아래행을 보면 클래스명과 동일하고 리턴타입이 없음
	public BankAccount(Integer sno, String name) {
		this.sNo =sno;
		this.name = name;
	}
//	입금 ---출처(source), 금액(inputmoney) 받는다면 balance에 금액만큼 더하고 최종 balance를 화면 표시함
//	출금 ---목적지(destination), 금액(outputmoney) 보낸다면 balance에 금액만큼 빼고 최종 balcane를 화면 표시함
//	비번확인--- 입력한패스워드(inputpassword)와 -password를 비교하여 같다면 true, 다르면 false를 표시함
//	잔액조회(데이터베이스)
//	입출금내역 조회(데이터베이스)
	public int deposit(int inputMoney // 여기서 inputMoney는 매개변수
	) {
		System.out.println(source + "으로 부터" + inputMoney + "만큼 입금되었습니다");

		double interate = 0.5;// 여기서 interate가 변수
		balance = balance + inputMoney;
		return balance;
	}
	
	
	
	
	
	
	
	
	
	public int getAccountNo() {
		return accountNo;
	}
	public String getName() {
		return name;
	}
	public Integer getsNo() {
		return sNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public Information getInfo() {
		return info;
	}
	public int getBalcane() {
		return balcane;
	}
	public int getBalance() {
		return balance;
	}
	public int getSource() {
		return source;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public void setInfo(Information info) {
		this.info = info;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	@Override//@어노테이션 annotation
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", name=" + name + ", accountName=" + accountName + ", balcane="
				+ balcane + ", balance=" + balance + ", source=" + source + "]";
	}

	
}
