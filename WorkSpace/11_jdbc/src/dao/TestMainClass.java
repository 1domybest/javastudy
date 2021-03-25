package dao;


public class TestMainClass {
	//메소드 호출 방법
	//1. 객체(인스턴스) : private StaffDao(){} 때문에 객체 생성이 불가능 하다.
	//2. 클래스 : 클래스 메소드로 바꿔야한다.
	
	public static void main(String[] args) {
		StaffDao.getInstance();

	}
}
