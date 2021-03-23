package quiz03;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

//로또 번호 6개를 HashSet에 저장하기S
public class MainClass {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		Random r = new Random();
		
		while(set.size()!=6) {
			
			set.add((int)(Math.random()*45)+1);

		}
	
		
		for (Integer string : set) {
			System.out.println(string);
		}
	}
}
