package quiz01;

public class Alba extends Staff {

	// field
	private int payPerHour;  // 시급
	private int times;  // 근무시간
	
	// constructor
	public Alba(String name) {
		super(name);
	}

	// method
	public int getPayPerHour() {
		return payPerHour;
	}
	public void setPayPerHour(int payPerHour) {
		this.payPerHour = payPerHour;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public int getPay() {
		return payPerHour * times;
	}
	
}
