package ex05_synchronized;

public class Mama extends Thread{
	private Dyson dyson;

	public Dyson getDyson() {
		return dyson;
	}

	public void setDyson(Dyson dyson) {
		this.dyson = dyson;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			dyson.floorCleaning();
		}
	}
	
	
}
