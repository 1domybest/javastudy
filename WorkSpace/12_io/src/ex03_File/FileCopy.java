package ex03_File;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		//원본 Wave.mp4
		//FIleIntputStream 을 통해서 읽습니다
		//속도를 높이기 위해서 BufferedInputStream 을 사용합니다
		BufferedInputStream bis = null;
		
		//복사본 C:\\MyTemp\\Wava.mp4
		//경로 지정을 위해서 File 클래스를 사용하고,
		//FileOutPutStream을 통해서 만듭니다
		File cpy = new File("C:\\MyTemp\\Wave.mp4");
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream (new FileInputStream("Wave.mp4"));//현재 디랙터리의 wave.mp4
			bos = new BufferedOutputStream(new FileOutputStream("C:\\MyTemp\\Wave.mp4")); //C:\\MyTemp디렉터리의 wava.mp4
			//복사시작시간
			
			long start = System.currentTimeMillis();
			byte[] bytes = new byte[1024];
			int length = 0;
			while((length = bis.read(bytes)) != -1) {
				bos.write(bytes, 0, length);
			}
			long end = System.currentTimeMillis();
			System.out.println(cpy.getAbsolutePath()+"파일이 복사되었습니다.");
			System.out.println("복사 소요시간: "+(end-start) * 0.001+"초");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bos != null) {bos.close();}
				if(bis != null) {bis.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
