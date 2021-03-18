package quiz01;

public class SalaryMan extends Staff {

	// field
	private int salary;

	// constructor
	public SalaryMan(String name, int salary) {
		super(name);  // 슈퍼클래스 Staff의 생성자를 호출
		this.salary = salary;
	}
	
	// method
	public int getPay() {
		return salary;
	}
	
}
