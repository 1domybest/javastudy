package ex13_interface;

public interface Shape { //interface <-> abstract class  비슷한 개념
	/*
	 * 인터페이스
	 * 1. 모든 메소드가 추상 메소드인 추상 클래스 입니다.
	 * 2. jdk 1.8 이후 디폴트 메소드와 스테틱 메소드를 가질수 있습니다.
	 * 3. 모든 필드는 final 상수를 가집는다.
	 */
	
	public abstract double getArea(); //interface 는 public abstract를 생략해도 자동으로 삽입돠어 처리된다.
}
