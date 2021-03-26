package dto;

import java.sql.Date;

import lombok.Data;

@Data
public class StaffDto {
	
	private int no;
	private String name;
	private String department;
	private Date hireDate;
	
	
	@Override
	public String toString() {
		return "\n+++++++++++++++++++++++++\n"+" 사원번호 : " + no + "\n 이름 : " + name + "\n 부서 : " + department + "\n 입사일 : " + hireDate + "\n+++++++++++++++++++++++++\n";
	}
	
}
