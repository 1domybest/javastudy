package ex05_synchronized;

public class Dyson {
	//critical section
	//1.임계영역
	//2.공유 자원을 관리하기 위해서 한 번에 한 스레드의 접근만 허용
	// "thread safe"하다 라고 표현합니다.
	//3.synchronized 키워드로 추가합니다.
	
	
	//synchronized
	//한 스레드만 floorCleaning()이나 homeCleaning()에 접근할수 있습니다.
	//동시 접근이 안됩니다.
	
	//method 
	public synchronized void floorCleaning() {
		try {
			System.out.println("바닥 청소를 하고 있습니다");
			Thread.sleep(1000); //1초
			notify();//다른 스레드에게 floorCleaning 이 끝났음을 알린다.
			wait(); //다른 스레드에게 실행권한을 넘긴다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public synchronized void homeCleaning() {
		try {
			System.out.println("집안을 청소하고 있습니다.");
			Thread.sleep(1000); //1초
			notify();//다른 스레드에게 floorCleaning 이 끝났음을 알린다.
			wait(); //다른 스레드에게 실행권한을 넘긴다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
