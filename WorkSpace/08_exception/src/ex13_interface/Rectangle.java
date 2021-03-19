 package ex13_interface;

public class Rectangle implements Shape{
//인터페이스는 본문이 없는 추상메소드를 가지고 있으므로,
//해당 추상메소드를 반드시 오버라이드(재정의) 해야합니다.
//클래스를 상속 받을때는 extends 를 사용하고
//인터페이스는 implements 를 사용한다.
//클래스를 상송 받는다 === 인터페이스를 구현한다.
		private int width; //넓이
		private int height;
		
		public Rectangle(int width, int height) {
			super();
			this.width = width;
			this.height = height;
		}
		
		@Override
		public double getArea() {
		
		return width*height;
		}
		

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
		
		
}
