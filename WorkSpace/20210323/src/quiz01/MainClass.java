package quiz01;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//임의의 member를 3명 저장하고,
//사용자로부터 회원 번호를 입력받아서 해당회원의 삭제를 진행하시오.

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Member m1 = new Member(1,"user1",new Date(System.currentTimeMillis()));
		Member m2 = new Member(2,"user2",new Date(System.currentTimeMillis()));
		Member m3 = new Member(3,"user3",new Date(System.currentTimeMillis()));
		
		List<Member> members = new ArrayList<Member>();
		members.add(m1);
		members.add(m2);
		members.add(m3);
		
		System.out.print("삭제할 회원번호를 입력하세요>>>");
		int mNo = sc.nextInt();
		
		int length = members.size();
		int removeIdx = -1; //삭제할 회원의 인덱스
		
		for (int i = 0; i < length; i++) {
			if(members.get(i).getMNo() == mNo) {				
				removeIdx = mNo; //삭제할 회원의 인덱스
			}
			if(removeIdx == -1) {
				
				System.out.println(mNo+"의 번호는 존재하지 않거나 비어있습니다");
				break;
			}else {
				members.remove(removeIdx-1);
				System.out.println(mNo+"회원 번호를 가진 회원 정보를 삭제했습니다");
				break;
			}
		}
		
		//Member 클래스는 toString() 메소드가 오바라이드 되어 있으므로
		//sout(m1)처럼 출력이가능
		System.out.println("한번에 확인: "+members);
		System.out.println("순회");
		for (Member member : members) {
			System.out.println(member);
		}
		
		
		
		
		

	}
}
