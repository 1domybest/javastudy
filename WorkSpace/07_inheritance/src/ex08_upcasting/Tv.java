package ex08_upcasting;

//Tv
public class Tv extends Elec {
	private String model;

	public Tv(int watt, String model) {
		super(watt);
		this.model = model;
		
	}
	@Override
	public void info() {
		System.out.println("Tv모델명: "+model);
		super.info();
	}
}
