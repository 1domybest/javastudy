package quiz05_starcraft;

public class MainClass {
	public static void main(String[] args) {
		
		
		Bunker bk = new Bunker();
		
		bk.add(new Marine());
		bk.add(new FireBat());
		bk.add(new Tank());//불가능 

	}
}
