package ex03_join;

public class Calculator extends Thread {

	// field
	private int from;
	private int to;
	private int result;
	
	// method
	@Override
	public void run() {
		addition();
	}
	public void addition() {
		// from부터 to까지 모든 정수 더해서 result에 저장
		if (from > to) {
			int temp = from;
			from = to;
			to = temp;
		} 
		for (int n = from; n <= to; n++) {
			result += n;
		}
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	
}
