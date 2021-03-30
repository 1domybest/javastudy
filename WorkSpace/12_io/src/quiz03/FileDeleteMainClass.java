package quiz03;

import java.io.File;

public class FileDeleteMainClass {
	public static void main(String[] args) {
		//C:\\MyTemp 디렉터리를 삭제합니다
		File dir = new File("C:\\MyTemp");
		File[] files = dir.listFiles();
		
		
		for (File file : files) {
			if(file.exists()==true) {
				File thoese = new File("C:\\MyTemp\\"+file.getName());
				System.out.println(file.getName()+" 파일이 삭제되었습니다");
				file.delete();
			}
		}
		if(dir.exists()==true) {
			System.out.println(dir.getName()+" 디렉터리가 삭제되었습니다");
			dir.delete();
		}
		
	}
}
