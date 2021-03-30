package ex02_socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientMainClass {
	public static void main(String[] args) {
		
		//Socket : 클라이언드
		Socket sk = null;
		
		try {
			//클라이언트 생성
			sk = new Socket();
			
			//클라이언트가 서버에 접속을 시도
			sk.connect(new InetSocketAddress("localhost", 4966));
			//sk.connect(new InetSocketAddress(InetAddress.getByName("localhost"),4966));
			
			//접속 성공
			System.out.println("서버에 접속되었습니다.");
			
			//웰컴 메시지 받기
			InputStream is = sk.getInputStream();
			byte[] b = new byte[50]; //welcome to my server 를 저장할 정도의 크기
			int length = is.read(b); //읽은 내용은 b에 저장 실제로 읽은 바이트 수는 length에 저장
			String message = new String(b, 0, length, "UTF-8");
			System.out.println(message);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(sk.isClosed()) {sk.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
