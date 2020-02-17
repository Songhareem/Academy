package lecture_200217.interfaceTest;

public abstract class Player implements Character, Skill, Item{
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