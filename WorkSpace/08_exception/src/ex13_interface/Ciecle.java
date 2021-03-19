package ex13_interface;

public class Ciecle implements Shape {
	private double radius;

	public Ciecle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double getArea() {
		
		return Math.PI*(radius*radius);
	}

}
