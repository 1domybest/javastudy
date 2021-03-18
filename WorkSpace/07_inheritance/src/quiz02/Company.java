package quiz02;

public class Company {
	private Staff[] staffList;
	private int idx;
	
	
	public Company(int staffCount) {
		this.staffList = new Staff[staffCount];
	
	}
	public void hireStaff(Staff staff) {
		if(idx == staffList.length) {
			System.out.println("직원을 모두 고용했습니다.");
			return;
		}
		staffList[idx++] = staff;
	}
	
	public void staffInfo() {
		for (Staff staff : staffList) {
			if(staff != null) {
				staff.info();
			}
		}
	}
	
	
	
	
}
