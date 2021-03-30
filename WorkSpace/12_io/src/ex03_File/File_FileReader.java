package ex03_File;

import java.io.File;
import java.io.FileReader;

public class File_FileReader {
	public static void main(String[] args) {
		File file = new File("C:\\MyTemp\\text.txt");
	
		try (FileReader fr = new FileReader(file)){
			int ch = 0;
			while((ch =fr.read())!= -1) {
				System.out.print((char)ch);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
