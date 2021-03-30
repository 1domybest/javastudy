package ex03_File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class FileOverViewMainClass {
	//File 클래스
	//1.파일을 조작하는 클래스 입니다.
	//2. 파일 생성 삭제 파일명 크기 수정날짜등의 확인이 가능합니다
	public static void main(String[] args) {
		//디렉토리
		File dir = new File("C:\\MyTemp"); //경로 구분(\\ == File.separator)
		//File dir = new File("C:"+File.separator+"Mytemp");
		System.out.println(dir.exists());//dir이 존재하는 경로이면 true 아니면 false
		
		if(dir.exists() == false) { //if(!dir.exists()){}
			dir.mkdirs();//dir 디렉터리를 생성합니다.
			System.out.println("MyTemp 디렉터리가 생성되었습니다");
		}
		//if(dir.exists() == true) { //if(!dir.exists()){}
		//	dir.delete();//dir 디렉터리를 생성합니다.
		//	System.out.println("MyTemp 디렉터리가 삭제 되었습니다");
		//}
		
		//파일 조작
		File file = new File("C:\\Mytemp\\MyFile.txt");
		//File file = new File("C:\\Mytemp", "MyTemp.txt");
		//File file = new File(dir, "MyTemp.txt"); // dir == File dir = new File("C:\\MyTemp")
		
		System.out.println(file.exists());
		
			try {
				
				if(file.exists() == false) { //if(!file.exists()){}
				file.createNewFile();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(file.getAbsolutePath());//C:\Mytemp\MyFile.txt
			System.out.println(file.getPath());//C:\Mytemp\MyFile.txt
			System.out.println(file.getParent());//C:\Mytemp
			System.out.println(file.getName());//MyFile.txt			
			System.out.println(file.lastModified());//1616978461973
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a h:mm:ss");
			System.out.println(sdf.format(new Date(file.lastModified()))); //2021-03-29 오전 9:41:01
			
			
			
			
			System.out.println(file.length());//0
			
			//디렉터리 내의 모든 디렉터리와 파일 목록 출력하기
			File javaDir = new File("C:\\Program Files\\Java\\jdk1.8.0_202");
			File[] files = javaDir.listFiles();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
			
			for (File f : files) {
				System.out.print(sdf2.format(new Date(f.lastModified()))+"  ");
				if(f.isDirectory()) {
					System.out.print("<DIR> "+"    ");
				}else {
					System.out.print("      "+new DecimalFormat("#,##0").format(f.lastModified()));
				}
				System.out.print("     "+f.getName());
				System.out.println();
			}
			
			File dir1 = new  File("C:\\Mytemp");
			if(!dir1.exists()) {
				dir1.mkdirs();
			}
			File file1 = new File(dir,"text.txt");
			
			FileWriter fw = null;
			
			try {
				fw = new FileWriter(file1);
				fw.write("안녕하세요");
				fw.write("\n");
				fw.write("반갑습니다");
				System.out.println(file.getAbsolutePath()+ "파일이 생성되었습니다");
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(fw != null) {fw.close();}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
	}
}
