package ex04_socket_thread;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMainClass {
	public static void main(String[] args) {
		Socket client = null;
		Scanner sc = null;
		File dir  = null;
		File file = null;
		DataOutputStream dos = null;
		BufferedInputStream bis = null;
		
		try {
			client = new Socket();
			client.connect(new InetSocketAddress("localhost",4966));
			
			while(true) {
			sc =new Scanner(System.in);
			System.out.print("전송할 파일을 입력>>>");
			String fileName= sc.nextLine();
			dir = new File("C:\\MyClient");
			file = new File(dir,fileName);
//			
//			if(!dir.exists() || !file.exists()) {
//				System.out.println(dir.getName()+"이란 폴더가 존재하지 않거나\n"+file.getName()+"이란 파일이 존재하지 않습니다.");
//				return;
//			}else if(fileName.equals("종료")) {
//				System.out.println("====프로그램을 종료합니다====");
//				break;
//			}
			//서버로 파일명 보내기
			dos = new DataOutputStream(client.getOutputStream());
			dos.writeUTF(fileName);
			
			//파일내용을 읽어서 서버로 파일내용 보내기.
			//파일내용을 읽기 위해서 FIleInputStream 이 필요합니다
			//성능을 높이기 위해서 BufferedInputStream 을 사용합니다.
			
			bis= new BufferedInputStream(new FileInputStream(file));
			byte [] b =new byte[1024];
			int length = 0;
			while((length = bis.read(b))!= -1) {
				dos.write(b,0,length);
			
			}
			System.out.println(file.getAbsolutePath()+" 파일을 서버로 전송했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bis != null) {bis.close();}
				if(dos != null) {dos.close();}
				if(!client.isClosed()) {client.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
