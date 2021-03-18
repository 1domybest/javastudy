package quiz04;

public class MainClass {
	public static void main(String[] args) {
		Fighter korean = new KoreanFighter("정찬성", energy, power);
		Fighter global = new GlobalFighter("에드가", energy, power);
		
		//선빵 결정
		boolean myTurn = Math.random() < 0.5;
		
 		do {
 			if(myTurn) {
 				korean.attack(global);
 			}else {
 				global.attack(korean);
 			}
 		}while()
		
		
	}
}
