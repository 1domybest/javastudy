package main;

import java.util.Scanner;

import dao.StaffDao;
import dto.StaffDto;

public class StaffManager {
	private StaffDao dao = StaffDao.getInstance();
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		System.out.println("==================");
		System.out.println("1.사원 추가");
		System.out.println("2.정보 수정");
		System.out.println("3.퇴사 처리");
		System.out.println("4.사원 조회");
		System.out.println("5.전체 조회");
		System.out.println("6.프로그램 종료");
		System.out.println("==================");
	}
	public void run() {
		menu();
		System.out.print("선택(1~6)>>>");
		int choice = sc.nextInt();
		while(true) {
			switch(choice) {
			case 1 :
				addStaff();
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
				staffList();
				break;
			case 6 :
				System.out.println("프로그램을 종료합니다.");
				return;
				default :
					System.out.println("잘못 입력하였습니다");

			}
		}
	}
	
	
	public void addStaff() {
		StaffDto dto = new StaffDto();
		System.out.print("사원의 이름을 입력하세요 >>>");
		String name = sc.next();
		System.out.print("사원의 부서를 입력하세요 >>>");
		String department = sc.next();
		
		dto.setNo(dao.MaxNo()+1);
		dto.setName(name);
		dto.setDepartment(department);
		
		int result = dao.addStaff(dto);
		if(result ==0) {
			System.out.println("실패하였습니다");
		}else {
			System.out.println(result +"명 사원의 정보를 추가하였습니다.");
		}
	}
	
	public void updateStaff() {
		
	}
	public void deleteStaff() {
		
	}
	public void searchStaff() {
		
	}
	public void staffList() {
		
	}
	
}





























