package ex09_upcasting;

public class Espresso extends Coffee{
	
	private int water;

	public Espresso(String bean, int water) {
		super(bean);
		this.water = water;
	}
	
	@Override
	public void info() {
		
		super.info();
		System.out.println("물:" + water +"ml");
	}
	
	@Override
	public void taste() {
		System.out.println("에스프레소 맛이 진하다.");
	}
}
