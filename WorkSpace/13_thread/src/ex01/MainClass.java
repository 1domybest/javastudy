package ex01;

public class MainClass {
	public static void main(String[] args) {
		Person p1 = new Person("자두");
		Person p2 = new Person("스폰지밥");
		Person p3 = new Person("브레드");
		
		p1.start();
		p2.start();
		p3.start();
		
		System.out.println("모두 식사가 끝났습니다."); //스레드 상황에서는 틀린 메시지 입니다.
		

	}
}
