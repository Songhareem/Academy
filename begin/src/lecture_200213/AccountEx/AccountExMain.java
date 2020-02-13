package lecture_200213.AccountEx;

public class AccountExMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account account1 = new Account();
		
		account1.accountNum = 11112222;
		account1.owner = "Lee";
		account1.asset = 10000;
		
		account1.deposit(-10000);
		account1.deposit(20000);
		account1.withdraw(10000);
		account1.withdraw(30000);
		
		System.out.println("\n");
		
		Account account2 = new Account(22223333, "Han", 1000);
		
		account2.deposit(-10000);
		account2.deposit(20000);
		account2.withdraw(10000);
		account2.withdraw(30000);
		
	}
}

// 계좌번호, 예금주, 잔고를 속성으로 갖는 Account 클래스 작성
// 입금, 출금, 잔고 조회
class Account {
	
	int accountNum;
	String owner;
	int asset = 0;
	
	Account() {
		
	}
	
	Account(int accountNum, String owner, int money) {
		
		this.accountNum = accountNum;
		this.owner = owner;
		this.asset = money;
		
		if(this.errInputDeposit(money))
			this.asset = 0;
		
		System.out.println("====== 계좌 개설 ======");
		System.out.println("예금주 : " + this.owner);
		System.out.println("계좌번호: " + this.accountNum);
		System.out.printf("초기 입금액 : %,d원\n", this.asset);
	}
	
	// 입금액 체크
	private boolean errInputDeposit(int money) {
		return money < 0? true:false;
	}
	// 입금
	public void deposit(int money) {
		
		if(this.errInputDeposit(money)) {
			System.out.printf("====== 입금액 에러 ======\n");
			System.out.printf("[입금 요청액] : %,d\n", money);
			return;	
		}
			
		this.asset += money;
		System.out.printf("====== 입금 성공 ======\n");
		System.out.printf("[입금] : %,d원\t\t", money);
		this.showAsset();
	}
	
	// 출금
	public void withdraw(int money) {
		
		if((this.asset - money) < 0) {
			System.out.printf("====== 잔고가 부족합니다 ======\n");
			System.out.printf("[출금 요청액] : %,d\t", money);
			this.showAsset();
			return;
		}
		
		this.asset -= money;
		System.out.printf("====== 출금 성공 ======\n");
		System.out.printf("[출금] : %,d원\t\t", money);
		this.showAsset();
	}
	
	// 잔고조회
	public void showAsset() {
		
		System.out.printf("[잔고] : %,d원\n", asset);
	}
}
