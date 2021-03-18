package quiz03;

public class SalesMan extends SalaryMan {

	// field
	private int salesAmount;  // 판매실적
	private double incentive;  // 인센티브(%)
	
	// constructor
	public SalesMan(String name, int salary) {
		super(name, salary);
	}

	// method
	public int getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
		if (salesAmount >= 1000) {
			setIncentive(0.07);  // 7% 인센티브
		} else {
			setIncentive(0.05);  // 5% 인센티브
		}
	}
	public double getIncentive() {
		return incentive;
	}
	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}
	@Override
	public int getPay() {
		return super.getPay() + getSalesPay();
	}
	public int getSalesPay() {
		return (int)(salesAmount * incentive);
	}
	@Override
	public void info() {
		super.info();
		System.out.println("인센티브: "+getSalesPay());
		System.out.println("총합: "+getPay());
	}
}
