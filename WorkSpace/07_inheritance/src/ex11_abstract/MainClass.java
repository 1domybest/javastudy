package ex11_abstract;

public class MainClass {
	public static void main(String[] args) {
		Staff staff = new SalaryMan("온석태", 10000);
		staff.info();
		//staff 의 getpay는 어떻게 호출?
		//1. staff클래스에 getpay를 추가합니다
		//->모든 staff는 getpay를 가져야하므로 1번으로 해결합니다.
		//2. 다운캐스팅
		System.out.println(staff.getPay());
		
	}
}
