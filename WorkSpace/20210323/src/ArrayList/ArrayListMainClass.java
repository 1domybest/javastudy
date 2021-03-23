package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMainClass {
	public static void main(String[] args) {
		//1.생성
		List<String> list = new ArrayList<String>();
		
		//2.추가
		
		list.add("브레드");
		list.add("짱구");
		list.add("자두");
		
		//3.삭제
		
//		list.remove(0);
//		list.remove("짱구");
		
		//4.크기
		System.out.println("리스트의 길이: "+list.size());
		
		//5.확인
		if(list.contains("둘리")){			
		System.out.println("둘리가 있습니다");
		}else {
			System.out.println("둘리가 없습니다");
		}
		
		//6.요소 가져오기
		System.out.println("첫 번째 요소: "+list.get(0));
		System.out.println("마지막 요소: "+list.get(list.size()-1));
		
		
		//7.전체 순회
		String [] s = {"","","","",""};
		for (int i = 0; i < s.length; i++) {  //s.length = 변수 참조
			System.out.println(s[i]);
		}
		int length = list.size();  // 메소드를 변수참조로 미리 저장후 적용하면 성능에 큰 도움이 된다.
		
		System.out.println("===일반 for문===");
		for (int i = 0; i < length; i++) {  //list.size() = 메소드    결과적으로 변수참조가 더 빠르고 메소드가 더 느리다.
			System.out.println(list.get(i)); 
		}
		//for(int i = 0, length = list.size(); 1 < length; i++) {  이런식으로 for문 안에서 한번에 선언과 참조가 동시에 가능하다 
			
		
		//8.향상 for문
		System.out.println("===향상for문===");
		for (String result : list) {
			System.out.println(result);
		}
		System.out.println();
		//9.출력
		System.out.println("한 번에 출력: "+list);
		
		//10.초기화
		list.clear();
		System.out.println("===============================");
		System.out.println(" 초기화 후에 한 번에 출력: "+list);
	}
}
