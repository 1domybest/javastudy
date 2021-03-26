package ex01_char;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderMainClass {
	/*
	 * FileReader 클래스
	 * 1."문자 기반"+입력 스트림"입니다.(Reader)
	 * 2.문자를 읽을때 사용합니다.
	 * 	1)통신: 상대방이 보낸 문자를 받을때
	 * 	2)파일 : 텍스트 파일을 읽을때
	 * 3.입력메소드
	 *  	read()
	 *  4.입력단위
	 *  	char[],int
	 *  5.예외처리가 필요합니다.
	 */
	public static void main(String[] args) {
		try (FileReader fr = new FileReader("text2.txt")){
			//read() 메소드를 이용해서 읽기
			while(true) {
				int ch = fr.read(); //읽은 문자 또는 -1 이 ch에 저장됩니다.
				if(ch ==-1) {
					break;
				}else {
					System.out.print((char)ch);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
