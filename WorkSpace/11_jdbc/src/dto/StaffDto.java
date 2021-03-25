package dto;

import java.sql.Date;

import lombok.Data;

//DB table 에 저장된 행(Row)을 저장하는 클래스
//VO : Value Object
//DTO : Data Transfer Object

//테이블 칼럼  클래스 필드
//BOARD_NO		board_no 또는 boardNo
//BNO			bNo

@Data //getter and setter (lombok)
//디폴트 생성자 필수 : 생성자를 안 만들거나, 디폴트 생성자와 필드를 이용한 생성자를 모두 만듭니다.
public class StaffDto {
	//field
	private int no;
	private String name;
	private String department;
	private Date hireDate;
	
	public StaffDto(){}    //<<<디폴트 생성자
 
	public StaffDto(int no, String name, String department, Date hireDate) {  //<<필드를 이용한 생성자
		super();
		this.no = no;
		this.name = name;
		this.department = department;
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "\n+++++++++++++++++++++++++\n"+" 사원번호 : " + no + "\n 이름 : " + name + "\n 부서 : " + department + "\n 입사일 : " + hireDate + "\n+++++++++++++++++++++++++\n";
	}
	
	
}
