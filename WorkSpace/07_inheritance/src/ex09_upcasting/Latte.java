package ex09_upcasting;

public class Latte extends Espresso{
	private int milk ;

	public Latte(String bean, int water, int milk) {
		super(bean, water);
		this.milk = milk;
	}
	@Override
	public void info() {
		super.info();
		System.out.println("우유:" + milk +"ml");
	}
	@Override
	public void taste() {
		System.out.println("카페라떼가 부드럽다");
	}
}
