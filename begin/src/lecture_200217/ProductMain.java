package lecture_200217;

public class ProductMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Product[] p = new Product[3];
		
		p[0] = new TV();
		p[1] = new Computer();
		p[2] = new Audio();
		
		Buyer b = new Buyer();
		
		for(int i=0; i<p.length; i++)
			b.buy(p[i]);
	}
}

class Product {
	int price;
	int bonusPoint;
}

class Buyer {
	
	int money = 10000;
	int bonusPoint = 0;
	
	public void buy(Product product) {
		if(product instanceof TV) {
			System.out.println("TV를 구매합니다");
		} else if(product instanceof Computer) {
			System.out.println("컴퓨터를 구매합니다");
		} else if(product instanceof Audio){
			System.out.println("오디오를 구매합니다");
		}
	}
}

class TV extends Product{
	
}

class Computer extends Product{
	
}

class Audio extends Product{
	
}
