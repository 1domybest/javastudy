package ex05_socket.copy;

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
				server = new ServerSocket();
				server.bind(new InetSocketAddress("localhost",4966));
				System.out.println("=====서버에 접속하였습니다=====");
				client = server.accept();
				InetSocketAddress isa = (InetSocketAddress)client.getRemoteSocketAddress();
				System.out.println("["+isa.getHostName()+"] 클라이언트에 연결되었습니다.");
				String exit = "종료";
			
				while(true) {
					
					
					bis= new BufferedInputStream(client.getInputStream());
					byte[] b = new byte[1024];
					int length = bis.read(b);
					String answer = new String(b,0,length,"UTF-8");
					System.out.println(answer);
					if(answer.equals(exit)) {
						System.out.println("====대화상자가 종료됩니다====");
						break;
					}
					
					bos =new BufferedOutputStream(client.getOutputStream());
					System.out.print("클라이언트에게 >>>");
					String message = sc.nextLine();
					bos.write(message.getBytes("UTF-8"));
					if(message.equals(exit)) {
						System.out.println("====대화상자가 종료됩니다====");
						break;
					}
					
					bos.flush();
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(bos != null) {bos.close();}
					if(bis != null) {bis.close();}
					//마지막에 쓴것을 먼저닫음
					if(!client.isClosed()) {client.close();}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
			
			
		} 
	
	}

