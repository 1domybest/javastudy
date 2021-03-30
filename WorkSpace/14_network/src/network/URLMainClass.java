package network;

import java.net.URL;

public class URLMainClass {
	public static void main(String[] args) {
		//URL = Uniform Resource Loactor
		//형식이 정해져 있는 자원의 표기법
		//프로토콜://호스트:포트?파라미터
		
		URL url = null;
		URL url2 = null;
		try {
			url = new URL("http://www.naver.com/webtoon/webtoon.nhn?query=java");
			System.out.println(url.getHost());
			System.out.println(url.getDefaultPort());
			System.out.println(url.getProtocol());
			System.out.println(url.getQuery());
			url2 = new URL("http://www.naver.com/webtoon/webtoon.jsp");
			System.out.println(url2.getFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}
