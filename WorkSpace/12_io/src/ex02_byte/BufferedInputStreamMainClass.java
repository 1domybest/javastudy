package ex02_byte;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamMainClass {
	public static void main(String[] args) {
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("byte2.txt"))) {
			
			byte[] bytes = new byte[5];
			while(true) {
				int readByte = bis.read(bytes); //읽은 데이터는 bytes 배열에 저장 , 식제 읽은 바이트수가 readByte 에 저장
				if(readByte == -1) {
					break;
				}
				System.out.print(new String(bytes));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
