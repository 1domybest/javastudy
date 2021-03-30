package ex04_priority;

public class Watch extends Weekend implements Runnable {
	@Override
	public void run() {
		System.out.println("TV를 봅니다.");		
	}
}