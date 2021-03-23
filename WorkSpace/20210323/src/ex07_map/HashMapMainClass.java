package ex07_map;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * HashMap 클래스
 * 	1.Map 인터페이스를 구현한 클래스 입니다.
 *  2.데이터를 쌍(pair)으로 저장(key,value)
 *  	1) 키(key) : 중복 불가
 *  	2) 값(value) : 중복 가능
 *  4.인덱스의 역할을 키(key)가 수행합니다.
 *  	
 */
public class HashMapMainClass {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		//1. 추가
		map.put("지구력", 80);
		map.put("근력", 70);
		map.put("인내력", 90);
		
		
		map.put("지구력", 100); //기존 지구력을 덮어씁니다.
		
		//2. 삭제
		map.remove("근력");
		
		//3. 요소 가져오기
		System.out.println("지구력: "+map.get("지구력"));
		System.out.println("인내력: "+map.get("인내력"));
		System.out.println("근력: "+map.get("근력"));
		
		//4. 크기
		System.out.println("저장된 데이터의 개수: "+map.size());
		
		//5. 출력
		System.out.println(map);
		
		//6.순회는 방법이 많아서 따로 진행합니다.
		
		       
	}
}
