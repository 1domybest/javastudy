package ex10_downcasting;

public class MainClass {
	public static void main(String[] args) {
		Person p1 ;
		p1 = new Student();
		p1.eat();
		p1.sleep();
	
		//person 타입의 p1을 student타입으로 변경하면 해결됩니다.
		//1.(Student)p1 : p1을 Student로 캐스팅합니다.(다운케스팅)
		//2.(Student)p1.student() : 정상 작동하지 않습니다.
		// 연산자 최우선 순위: 마침표(.)이므로  p1.study()가 먼저 호출되기 때문입니다.
		//3.((Student)p1).study(); : 캐스팅을 먼저 처리하고 나면 study의 호출이 가능해집니다
		
		((Student)p1).study();

		Person p2;
		p2 = new Worker();
		p2.eat();
		p2.sleep();
		((Worker)p2).work();
		
		
		//실수
		
		Person p3;
		p3= new Student();
		p3.eat();
		p3.sleep();
		//((Worker)p3).work();
		
		if(p3 instanceof Student) {
			((Student)p1).study();
		}else if(p3 instanceof Worker) {
			((Worker)p3).work();
		}
		
	}
}
