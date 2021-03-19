package ex15_interface_extends;

public class SmartPhone extends Phone implements Computable {

	@Override
	public void playApp() {
		System.out.println("앱을 실행합니다");
		
	}

	@Override
	public void sendCall() {
		super.sendCall();
	}

}
