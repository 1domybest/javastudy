package quiz11;

import java.util.Scanner;

public class WeekScheduler {

	// field
	private int nthWeek;
	private Day[] week;
	private String[] weekNames = { "일", "월", "화", "수", "목", "금", "토" };
	private Scanner sc = new Scanner(System.in);
	
	// constructor
	public WeekScheduler(int nthWeek) {
		this.nthWeek = nthWeek;
		week = new Day[7];
		for (int i = 0; i < week.length; i++) {
			week[i] = new Day();
		}
	}
	
	// method
	
	// 1. run()
	public void run() {
		while (true) {
			menu();
			System.out.print("작업 선택 >>> ");
			int choice = sc.nextInt();
			sc.nextLine();  // choice 입력 뒤에 남아 있는 엔터를 제거하기 위한 코드
			switch (choice) {
			case 1 : makeSchedule(); break;
			case 2 : deleteSchedule(); break;
			case 3 : updateSchedule(); break;
			case 4 : searchSchedule(); break;
			case 5 : printAllSchedule(); break;
			case 0 : exit();  return;  // run() 메소드의 실행을 종료하는 코드
			default : System.out.println("없는 작업입니다. 다시 입력하세요.");
			}
		}
	}
	
	// 2. menu()
	public void menu() {
		System.out.println("=====스케쥴러=====");
		System.out.println("1. 스케쥴 만들기");
		System.out.println("2. 스케쥴 삭제하기");
		System.out.println("3. 스케쥴 수정하기");
		System.out.println("4. 스케쥴 조회하기");
		System.out.println("5. 전체 스케쥴 보기");
		System.out.println("0. 프로그램 종료하기");
		System.out.println("===================");
	}
	
	// 3. exit()
	public void exit() {
		System.out.println("스케쥴러를 종료합니다.");
		sc.close();
	}
	
	// 4. makeSchedule()
	public void makeSchedule() {
		System.out.println("===스케쥴 만들기===");
		System.out.print("스케쥴을 등록할 요일(일~토) 입력 >>> ");
		String weekName = sc.next();
		weekName = weekName.substring(0, 1);  // 0 <= 추출할문자열 < 1
		sc.nextLine();  // 요일 입력 뒤에 남아 있는 엔터 제거
		for (int i = 0; i < week.length; i++) {
			if (weekNames[i].equals(weekName)) {
				if (week[i].getSchedule() == null || week[i].getSchedule().isEmpty()) {
					System.out.print(weekName + "요일의 신규 스케쥴 >>> ");
					String schedule = sc.nextLine();
					week[i].setSchedule(schedule);
					System.out.println(weekName + "요일에 신규 스케쥴이 저장되었습니다.");
				} else {
					System.out.println(weekName + "요일은 이미 스케쥴이 있습니다.");
				}
				break;  // for문 종료
			}
		}
	}
	
	// 5. deleteSchedule()
	public void deleteSchedule() {
		System.out.println("===스케쥴 삭제===");
		System.out.print("스케쥴을 삭제할 요일(일~토) 입력 >>> ");
		String weekName = sc.next();  // 만약 "화요일"이라고 입력을 했다면,
		weekName = weekName.substring(0, 1);  // 0 <= 추출할문자열 < 1
		for (int i = 0; i < week.length; i++) {
			if (weekNames[i].equals(weekName)) {
				if (week[i].getSchedule() == null || week[i].getSchedule().isEmpty()) {
					System.out.println(weekName + "요일은 스케쥴이 없습니다.");
				} else {
					System.out.println(weekName + "요일의 스케쥴은 다음과 같습니다.");
					System.out.println("[" + week[i].getSchedule() + "]");
					System.out.print("삭제할까요(Y/N) ? >>> ");
					String yesNo = sc.next();
					yesNo = yesNo.substring(0, 1);
					if (yesNo.equalsIgnoreCase("Y")) {
						week[i].setSchedule(null);
						System.out.println(weekName + "요일의 스케쥴이 삭제되었습니다.");
					} else {
						System.out.println("삭제가 취소되었습니다.");
					}
				}
				break;
			}
		}
	}

	// 6. updateSchedule() : 있으면 수정, 없으면 새로 등록
	public void updateSchedule() {
		System.out.println("===스케쥴 수정===");
		System.out.print("스케쥴을 수정할 요일(일~토) 입력 >>> ");
		String weekName = sc.next();
		weekName = weekName.substring(0, 1);
		sc.nextLine();
		for (int i = 0; i < week.length; i++) {
			if (weekNames[i].equals(weekName)) {
				if (week[i].getSchedule() == null || week[i].getSchedule().isEmpty()) {
					System.out.println(weekName + "요일은 스케쥴이 없습니다.");
					System.out.print("새로운 스케쥴을 등록하시겠습니까(Y/N)? >>> ");
					String yesNo = sc.next();
					sc.nextLine();
					if (yesNo.charAt(0) == 'Y' || yesNo.charAt(0) == 'y') {
						System.out.print(weekName + "요일의 신규 스케쥴 입력 >>> ");
						String schedule = sc.nextLine();
						week[i].setSchedule(schedule);
						System.out.println(weekName + "요일에 신규 스케쥴이 저장되었습니다.");
					} else {
						System.out.println("스케쥴 수정이 취소되었습니다.");
					}
				} else {
					System.out.println(weekName + "요일의 스케쥴을 확인합니다.");
					System.out.println("[" + week[i].getSchedule() + "]");
					System.out.print("스케쥴을 수정할까요(Y/N)? >>> ");
					String yesNo = sc.next();
					sc.nextLine();
					if (yesNo.charAt(0) == 'Y' || yesNo.charAt(0) == 'y') {
						System.out.print(weekName + "요일의 수정 스케쥴 입력 >>> ");
						String schedule = sc.nextLine();
						week[i].setSchedule(schedule);
						System.out.println(weekName + "요일의 스케쥴이 수정되었습니다.");
					} else {
						System.out.println("스케쥴 수정이 취소되었습니다.");
					}
				}
				break;
			}
		}
	}
	
	// 7. searchSchedule()
	public void searchSchedule() {
		System.out.println("===스케쥴 조회===");
		System.out.print("스케쥴을 조회할 요일(일~토) 입력 >>> ");
		String weekName = sc.next();
		weekName = weekName.substring(0, 1);  // weekName.charAt(0) + "";
		for (int i = 0; i < week.length; i++) {
			if (weekNames[i].equals(weekName)) {
				System.out.println(weekName + "요일의 스케쥴입니다.");
				week[i].info();
				return;  // searchSchedule() 메소드의 종료
			}
		} 
		System.out.println(weekName + "요일은 존재하지 않습니다.");
	}
	
	// 8. printAllSchedule()
	public void printAllSchedule() {
		System.out.println("===" + nthWeek + "주차 전체 스케쥴===");
		/*
		for (Day day : week) {
			day.info();
		}
		*/
		for (int i = 0; i < week.length; i++) {
			System.out.print(weekNames[i] + "요일 스케쥴: ");
			week[i].info();
		}
	}
	
}