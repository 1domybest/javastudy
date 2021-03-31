package ex02_socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMainClass {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket client = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			
			// 서버 생성
			server = new ServerSocket();
			server.bind(new InetSocketAddress("localhost", 4966));
			
				
				// 클라이언트 접속처리
				System.out.println("=====서버가 동작하고 있습니다.=====");
				client = server.accept();
				InetSocketAddress isa = (InetSocketAddress)client.getRemoteSocketAddress();
				System.out.println("접속 클라이언트: [" + isa.getHostName() + "]");
				
				while (true) {
				// 클라이언트가 보낸 메시지 받기
				bis = new BufferedInputStream(client.getInputStream());
				byte[] b = new byte[1024];
				int length = bis.read(b);  // 메시지: b, 메시지글자수: length
				String message = new String(b, 0, length, "UTF-8");
				System.out.println(message);
				
	
					bos = new BufferedOutputStream(client.getOutputStream());
					System.out.print("클라이언트 에게 답변하세요>>>");
					String answer = sc.next();
					bos.write(answer.getBytes("UTF-8"));
					bos.flush();
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) {bos.close();}
				if(bis != null) {bis.close();}
				if ( !server.isClosed() ) {
					server.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}