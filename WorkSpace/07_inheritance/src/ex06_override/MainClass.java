package ex06_override;

public class MainClass {
	public static void main(String[] args) {
		Espresso e = new Espresso("카카오", 1);
		e.taste();
		Coffee c = new Coffee("인도네시아");
		c.taste();
	}
}
