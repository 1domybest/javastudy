package ex02_byte;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//복사프로그램

public class FileCopyProgram {
	public static void main(String[] args) {
		BufferedInputStream bis =null;
		BufferedOutputStream bos =null;
		try {
			bis = new BufferedInputStream(new FileInputStream("wave.mp4"));
			bos = new BufferedOutputStream(new FileOutputStream("wave2.mp4"));
			byte[] b = new byte[1024]; //1KB 
			while(true) {
				int readByte = bis.read(b); //영상 저장은 b ,실제 읽은 바이트수는 readByte
				if(readByte == -1) {
					break;
				}
				bos.write(b,0,readByte);
					}
			System.out.println("wava2.mp4 파일이 복사되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bos!=null) {bos.close();}
				if(bis!=null) {bis.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
