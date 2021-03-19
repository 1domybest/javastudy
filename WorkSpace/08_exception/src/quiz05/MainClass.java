package quiz05;

public class MainClass {
	public static void main(String[] args) {
		Cal c = new Cal();
		
		try {
			c.add(10);
			c.minor(10);
			c.times(10);
			c.split(10);
			
		} catch (Exception e) {
			System.out.println("예외 발생");
			e.printStackTrace();
		}
		
	}
}
