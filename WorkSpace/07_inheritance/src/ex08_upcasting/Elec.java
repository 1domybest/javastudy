package ex08_upcasting;

//전자 제품
public class Elec {
	private int watt; //와트(전기)

	public Elec(int watt) {
		super();
		this.watt = watt;
	}
	public void info() {
		System.out.println("소비전력: "+watt+"(W)");
	}
	
}
