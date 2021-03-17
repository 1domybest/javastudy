package ex05_constructor;

public class Circle extends Coord{
	private double radius;
	
public Circle(int x, int y,double radius) {
		super(x, y);
		// TODO Auto-generated constructor stub\
		this.radius = radius;
		
	}
public void info() {
	System.out.println("중심좌표 :["+getX()+","+getY()+"]");
	System.out.println("반지름:" + radius);
}
}
