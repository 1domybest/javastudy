package quiz02;

public class Staff {

	// field
	private String name;

	// constructor
	public Staff(String name) {
		super();          
		this.name = name;
	}
	
	// method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void info() {
		System.out.println("직원명: "+name);
	}
}
