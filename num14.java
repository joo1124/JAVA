interface Shape {
	final double PI = 3.14;
	void draw();
	double getArea();
	default public void redraw() {
		System.out.print("--- 다시 그립니다.");
		draw();
	}
}    

class Circle implements Shape {
	private int radius;
	public Circle(int radius) {
		this.radius = radius;
	}
	@Override
	public void draw() {
		System.out.println("반지름이 "+radius+"인 원입니다.");
	}
	@Override
	public double getArea() {
		return PI*radius*radius;
	}
}

class Oval implements Shape {
	private int n1,n2;
	public Oval(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	@Override
	public void draw() {
		System.out.println(n1 + "x" + n2 + "에 내접하는 타원입니다." );
	}
	@Override
	public double getArea() {
		return PI*n1*n2;
	}
}
class Rect implements Shape{
	private int n1,n2;
	public Rect(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	@Override
	public void draw() {
		System.out.println(n1 + "x" + n2 + "크기의 사각형 입니다." );
	}

	@Override
	public double getArea() {
		return n1*n2;
	}
	
}
public class num14 {
	public static void main(String[] args) {
		Shape [] list = new Shape[3];
		list[0] = new Circle(10);
		list[1] = new Oval(20, 30);
		list[2] = new Rect(10, 40);
		
		for(int i=0; i<list.length; i++) list[i].redraw();
		for(int i=0; i<list.length; i++) System.out.println("면적은 " + list[i].getArea());

	}

}
