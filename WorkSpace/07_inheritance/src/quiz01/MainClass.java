package quiz01;

public class MainClass {

	public static void main(String[] args) {
		
		// 월급쟁이
		SalaryMan staff1 = new SalaryMan("james", 300);
		System.out.println(staff1.getName());
		System.out.println(staff1.getPay());
		
		// 판매직
		SalesMan staff2 = new SalesMan("alice", 100);
		staff2.setSalesAmount(2000);
		System.out.println(staff2.getName());
		System.out.println(staff2.getPay());
		
		// 알바
		Alba staff3 = new Alba("david");
		staff3.setPayPerHour(1);
		staff3.setTimes(200);
		System.out.println(staff3.getName());
		System.out.println(staff3.getPay());

	}

}
