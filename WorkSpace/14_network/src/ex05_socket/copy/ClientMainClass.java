package ex05_socket.copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMainClass {
	public static void main(String[] args) {

			Socket client = null;
			Scanner sc = new Scanner(System.in);
			BufferedInputStream bis =null;
			BufferedOutputStream bos = null;
			
			System.out.println("대화를 종료하시려면 (\"종료\" 를 입력하세요)");
			String exit = "종료";
			try {
				client = new Socket();
				client.connect(new InetSocketAddress("localhost",4966));
				System.out.println("클라이언트 접속성공");
				
				while(true) {
					
					bos = new BufferedOutputStream(client.getOutputStream());
					System.out.print("서버에게 >>>");
					String message = sc.nextLine();
					
					bos.write(message.getBytes("UTF-8"));
					
					if(message.equals(exit)) {
						System.out.println("====대화상자가 종료됩니다====");
						break;
					}
					
					
					bos.flush();
					
					bis = new BufferedInputStream(client.getInputStream());
					byte [] b = new byte[1024];
					int length = bis.read(b);
					String answer = new String(b,0,length,"UTF-8");
					if(answer.equals(exit)) {
						System.out.println("====대화상자가 종료됩니다====");
						break;
					}
					 
					System.out.println(answer);
				}
						
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(bis != null) {bis.close();}
					if(bos != null) {bos.close();}
					//마지막에 쓴것을 먼저닫음
					if(!client.isClosed()) {client.close();}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
	}
}
