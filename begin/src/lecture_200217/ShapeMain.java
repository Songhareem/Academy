package lecture_200217;

public class ShapeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shape sp;
		
		System.out.println("==== ShapeCircle ====");
		sp = new ShapeCircle("붓", "원");
		sp.drawShape();
		ShapeCircle sc = (ShapeCircle)sp;
		sc.drawCircleFormula();
		
		System.out.println("==== ShapeRectangle ====");
		sp = new ShapeRectangle("연필", "사각형");
		sp.drawShape();
		ShapeRectangle sr = (ShapeRectangle)sp;
		sr.setWidth(10);
		sr.setHeigth(20);
		sr.drawRectangleFormula();
	}

}

abstract class Shape {
	String tool;
	String name;
	
	public abstract void drawShape();
}

abstract class ShapeChild extends Shape {
	
}

class ShapeGrandChild extends ShapeChild {

	@Override
	public void drawShape() {
		// TODO Auto-generated method stub
		
	}
}

class ShapeCircle extends Shape{

	private static final double PI = 3.14;
	
	ShapeCircle(String tool, String name) {
		
		this.tool = tool;
		this.name = name;		
	}
	
	public void drawShape() {
		System.out.printf("ShapeCircle 클래스가 %s로 %s을(를) 그리다\n", tool, name);
	}
	
	public void drawCircleFormula() {
		System.out.printf("원의 면적을 구하는 공식은 반지름 x반지름x%.2f\n",PI);
	}
}

class ShapeRectangle extends Shape{

	private int width = -1;
	private int height = -1;
	
	public ShapeRectangle(String tool, String name) {
	
		this.tool = tool;
		this.name = name;
	}

	public void drawShape() {
		System.out.printf("ShapeRactangle 클래스가 %s로 %s을(를) 그리다\n", tool, name);
	}
	
	public void drawRectangleFormula() {
		if(width == -1 || height == -1)
			System.out.printf("사각형의 면적을 구하는 공식은 가로x세로\n");
		else
			System.out.printf("사각형의 면적을 구하는 공식은 가로x세로, 예시 ) %d x %d = %d", width, height, width*height);
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeigth(int height) {
		this.height = height;
	}
}