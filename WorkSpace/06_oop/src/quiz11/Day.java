package quiz11;
//변경
public class Day {

	// field
	private String schedule;

	// constructor
	
	// method
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public void info() {
		if (schedule == null || schedule.isEmpty()) {  // null 또는 빈문자열("")
			System.out.println("[없음]");
		} else {
			System.out.println("[" + schedule + "]");
		}
	}
	
}