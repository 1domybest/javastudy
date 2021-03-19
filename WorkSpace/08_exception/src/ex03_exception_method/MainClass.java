package ex03_exception_method;

public class MainClass {
	public static void main(String[] args) {
		try {
			int a= 2/0;
			
		} catch (Exception e) {
			System.out.println("예외 메시지" +e.getMessage());
			e.printStackTrace(); //개발자가 넣어 두는코드(디버깅하기 쉽도록 만드는 코드)
		}
	}
}
