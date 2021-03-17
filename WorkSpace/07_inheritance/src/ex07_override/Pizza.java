package ex07_override;

public class Pizza {
	private String dough;
	private int cheese;
	
	public Pizza(String dough, int cheese) {
		this.dough = dough;
		this.cheese = cheese;
	}
	
	public void info() {
		System.out.println(dough+"("+cheese+")");
	}
	
}
