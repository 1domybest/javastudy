package quiz04;

import java.util.Random;

public class GlobalFighter extends Fighter {

	public GlobalFighter(String name, int energy, int power) {
		super(name, energy, power);
		// TODO Auto-generated constructor stub
	}

	//attack() : 10% 확률로 한방에 ko시킬수 있다
	@Override
	public void attack(Fighter fighter) {
		Random r = new Random();
		
		
	}

}
