package quiz03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMainClass {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in); 
			BufferedReader br = null;
			BufferedWriter bw = null;
			ServerSocket server = null;
			Socket client = null;
			try {
				String exit = "종료";
				System.out.println("====서버 접속중====");
				server = new ServerSocket();
				server.bind(new InetSocketAddress("localhost",4966));
				client = server.accept();
				InetSocketAddress isa = (InetSocketAddress)client.getRemoteSocketAddress();
				System.out.println("["+isa.getHostName()+"] 클라이언트에 접속하였습니다");
				
				
				while(true) {
					br = new BufferedReader(new InputStreamReader(client.getInputStream(),"UTF-8"));
					bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),"UTF-8"));
					
					String message = br.readLine();
					if(message.equals("종료")) {
						System.out.println("대화상자를 종료합니다.");
						break;
					}
					System.out.println(message);
					
					System.out.print("클라이언트 에게 >>>");
					String send = sc.nextLine();
					bw.write(send+"\n");
					bw.flush();
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(bw != null) {bw.close();}
					if(br != null) {br.close();}
					if(!client.isClosed()) {client.close();}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	}

}