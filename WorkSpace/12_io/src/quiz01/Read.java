package quiz01;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Read {
public static void main(String[] args) {
	
	try (DataInputStream dis = new DataInputStream(new FileInputStream("newscore.dat"))){
		int kor = dis.readInt();
		int eng = dis.readInt();
		int math = dis.readInt();
		
		
		System.out.println("국어: "+kor);
		System.out.println("영어: "+eng);
		System.out.println("수학: "+math);
	
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		
	}
}
}
