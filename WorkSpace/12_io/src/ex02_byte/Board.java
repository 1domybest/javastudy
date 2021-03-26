package ex02_byte;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

//ObjectOutputStream 에 의해서 writeObject() 메소드로 호출되는 클래스 입니다.
//반드시 "직렬화" 를 해야합니다.

//"직력화" 방법: Serialiazable 인터페이스를 구현합니다. serialVersionID 를 생성합니다.


public class Board implements Serializable{
	/**
	 * <<<javadoc 파란색 주석  
	 */
	private static final long serialVersionUID = 7608824469292228614L;
	
	private String title;
	private String content;
	private String writer;
	
	
	@Override
	public String toString() {
		return "[제목: " + title + ", 내용: " + content + ", 저자: " + writer + "]";
	}
	
}

