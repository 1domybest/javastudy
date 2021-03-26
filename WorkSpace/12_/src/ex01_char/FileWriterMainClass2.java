package ex01_char;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMainClass2 {
	/*
	 * try_catch_resources
	 * 1.close() 메소드를 자동으로 호출하는 try 문
	 * 2.형식
	 * 	try(스트림 생성){
	 * 
	 * }catch(){
	 * 
	 * }
	 */
	public static void main(String[] args) {
		try (FileWriter fw = new FileWriter("text2.txt")){
			char[] cbuf = {'H','E','l','l','o'};
			fw.write(cbuf,0,cbuf.length);
		} catch (IOException e) {
		e.printStackTrace();
		
		}
	}
}
