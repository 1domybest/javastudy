package ex02;

public class Player implements Runnable{
	
	private String name;

	public Player(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			
			System.out.println(name+" 이(가) 게임중입니다.");
		}
	}
	
}
