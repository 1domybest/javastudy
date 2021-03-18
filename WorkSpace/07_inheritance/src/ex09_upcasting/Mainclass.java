package ex09_upcasting;

public class Mainclass {
	public static void main(String[] args) {
		Coffee coffee =new Coffee("카카오");
		Espresso espresso = new Espresso("카카오", 1);
		Latte  latte = new Latte("카카오", 0, 2);
		
		//upcasting 이 없는경우
		//=>타입이 다르다: 커피마다 커피를 담는 컵이 다르다.
		
		//upcasting 을 사용하는 경우
		
		Coffee coffee1 = new Espresso("카카오", 1);
		Coffee coffee2 = new Latte("카카오", 1,15);
		

		
		coffee1.info();
		coffee1.taste();
		
		coffee2.info();
		coffee2.taste();
		
		
	}
}
