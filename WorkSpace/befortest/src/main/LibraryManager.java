package main;

import java.util.Scanner;

import dao.LibraryDao;
import dto.LibraryDto;

public class LibraryManager {
	private Scanner sc = new Scanner(System.in);
	private LibraryDao dao = new LibraryDao();
	
	public void menu() {
		System.out.println("=====사원 관리 프로그램=====");
		System.out.println("1.책 등록");
		System.out.println("2.책 정보 수정");
		System.out.println("3.책 정보 삭제");
		System.out.println("4.책 검색");
		System.out.println("5.책 전체 조회");
		System.out.println("6.프로그램 종료");
		System.out.println("============================");
	}
	public void execute() {
		while(true) {
			menu();
			System.out.print("선택 (1~6) >>>");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
				default :
					System.out.println("잘못 입력하였습니다");
			}
		}
	}
	public void addBook() {
		System.out.print("추가하실 책의 제목을 입력하세요");
		String title = sc.next();
		System.out.print("추가하실 책의 저자를 입력하세요");
		String writer = sc.next();
		LibraryDto dto = new LibraryDto();
		dto.setBookNo(dao.MaxNo()+1);
		dto.setBookTitle(title);
		dto.setBookWriter(writer);
		
		int result = dao.addBook(dto);
		
		if(result == 0) {
			System.out.println("추가에 실패하였습니다");
		}else {
			System.out.println(result + "권의 책의정보를 추가하였습니다");
		}
		
		
	}
	public void selectBook() {
		System.out.println("검색하실 책의 고유번호를 입력하세요");
		int no = sc.nextInt();
		
		LibraryDto dto = new LibraryDto();
		LibraryDto result = dao.selectBook(no);
		
		if(result ==null) {
			System.out.println(no+"번의 책은 존재하지않습니다");
		}else {
			System.out.println(result);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
