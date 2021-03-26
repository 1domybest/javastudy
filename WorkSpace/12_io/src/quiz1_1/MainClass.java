package quiz1_1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] subject = {"국어","영어","수학"};
		String name = "온석태";
		int [] scores =new int[3];
		double avg =0;
		int total =0;
		
		for (int i = 0; i < subject.length; i++) {
			System.out.print(subject[i]+">>>");
			scores[i] = sc.nextInt();
			total += scores[i];
		}
		avg = total / subject.length;
		
		try(DataOutputStream dos =new DataOutputStream(new FileOutputStream("score1.dat"))) {
			dos.writeUTF(name);
			for (int score : scores) {
				dos.writeInt(score);
			}
			dos.writeDouble(avg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}
	

}
