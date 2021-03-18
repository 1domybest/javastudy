package ex11_abstract;

public class SalaryMan extends Staff {
	private int salary;

	//추상클래스를 상속 받는 서브클래스는
	//반드시 모든 추상메소드를 오버라이드 해야합니다
	
	public SalaryMan(String name, int salary) {
		super(name);
		this.salary = salary;
	}



	@Override
	public void info() {
		
		super.info();
		System.out.println("기본급: "+salary);
	}
	
	@Override
	public int getPay() {
		
		return salary;
	}
	
}
