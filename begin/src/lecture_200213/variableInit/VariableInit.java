package lecture_200213.variableInit;

public class VariableInit {

	// 변수의 초기화
	// 변수의 처음 값을 저장하는것
	
	// 멤버변수 : 기본값으로 자동 초기화
	int num;
	// 멤버변수 : 명시적 초기화(explict initalization)
	int sum = 5;
	
	// 지역변수 : 사용 전 반드시 초기화 필요
	
	// 생성자를 이용한 멤버 변수 초기화
	// num과 sum의 값을 매개변수로 받아서 초기화
	public VariableInit(int num, int sum) {
		this.num = num;
		this.sum = sum;
		System.out.println("생성자 호출됨");
	}
	
	// 초기화 블럭
	
	// 클래스 초기화 블럭
	// > 클래스변수의 복잡한 초기화에 사용
	// > 클래스가 로딩될 때 실행됨
	static { 
		System.out.println("클래스 초기화 블럭");
	}
	
	// 인스턴스 초기화 블럭
	// > 생성자에서 공통적으로 수행되는 작업 사용
	// > 인스턴스가 생성될 때 마다 (생성자보다 먼저) 실행
	{ 
		System.out.println("인스턴스 초기화 블럭");
	}
}
