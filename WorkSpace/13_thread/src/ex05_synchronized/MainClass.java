package ex05_synchronized;

public class MainClass {
	public static void main(String[] args) {
		//청소기 1대
		Dyson v11 = new Dyson();

		//엄마,아빠
		Mama mama = new Mama();
		Papa papa = new Papa();
		
		mama.setDyson(v11);
		mama.start();
		papa.setDyson(v11);
		papa.start();
	}
}
