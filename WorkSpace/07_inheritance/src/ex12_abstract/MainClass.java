package ex12_abstract;

public class MainClass {
	public static void main(String[] args) {
		Shape[] shapes =new Shape[10];
		
		shapes[0] = new Rectangle(3, 4);
		System.out.println(shapes[0].getArea());
		shapes[1] = new Square(5);
		shapes[2] = new Triangle(3,5);
		shapes[3] = new Ciecle(1.5);
		for (int i = 0; i < shapes.length; i++) {
			if(shapes[i]!=null) {
				
				System.out.println(shapes[i].getArea());
			}
		}
		
	}
}
