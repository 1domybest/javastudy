package network;

import java.net.InetAddress;
import java.util.Arrays;

public class InetAddressMainClass {
	public static void main(String[] args) {
		//원격 호스트
		String host = "www.naver.com";
		
		//인터넷 주소를 처리하는 InetAddress
		InetAddress ia =null;
		
		try {			
			ia = InetAddress.getByName(host);
			System.out.println(ia);
			System.out.println(ia.getHostName());
			System.out.println(ia.getHostAddress( ));
			
			InetAddress[] ias = InetAddress.getAllByName(host);
			for (InetAddress inetAddress : ias) {
				System.out.println(inetAddress.getHostName()+"의 ip 주소: "+inetAddress.getHostAddress());
			}
			byte[] byteId = ia.getAddress();
			
			short[] ip = new short[byteId.length];
			for (int i = 0; i < ip.length; i++) {
				ip[i]=(short)(byteId[i]<0 ? byteId[i] +256 : byteId[i]);
			}
			System.out.println(Arrays.toString(ip));
		
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
