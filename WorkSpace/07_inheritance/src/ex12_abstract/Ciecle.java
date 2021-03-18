package ex12_abstract;

public class Ciecle extends Shape {
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
