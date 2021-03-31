package ex04_socket_thread;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;


public class FileUploadThread extends Thread{
	private Socket client;




	public Socket getClient() {
		return client;
	}
	
	public void setClient(Socket client) {
		this.client = client;
	}




	@Override
	public void run() {
		//클라이언트가 보낸 파일을 저장 할 디렉터리
		File dir = new File("C:\\MyServer");
		File file = null;
		BufferedOutputStream bos = null;
		DataInputStream  dis =null;
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		try {
			while(true) {
			//client 가 파일명 + 파일 내용을 보내고 있습니다.
			dis = new DataInputStream(client.getInputStream());
			String fileName = dis.readUTF();
			//파일을 저장하기 위해서 FileOutputStream 이 필요하고,
			//성능향상을위해 BufferedOutputStream 이 필요함.
			file = new File(dir,fileName);
			bos = new BufferedOutputStream(new FileOutputStream(file));
			byte [] b = new byte[1024];
			int length = 0;
			while((length = dis.read(b))!= -1) {
				bos.write(b,0,length);
			}
			System.out.println(file.getAbsolutePath()+" 파일이 서버에 저장되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bos!= null) {bos.close();}
				if(dis != null) {dis.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
