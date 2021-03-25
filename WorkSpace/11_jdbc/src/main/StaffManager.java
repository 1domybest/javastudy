package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.StaffDao;
import dto.StaffDto;

public class StaffManager {
	
	//필드
	private StaffDao dao = StaffDao.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	
	//메소드
	public void menu() {
		System.out.println("=====사원 관리 프로그램=====");
		System.out.println("1.사원 등록");
		System.out.println("2.정보 수정");
		System.out.println("3.퇴사 처리");
		System.out.println("4.사원 검색");
		System.out.println("5.전체 조회");
		System.out.println("6.프로그램 종료");
		System.out.println("============================");
		
	}
	public void excute() {
		while(true) {
		menu();	
		System.out.print("선택(1~6)>>>");
		switch(sc.nextInt()) {
		case 1 : insertStaff(); 
		
			break;
		case 2 :
			updateStaff();
			break;
		case 3 :
			deleteStaff();
			break;
		case 4 :
			searchStaff();
			break;
		case 5 :
			FullSearch();
			break;
		case 6 :
			System.out.println("프로그램을 종료합니다.");
			return;
		default : System.out.println("잘못 입력하였습니다.");
		}
	}
}
	
	public void insertStaff() {
		System.out.print("신규 사원이름 이름>>>");
		String name = sc.next();
		System.out.print("신규 부서 이름>>>");
		String department = sc.next();
		
		StaffDto dto = new StaffDto();
		int no = dao.selectMaxNo();
		dto.setNo(no+1);
		dto.setName(name);
		dto.setDepartment(department);
		
		int result = dao.insertStaff(dto);
		System.out.println(result+" 명의 사원이 등록 되었습니다.");
	}
	
	public void updateStaff() {
		System.out.print("수정할 사원번호 >>>");
		int no = sc.nextInt();
		StaffDto dto = dao.searchStaff(no);	
		System.out.print("수정할 내용을 선택하세요. (1.이름 2.부서) >>>");
		int choice = sc.nextInt();
		if(choice ==1) {
			System.out.print("새로운 사원 이름 입력>>>");
			String name = sc.next();
			dto.setName(name);
			
		}else if(choice ==2) {
			System.out.print("새로운 부서 이름 입력>>>");
			String department = sc.next();
			dto.setDepartment(department);
			
		}else {
			System.out.println("잘못 입력하였습니다.");
			return;
		}

		int result = dao.updateStaff(dto);
		System.out.println(result+" 명의 사원의 정보를 수정 하였습니다.");
		return;
		
		
	}
	public void deleteStaff() {
		System.out.print("삭제할 사원번호>>>");
		int no = sc.nextInt();
		StaffDto dto = new StaffDto();
			dto.setNo(no);
			int result = dao.deleteStaff(dto);
			System.out.println(result+"번의 회원정보가 삭제되었습니다");

		
	}
	public void searchStaff() {
		System.out.print("조회할 사원번호>>>");
		int no = sc.nextInt();
		StaffDto staffdto = dao.searchStaff(no);
		if(staffdto == null) {
			System.out.println("사원번호" +no+" 을 가진 사원이 없습니다");
		}else {
			System.out.println(staffdto);
		}
	}
	
	public void FullSearch() {
		List<StaffDto> staffList = dao.FullSearch();
		System.out.println("총 사원수 :"+ staffList.size());
		for (StaffDto staffDto : staffList) {
			System.out.println(staffDto);
		}
	}

	
}





















