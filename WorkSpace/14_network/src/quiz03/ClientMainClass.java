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

public class ClientMainClass {

	public static void main(String[] args) {

		Socket client = null;
		Scanner sc = new Scanner(System.in); 
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			client = new Socket();
			
			client.connect(new InetSocketAddress("localhost",4966));
			System.out.println("접속성공");
			while(true) {
				
				br = new BufferedReader(new InputStreamReader(client.getInputStream(),"UTF-8"));
				bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),"UTF-8"));
				
				
				System.out.print("서버 에게 >>>");
				String send = sc.nextLine();
				
				bw.write(send+"\n");
				bw.flush();
				
				
				String message = br.readLine();
				if(message.equals("종료")) {
					System.out.println("대화상자를 종료합니다.");
					break;
				}
				System.out.println(message);
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