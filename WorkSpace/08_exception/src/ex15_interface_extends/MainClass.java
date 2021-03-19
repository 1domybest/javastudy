package ex15_interface_extends;

public class MainClass {
	public static void main(String[] args) {
		
		Phone phone1 = new SmartPhone();
		phone1.sendCall();
		
		((Computable)phone1).playApp();
		
		Computable phone2 = new SmartPhone();
		((Phone)phone2).sendCall();
		phone2.playApp();
		
		SmartPhone phone3 = new SmartPhone();
		phone3.sendCall();
		phone3.playApp();
		
		 
	}
}
