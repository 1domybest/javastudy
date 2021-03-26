package ex01_char;

import java.io.FileWriter;

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
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
