package lecture_200217.subject;

public class RpgGame extends Game{

	@Override
	void gameLogic() {
		
		System.out.println("==== RPG GAME ====\n");
		
		SwordMan sm = new SwordMan("소드맨"); 
		sm.attack();
		sm.move(1, 1);
		
		Merchant mc = new Merchant("상인");
		mc.attack();
		mc.move(1, 1);
		
		System.out.println("\n==== Game End ====");
	}

}

interface Attack {
	// 같은 패키지, 같은 클래스, 다른 패키지에서 접근 가능한 attack() 작성
	// 단, 매개변수와 반환값 없음
	public void attack();
}

interface Character {

	// 접근제한이 없는 상수 HEART 5 초기화
	// 같은 패키지 내에서는 접근 가능한 상수 POWER 5 초기화
	
	public final int HEART = 5;
	final int POWER = 5;
}

interface Item {
	
	// 정수형 값 100을 갖는 상수 POTION
	// 	 "   200을 갖는 상수 WEAPON
	final int POTION = 100;
	final int WEAPON = 200;
	
	// 같은 패키지 내에서만 접근 가능한 helpItem() 작성 및 구현
	// 매개변수 	: 없음
	// 반환값		: 없음
	// 기능		: "[도움말]" 아이템을 구매하려면 골드가 필요합니다" 출력
	static void helpItem() {
		System.out.println("[도움말] 아이템을 구매하려면 골드가 필요합니다");
	}
}

interface Move {
	// 정수형 매개변수 2개를 받고 반환값은 없는 추상 메서드 move 선언
	// (단, 접근제한 없음)
	void move(int i, int j);
}

interface Skill extends Move, Attack{
	
	// 다른 패키지(하위 패키지 포함)에서는 접근할 수 없도록 helpSkill() 작성 및 구현
	// 매개변수	: 없음
	// 기능		: "[도움말] 스킬은 공격과 이동 중에서 선택가능합니다" 출력

	default void helpSkill() {
		System.out.println("[도움말] 스킬은 공격과 이동 중에서 선택가능합니다");
	}
}

abstract class Player implements Character, Skill, Item{
	private int x;
	private int y;
	private int heart;
	private int power;
	private int gold;
	private String name;
	
	public Player(String name) {
		
		this.name = name;
		this.heart = HEART;
		this.power = POWER;
		
		System.out.println("==== 캐릭터 생성 ====");
		System.out.println("캐릭터 이름	: " + name);
		setPosition(0,0);
		setHeart(0);
		setPower(0);
		setGold(10000);
	}

	// getter setter
	public void setHeart(int heart) {
		this.heart += heart;
		System.out.print("HEART :");
		for(int i=0; i<this.heart; i++)
			System.out.print("♥");
		System.out.println();
	}
	
	public void setPower(int power) {
		this.power += power;
		System.out.print("POWER :");
		for(int i=0; i<this.power; i++)
			System.out.print("★");
		System.out.println();
	}

	public void setGold(int gold) {
		this.gold += gold;
		System.out.printf("GOLD : %,d\n",gold);
	}

	public String getName() {
		return name;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.printf("현재 위치 : (%d, %d)\n", x,y);
	}
}

class SwordMan extends Player {

	public SwordMan(String name) {
		super(name);
	}

	public void move(int i, int j) {
		
		System.out.println("-- 소드맨의 이동 --");
		this.setPosition(i*2,j*2);
		this.setPower(1);
		this.setHeart(1);
	}

	public void attack() {
		System.out.println("-- 소드맨의 공격 --");
		this.setPower(-2);
		this.setHeart(-2);
	}
}

class Merchant extends Player {

	public Merchant(String name) {
		super(name);
	}

public void move(int i, int j) {
		
		System.out.println("-- 상인의 이동 --");
		this.setPosition(i*2,j*2);
		this.setPower(2);
		this.setHeart(2);
	}

	public void attack() {
		System.out.println("-- 상인의 공격 --");
		this.setPower(-1);
		this.setHeart(-1);
	}
}

