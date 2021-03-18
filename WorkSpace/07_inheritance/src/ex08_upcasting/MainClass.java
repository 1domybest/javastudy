package ex08_upcasting;

public class MainClass {
	public static void main(String[] args) {
		Tv tv = new Tv(200, "LG-75");
		tv.info(); //tv클래스의 info호출
		
		Elec elec = tv;
		elec.info(); //tv타입의 객체를 elec 타입으로 변경
						//서브> 슈퍼타입으로 변경하는 것으로 업케스팅
					//upcastiog 은 별고 케스팅 문법이 없습니다
		
		
		/*
		 * 메소드 호출
		 * 1. 객체의 타입에 따라 결정됩니다.
		 * 		호출할 메소드를 결정하는것을 바인딩 이라고합니다
		 * 2.자바는 동적바인딩 입니다
		 * 	1) 메소드 호출 시점(실행전) 에는 객체의 타입을 봅니다. 
		 * 		Elec elec = tv; 이므로 elec.info();는 Elec의 info()입니다.
		 * 
		 * 	2)객체를 확인합니다.
		 * 		Tv tv = new Tv(200, "LG-75"); 이므로 tv객체가 Tv타입이라는것을 확인할수 있다
		 * 	3)실제 객체의 타입으로 바꿔서 호출한다
		 * 	 	elec.info(); 가 실행될때는 Tv의 info()가 호출됩니다. 
		 */
		Elec elec2 = new Tv(300,"Samsung-85");
		elec2.info();
	}
}
