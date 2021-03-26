package ex01_char;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderMainClass2 {
	public static void main(String[] args) {
		try (FileReader fr = new FileReader("text3.txt")){
			char[] cbuf =new char[5];
			while(true) {
				int readCharCount = fr.read(cbuf); //읽은 내용은 cubf에 저장되고, readCharCount 에는 읽은 글자수가 저장됩니다.
												   //파일의 끝에 도달하면 -1을 readCharCount 에 반환합니다.
				if(readCharCount == -1) {
					break;
				}
				System.out.print(cbuf);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
