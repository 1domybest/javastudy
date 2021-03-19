package ex04_finally;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a ;
		try {
			System.out.print("정수를 입력하세요 >>>");
			a = sc.nextInt();
			System.out.println("입력은 "+a+" 입니다.");
		} catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
			e.printStackTrace();
		}finally { //무조건
			System.out.println("프로그램을 종료합니다");
			sc.close();
		}
		
	}
}
