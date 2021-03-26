package quiz01;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

//사용자로부터 국,영,수 점수를 입력 받은뒤,
//int[] 배열에 저장한다.
//score.dat 파일에 이름,입력받은 점수와,평균을 저장하시오.
//score.dat 파일을 읽어서 저장을 확인하시오

public class MainClass {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream("newscore.dat"));
			System.out.print("국어>>>");
			int kor = sc.nextInt();
		
			System.out.print("영어>>>");
			int eng = sc.nextInt();
			System.out.print("수학>>>");
			int math = sc.nextInt();
			double avg = (kor+eng+math)/3;
			
		
			dos.writeInt(kor);
			dos.writeInt(eng);
			dos.writeInt(math);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(dos != null) {dos.close();}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
